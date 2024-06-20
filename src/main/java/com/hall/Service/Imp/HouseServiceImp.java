package com.hall.Service.Imp;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hall.Bean.*;
import com.hall.DAO.*;
import com.hall.Service.HouseService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class HouseServiceImp implements HouseService {


    private static final OkHttpClient client = new OkHttpClient();
    @Resource
    HouseOverviewMapper houseOverviewMapper;

    @Resource
    LandlordsMapper landlordsMapper;

    @Resource
    HouseLocationMapper houseLocationMapper;

    @Resource
    houseImagesMapper houseImagesMapper;

    @Resource
    HouseFacilitiesMapper houseFacilitiesMapper;

    @Resource
    houseFeaturesMapper houseFeaturesMapper;
    @Resource
    PoliciesMapper policiesMapper;

    @Resource
    CommentImagesMapper commentImagesMapper;
    @Resource
    CommentsMapper commentsMapper;

    @Resource
    AvatarsMapper avatarsMapper;

    @Resource
    LandlordIntroMapper landlordIntroMapper;

    @Resource
    userFavoritesMapper userFavoritesMapper;
    @Resource
    BookingsMapper bookingsMapper;

    @Resource
    userMapper userMapper;

   @Resource
    UserBrowsingHistoryMapper userBrowsingHistoryMapper;


    @Override
    @Transactional
    public ResponeseEntity insertHouse(Map<String, Object> req) {
        HashMap houseOverviewObj;
        try {
            houseOverviewObj = (LinkedHashMap) req.get("houseOverview");
        }catch (ClassCastException e){
            System.out.println(e.getMessage());
            return new ResponeseEntity(e.getMessage(),"400",null);
        }
        System.out.println(houseOverviewObj);
        HouseOverview houseOverview = mapToHouseoverview(houseOverviewObj);

        houseOverviewMapper.insertSelective(houseOverview);

        Integer houseid = houseOverview.getHouseid();
//        拿到房屋id
        ArrayList pics;
        try {
            pics = (ArrayList) req.get("houseImg");
        }catch (ClassCastException e){
            System.out.println(e.getMessage());
             return new ResponeseEntity(e.getMessage(),"400",null);
        }
//        进行图片的处理
        for (Object pic : pics) {
            HashMap picMap = (HashMap) pic;
            String imagetype =(String) picMap.get("ImgGroup");
            ArrayList<String> urls = (ArrayList) picMap.get("urls");
            for (String url : urls) {
                houseImages houseImages = new houseImages();
                houseImages.setHouseid(houseid);
                houseImages.setUrl(url);
                houseImages.setImagetype(imagetype);
                houseImages.setHouseid(houseid);
                houseImagesMapper.insertSelective(houseImages);
            }
        }
//        处理位置信息
        String location =(String) req.get("houseLocation");
        if(location!=null){
//            调用api获得逆地理编码
//            把得到的数据插入到location表中
            try{
            String url = "https://restapi.amap.com/v3/geocode/regeo?key=ca5638622884957be4cff8d31d00b1b0&location="+location;
            String responseJson = sendGetRequest(url);
            JSONObject jsonObject = JSONObject.parseObject(responseJson);
            HouseLocation location1 = getLocation(jsonObject);
                String[] split = location.split(",");
                location1.setLongitude(Double.parseDouble(split[0]));
                location1.setLatitude(Double.parseDouble(split[1]));
                location1.setLocation(location);
            location1.setHouseid(houseid);
            houseLocationMapper.insertSelective(location1);

            }catch (IOException e){
                System.out.println(e.getMessage());
                return new ResponeseEntity(e.getMessage(),"400",null);
            }
        }
        //        处理设施信息
        HashMap<String,String> facilities= (HashMap<String,String>) req.get("facilities");
        HouseFacilities houseFacilities = new HouseFacilities();
        houseFacilities.setService(facilities.get("service"));
        houseFacilities.setBasic(facilities.get("basic"));
        houseFacilities.setBathroom(facilities.get("bathroom"));
        houseFacilities.setKitchen(facilities.get("kitchen"));
        houseFacilities.setSurrounding(facilities.get("surrounding"));
        houseFacilities.setSafety(facilities.get("safety"));
        houseFacilities.setEntertainment(facilities.get("entertainment"));
        houseFacilities.setLeisure(facilities.get("leisure"));
        houseFacilities.setChildren(facilities.get("children"));
        houseFacilities.setHouseid(houseid);

//        插入 设施表
        houseFacilitiesMapper.insertSelective(houseFacilities);
//        处理特色信息
        ArrayList<Map<String,String>> features = (ArrayList<Map<String,String>>) req.get("features");
        for (Map<String, String> feature : features) {
            houseFeatures houseFeatures = new houseFeatures();
            houseFeatures.setFeaturetype(feature.get("featureType"));
            houseFeatures.setFeaturecontent(feature.get("featureContent"));
            houseFeatures.setHouseid(houseid);
//            插入设施表的数据库操作

            houseFeaturesMapper.insertSelective(houseFeatures);
        }

//        处理政策信息
        Map<String,Object> plcy =(Map<String,Object>) req.get("policies");
//        插入政策表
        Policies policies = new Policies();
        policies.setHouseid(houseid);
        policies.setCancelpolicy((String) plcy.get("cancelPolicy"));
        policies.setAllowaddguests( Double.parseDouble ((String) plcy.get("allowAddGuests")));
        policies.setDeposit(Double.parseDouble((String) plcy.get("deposit")));
        policies.setNeedtoknow((String) plcy.get("needToKnow"));

//        调用数据库插入政策表
        policiesMapper.insertSelective(policies);
        return new ResponeseEntity("插入成功","200",null);
    }

    @Override
    @Transactional
    public ResponeseEntity getHouseByHouseid(int houseid,int useridfromClient) {

//        获取到房屋概览数据
        HouseOverview houseOverview = houseOverviewMapper.selectByPrimaryKey(houseid);
        if(houseOverview==null){
            return new ResponeseEntity("house not exist or has deleted","400",null);
        }

//        创建一个要返回的数据对象
        HashMap<String, Object> data = new HashMap<>();
        data.put("houseOverview",houseOverview);

//        查询房屋图片数据
        houseImagesExample houseImagesExample = new houseImagesExample();
        houseImagesExample.Criteria houseImagescriteria = houseImagesExample.createCriteria();
        houseImagescriteria.andHouseidEqualTo(houseid);
        List<houseImages> houseImages = houseImagesMapper.selectByExample(houseImagesExample);
//        把房屋数据加入到返回数据中
        data.put("houseImgs",houseImages);

//        获取房屋位置数
        HouseLocationExample houseLocationExample = new HouseLocationExample();
        HouseLocationExample.Criteria locationCriteria = houseLocationExample.createCriteria();
        locationCriteria.andHouseidEqualTo(houseid);
        List<HouseLocation> houseLocations = houseLocationMapper.selectByExample(houseLocationExample);
        if(!houseLocations.isEmpty()){data.put("location",houseLocations.get(0));}


//        获取设施信息
        HouseFacilities facilitiyNumber = houseFacilitiesMapper.getFacilityByHouseid(houseid);
        List<Facilities> facilities = getFacilities(facilitiyNumber);
        data.put("facilities",facilities);

        //获取特色信息
        houseFeaturesExample houseFeaturesExample = new houseFeaturesExample();
        houseFeaturesExample.Criteria houseFeaturescriteria = houseFeaturesExample.createCriteria();
        houseFeaturescriteria.andHouseidEqualTo(houseid);
        List<houseFeatures> houseFeatures = houseFeaturesMapper.selectByExample(houseFeaturesExample);
        data.put("features",houseFeatures);

        //获取政策信息
        PoliciesExample policiesExample = new PoliciesExample();
        PoliciesExample.Criteria policiesCriteria = policiesExample.createCriteria();
        policiesCriteria.andHouseidEqualTo(houseid);
        List<Policies> policies = policiesMapper.selectByExample(policiesExample);

        data.put("policies",policies.get(0));

        //获取评论信息
        CommentsWithBLOBs comments = commentsMapper.selectLatestCommentByHouseid(houseid);
        HashMap<String, Object> Avatars = new HashMap<>();
        if (comments!=null){
            HashMap<String, Object> commentBrief = new HashMap<>();
            commentBrief.put("commentContent",comments);

            //获取用户头像
            Integer userid = comments.getUserid();
            System.out.println(userid);
            user user = userMapper.selectByPrimaryKey(userid);
            String useravatarpic = user.getAvatarpic();
            Avatars.put("userAvatars",useravatarpic);
            Boolean hasimage = comments.getHasimage();
            System.out.println(hasimage);
            //判断有没有图片，有图片再查评论图片表
            if (hasimage){
                CommentImagesExample commentImagesExample = new CommentImagesExample();
                CommentImagesExample.Criteria criteria = commentImagesExample.createCriteria();
                criteria.andCommentidEqualTo(comments.getCommentid());
                List<CommentImages> commentImages = commentImagesMapper.selectByExample(commentImagesExample);
                commentBrief.put("commentImages",commentImages);
            }

            data.put("commentBrief",commentBrief);
        }else{
            data.put("commentBrief",new HashMap<>());
        }


        //获取房东头像
        Integer landlordid = houseOverview.getLandlordid();
        Landlords landlords = landlordsMapper.selectByPrimaryKey(landlordid);
        String landlordavatar = landlords.getAvatar();

        Avatars.put("landLordAvatars",landlordavatar);
        data.put("avatars",Avatars);





        BookingsExample bookingsExample = new BookingsExample();
        BookingsExample.Criteria bookcriteria = bookingsExample.createCriteria();
        bookcriteria.andHouseidEqualTo(houseid).andBstatusEqualTo("Booked");
        List<Bookings> bookings = bookingsMapper.selectByExample(bookingsExample);

        ArrayList<Object> bookingTimeList = new ArrayList<>();

        for (Bookings booking : bookings) {
            LocalDate sdate = dateToLD(booking.getSdate()) ;
            LocalDate edate = dateToLD(booking.getEdate()) ;
            // 创建一个DateTimeFormatter对象，并指定日期格式为yyyy-MM-dd
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // 使用SimpleDateFormat对象将Date对象转换为字符串
            for (LocalDate date = sdate; !date.isAfter(edate); date = date.plusDays(1)) {
                // 将LocalDate对象格式化为字符串并添加到列表中
                Map<String, Object> listItem = new HashMap<>();
                listItem.put("date",date.format(formatter));
                listItem.put("info","不可租");
                listItem.put("disable",true);
                bookingTimeList.add(listItem);
            }



        }
        data.put("bookingTimeList",bookingTimeList);

        String landlordTel = landlordsMapper.getLandlordTel(landlordid);
        data.put("landlordTel",landlordTel);

        return new ResponeseEntity("success","200",data);


    }
    public LocalDate dateToLD(Date date){
        ZoneId zoneId = ZoneId.systemDefault();

        // 将 Date 转换为 ZonedDateTime
        ZonedDateTime zonedDateTime = date.toInstant().atZone(zoneId);

        // 从 ZonedDateTime 获取 LocalDate
        LocalDate localDate = zonedDateTime.toLocalDate();
        return localDate;
    }
    @Override
    @Transactional
    public ResponeseEntity getAllCommentByHouseid(int houseid, int page) {
        try {
            PageHelper.startPage(page, 10);


            List<CommentsWithBLOBs> comments = commentsMapper.selectCommentByHouseid(houseid);
            HashMap<String, Object> data = new HashMap<>();
            ArrayList<Object> commentList = new ArrayList<>();


            for (CommentsWithBLOBs comment : comments) {
                HashMap<String, Object> data_item = new HashMap<>();
                data_item.put("commentContent",comment);
                //获取用户头像
                Integer userid = comment.getUserid();
                user user = userMapper.selectByPrimaryKey(userid);
                String avatarpic = user.getAvatarpic();

                //获取房东头像
                Integer landlordid = comment.getLandlordid();
                Landlords landlords = landlordsMapper.selectByPrimaryKey(landlordid);
                String landlordsavatar = landlords.getAvatar();

                HashMap<String, Object> Avatars = new HashMap<>();
                Avatars.put("userAvatars",avatarpic);
                Avatars.put("landLordAvatars",landlordsavatar);
                data_item.put("avatars",Avatars);
                if(comment.getHasimage()){
                    Integer commentid = comment.getCommentid();
                    CommentImagesExample commentImagesExample = new CommentImagesExample();
                    CommentImagesExample.Criteria criteria = commentImagesExample.createCriteria();
                    criteria.andCommentidEqualTo(commentid);
                    List<CommentImages> commentImages = commentImagesMapper.selectByExample(commentImagesExample);
                    data_item.put("commentImages",commentImages);
                }
                commentList.add(data_item);
            }
            data.put("comments",commentList);
            return new ResponeseEntity("查询成功","200",data);
        }catch (Exception e){
            return new ResponeseEntity("失败原因："+e.getMessage(),"400",null);
        }

    }

    @Override
    public void updateHotValue(int houseid) {
        HouseOverview houseOverview = houseOverviewMapper.selectByPrimaryKey(houseid);
        Integer viewcount = houseOverview.getViewcount();
        Integer favoritecount = houseOverview.getFavoritecount();
        Integer dealcount = houseOverview.getDealcount();
        Integer newHotValue= (int)(viewcount*40+favoritecount*30+dealcount*20+(dealcount/viewcount)*10);
        HouseOverview update = new HouseOverview();
        update.setHouseid(houseid);
        update.setHotvalue(newHotValue);
        houseOverviewMapper.updateByPrimaryKeySelective(update);
    }

    @Override
    public void updateCommentcount(int hid){
        houseOverviewMapper.updateCommentcount(hid);
    }
    @Override
    public void updateLandlordName(int lid, String name){
        houseOverviewMapper.changelandlordname(lid,name);
    }

    @Override
    public void updateRating(int houseid, double rating){
        HouseOverview houseOverview = new HouseOverview();
        houseOverview.setHouseid(houseid);
        houseOverview.setRating(rating);
        houseOverviewMapper.updateByPrimaryKeySelective(houseOverview);
    }

    @Override
    public boolean favorHouse(int houseid, int userid) {
        userFavoritesExample userFavoritesExample = new userFavoritesExample();
        com.hall.Bean.userFavoritesExample.Criteria criteria = userFavoritesExample.createCriteria();
        criteria.andHouseidEqualTo(houseid).andUseridEqualTo(userid);
        List<userFavorites> userFavorites1 = userFavoritesMapper.selectByExample(userFavoritesExample);
//        如果不存在记录，就收藏
        if(userFavorites1.isEmpty()){
            userFavorites userFavorites = new userFavorites();
            userFavorites.setHouseid(houseid);
            userFavorites.setUserid(userid);

            userFavoritesMapper.insertSelective(userFavorites);
            return true;
        }else{
//            如果存在，就取消收藏
            userFavoritesMapper.deleteByExample(userFavoritesExample);
            return false;
        }


    }

    @Override
    public boolean queryfavor(int houseid, int userid) {
        userFavoritesExample userFavoritesExample = new userFavoritesExample();
        com.hall.Bean.userFavoritesExample.Criteria criteria = userFavoritesExample.createCriteria();
        criteria.andHouseidEqualTo(houseid).andUseridEqualTo(userid);
        List<userFavorites> userFavorites1 = userFavoritesMapper.selectByExample(userFavoritesExample);
//        如果不存在记录，就收藏
        if(userFavorites1.isEmpty()){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public void updateFavor(int houseid,boolean addOrSub){
        HouseOverview houseOverview = houseOverviewMapper.selectByPrimaryKey(houseid);
        Integer favoritecount = houseOverview.getFavoritecount();
        if(addOrSub){
//            收藏数加一
            favoritecount+=1;
        }else {
//            收藏数减一
            favoritecount-=1;
        }

        HouseOverview houseOverview1 = new HouseOverview();
        houseOverview1.setHouseid(houseid);
        houseOverview1.setFavoritecount(favoritecount);
        houseOverviewMapper.updateByPrimaryKeySelective(houseOverview1);
    }

    @Override
    @Transactional
    public ResponeseEntity getLandlordDetail(int landlordid,int userid,int page){
        try{
//        主要查询房东的其他房源和房东简介，因为其他的信息在房屋详情页已经查到了
        LandlordIntroExample landlordIntroExample = new LandlordIntroExample();
        LandlordIntroExample.Criteria criteria = landlordIntroExample.createCriteria();
        criteria.andLandlordidEqualTo(landlordid);

        List<LandlordIntro> landlordIntros = landlordIntroMapper.selectByExample(landlordIntroExample);


        PageHelper.startPage(page, 12);
        List<HouseOverview> houseOverviews = houseOverviewMapper.selectHouseIntroBylandlord(landlordid);

        List<Object> dataList=new ArrayList<>();
        for (HouseOverview houseOverview : houseOverviews) {
            HashMap<String, Object> dataItem = new HashMap<>();
            dataItem.put("overview",houseOverview);
            Integer houseid = houseOverview.getHouseid();
//            查询地理位置
            HouseLocationExample houseLocationExample = new HouseLocationExample();
            HouseLocationExample.Criteria locationcriteria = houseLocationExample.createCriteria();
            locationcriteria.andHouseidEqualTo(houseid);
            List<HouseLocation> houseLocations = houseLocationMapper.selectByExample(houseLocationExample);
            HouseLocation houseLocation = houseLocations.get(0);
            dataItem.put("locationInfo",houseLocation);
//            查询该房屋用户是否收藏
            userFavoritesExample userFavoritesExample = new userFavoritesExample();
            userFavoritesExample.Criteria criteria1 = userFavoritesExample.createCriteria();
            criteria1.andHouseidEqualTo(houseid).andUseridEqualTo(userid);
            List<userFavorites> userFavorites = userFavoritesMapper.selectByExample(userFavoritesExample);
            if(userFavorites.isEmpty()){
                dataItem.put("islike",false);
            }else {
                dataItem.put("islike",true);
            }
            dataList.add(dataItem);
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("houseInfo",dataList);
        if (landlordIntros.isEmpty()){
            data.put("landlordInfo",null);
        }else{
            data.put("landlordInfo",landlordIntros.get(0));
        }



            Landlords brief = landlordsMapper.getBrief(landlordid);
            data.put("landlordbrief",brief);
            return new ResponeseEntity("success","200",data);
        }catch (Exception e){
            return new ResponeseEntity("错误原因"+e.getMessage(),"500",null);
        }
    }

@Override
@Transactional
    public ResponeseEntity insertHouseAndComment(Map<String, Object> req){
    HashMap houseOverviewObj;
    try {
        houseOverviewObj = (HashMap) req.get("houseOverview");
    }catch (ClassCastException e){
        System.out.println(e.getMessage());
        return new ResponeseEntity(e.getMessage(),"400",null);
    }

    HouseOverview houseOverview = mapToHouseoverview2(houseOverviewObj);

    String landlordAvatar = (String)houseOverviewObj.get("landlordAvatar");
    String landlordnickname = (String)houseOverviewObj.get("landlordnickname");
    LandlordsExample landlordsExample = new LandlordsExample();
    LandlordsExample.Criteria ldcriteria = landlordsExample.createCriteria();
    ldcriteria.andNicknameEqualTo(landlordnickname).andAvatarEqualTo(landlordAvatar);
    List<Landlords> landlords = landlordsMapper.selectByExample(landlordsExample);
    int landId=0;
    if(landlords.isEmpty()){
//        新建一个房东
        Landlords newlandlord = new Landlords();
        newlandlord.setAvatar(landlordAvatar);
        newlandlord.setNickname(landlordnickname);
        newlandlord.setPhonenumber(generateRandomPhoneNumber());
        newlandlord.setBalance(1111.11);
        landlordsMapper.insertSelective(newlandlord);

//        拿到房东id
         landId = newlandlord.getLandlordid();
        List<HashMap<String,String>> landlordIntroList =(ArrayList<HashMap<String,String>>) req.get("landlordIntro");
        LandlordIntro landlordIntro = new LandlordIntro();
        landlordIntro.setLandlordid(landId);
        landlordIntro.setIntrotitle(landlordIntroList.get(0).get("introtitle"));
        landlordIntro.setIntrocont(landlordIntroList.get(0).get("introcont"));
        landlordIntroMapper.insertSelective(landlordIntro);
        // 头像表
        Avatars avatars = new Avatars();
        avatars.setRole("landlord");
        avatars.setUid(landId);
        avatars.setUrl(landlordAvatar);
        avatarsMapper.insertSelective(avatars);
    }
    if(landId==0){
        landId=landlords.get(0).getLandlordid();
    }
//        查询房东数据库，如果房东不存在就返回

//        房东存在，插入房屋概览，拿到房屋id
    houseOverview.setLandlordid(landId);

    houseOverviewMapper.insertSelective(houseOverview);

    Integer houseid = houseOverview.getHouseid();
//        拿到房屋id
    ArrayList pics;
    try {
        pics = (ArrayList) req.get("houseImg");
    }catch (ClassCastException e){
        System.out.println(e.getMessage());
        return new ResponeseEntity(e.getMessage(),"400",null);
    }
//        进行图片的处理
    for (Object pic : pics) {
        HashMap picMap = (HashMap) pic;
        String imagetype =(String) picMap.get("ImgGroup");
        ArrayList<String> urls = (ArrayList) picMap.get("urls");
        for (String url : urls) {
            houseImages houseImages = new houseImages();
            houseImages.setHouseid(houseid);
            houseImages.setUrl(url);
            houseImages.setImagetype(imagetype);
//                拿着imgurl去图片表中查询对应的path，如果查到的结果为空就不进行操作
//                把记录插入到houseImage表
            houseImagesMapper.insertSelective(houseImages);
        }
    }
//        处理位置信息
    String location =(String) req.get("houseLocation");
    if(location!=null){
//            调用api获得逆地理编码
//            把得到的数据插入到location表中
        try{
            String url = "https://restapi.amap.com/v3/geocode/regeo?key=ca5638622884957be4cff8d31d00b1b0&location="+location;
            String responseJson = sendGetRequest(url);
            JSONObject jsonObject = JSONObject.parseObject(responseJson);
            HouseLocation location1 = getLocation(jsonObject);
            location1.setLocation(location);
            location1.setHouseid(houseid);
            String[] split = location.split(",");
            location1.setLongitude(Double.parseDouble(split[0]));
            location1.setLatitude(Double.parseDouble(split[1]));
            houseLocationMapper.insertSelective(location1);

        }catch (IOException e){
            System.out.println(e.getMessage());
            return new ResponeseEntity(e.getMessage(),"400",null);
        }
    }
    //        处理设施信息
    HashMap<String,String> facilities= (HashMap<String,String>) req.get("facilities");
    HouseFacilities houseFacilities = new HouseFacilities();
    houseFacilities.setService(facilities.get("service"));
    houseFacilities.setBasic(facilities.get("basic"));
    houseFacilities.setBathroom(facilities.get("bathroom"));
    houseFacilities.setKitchen(facilities.get("kitchen"));
    houseFacilities.setSurrounding(facilities.get("surrounding"));
    houseFacilities.setSafety(facilities.get("safety"));
    houseFacilities.setEntertainment(facilities.get("entertainment"));
    houseFacilities.setLeisure(facilities.get("leisure"));
    houseFacilities.setChildren(facilities.get("children"));
    houseFacilities.setHouseid(houseid);

//        插入 设施表
    houseFacilitiesMapper.insertSelective(houseFacilities);
//        处理特色信息
    ArrayList<Map<String,String>> features = (ArrayList<Map<String,String>>) req.get("features");
    for (Map<String, String> feature : features) {
        houseFeatures houseFeatures = new houseFeatures();
        houseFeatures.setFeaturetype(feature.get("featureType"));
        houseFeatures.setFeaturecontent(feature.get("featureContent"));
        houseFeatures.setHouseid(houseid);
//            插入设施表的数据库操作

        houseFeaturesMapper.insertSelective(houseFeatures);
    }

//        处理政策信息
    Map<String,Object> plcy =(Map<String,Object>) req.get("policies");
//        插入政策表
    Policies policies = new Policies();
    policies.setHouseid(houseid);
    policies.setCancelpolicy((String) plcy.get("cancelPolicy"));
    policies.setAllowaddguests( Double.parseDouble ((String) plcy.get("allowAddGuests")));
    policies.setDeposit(Double.parseDouble((String) plcy.get("deposit")));
    policies.setNeedtoknow((String) plcy.get("needToKnow"));

//        调用数据库插入政策表
    policiesMapper.insertSelective(policies);

    //插入评论
    List<Map<String,Object>> commentlist =(List<Map<String,Object>>) req.get("comments");
    if(!commentlist.isEmpty()){
        for (Map<String, Object> comment : commentlist) {
            CommentsWithBLOBs commentObj = new CommentsWithBLOBs();
            String uname= (String)comment.get("username");
            commentObj.setUsername(uname);
            commentObj.setHouseid(houseid);

            userExample userExample = new userExample();
            userExample.Criteria criteria = userExample.createCriteria();
            criteria.andUsernameEqualTo(uname);
            List<user> users = userMapper.selectByExample(userExample);
            int userid=0;
            if(users.isEmpty()){
                user user = new user();
                user.setPhonenumber(generateRandomPhoneNumber());
                user.setUsername(uname);
                user.setRole("tenant");
                user.setRegistrationdate(new Date());
                user.setPassword("00000000");
                user.setAvatarpic((String) comment.get("uAvatar"));
                userMapper.insertSelective(user);
                userid=user.getUserid();


            }

            if(userid==0){
                userid=users.get(0).getUserid();
            }
            String dateString =(String) comment.get("commentTime");
            String timestampString = dateString.substring(6, dateString.indexOf('+'));
            long timestamp = Long.parseLong(timestampString);

            // 将时间戳转换为时间对象
            Date date = new Date(timestamp);
            commentObj.setCommenttime(date);
            commentObj.setUserid(userid);
            commentObj.setCleanliness(Double.parseDouble((String)comment.get("cleanliness")));
            commentObj.setAccuracy(Double.parseDouble((String)comment.get("accuracy")));
            commentObj.setLocationtransport(Double.parseDouble((String)comment.get("locationTransport")));
            commentObj.setSafety(Double.parseDouble((String)comment.get("safety")));
            commentObj.setValueformmoney(Double.parseDouble((String)comment.get("valueForMmoney")));
            commentObj.setRating(Double.parseDouble((String)comment.get("rating")));
            Boolean hasImage=(boolean)comment.get("hasImage");

            commentObj.setHasimage(hasImage);

            System.out.println(hasImage);
            String replyDetail = (String) comment.get("replyDetail");
            if (replyDetail.isEmpty()){
                commentObj.setLandlordreply(null);
            }else{
                commentObj.setLandlordreply(replyDetail);
            }
            System.out.println("reply"+commentObj.getLandlordreply());
//            String a ="dfs";
//            Integer.parseInt(a);
            commentObj.setCommentcontent((String)comment.get("commentContent"));
            System.out.println("content"+commentObj.getCommentcontent());
            commentObj.setLandlordid(landId);
            commentsMapper.insertSelective(commentObj);
            Integer commentid = commentObj.getCommentid();
            if(hasImage){
//                插入评论图片
                List<String> pictures =(List<String>) comment.get("pictures");
                for (String picture : pictures) {
                    CommentImages commentImages = new CommentImages();
                    commentImages.setUrl(picture);
                    commentImages.setUserid(userid);
                    commentImages.setCommentid(commentid);

                    commentImagesMapper.insertSelective(commentImages);
                }
            }

        }
    }
    return new ResponeseEntity("插入成功","200",null);
    }


    public HouseOverview mapToHouseoverview(HashMap map){
        String houseName;
        String address;
        int bedCount;
        int roomCount;
        int bathroomCount;
        int kitchenCount;
        String coverUrl;
        double discountPrice;
        double originalPrice;
        String rentalType;
        int maxGuests;
        String houseType;
        int landlordId;
        String landlordNickname;
        int bed218;
        int bed215;
        int bed212;
        String tatami;
        try {
            houseName = (String) map.get("housename");
            address = (String) map.get("address");
            bedCount = (int) map.get("bedcount");
            roomCount = (int) map.get("roomcount");
            bathroomCount = (int) map.get("bathroomcount");
            kitchenCount = (int) map.get("kitchencount");
            coverUrl = (String) map.get("coverurl");
            String dpString = (String) map.get("discountprice");
            discountPrice = Double.parseDouble(dpString);
            String opString = (String) map.get("originalprice");
            originalPrice = Double.parseDouble(opString) ;
            rentalType = (String) map.get("rentaltype");
            maxGuests = (int) map.get("maxguests");
            houseType = (String) map.get("housetype");
            landlordId = (int) map.get("landlordid");
            landlordNickname = (String) map.get("landlordnickname");
            bed218 = (int) map.get("bed218");
            bed215 = (int) map.get("bed215");
            bed212 = (int) map.get("bed212");
            tatami = (String) map.get("tatami");

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());

            return null;
        }
        HouseOverview houseOverview = new HouseOverview();
        houseOverview.setHousename(houseName);
        houseOverview.setAddress(address);
        houseOverview.setBedcount(bedCount);
        houseOverview.setRoomcount(roomCount);
        houseOverview.setBathroomcount(bathroomCount);
        houseOverview.setKitchencount(kitchenCount);
        houseOverview.setCoverurl(coverUrl);
        houseOverview.setDiscountprice(discountPrice);
        houseOverview.setOriginalprice(originalPrice);
        houseOverview.setRentaltype(rentalType);
        houseOverview.setLandlordid(landlordId);
        houseOverview.setMaxguests(maxGuests);
        houseOverview.setHousetype(houseType);
        houseOverview.setLandlordnickname(landlordNickname);
        houseOverview.setBed218(bed218);
        houseOverview.setBed215(bed215);
        houseOverview.setBed212(bed212);
        houseOverview.setTatami(tatami);
        houseOverview.setCommentcount(0);
        houseOverview.setFavoritecount(0);
        houseOverview.setDealcount(0);
        houseOverview.setViewcount(0);
        houseOverview.setRating(4.0);
        houseOverview.setVstatus("审核通过");
        houseOverview.setHotvalue(20000);
        return houseOverview;
    }
    public HouseOverview mapToHouseoverview2(HashMap map){
        String houseName;
        String address;
        int bedCount;
        int roomCount;
        int bathroomCount;
        int kitchenCount;
        String coverUrl;
        double discountPrice;
        double originalPrice;
        String rentalType;
        int maxGuests;
        String houseType;
        String landlordNickname;
        int bed218;
        int bed215;
        int bed212;
        double rating;
        int hotValue;
        String tatami;
        int viewcount;
        int favoritecount;
        int dealcount;
        int commentcount;
        try {
            houseName = (String) map.get("housename");
            address = (String) map.get("address");
            bedCount = (int) map.get("bedcount");
            roomCount = (int) map.get("roomcount");
            bathroomCount = (int) map.get("bathroomcount");
            kitchenCount = (int) map.get("kitchencount");
            coverUrl = (String) map.get("coverurl");
            String dpString = (String) map.get("discountprice");
            discountPrice = Double.parseDouble(dpString);
            String opString = (String) map.get("originalprice");
            originalPrice = Double.parseDouble(opString) ;
            rentalType = (String) map.get("rentaltype");
            maxGuests = (int) map.get("maxguests");
            houseType = (String) map.get("housetype");
            landlordNickname = (String) map.get("landlordnickname");
            bed218 = (int) map.get("bed218");
            bed215 = (int) map.get("bed215");
            bed212 = (int) map.get("bed212");
            tatami = (String) map.get("tatami");
            String ratingStr=(String) map.get("rating");
            rating=Double.parseDouble(ratingStr);
            viewcount = (int) map.get("viewcount");
            hotValue = (int) map.get("hotValue");
            favoritecount=(int) map.get("favoritecount");
            dealcount = (int) map.get("dealcount");
            commentcount=(int)map.get("commentcount");
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());

            return null;
        }
        HouseOverview houseOverview = new HouseOverview();
        houseOverview.setHousename(houseName);
        houseOverview.setAddress(address);
        houseOverview.setBedcount(bedCount);
        houseOverview.setRoomcount(roomCount);
        houseOverview.setBathroomcount(bathroomCount);
        houseOverview.setKitchencount(kitchenCount);
        houseOverview.setCoverurl(coverUrl);
        houseOverview.setDiscountprice(discountPrice);
        houseOverview.setOriginalprice(originalPrice);
        houseOverview.setRentaltype(rentalType);
        houseOverview.setMaxguests(maxGuests);
        houseOverview.setHousetype(houseType);
        houseOverview.setLandlordnickname(landlordNickname);
        houseOverview.setBed218(bed218);
        houseOverview.setBed215(bed215);
        houseOverview.setBed212(bed212);
        houseOverview.setTatami(tatami);
        houseOverview.setCommentcount(commentcount);
        houseOverview.setRating(rating);
        houseOverview.setViewcount(viewcount);
        houseOverview.setHotvalue(hotValue);
        houseOverview.setFavoritecount(favoritecount);
        houseOverview.setDealcount(dealcount);
        return houseOverview;
    }

    public static String sendGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    public HouseLocation getLocation(JSONObject jsonObject){
        JSONObject regeocode = jsonObject.getJSONObject("regeocode");
        String address = regeocode.getString("formatted_address");

        JSONObject addressComponent = regeocode.getJSONObject("addressComponent");
        String province = addressComponent.getString("province");
        String city = addressComponent.getString("city");
        String district = addressComponent.getString("district");
        String town = addressComponent.getString("township");
        HouseLocation houseLocation = new HouseLocation();
        if (address != null && !address.isEmpty()) {
            houseLocation.setRegeocodingaddress(address);
        }

        if (city != null && !city.isEmpty()) {
           houseLocation.setCity(city);
        }

        if (province != null && !province.isEmpty()) {
            houseLocation.setProvince(province);
        }

        if (town != null && !town.isEmpty()) {
            houseLocation.setTown(town);
        }

        if (district != null && !district.isEmpty()) {
            houseLocation.setCounty(district);
        }

        return houseLocation;
    }

    public List<Facilities> getFacilities(HouseFacilities facilitiyNumber){
        String service = facilitiyNumber.getService();
        String basic = facilitiyNumber.getBasic();
        String bathroom = facilitiyNumber.getBathroom();
        String kitchen = facilitiyNumber.getKitchen();
        String surrounding = facilitiyNumber.getSurrounding();
        String safety = facilitiyNumber.getSafety();
        String entertainment = facilitiyNumber.getEntertainment();
        String leisure = facilitiyNumber.getLeisure();
        String children = facilitiyNumber.getChildren();



        ArrayList<String> facCharList =new ArrayList<>(Arrays.asList(service,basic,bathroom,kitchen,surrounding,safety,entertainment,leisure,children));
        int index = 0;
        ArrayList<Facilities> facilities = new ArrayList<>();
        for (String facCharListItem : facCharList) {
            char[] charArray = facCharListItem.toCharArray();
            Facilities facilities1 = new Facilities();
            facilities1.setGroup(Facilities.facGroupList.get(index));
            ArrayList<FacItem> facItemList = new ArrayList<>();
            ArrayList<ArrayList<String>> facItemTextList = FacItem.facItemTextList;
            ArrayList<String> currentGourpTextGroup = facItemTextList.get(index);
            index++;
            for (int i = 0; i <charArray.length; i++) {
                FacItem facItem = new FacItem();
                facItem.setFacName(currentGourpTextGroup.get(i));
                if(charArray[i]=='0'){
                    facItem.setVaild(false);
                }else{
                    facItem.setVaild(true);
                }
                facItemList.add(facItem);
            }
            facilities1.setItems(facItemList);
            facilities.add(facilities1);
        }
        return facilities;
    }

    public  String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder();
        Random random = new Random();

        // 第一位数字不为0
        phoneNumber.append(random.nextInt(9) + 1);

        // 生成剩余10位数字
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }

        return phoneNumber.toString();
    }

    @Override
@Transactional
    public void addViewCount(int houseid,int userid){
//        增加浏览量
//        1.对应房屋的浏览量加一
        HouseOverview houseOverview = houseOverviewMapper.selectByPrimaryKey(houseid);
        Integer viewcount = houseOverview.getViewcount();
        viewcount=viewcount+1;
        HouseOverview updateOverview = new HouseOverview();
        updateOverview.setHouseid(houseid);
        updateOverview.setViewcount(viewcount);
        houseOverviewMapper.updateByPrimaryKeySelective(updateOverview);

//        2.往浏览记录表中添加对应的记录
        UserBrowsingHistoryExample userBrowsingHistoryExample = new UserBrowsingHistoryExample();
        UserBrowsingHistoryExample.Criteria criteria = userBrowsingHistoryExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<UserBrowsingHistory> userBrowsingHistories = userBrowsingHistoryMapper.selectByExampleWithBLOBs(userBrowsingHistoryExample);
    System.out.println(userBrowsingHistories);
        UserBrowsingHistory userBrowsingHistory=null;
        if(userBrowsingHistories.isEmpty()){
            userBrowsingHistory = new UserBrowsingHistory();
            userBrowsingHistory.setUserid(userid);
            userBrowsingHistoryMapper.insertSelective(userBrowsingHistory);
        }else{

            userBrowsingHistory = userBrowsingHistories.get(0);
        }

        String houseids = userBrowsingHistory.getHouseids();
        if(houseids==null){
            houseids=String.valueOf(houseid)+";";
        }else {

            String[] houseidArr = houseids.split(";");
            int index = -2;
            for (int i = 0; i < houseidArr.length; i++) {
                if(houseid==Integer.parseInt(houseidArr[i])){
                    index=i;
                    break;
                }else{
                    index=-1;
                }
            }

            String result;
            if(index!=-1){
                String[] newArray = new String[houseidArr.length - 1];
                int newIndex = 0;
                for (int i = 0; i < houseidArr.length; i++) {
                    if (i != index) {
                        newArray[newIndex++] = houseidArr[i];
                    }
                }
                 result = String.join(";", newArray);
            }else{
                result=houseids;
            }
            houseids=String.valueOf(houseid)+";"+result;
        }
        userBrowsingHistory.setHouseids(houseids);

        userBrowsingHistoryMapper.updateByExampleSelective(userBrowsingHistory,userBrowsingHistoryExample);
    }
//    @Override
//    public void changcomment() {
//        List<HouseOverview> houseOverviews = houseOverviewMapper.selectByExample(null);
//        for (HouseOverview houseOverview : houseOverviews) {
//            Integer houseid = houseOverview.getHouseid();
//            CommentsExample commentsExample = new CommentsExample();
//            CommentsExample.Criteria criteria = commentsExample.createCriteria();
//            criteria.andHouseidEqualTo(houseid);
//            long l = commentsMapper.countByExample(commentsExample);
//            if (l<20){
//                HouseOverview houseOverview1 = new HouseOverview();
//                houseOverview1.setHouseid(houseOverview.getHouseid());
//                houseOverview1.setCommentcount(Integer.parseInt(String.valueOf(l)));
//                houseOverviewMapper.updateByPrimaryKeySelective(houseOverview1);
//            }
//
//        }
//    }
    @Override
    public HashMap<String, Object> gethouseidsByLocation(double longitude, double latitude, double distance, int page){
        PageHelper.startPage(page, 10);
        List<Integer> houseids = houseLocationMapper.gethouseidsByLocation(longitude, latitude, distance);
        PageInfo<Integer> pageInfo = new PageInfo<>(houseids);
//        // 获取总记录数
        long total = pageInfo.getTotal();
        HashMap<String, Object> data = new HashMap<>();
        data.put("houseids",houseids);
        data.put("total",total);
        return data;
    }

    @Override
    public HouseLocation getLocationByHouseid(int houseid){
        HouseLocationExample houseLocationExample = new HouseLocationExample();
        HouseLocationExample.Criteria criteria = houseLocationExample.createCriteria();
        criteria.andHouseidEqualTo(houseid);
        List<HouseLocation> houseLocations = houseLocationMapper.selectByExample(houseLocationExample);
        return houseLocations.get(0);
    }
    @Override
    @Transactional
    public List<Object> getSingleHouseBriefByHouseid(int houseid, int userid){



        ArrayList<Object> infoList = new ArrayList<>();
        HouseOverview houseOverview = houseOverviewMapper.selectByPrimaryKey(houseid);

        if(houseOverview==null){
            return infoList;
        }

        HashMap<String, Object> dataItem = new HashMap<>();
        HouseLocationExample houseLocationExample = new HouseLocationExample();
        HouseLocationExample.Criteria hlc = houseLocationExample.createCriteria();
        hlc.andHouseidEqualTo(houseid);
        List<HouseLocation> houseLocations = houseLocationMapper.selectByExample(houseLocationExample);
        dataItem.put("locationInfo",houseLocations.get(0));
        dataItem.put("overview",houseOverview);
        Integer hotvalue = houseOverview.getHotvalue();
        Integer viewcount = houseOverview.getViewcount();
        Double discountprice = houseOverview.getDiscountprice();
        Integer favoritecount = houseOverview.getFavoritecount();

        infoList.add(hotvalue);
        infoList.add(viewcount);
        infoList.add(discountprice);
        infoList.add(favoritecount);

        //            查询该房屋用户是否收藏
        userFavoritesExample userFavoritesExample = new userFavoritesExample();
        userFavoritesExample.Criteria criteria1 = userFavoritesExample.createCriteria();
        criteria1.andHouseidEqualTo(houseid).andUseridEqualTo(userid);
        List<userFavorites> userFavorites = userFavoritesMapper.selectByExample(userFavoritesExample);
        if(userFavorites.isEmpty()){
            dataItem.put("islike",false);
        }else {
            dataItem.put("islike",true);
        }

        Landlords brief = landlordsMapper.getBrief(houseOverview.getLandlordid());
        dataItem.put("landlordAvatar",brief.getAvatar());

        List<String> coverurls = houseImagesMapper.getBriefUrlbyHouseId(houseid);
        dataItem.put("coverurls",coverurls);
        infoList.add(dataItem);
        infoList.add(houseLocations.get(0).getLongitude());
        infoList.add(houseLocations.get(0).getLatitude());
        return infoList;
    }

    @Override
    @Transactional
    public List<Object> getSingleHouseBriefByHouseidWithCondition(int houseid, int userid,
                                                                  Double maxPrice_c,
                                                                  Double minPrice_c,
                                                                  Integer bedcount_c,
                                                                  Integer roomcount_c,
                                                                  Integer maxpeople_c){
        HashMap<String, Object> dataItem = new HashMap<>();
        HouseLocationExample houseLocationExample = new HouseLocationExample();
        HouseLocationExample.Criteria hlc = houseLocationExample.createCriteria();
        hlc.andHouseidEqualTo(houseid);
        List<HouseLocation> houseLocations = houseLocationMapper.selectByExample(houseLocationExample);
        dataItem.put("locationInfo",houseLocations.get(0));



        ArrayList<Object> infoList = new ArrayList<>();
        HouseOverview houseOverview = houseOverviewMapper.selectByPrimaryKey(houseid);
        Integer hotvalue = houseOverview.getHotvalue();
        Integer viewcount = houseOverview.getViewcount();
        Double discountprice = houseOverview.getDiscountprice();
        Integer favoritecount = houseOverview.getFavoritecount();

        Integer bedcount = houseOverview.getBedcount();
        Integer roomcount = houseOverview.getRoomcount();
        Integer maxguests = houseOverview.getMaxguests();

        if(maxPrice_c!=null){
            if(discountprice>maxPrice_c){
                return null;
            }
        }
        if(minPrice_c!=null){
            if(discountprice<minPrice_c){
                return null;
            }
        }
        if(bedcount_c!=null){
            if(bedcount_c>=bedcount){
                return null;
            }
        }
        if(roomcount_c!=null){
            if(roomcount_c>roomcount){
                return null;
            }
        }

        if(maxpeople_c!=null){
            if(maxpeople_c>maxguests){
                return null;
            }
        }

        dataItem.put("overview",houseOverview);


        infoList.add(hotvalue);
        infoList.add(viewcount);
        infoList.add(discountprice);
        infoList.add(favoritecount);

        //            查询该房屋用户是否收藏
        userFavoritesExample userFavoritesExample = new userFavoritesExample();
        userFavoritesExample.Criteria criteria1 = userFavoritesExample.createCriteria();
        criteria1.andHouseidEqualTo(houseid).andUseridEqualTo(userid);
        List<userFavorites> userFavorites = userFavoritesMapper.selectByExample(userFavoritesExample);
        if(userFavorites.isEmpty()){
            dataItem.put("islike",false);
        }else {
            dataItem.put("islike",true);
        }
        Landlords brief = landlordsMapper.getBrief(houseOverview.getLandlordid());
        dataItem.put("landlordAvatar",brief.getAvatar());

        List<String> coverurls = houseImagesMapper.getBriefUrlbyHouseId(houseid);
        dataItem.put("coverurls",coverurls);
        infoList.add(dataItem);
        infoList.add(houseLocations.get(0).getLongitude());
        infoList.add(houseLocations.get(0).getLatitude());
        return infoList;
    }
    @Override
    public HashMap<String,Object> getFavorIds(int userid, int page){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, 10);
        List<Integer> favorids = userFavoritesMapper.getFavorids(userid);
        PageInfo<Integer> pageInfo = new PageInfo<>(favorids);
        // 获取总记录数
        long total = pageInfo.getTotal();
        map.put("total",total);
        map.put("houseids",favorids);
        return  map;
    }
    @Override
    public String getHistoryId(int userid){
        UserBrowsingHistoryExample userBrowsingHistoryExample = new UserBrowsingHistoryExample();
        UserBrowsingHistoryExample.Criteria criteria = userBrowsingHistoryExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<UserBrowsingHistory> userBrowsingHistories = userBrowsingHistoryMapper.selectByExampleWithBLOBs(userBrowsingHistoryExample);
        if (userBrowsingHistories.isEmpty()){
            return "null";
        }
        return userBrowsingHistories.get(0).getHouseids();
    }

    @Override
    @Transactional
    public ResponeseEntity deleteHouse(int lid,int hid){
        HouseOverviewExample houseOverviewExample = new HouseOverviewExample();
        HouseOverviewExample.Criteria criteria = houseOverviewExample.createCriteria();
        criteria.andHouseidEqualTo(hid).andLandlordidEqualTo(lid);
        List<HouseOverview> houseOverviews = houseOverviewMapper.selectByExample(houseOverviewExample);
        if (houseOverviews.isEmpty()){
//            非法操作
            return new ResponeseEntity("invalid option","400",null);
        }else{
//            删除概览表中的数据
            houseOverviewMapper.deleteByExample(houseOverviewExample);
//            删除房屋图片数据
            houseImagesExample houseImagesExample = new houseImagesExample();
            houseImagesExample.Criteria himageCon = houseImagesExample.createCriteria();
            himageCon.andHouseidEqualTo(hid);
            houseImagesMapper.deleteByExample(houseImagesExample);
//            删除对应的评论数据
            List<Integer> commenids = commentsMapper.selectImageCommentId(hid);
            if(!commenids.isEmpty()){
                //            删除评论图片数据
                commentImagesMapper.deleteImages(commenids.toArray(new Integer[0]));
            }
            CommentsExample commentsExample = new CommentsExample();
            CommentsExample.Criteria commentCon = commentsExample.createCriteria();
            commentCon.andHouseidEqualTo(hid);
            commentsMapper.deleteByExample(commentsExample);
//            删除政策表的数据
            PoliciesExample policiesExample = new PoliciesExample();
            PoliciesExample.Criteria policyCon = policiesExample.createCriteria();
            policyCon.andHouseidEqualTo(hid);
            policiesMapper.deleteByExample(policiesExample);
//            删除位置表的数据
            HouseLocationExample houseLocationExample = new HouseLocationExample();
            HouseLocationExample.Criteria locationCon = houseLocationExample.createCriteria();
            locationCon.andHouseidEqualTo(hid);
            houseLocationMapper.deleteByExample(houseLocationExample);
//            删除特色表的数据
            houseFeaturesExample houseFeaturesExample = new houseFeaturesExample();
            houseFeaturesExample.Criteria featureCon = houseFeaturesExample.createCriteria();
            featureCon.andHouseidEqualTo(hid);
            houseFeaturesMapper.deleteByExample(houseFeaturesExample);
//            删除收藏表中的数据
            userFavoritesExample userFavoritesExample = new userFavoritesExample();
            userFavoritesExample.Criteria favorCon = userFavoritesExample.createCriteria();
            favorCon.andHouseidEqualTo(hid);
            userFavoritesMapper.deleteByExample(userFavoritesExample);
//            删除预订表中的数据
            BookingsExample bookingsExample = new BookingsExample();
            BookingsExample.Criteria bookCon = bookingsExample.createCriteria();
            bookCon.andHouseidEqualTo(hid);
            bookingsMapper.deleteByExample(bookingsExample);
//            删除设施表里的数据
            HouseFacilitiesExample houseFacilitiesExample = new HouseFacilitiesExample();
            HouseFacilitiesExample.Criteria facCon = houseFacilitiesExample.createCriteria();
            facCon.andHouseidEqualTo(hid);
            houseFacilitiesMapper.deleteByExample(houseFacilitiesExample);
            return new ResponeseEntity("delete success","200",null);
        }
    }

    @Override
    public Policies getHousePolicy(int hid){
        PoliciesExample policiesExample = new PoliciesExample();
        PoliciesExample.Criteria criteria = policiesExample.createCriteria();
        criteria.andHouseidEqualTo(hid);
        List<Policies> policies = policiesMapper.selectByExample(policiesExample);
        if(!policies.isEmpty()){
            return policies.get(0);
        }else {
            return null;
        }

    }

    @Override
    public HouseOverview getHouseOverview(int hid){
       return houseOverviewMapper.selectByPrimaryKey(hid);
    }

}
