package com.hall.Service.Imp;

import com.hall.Bean.*;
import com.hall.DAO.*;
import com.hall.Service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Resource
    userMapper userMapper;

    @Resource
    verifyCodeStatusMapper verifyCodeStatusMapper;

    @Resource
    userFavoritesMapper userFavoritesMapper;
    @Resource
    UserBrowsingHistoryMapper userBrowsingHistoryMapper;

    @Resource
    LandlordIntroMapper landlordIntroMapper;
    @Resource
    LandlordsMapper landlordsMapper;
    @Resource
    HouseOverviewMapper houseOverviewMapper;

    @Resource
    guestInformationMapper guestInformationMapper;
    @Resource
    AvatarsMapper avatarsMapper;

    @Override
    public boolean userIsExist(String phoneNumber) {
        int i = userMapper.selectCountUserByPhonenNumber(phoneNumber);
        if(i==0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean insertUser(user user) {
        int i = userMapper.insertSelective(user);
        verifyCodeStatusMapper.deleteByPrimaryKey(user.getPhonenumber());
        if(i==0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Map<String, Object> completeLogin(String phoneNumber, String newToken,Date expiredTime) {
        user user = new user();
        user.setToken(newToken);
        user.setLastlogintime(new Date());
        user.setExpiredtime(expiredTime);
        user.setPhonenumber(phoneNumber);
        userMapper.updateUserByPhonenNumber(user);
        verifyCodeStatusMapper.deleteByPrimaryKey(phoneNumber);
        user user1 = userMapper.selectUserByPhonenNumber(phoneNumber);

        HashMap<String, Object> data = new HashMap<>();
        data.put("userId",user1.getUserid());
        data.put("phoneNumber",phoneNumber);
        data.put("token",newToken);

        return data;
    }

    @Override
    public boolean loginByPwd(String phoneNumber, String password) {
        int i = userMapper.loginByPwd(phoneNumber, password);
        if(i==0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean updatePwd(String phoneNumber, String password) {
        int i = userMapper.updatePwd(phoneNumber, password);
        if(i==0){
            return false;
        }else {
            return false;
        }
    }

    @Override
    public int queryLoginRecord(String id, String token) {
        return userMapper.queryLoginRecord(id, token);
    }

    @Override
    public user queryById(String id) {
        return userMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    public int updateExpireTime(user user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
    @Override
    @Transactional

    public HashMap<String, Object> getUserbrief(int userid){
        user userprofile = userMapper.getUserprofile(userid);

        userFavoritesExample userFavoritesExample = new userFavoritesExample();
        com.hall.Bean.userFavoritesExample.Criteria criteria = userFavoritesExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        long favorcount = userFavoritesMapper.countByExample(userFavoritesExample);

        UserBrowsingHistoryExample userBrowsingHistoryExample = new UserBrowsingHistoryExample();
        UserBrowsingHistoryExample.Criteria criteria1 = userBrowsingHistoryExample.createCriteria();
        criteria1.andUseridEqualTo(userid);
        List<UserBrowsingHistory> userBrowsingHistories = userBrowsingHistoryMapper.selectByExampleWithBLOBs(userBrowsingHistoryExample);
        String houseids = "";
        if(!userBrowsingHistories.isEmpty()){
            UserBrowsingHistory userBrowsingHistory = userBrowsingHistories.get(0);
            houseids = userBrowsingHistory.getHouseids();
        }

        String[] browseList = houseids.split(";");
        int browsecount = browseList.length;

        HashMap<String, Object> data = new HashMap<>();
        data.put("browsecount",browsecount);
        data.put("favorcount",favorcount);
        data.put("user",userprofile);

        return data;
    }
    @Override
    public user getUsermessage(int userid){
        return userMapper.getUserprofile(userid);
    }

    @Override
    public int insertLandlord(Landlords landlords){
     return landlordsMapper.insertSelective(landlords);
    }
    @Override
    public void insertToAvatar(String url, int lid){
        Avatars avatars = new Avatars();
        avatars.setUid(lid);
        avatars.setUrl(url);
        avatars.setRole("landlord");
        avatarsMapper.insertSelective(avatars);
    }
    @Override
    public boolean hasLandlord(int userid){
        userExample userExample = new userExample();
        userExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseridEqualTo(userid).andRoleEqualTo("landlord");
        List<user> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public int updataLidInUser(int landlordid, int userid){
        user user = new user();
        user.setUserid(userid);
        user.setLandlordid(landlordid);
        user.setRole("landlord");
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int addIntro(int landlordid, String title, String content){
        LandlordIntroExample landlordIntroExample = new LandlordIntroExample();
        LandlordIntroExample.Criteria criteria = landlordIntroExample.createCriteria();
        criteria.andLandlordidEqualTo(landlordid);
        List<LandlordIntro> landlordIntros = landlordIntroMapper.selectByExample(landlordIntroExample);
        if(landlordIntros.isEmpty()){
            LandlordIntro landlordIntro = new LandlordIntro();
            landlordIntro.setIntrotitle(title);
            landlordIntro.setIntrocont(content);
            landlordIntro.setLandlordid(landlordid);
           return landlordIntroMapper.insertSelective(landlordIntro);
        }else {
            LandlordIntro landlordIntro = new LandlordIntro();
            landlordIntro.setIntrotitle(title);
            landlordIntro.setIntrocont(content);
            return landlordIntroMapper.updateByExampleSelective(landlordIntro,landlordIntroExample);

        }
    }

    @Override
    public List<LandlordIntro> queryIntro(int landlordid){
        LandlordIntroExample landlordIntroExample = new LandlordIntroExample();
        LandlordIntroExample.Criteria criteria = landlordIntroExample.createCriteria();
        criteria.andLandlordidEqualTo(landlordid);
         return  landlordIntroMapper.selectByExample(landlordIntroExample);

    }

    @Override
    public Map<String,Object> queryLandlord(int landlordid){
        Landlords landlords = landlordsMapper.selectByPrimaryKey(landlordid);
        Double balance = landlords.getBalance();
        double after= Math.round(balance*100.0)/100.0;
        landlords.setBalance(after);
        Map<String, Object> data = new HashMap<>();
        data.put("landlordProfile",landlords);
        AvatarsExample avatarsExample = new AvatarsExample();
        AvatarsExample.Criteria criteria = avatarsExample.createCriteria();
        criteria.andUidEqualTo(landlordid);
        List<Avatars> avatars = avatarsMapper.selectByExample(avatarsExample);
        data.put("avatar",avatars.get(0).getUrl());
        return data;
    }

    @Override
    public long countHouses(int lid){
        HouseOverviewExample example = new HouseOverviewExample();
        HouseOverviewExample.Criteria criteria = example.createCriteria();
        criteria.andLandlordidEqualTo(lid);
        return houseOverviewMapper.countByExample(example);
    }


    @Override
    public List<HouseOverview> getLandlordHouses(int id){
       return houseOverviewMapper.getHouseidsBylid(id);
    }

    @Override
    public ResponeseEntity updateHousePrice(int lid, int hid, double orgprice, double price){
        HouseOverviewExample houseOverviewExample = new HouseOverviewExample();
        HouseOverviewExample.Criteria criteria = houseOverviewExample.createCriteria();
        criteria.andHouseidEqualTo(hid).andLandlordidEqualTo(lid);
        List<HouseOverview> houseOverviews = houseOverviewMapper.selectByExample(houseOverviewExample);
        if (houseOverviews.isEmpty()){
//            非法操作
            return new ResponeseEntity("invalid option","400",null);
        }else{
            if(orgprice<price){
                double temp = orgprice;
                orgprice=price;
                price=temp;
            }
            HouseOverview house = new HouseOverview();
            house.setDiscountprice(price);
            house.setOriginalprice(orgprice);
            houseOverviewMapper.updateByExampleSelective(house,houseOverviewExample);
            return new ResponeseEntity("update success","200",null);
        }
    }


    @Override
    public boolean addIDinfo(int uid, String name, String idnum){
        try{
            guestInformation guestInformation = new guestInformation();
            guestInformation.setUserid(uid);
            guestInformation.setRealname(name);
            guestInformation.setIdnumber(idnum);
            guestInformationMapper.insertSelective(guestInformation);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteIDinfo(int uid, String name, String idnum){
    try{
        guestInformationExample guestInformationExample = new guestInformationExample();
        guestInformationExample.Criteria criteria = guestInformationExample.createCriteria();
        criteria.andUseridEqualTo(uid).andRealnameEqualTo(name).andIdnumberEqualTo(idnum);
        guestInformationMapper.deleteByExample(guestInformationExample);
        return true;
    }catch (Exception e){
        return false;
    }

    }
    @Override
    public List<guestInformation> queryIDinfo(int uid){

        guestInformationExample guestInformationExample = new guestInformationExample();
        guestInformationExample.Criteria criteria = guestInformationExample.createCriteria();
        criteria.andUseridEqualTo(uid);
        return guestInformationMapper.selectByExample(guestInformationExample);
    }

    @Override
    public void updateUserProfile(String name, String avatar, int id){
        user user = new user();
        user.setAvatarpic(avatar);
        user.setUsername(name);
        user.setUserid(id);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updateLProfile(String name, String avatar, int id){
        Landlords landlords = new Landlords();
        landlords.setNickname(name);
        landlords.setAvatar(avatar);
        landlords.setLandlordid(id);
        landlordsMapper.updateByPrimaryKeySelective(landlords);

        AvatarsExample avatarsExample = new AvatarsExample();
        AvatarsExample.Criteria criteria = avatarsExample.createCriteria();
        criteria.andUidEqualTo(id).andRoleEqualTo("landlord");
        Avatars avatars = new Avatars();
        avatars.setUrl(avatar);
        avatarsMapper.updateByExampleSelective(avatars,avatarsExample);
    }

    @Override
    public void updateLBalance(BigDecimal amount, int lid){
        double doubleamount = amount.doubleValue();
        System.out.println(doubleamount);
        landlordsMapper.reduceBalance(lid,amount);
    }

}
