package com.hall.Service;

import com.hall.Bean.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {

    public boolean userIsExist(String phoneNumber);
    public boolean insertUser(user user);

    public Map<String,Object> completeLogin(String phoneNumber, String newToken,Date expiredTime);

    public boolean loginByPwd(String phoneNumber,String password);

    public boolean updatePwd(String phoneNumber,String password);

    public int queryLoginRecord(String id,String token);

    public user queryById(String id);
    public int updateExpireTime(user user);


    HashMap<String, Object> getUserbrief(int userid);

    user getUsermessage(int userid);

    int insertLandlord(Landlords landlords);

    void insertToAvatar(String url, int lid);

    boolean hasLandlord(int userid);

    int updataLidInUser(int landlordid, int userid);

    int addIntro(int landlordid, String title, String content);

    List<LandlordIntro> queryIntro(int landlordid);

    Map<String,Object> queryLandlord(int landlordid);

    long countHouses(int lid);

    List<HouseOverview> getLandlordHouses(int id);

    ResponeseEntity updateHousePrice(int lid, int hid, double orgprice, double price);

    boolean addIDinfo(int uid, String name, String idnum);

    boolean deleteIDinfo(int uid, String name, String idnum);

    List<guestInformation> queryIDinfo(int uid);

    void updateUserProfile(String name, String avatar, int id);

    void updateLProfile(String name, String avatar, int id);

    void updateLBalance(BigDecimal amount, int lid);
}
