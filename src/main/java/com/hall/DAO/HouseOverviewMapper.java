package com.hall.DAO;

import com.hall.Bean.HouseOverview;
import com.hall.Bean.HouseOverviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseOverviewMapper {
    long countByExample(HouseOverviewExample example);

    int deleteByExample(HouseOverviewExample example);

    int deleteByPrimaryKey(Integer houseid);

    int insert(HouseOverview record);

    int insertSelective(HouseOverview record);

    List<HouseOverview> selectByExample(HouseOverviewExample example);

    HouseOverview selectByPrimaryKey(Integer houseid);

    int updateByExampleSelective(@Param("record") HouseOverview record, @Param("example") HouseOverviewExample example);

    int updateByExample(@Param("record") HouseOverview record, @Param("example") HouseOverviewExample example);

    int updateByPrimaryKeySelective(HouseOverview record);

    int updateByPrimaryKey(HouseOverview record);

    List<HouseOverview> selectHouseIntroBylandlord(int landlordid);

    int updateHouseViewcount(@Param("houseid") int houseid, @Param("viewcount") int viewcount);

    List<HouseOverview> getHouseidsBylid(int id);

    int updateCommentcount(int hid);
    int changelandlordname(@Param("lid")int lid,@Param("name")String name);


}