package com.hall.Service;

import com.hall.Bean.HouseLocation;
import com.hall.Bean.HouseOverview;
import com.hall.Bean.Policies;
import com.hall.Bean.ResponeseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface HouseService {

    public ResponeseEntity insertHouse(Map<String,Object> req);

    public ResponeseEntity getHouseByHouseid(int houseid,int useridfromClient);

    public ResponeseEntity getAllCommentByHouseid(int houseid,int page);

    boolean queryfavor(int houseid, int userid);

    void updateFavor(int houseid, boolean addOrSub);

    public ResponeseEntity getLandlordDetail(int landlordid, int userid, int page);
    public ResponeseEntity insertHouseAndComment(Map<String, Object> req);

//    public void changcomment();
public void addViewCount(int houseid,int userid);
public void updateHotValue(int houseid);

    void updateCommentcount(int hid);

    void updateLandlordName(int lid, String name);

    void updateRating(int houseid, double rating);

    public boolean favorHouse(int houseid, int userid);


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
    HashMap<String, Object> gethouseidsByLocation(double longitude, double latitude, double distance, int page);

    HouseLocation getLocationByHouseid(int houseid);

    List<Object> getSingleHouseBriefByHouseid(int houseid, int userid);


    List<Object> getSingleHouseBriefByHouseidWithCondition(int houseid, int userid,Double maxPrice_c,
                                                           Double minPrice_c,
                                                           Integer bedcount_c,
                                                           Integer roomcount_c,
                                                           Integer maxpeople_c);

    HashMap<String,Object> getFavorIds(int userid,int page);

    String getHistoryId(int userid);

    @Transactional
    ResponeseEntity deleteHouse(int lid, int hid);

    Policies getHousePolicy(int hid);

    HouseOverview getHouseOverview(int hid);

}
