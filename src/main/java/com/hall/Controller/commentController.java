package com.hall.Controller;
import com.hall.Bean.CommentsWithBLOBs;
import com.hall.Bean.HouseOverview;
import com.hall.Bean.Orders;
import com.hall.Service.CommentService;
import com.hall.Service.HouseService;
import com.hall.Service.orderService;
import com.hall.Bean.ResponeseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class commentController {

    @Resource
    orderService orderService;

    @Resource
    HouseService houseService;
    @Resource
    CommentService commentService;

    @GetMapping("/queryComments")
    public ResponeseEntity queryComments(@RequestParam int userid){

//        查询已完成的订单号
        List<Orders> orders = orderService.getOrdersByUID(userid);

        ArrayList<Object> comments = new ArrayList<>();
        for (Orders order : orders) {
            String ordernumber = order.getOrdernumber();
            boolean isCommentEmpty = commentService.isComment(ordernumber);
            if(!isCommentEmpty){
                Integer hid = order.getHid();
                HouseOverview houseOverview = houseService.getHouseOverview(hid);
                HashMap<String, Object> dataItem = new HashMap<>();
                dataItem.put("order",order);
                dataItem.put("hov",houseOverview);
                comments.add(dataItem);
            }

        }
//        查询房屋概览消息
        HashMap<String, Object> data = new HashMap<>();
        data.put("comments",comments);
        return new ResponeseEntity("success","200",data);
    }

    @GetMapping("/commitComment")
    public boolean commitComment(@RequestParam int uid,
                                 @RequestParam String commentContent,
                                 @RequestParam List<String> urls,
                                 @RequestParam String uname,
                                 @RequestParam  double rate1,
                                 @RequestParam  double rate2,
                                 @RequestParam  double rate3,
                                 @RequestParam  double rate4,
                                 @RequestParam  double rate5,
                                 @RequestParam  double rating,
                                 @RequestParam  int lid,
                                 @RequestParam  int hid,
                                 @RequestParam int oid
                                 ){
        try {
            boolean hasimage;
            if(urls.isEmpty()){
                hasimage=false;
            }else {
                hasimage=true;
            }
            int commentid = commentService.toComment(commentContent, uid, hasimage, hid, lid, rate1, rate2, rate3, rate4, rate5, rating, uname,oid);
//            重新计算房屋的一些数据
            double newRating = commentService.getNewRating(hid);
            houseService.updateRating(hid,newRating);
            houseService.updateCommentcount(hid);
            houseService.updateHotValue(hid);
            if(hasimage){
                commentService.insertImages(urls,commentid,uid);
            }
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @GetMapping("/landlordQueryComment")
    public ResponeseEntity landlordQueryReply(@RequestParam int lid){
        List<CommentsWithBLOBs> commentsWithBLOBs = commentService.queryNeedReply(lid);

        ArrayList<Object> list = new ArrayList<>();
        for (CommentsWithBLOBs cb : commentsWithBLOBs) {
            Integer houseid = cb.getHouseid();
            HouseOverview houseOverview = houseService.getHouseOverview(houseid);
            HashMap<String, Object> ntp = new HashMap<>();
            ntp.put("hov",houseOverview);
            ntp.put("comment",cb);
            list.add(ntp);
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("comments",list);

        return new ResponeseEntity("success","200",data);

    }

    @GetMapping("/replyComment")
    public boolean replyComment(@RequestParam int cid,@RequestParam String reply){
        try{
        commentService.replyComment(cid,reply);
        return true;
        }catch (Exception e){
            return false;
        }
    }

    @GetMapping("/getSingalComment")
    public ResponeseEntity getSingalComment(@RequestParam int cid){
        HashMap<String, Object> data = commentService.getSingalComment(cid);
        return new ResponeseEntity("success","200",data);
    }
}
