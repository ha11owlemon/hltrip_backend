package com.hall.Service.Imp;

import com.hall.Bean.*;
import com.hall.DAO.*;
import com.hall.Service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Resource
    CommentsMapper commentsMapper;

    @Resource
    CommentImagesMapper commentImagesMapper;

    @Resource
    OrdersMapper ordersMapper;

    @Resource
    userMapper userMapper;

    @Override
    public boolean isComment(String ordernum){
//        CommentsExample commentsExample = new CommentsExample();
//        CommentsExample.Criteria criteria = commentsExample.createCriteria();
//        criteria.andHouseidEqualTo(hid).andUseridEqualTo(uid);
//        List<Comments> comments = commentsMapper.selectByExample(commentsExample);
//        System.out.println(comments.isEmpty());
//        return comments.isEmpty();
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andOrdernumberEqualTo(ordernum).andOrdergentimeIsNull();
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        return orders.isEmpty();
    }

    @Override
    public int toComment(String content,
                         int uid,
                         boolean hasImage,
                         int hid,
                         int lid,
                         double r1,
                         double r2,
                         double r3,
                         double r4,
                         double r5,
                         double rating,
                         String uname,
                         int oid
    ){
        CommentsWithBLOBs comments = new CommentsWithBLOBs();
        comments.setCommenttime(new Date());
        comments.setHasimage(hasImage);
        comments.setUserid(uid);
        comments.setHouseid(hid);
        comments.setUsername(uname);
        comments.setCommentcontent(content);
        comments.setCleanliness(r1);
        comments.setAccuracy(r2);
        comments.setLocationtransport(r3);
        comments.setSafety(r4);
        comments.setValueformmoney(r5);
        comments.setRating(rating);
        comments.setLandlordid(lid);

        commentsMapper.insertSelective(comments);
        Orders orders = new Orders();
        orders.setOrdergentime(new Date());
        orders.setOrderid(oid);
        ordersMapper.updateByPrimaryKeySelective(orders);
        return comments.getCommentid();
    }

    @Override
    public void insertImages(List<String> urls, int commentid, int uid){
        for (String url : urls) {
            CommentImages commentImages = new CommentImages();
            commentImages.setCommentid(commentid);
            commentImages.setUserid(uid);
            commentImages.setUrl(url);
            commentImagesMapper.insertSelective(commentImages);
        }

    }

    @Override
    public List<CommentsWithBLOBs> queryNeedReply(int lid){
        return commentsMapper.queryNeedToReply(lid);
    }

    @Override
    public void replyComment(int cid, String reply){
        CommentsWithBLOBs commentsWithBLOBs = commentsMapper.selectByPrimaryKey(cid);
        commentsWithBLOBs.setLandlordreply(reply);
        commentsWithBLOBs.setReplytime(new Date());
        commentsMapper.updateByPrimaryKeySelective(commentsWithBLOBs);
    }

    @Override
    public void updateUname(int uid, String name){
        CommentsExample commentsExample = new CommentsExample();
        CommentsExample.Criteria criteria = commentsExample.createCriteria();
        criteria.andUseridEqualTo(uid);
        CommentsWithBLOBs comments = new CommentsWithBLOBs();
        comments.setUsername(name);
        commentsMapper.updateByExampleSelective(comments,commentsExample);
    }

    @Transactional
    @Override
    public HashMap<String, Object> getSingalComment(int cid){
        HashMap<String, Object> data = new HashMap<>();
        CommentsWithBLOBs comments = commentsMapper.selectByPrimaryKey(cid);
        data.put("comment",comments);

        Integer userid = comments.getUserid();
        user user = userMapper.selectByPrimaryKey(userid);
        data.put("avatar",user.getAvatarpic());

        Boolean hasimage = comments.getHasimage();
        if(hasimage){
            CommentImagesExample commentImagesExample = new CommentImagesExample();
            CommentImagesExample.Criteria criteria = commentImagesExample.createCriteria();
            criteria.andCommentidEqualTo(cid);
            List<CommentImages> commentImages = commentImagesMapper.selectByExample(commentImagesExample);
            ArrayList<String> urls = new ArrayList<>();
            for (CommentImages commentImage : commentImages) {
                urls.add(commentImage.getUrl());
            }
            data.put("urls",urls);
        }else {
            data.put("urls",new ArrayList<>());
        }
        return data;
    }

    @Override
    public double getNewRating(int hid){

        List<Double> ratings = commentsMapper.selectRatings(hid);
        double sum=0.0;
        for (Double rating : ratings) {
            sum+=rating;
        }

        double avgRating=sum/ratings.size();
        return  Math.round(avgRating * 10.0) / 10.0;
    }
}
