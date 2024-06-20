package com.hall.Controller;

import com.hall.Bean.*;
import com.hall.Service.CommentService;
import com.hall.Service.HouseService;
import com.hall.Service.PictureService;
import com.hall.Service.UserService;
import com.hall.Service.orderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class profileController {
    @Resource
    UserService userService;
    @Resource
    PictureService pictureService;
    @Resource
    HouseService houseService;
    @Resource
    CommentService commentService;

    @Resource
    orderService orderService;

    @GetMapping("/getProfileData")
    public ResponeseEntity getProfileData(@RequestParam int userid){
//        获取用户昵称，头像，收藏数，浏览记录数
        HashMap<String, Object> userbrief = userService.getUserbrief(userid);

//        订单号什么的后续再说

        return new ResponeseEntity("success","200",userbrief);
    }

    @PostMapping("/uploadAvatar")
    public String handleFileUpload(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty";
        }

        // 此段代码为保存文件到服务器本地，实际开发中您可能需要保存到其他位置，如云存储等
        String fileName = file.getOriginalFilename();
        File dest = new File("D:/upload/" + fileName);
        try {
            file.transferTo(dest);
            return "http://192.168.21.85:11111/images/"+fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Upload fail";
    }

    @GetMapping("/verifyLandlord")
    public ResponeseEntity addLandlord(@RequestParam String[] urls,@RequestParam int userid){
//        自动删除对应图片
        for (String url : urls) {
            pictureService.deleteImage(url);
            String[] split = url.split("/");
            String filename = split[split.length - 1];
            File file = new File("/upload/"+filename);
            if(file.exists()){
                if(file.delete()){
                    System.out.println("删除成功");
                }else {
                    System.out.println("无法删除文件"+filename);
                }
            }
        }
//        新建一个房东
        Landlords landlords = new Landlords();
        landlords.setBalance(0.0);
        user usermessage = userService.getUsermessage(userid);
        landlords.setAvatar(usermessage.getAvatarpic());
        landlords.setNickname(usermessage.getUsername());
        landlords.setPhonenumber(usermessage.getPhonenumber());
        userService.insertLandlord(landlords);
        Integer landlordid = landlords.getLandlordid();
        userService.insertToAvatar(usermessage.getAvatarpic(),landlordid);
        userService.updataLidInUser(landlordid,userid);
//        返回房东id
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("landlordid",landlordid);
        return new ResponeseEntity("success","200",data);
    }

    @GetMapping("/hasLandlord")
    public boolean hasLandlord(@RequestParam int userid){
        return userService.hasLandlord(userid);
    }


    @PostMapping("/addIntro")
    public boolean addIntro(@RequestBody HashMap<String,String>  req){
        String landlordid = req.get("landlordid");
        String title = req.get("title");
        String content = req.get("content");
        int i = userService.addIntro(Integer.parseInt(landlordid), title, content);
        if (i==0){
            return false;
        }else {
            return true;
        }
    }

    @GetMapping("/queryIntro")
    public ResponeseEntity queryIntro(@RequestParam int landlordid){
        List<LandlordIntro> landlordIntros = userService.queryIntro(landlordid);
        HashMap<String, Object> data = new HashMap<>();
        if(landlordIntros.isEmpty()){
            data.put("intro",null);
            return new ResponeseEntity("success","200",data);
        }else{
            data.put("intro",landlordIntros.get(0));
            return new ResponeseEntity("success","200",data);

        }
    }

    @GetMapping("/getLandlordProfileData")
    public ResponeseEntity getLandlordProfileData(@RequestParam int landlordid){

        Map<String, Object> data = userService.queryLandlord(landlordid);
        long hcount = userService.countHouses(landlordid);
        BigDecimal noarrived = orderService.noArrived(landlordid);
        data.put("hcount",hcount);
        data.put("noarrived",noarrived);
        return new ResponeseEntity("success","200",data);
    }

    @GetMapping("/getLordHouses")
    public ResponeseEntity getLordHouses(@RequestParam int landlordid){
        List<HouseOverview> landlordHouses = userService.getLandlordHouses(landlordid);
        HashMap<String, Object> data = new HashMap<>();
        data.put("landlordHouses",landlordHouses);
        return new ResponeseEntity("success","200",data);
    }

    @GetMapping("/updatePrice")
    public ResponeseEntity updatePrice(@RequestParam int landlordid,@RequestParam int houseid,@RequestParam double orgprice,@RequestParam double price){
        return userService.updateHousePrice(landlordid,houseid,orgprice,price);
    }

    @GetMapping("/deleteHouse")
    public ResponeseEntity deleteHouse(@RequestParam int landlordid,@RequestParam int houseid){
        return houseService.deleteHouse(landlordid,houseid) ;
    }

    @GetMapping("/addIDinfo")
    public boolean addIDinfo(@RequestParam int uid,@RequestParam String name,@RequestParam String idnum){
        System.out.println(idnum);
        return userService.addIDinfo(uid,name,idnum) ;
    }

    @GetMapping("/deleteIDinfo")
    public boolean deleteDinfo(@RequestParam int uid,@RequestParam String name,@RequestParam String idnum){

        return userService.deleteIDinfo(uid,name,idnum) ;
    }
    @GetMapping("/getIDinfo")
    public ResponeseEntity getIDinfo(@RequestParam int uid){
        HashMap<String, Object> data = new HashMap<>();
        List<guestInformation> guestInformations = userService.queryIDinfo(uid);
        data.put("info", guestInformations);
        return new ResponeseEntity("success","200",data) ;
    }

    @GetMapping("/changeUserProfile")
    public boolean changeUserProfile(@RequestParam String name,@RequestParam String avatar,@RequestParam int uid){
        try{
            userService.updateUserProfile(name,avatar,uid);
            commentService.updateUname(uid,name);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @GetMapping("/changeLProfile")
    public boolean changeLProfile(@RequestParam String name,@RequestParam String avatar,@RequestParam int lid){
        try{
            userService.updateLProfile(name,avatar,lid);
            houseService.updateLandlordName(lid,name);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
