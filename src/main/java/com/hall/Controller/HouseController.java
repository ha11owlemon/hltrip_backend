package com.hall.Controller;

import com.hall.Bean.HouseLocation;
import com.hall.Bean.HouseOverview;
import com.hall.Bean.ResponeseEntity;
import com.hall.Bean.houseImages;
import com.hall.Service.HouseService;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.*;

@RestController
public class HouseController {

    @Resource
    HouseService houseService;

    @PostMapping("/uploadHouse")
    public ResponeseEntity uploadHouse(@RequestBody Map<String,Object> req){
        return houseService.insertHouse(req);
    }

    @PostMapping("/test")
    public String test(@RequestBody Map<String,Object> req){
        String o =(String) req.get("message");
        System.out.println(o);
        return o;
    }

    @GetMapping("/getHouseByHouseid")
    public ResponeseEntity getHouseByHouseid(@RequestParam int houseid,@RequestParam int userid){
        //        先更新浏览量和浏览记录
        houseService.addViewCount(houseid,userid);
        houseService.updateHotValue(houseid);

        ResponeseEntity respdata = houseService.getHouseByHouseid(houseid, userid);
        Map<String, Object> data = respdata.getData();
        data.put("islike",houseService.queryfavor(houseid,userid));
        return respdata;
    }

    @GetMapping("/getAllCommentByHouseid")
    public ResponeseEntity getAllCommentByHouseid(@RequestParam int houseid,@RequestParam int page){

    return houseService.getAllCommentByHouseid(houseid,page);
    }

    @GetMapping("/getHouseInfoBylandlord")
    public ResponeseEntity getHouseInfoBylandlord(@RequestParam int landlordid,@RequestParam int userid,@RequestParam int page){
        return houseService.getLandlordDetail(landlordid,userid,page);
    }
    @GetMapping("/favorHouse")
    public void favorHouse(@RequestParam int houseid,@RequestParam int userid){
//        1.更新overview表
//        2.更新收藏表
//        3.重新计算热度
        boolean addOrSub = houseService.favorHouse(houseid,userid);
        houseService.updateFavor(houseid,addOrSub);
        houseService.updateHotValue(houseid);
    }

    @PostMapping("/quickInsert")
    public ResponeseEntity quickInsert(@RequestBody Map<String,Object> req){
        return houseService.insertHouseAndComment(req);
    }
//    @PostMapping("/changeComment")
//    public void changeComment(){
//        houseService.changcomment();
//    }
    @GetMapping("/getRecommendHouses")
    public ResponeseEntity getRecommendHouses(@RequestParam double longitude,
                                              @RequestParam double latitude,
                                              @RequestParam int page,
                                              @RequestParam int userid,
                                              @RequestParam(required = false) Double maxPrice_c,
                                              @RequestParam(required = false) Double minPrice_c,
                                              @RequestParam(required = false) Integer bedcount_c,
                                              @RequestParam(required = false) Integer roomcount_c,
                                          @RequestParam(required = false) Integer maxpeople_c,
                                              @RequestParam(required = false) Integer distance_c
                                              ){

        if(distance_c==null){
            distance_c=50000;
        }

        HashMap<String, Object> data1 = houseService.gethouseidsByLocation(longitude, latitude, distance_c, page);
        List<Integer> houseids =(List<Integer>) data1.get("houseids");
        long total=(long)data1.get("total");
        List<Integer> hotValueArr=new ArrayList<>();
        List<Integer> viewcountArr=new ArrayList<>();
        List<Double> priceArr=new ArrayList<>();
        List<Integer> favorcountArr=new ArrayList<>();
        List<Double> distanceArr=new ArrayList<>();
        List<HashMap<String,Object>> dataList=new ArrayList<>();
//        获取到符合要求的距离内的id列表
        if (maxPrice_c==null&&minPrice_c==null&&bedcount_c==null&&roomcount_c==null&&maxpeople_c==null){
            //        1.什么筛选条件都不带，按照推荐算法
//            infoList.add(hotvalue);
//            infoList.add(viewcount);
//            infoList.add(discountprice);
//            infoList.add(favoritecount);
            for (Integer houseid : houseids) {
                //            2.处理数据
                //            2.1 先做基本处理
                List<Object> infoList=houseService.getSingleHouseBriefByHouseid(houseid,userid);
                HashMap<String, Object> dataItem =(HashMap<String, Object>) infoList.get(4);
                hotValueArr.add((int)infoList.get(0));
                viewcountArr.add((int) infoList.get(1));
                priceArr.add((double)infoList.get(2));
                favorcountArr.add((int)infoList.get(3));
                double longitude_t =(double) infoList.get(5);
                double latitude_t =(double) infoList.get(6);
//                计算距离，并且添加到dataItem中


                // 输出计算结果
                int R = 6371000; // 地球半径，单位是米

                double latDistance = Math.toRadians(latitude_t - latitude);
                double lonDistance = Math.toRadians(longitude_t - longitude);

                double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                        + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(latitude_t))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

                double distance = R * c;
                dataItem.put("distance",distance);
                distanceArr.add(distance);
                dataList.add(dataItem);
            }
            if(dataList.size()==1){
                HashMap<String, Object> data = new HashMap<>();
                dataList.get(0).put("recommendValue",0.2);
                data.put("houseInfo",dataList);
                data.put("total",total);
                System.out.println(total);
                return new ResponeseEntity("get data success","200",data);
            }else if(dataList.size()==0){
                return  new ResponeseEntity("no data,please flush page","300",null);
            }else{
                //            以上遍历结束，会得到一个封面信息数据数组，热度值数组，浏览量数组，价格数组，收藏数组,距离数组
                double maxPrice_s=Collections.max(priceArr);
                double minPrice_s=Collections.min(priceArr);

                int maxViewcount_s=Collections.max(viewcountArr);
                int minViewcount_s=Collections.min(viewcountArr);

                int maxFavor_s=Collections.max(favorcountArr);
                int minFovor_s=Collections.min(favorcountArr);

                int maxHotvalue_s=Collections.max(hotValueArr);
                int minHotvalue_s=Collections.min(hotValueArr);

                double maxDistance_s=Collections.max(distanceArr);

                int index=0;
                System.out.println(houseids);
                for (Integer houseid : houseids) {

                    double viewcountFormat=(viewcountArr.get(index)-minViewcount_s)/(maxViewcount_s-minViewcount_s);
                    double priceFormat=(priceArr.get(index)-minPrice_s)/(maxPrice_s-minPrice_s);
                    double favorFormat=(favorcountArr.get(index)-minFovor_s)/(maxFavor_s-minFovor_s);
                    double hotvFormat=(hotValueArr.get(index)-minHotvalue_s)/(maxHotvalue_s-minHotvalue_s);
                    double distanceFormat=1-(distanceArr.get(index)/maxDistance_s);

                    double recommendValue=0.35*distanceFormat+0.1*priceFormat+0.1*favorFormat+0.15*viewcountFormat+0.3*hotvFormat;

                    HashMap<String, Object> stringObjectHashMap = dataList.get(index);
                    stringObjectHashMap.put("recommendValue",recommendValue);
                    dataList.set(index,stringObjectHashMap);
                    index++;
                }
                HashMap<String, Object> data = new HashMap<>();
                data.put("houseInfo",dataList);
                data.put("total",total);
                return new ResponeseEntity("get data success","200",data);
            }


        }else {
            for (Integer houseid : houseids) {
                List<Object> list = houseService.getSingleHouseBriefByHouseidWithCondition(houseid, userid, maxPrice_c, minPrice_c, bedcount_c, roomcount_c, maxpeople_c);
                if(list!=null){
                    HashMap<String, Object> dataItem =(HashMap<String, Object>) list.get(4);
                    hotValueArr.add((int)list.get(0));
                    viewcountArr.add((int) list.get(1));
                    priceArr.add((double)list.get(2));
                    favorcountArr.add((int)list.get(3));
                    double longitude_t =(double) list.get(5);
                    double latitude_t =(double) list.get(6);
//                计算距离，并且添加到dataItem中


                    // 输出计算结果
                    int R = 6371000; // 地球半径，单位是米

                    double latDistance = Math.toRadians(latitude_t - latitude);
                    double lonDistance = Math.toRadians(longitude_t - longitude);

                    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                            + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(latitude_t))
                            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

                    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

                    double distance = R * c;
                    dataItem.put("distance",distance);
                    distanceArr.add(distance);
                    dataList.add(dataItem);
                }
            }

            if(dataList.size()==1){
                HashMap<String, Object> data = new HashMap<>();
                dataList.get(0).put("recommendValue",0.2);
                data.put("houseInfo",dataList);
                return new ResponeseEntity("get data success","200",data);
            }else if(dataList.size()==0){
                return  new ResponeseEntity("no data,please flush page","300",null);
            }else{
                //            以上遍历结束，会得到一个封面信息数据数组，热度值数组，浏览量数组，价格数组，收藏数组,距离数组

                double maxPrice_s=Collections.max(priceArr);
                double minPrice_s=Collections.min(priceArr);

                int maxViewcount_s=Collections.max(viewcountArr);
                int minViewcount_s=Collections.min(viewcountArr);

                int maxFavor_s=Collections.max(favorcountArr);
                int minFovor_s=Collections.min(favorcountArr);

                int maxHotvalue_s=Collections.max(hotValueArr);
                int minHotvalue_s=Collections.min(hotValueArr);

                double maxDistance_s=Collections.max(distanceArr);


                for (int index = 0; index < dataList.size(); index++) {
                    double viewcountFormat=(viewcountArr.get(index)-minViewcount_s)/(maxViewcount_s-minViewcount_s);
                    double priceFormat=(priceArr.get(index)-minPrice_s)/(maxPrice_s-minPrice_s);
                    double favorFormat=(favorcountArr.get(index)-minFovor_s)/(maxFavor_s-minFovor_s);
                    double hotvFormat=(hotValueArr.get(index)-minHotvalue_s)/(maxHotvalue_s-minHotvalue_s);
                    double distanceFormat=1-(distanceArr.get(index)/maxDistance_s);

                    double recommendValue=0.35*distanceFormat+0.1*priceFormat+0.1*favorFormat+0.15*viewcountFormat+0.3*hotvFormat;

                    HashMap<String, Object> stringObjectHashMap = dataList.get(index);
                    stringObjectHashMap.put("recommendValue",recommendValue);
                    dataList.set(index,stringObjectHashMap);
                    index++;
                }
                HashMap<String, Object> data = new HashMap<>();
                data.put("houseInfo",dataList);
                data.put("total",total);
                return new ResponeseEntity("get data success","200",data);
        }
    }
    }

    @GetMapping("/getFavorList")
    public ResponeseEntity getFavorList(@RequestParam int userid,@RequestParam int page){
        HashMap<String, Object> queryData = houseService.getFavorIds(userid, page);
        List<Integer> houseids = (List<Integer>) queryData.get("houseids");
        long total=(long) queryData.get("total");
        List<Map<String, Object>> houseInfo = new ArrayList<>();
        for (Integer houseid : houseids) {
            List<Object> infoList=houseService.getSingleHouseBriefByHouseid(houseid,userid);
            HashMap<String, Object> dataItem =(HashMap<String, Object>) infoList.get(4);
            houseInfo.add(dataItem);
        }


        HashMap<String, Object> data = new HashMap<>();
        data.put("total",total);
        data.put("houseInfo",houseInfo);
        return new ResponeseEntity("success","200",data);
    }

    @GetMapping("/getAllHistoryId")
    public ResponeseEntity getAllHistoryId(@RequestParam int userid){
        String historyids = houseService.getHistoryId(userid);
        if(historyids.equals("null")){
            return  new ResponeseEntity("null data","203",null);
        }
        String[] split = historyids.split(";");
        HashMap<String, Object> data = new HashMap<>();
        data.put("houseids",split);
        return new ResponeseEntity("success","200",data);
    }

    @GetMapping("/getHistroyHouse")
    public ResponeseEntity getHistroyHouse(@RequestParam List<Integer> houseids,@RequestParam int userid){
        List<Map<String, Object>> houseInfo = new ArrayList<>();
        for (Integer houseid : houseids) {
            List<Object> infoList=houseService.getSingleHouseBriefByHouseid(houseid,userid);
            if(!infoList.isEmpty()){
                HashMap<String, Object> dataItem =(HashMap<String, Object>) infoList.get(4);
                houseInfo.add(dataItem);
            }
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("houseInfo",houseInfo);
        return new ResponeseEntity("success","200",data);
    }


}
