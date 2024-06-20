package com.hall.Controller;

import com.hall.Service.PictureService;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@RestController
public class ImageuploadController {
    @Resource
    PictureService pictureService;

    @PostMapping("/uploadImage")
    public String handleFileUpload(@RequestPart("file") MultipartFile file, @RequestParam("uid") int uid, @RequestParam("role") String role) {
        if (file.isEmpty()) {
            return "error";
        }
        // 此段代码为保存文件到服务器本地，实际开发中您可能需要保存到其他位置，如云存储等
        String orgfileName = file.getOriginalFilename();
        String fileName = generateFileName(orgfileName);
        File dest = new File("/upload/" + fileName);
        try {
            file.transferTo(dest);
            pictureService.insertImage("/upload/" + fileName,"http://hallowlemon.online:11111/upload/images/"+fileName,uid,role);
            return "http://hallowlemon.online:11111/upload/images/"+fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/deletePic")
    public void handleDeleteReq(@RequestParam("url") String url){
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


    public  String generateFileName(String orgName) {

        String[] split = orgName.split("\\.");
        String suffFix=split[split.length-1];

        // 生成随机英文字符
        String randomChars = generateRandomChars(6);

        // 获取当前时间戳
        long timestamp = System.currentTimeMillis();

        // 返回生成的文件名
        return randomChars + "_" + timestamp + "."+suffFix;
    }

    private  String generateRandomChars(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // 生成随机小写字母的 ASCII 码，范围为 97~122
            int randomAscii = random.nextInt(26) + 97;
            // 将 ASCII 码转换为字符并添加到字符串中
            sb.append((char) randomAscii);
        }
        return sb.toString();
    }
}
