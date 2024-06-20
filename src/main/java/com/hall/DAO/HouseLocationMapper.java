package com.hall.DAO;

import com.hall.Bean.HouseLocation;
import com.hall.Bean.HouseLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseLocationMapper {
    long countByExample(HouseLocationExample example);

    int deleteByExample(HouseLocationExample example);

    int deleteByPrimaryKey(Integer locationid);

    int insert(HouseLocation record);

    int insertSelective(HouseLocation record);

    List<HouseLocation> selectByExample(HouseLocationExample example);

    HouseLocation selectByPrimaryKey(Integer locationid);

    int updateByExampleSelective(@Param("record") HouseLocation record, @Param("example") HouseLocationExample example);

    int updateByExample(@Param("record") HouseLocation record, @Param("example") HouseLocationExample example);

    int updateByPrimaryKeySelective(HouseLocation record);

    int updateByPrimaryKey(HouseLocation record);

    List<Integer> gethouseidsByLocation(@Param("longitude") double longitude, @Param("latitude") double latitude,@Param("distance") double distance);
}