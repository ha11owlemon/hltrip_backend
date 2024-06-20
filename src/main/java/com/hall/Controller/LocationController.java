package com.hall.Controller;

import com.hall.Bean.ResponeseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LocationController {
    private static final String AMAP_API_KEY = "ca5638622884957be4cff8d31d00b1b0";

    @GetMapping("/getNearByInfo")
    public ResponeseEntity getNearByInfo(@RequestParam("longitude") String longitude, @RequestParam("latitude") String latitude){
//        SELECT * FROM `house_location`
//
//        WHERE
//        ST_Distance(ST_GeomFromText('POINT(119.28420 26.082709)'), ST_GeomFromText(CONCAT('POINT(', longitude, ' ', latitude, ')'))) < 1000;
        System.out.println("经度："+longitude);
        System.out.println("纬度："+latitude);
        HashMap<String, Object> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("citys","data");
        return new ResponeseEntity("success","200",stringStringHashMap);
    }
}
