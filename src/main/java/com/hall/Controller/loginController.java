package com.hall.Controller;

import java.security.MessageDigest;
import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.core.http.HttpClient;
import com.aliyun.core.http.HttpMethod;
import com.aliyun.core.http.ProxyOptions;
import com.aliyun.httpcomponent.httpclient.ApacheAsyncHttpClientBuilder;
import com.aliyun.sdk.service.dysmsapi20170525.models.*;
import com.aliyun.sdk.service.dysmsapi20170525.*;
import com.google.gson.Gson;
import com.hall.Bean.ResponeseEntity;
import com.hall.Bean.user;
import com.hall.Bean.verifyCodeStatus;
import com.hall.Service.UserService;
import com.hall.Service.verifyCodeService;
import darabonba.core.RequestConfiguration;
import darabonba.core.client.ClientOverrideConfiguration;
import darabonba.core.utils.CommonUtil;
import darabonba.core.TeaPair;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import javax.net.ssl.KeyManager;
//import javax.net.ssl.X509TrustManager;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.io.*;

@RestController
public class loginController {

    @Resource
    verifyCodeService verifyCodeService;

    @Resource
    UserService userService;

    @PostMapping("/getVerify")
    public ResponeseEntity smsTest(@RequestBody Map<String,Object> req) throws Exception {
        String phoneNumber =(String) req.get("phoneNumber");
        String type=(String) req.get("type");
//        System.out.println(clientPhoneNumber);
        if(phoneNumber==null){
            return new ResponeseEntity("请先输入手机号","400",null);
        }
        if(type==null){
            return new ResponeseEntity("请指定验证码类型","401",null);
        }

        String code = generateVerificationCode();
        System.out.println(code);
        String templateCode="";
        if(type.equals("登录")){
            if(!userService.userIsExist(phoneNumber)){
                return new ResponeseEntity("手机号尚未注册","304",null);
            }
            templateCode="SMS_465403881";
        }else if(type.equals("注册")){
            templateCode="SMS_465328924";
        }else if (type.equals("找回密码")){
            if(!userService.userIsExist(phoneNumber)){
                return new ResponeseEntity("手机号尚未注册","304",null);
            }
            templateCode="SMS_465442060";
        } else if (type.equals("修改密码")) {
            if(!userService.userIsExist(phoneNumber)){
                return new ResponeseEntity("手机号尚未注册","304",null);
            }
            templateCode="SMS_465615446";
        }else{
            return new ResponeseEntity("验证码类型错误","402",null);
        }
        smessage(phoneNumber,code,templateCode);
        verifyCodeService.insertCode(phoneNumber,code);
        return new ResponeseEntity("发送成功","200",null);
    }

    @PostMapping("/loginByCode")
    public ResponeseEntity loginByCode(@RequestBody Map<String,Object> req){
        String phoneNumber =(String) req.get("phoneNumber");
        String code = (String)req.get("code");
//        确保有传数据
        if(phoneNumber==null || code==null){
            return new ResponeseEntity("请输入手机号和验证码","400",null);
        }

//        1.先在数据库的用户表查询有没有这个用户
        if(userService.userIsExist(phoneNumber)){
            //        2.如果存在，就做下一步验证
            verifyCodeStatus vcs = verifyCodeService.codeIsVaild(phoneNumber, code);
            if(vcs==null){
                return new ResponeseEntity("验证码错误","409",null);
            }
            Date codegentime = vcs.getCodegentime();
            if(codeIsExpired(codegentime)){
                verifyCodeService.deleteByphone(phoneNumber);
                return new ResponeseEntity("验证码已过期","410",null);
            }
//            通过验证，完成登录

            String token = UUID.randomUUID().toString();
            // 获取当前日期
            Calendar calendar = Calendar.getInstance();
            Date currentDate = calendar.getTime();

            // 往后推3天
            calendar.add(Calendar.DAY_OF_MONTH, 3);
            Date futureDate = calendar.getTime();

            Map<String, Object> data = userService.completeLogin(phoneNumber, token, futureDate);
            return new ResponeseEntity("登录成功","200",data);
        }else{
            //        3.不存在，直接返回，提醒前端注册
            return new ResponeseEntity("用户未注册","304",null);
        }

    }

    @PostMapping("/loginByPwd")
    public ResponeseEntity loginByPassword(@RequestBody Map<String,String> req){
        String phoneNumber = req.get("phoneNumber");
        String password = req.get("password");
        if(phoneNumber==null||password==null){
            return new ResponeseEntity("请输入手机号或者密码","400",null);
        }
        //        1.先在数据库的用户表查询有没有这个用户
        if(userService.userIsExist(phoneNumber)){
            //        2.如果存在，就做下一步验证
           if(userService.loginByPwd(phoneNumber,md5(password))){
//            通过验证，完成登录

            String token = UUID.randomUUID().toString();
            // 获取当前日期
            Calendar calendar = Calendar.getInstance();
            Date currentDate = calendar.getTime();

            // 往后推3天
            calendar.add(Calendar.DAY_OF_MONTH, 3);
            Date futureDate = calendar.getTime();

            Map<String, Object> data = userService.completeLogin(phoneNumber, token, futureDate);
            return new ResponeseEntity("登录成功","200",data);
           }else{
               return new ResponeseEntity("密码错误","400",null);
           }
        }else{
            //        3.不存在，直接返回，提醒前端注册
            return new ResponeseEntity("用户未注册","304",null);
        }

    }

    @PostMapping("/register")
    public ResponeseEntity register(@RequestBody Map<String,String>req) {
        String phoneNumber = req.get("phoneNumber");
//        没有传值的话默认是null
//        System.out.println("+++++++++++++++++++++++++++++++++++++++");
//        System.out.println(phoneNumber);

        if(phoneNumber==null){
//        没有传参数，直接返回
           return new ResponeseEntity("没有传递电话号码","400",null);
        }
//        判断是否存在该账号

       if(userService.userIsExist(phoneNumber)) {
//           账号已经存在
           return new ResponeseEntity("账号已存在，跳转到登录页面","304",null);
       }else{
//           账号不存在，进行账号的注册

//           1.保证该传递的值都有进行传递
           String password = req.get("password");
           String code = req.get("code");
           if(password==null&&code==null){
            return new ResponeseEntity("请输入密码和验证码","406",null);
           } else if (password==null) {
               return new ResponeseEntity("请输入密码","407",null);
           }else if(code==null){
               return new ResponeseEntity("请输入验证码","408",null);
           }
//           3.验证验证码和手机号是否对应，对应则下一步，否则就直接拒绝
           verifyCodeStatus vcs = verifyCodeService.codeIsVaild(phoneNumber, code);
           if(vcs==null){

               return new ResponeseEntity("验证码错误","409",null);
           }
           Date codegentime = vcs.getCodegentime();
           if(codeIsExpired(codegentime)){
               verifyCodeService.deleteByphone(phoneNumber);
               return new ResponeseEntity("验证码已过期","410",null);
           }

//           4.验证密码是否合法，合法则进行最后的数据插入，不合法就拒绝 ，对应返回码405
            if(!validatePassword(password)){
                return new ResponeseEntity("至少包含大小写,数字,特殊符号中的两种类型组合","411",null);
            }
//           5.自动生成用随机昵称，对密码进行md5加密，默认角色为租客,删除验证码
           user user = new user();
           String token = UUID.randomUUID().toString();
           user.setAvatarpic("https://pic.tujia.com/upload/festatic/app/tujia_useravatar.png");
           user.setPhonenumber(phoneNumber);
           user.setRole("tenant");
           user.setPassword(md5(password));
           user.setToken(token);
           user.setUsername("手机用户"+phoneNumber);
           // 获取当前日期
           Calendar calendar = Calendar.getInstance();
           Date currentDate = calendar.getTime();

           // 往后推3天
           calendar.add(Calendar.DAY_OF_MONTH, 3);
           Date futureDate = calendar.getTime();
           user.setExpiredtime(futureDate);
           userService.insertUser(user);
           Map<String, Object> data = new HashMap<>();
           data.put("token",token);
           data.put("phoneNumber",phoneNumber);
           data.put("userId",user.getUserid());
           return new ResponeseEntity("注册成功","200",data);
       }
    }

    @PostMapping("/resetPwd")
    public ResponeseEntity resetPwd(@RequestBody Map<String,String>req){
        String phoneNumber = req.get("phoneNumber");
        String newPwd = req.get("newPwd");
        String code = req.get("code");
//        没有传值的话默认是null
//        System.out.println("+++++++++++++++++++++++++++++++++++++++");
//        System.out.println(phoneNumber);

        if(phoneNumber==null){
//        没有传参数，直接返回
            return new ResponeseEntity("没有传递电话号码","400",null);
        }else if(newPwd==null){
            return new ResponeseEntity("请输入新密码","401",null);
        } else if (code==null) {
            return new ResponeseEntity("请输入验证码","402",null);
        }

        verifyCodeStatus vcs = verifyCodeService.codeIsVaild(phoneNumber, code);
        if(vcs==null){

            return new ResponeseEntity("验证码错误","409",null);
        }
        Date codegentime = vcs.getCodegentime();
        verifyCodeService.deleteByphone(phoneNumber);
        if(codeIsExpired(codegentime)){
            return new ResponeseEntity("验证码已过期","410",null);
        }

//           4.验证密码是否合法，合法则进行最后的数据插入，不合法就拒绝 ，对应返回码405
        if(!validatePassword(newPwd)){
            return new ResponeseEntity("至少8位并且包含大小写,数字,特殊符号中的两种类型组合","411",null);
        }

        userService.updatePwd(phoneNumber, md5(newPwd));
        return new ResponeseEntity("重置密码成功","200",null);

    }

    @PostMapping("/verifyLogin")
    public ResponeseEntity verifyLogin(@RequestBody Map<String,String>req){
        String id = req.get("userId");
        String token = req.get("token");
        if(id.isEmpty() ||token.isEmpty()){
            return new ResponeseEntity("验证失败","400",null);
        }
        int recordCount = userService.queryLoginRecord(id, token);
        if(recordCount!=0){
            user user = userService.queryById(id);
            Date expiredtime = user.getExpiredtime();
            if(tokenIsExpired(expiredtime)){
                //        2.如果对应记录存在，但是过期了，那就返回过期了
                return new ResponeseEntity("登录已过期，请重新登录","401",null);
            }else{
                //        1.传入id和token，如果存在相应记录，并且还没过期，那就延长token过期时间
                user user1 = new user();
                Calendar calendar = Calendar.getInstance();
                // 往后推3天
                calendar.add(Calendar.DAY_OF_MONTH, 3);
                Date futureDate = calendar.getTime();
                user1.setExpiredtime(futureDate);
                user1.setUserid(Integer.valueOf(id));
                userService.updateExpireTime(user1);
                return new ResponeseEntity("免密登录成功","200",null);
            }

        }else{
            //        3.如果对应记录不存在，那就说明要么token是错误的，要么在别处登录了所以更新了token
            return new ResponeseEntity("登录失效或在其他地方登录","402",null);
        }
//        3.如果对应记录不存在，那就说明要么token是错误的，要么在别处登录了所以更新了token

    }
    public void smessage(String phoneNumber,String templateParam,String templateCode) throws Exception{
        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId("LTAI5tKoXNh3bYvgK77Q4xbz")
                .accessKeySecret("oXhLH7LQsICkx0S7t1FjoIxGrtcx4E")
                .build());


        AsyncClient client = AsyncClient.builder()
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                .setEndpointOverride("dysmsapi.aliyuncs.com")
                )
                .build();

        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .phoneNumbers(phoneNumber)
                .signName("hallowlemon")
                .templateParam("{\"code\":\""+templateParam+"\"}")
                .templateCode(templateCode)
                .build();


        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);
        SendSmsResponse resp = response.get();
        System.out.println("-----------------------------------------");
        System.out.println(new Gson().toJson(resp));
        System.out.println("-----------------------------------------");

        client.close();
    }
    public  String md5(String pwd) {


        try {
            // 创建一个MD5消息摘要对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 使用指定的字节数组更新摘要
            md.update(pwd.getBytes());

            // 计算消息摘要
            byte[] digest = md.digest();

            // 将字节数组转换为十六进制字符串
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                String hex = Integer.toHexString(0xff & digest[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }


            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String generateVerificationCode() {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(random.nextInt(10)); // 生成 0 到 9 之间的随机数字
            }
            return sb.toString();
        }

    public boolean codeIsExpired(Date t){
        Date nowDate = new Date();

        long diffInMillis=nowDate.getTime()-t.getTime();
        long diffInDays=diffInMillis/(60*1000);
        if (diffInDays > 5) {
            //System.out.println("日期间隔超过5分钟");
            return true;
        } else {
            // System.out.println("日期间隔不超过5分钟");
            return false;
        }


    }
    public boolean tokenIsExpired(Date t){
        Date nowDate = new Date();

        long diffInMillis=nowDate.getTime()-t.getTime();
        long diffInDays=diffInMillis/(24*60*60*1000);
        if (diffInDays > 5) {
            //System.out.println("日期间隔超过5天");
            return true;
        } else {
            // System.out.println("日期间隔超过5天");
            return false;
        }


    }

    public  boolean validatePassword(String password) {
        int count = 0; // 用于计数满足条件的字符类型数量

        // 检查是否包含数字
        if (password.matches(".*[0-9].*")) {
            count++;
        }

        // 检查是否包含符号
        if (password.matches(".*[^a-zA-Z0-9].*")) {
            count++;
        }

        // 检查是否包含小写字母
        if (password.matches(".*[a-z].*")) {
            count++;
        }

        // 检查是否包含大写字母
        if (password.matches(".*[A-Z].*")) {
            count++;
        }

        // 至少包含两种字符类型则返回true，否则返回false
        return count >= 2&&password.length()>=8;
    }
}
