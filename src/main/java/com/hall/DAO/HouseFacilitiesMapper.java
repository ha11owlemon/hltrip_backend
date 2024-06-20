package com.hall.DAO;

import com.hall.Bean.HouseFacilities;
import com.hall.Bean.HouseFacilitiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseFacilitiesMapper {
    long countByExample(HouseFacilitiesExample example);

    int deleteByExample(HouseFacilitiesExample example);

    int deleteByPrimaryKey(Integer facilitiesid);

    int insert(HouseFacilities record);

    int insertSelective(HouseFacilities record);

    List<HouseFacilities> selectByExample(HouseFacilitiesExample example);

    HouseFacilities selectByPrimaryKey(Integer facilitiesid);

    int updateByExampleSelective(@Param("record") HouseFacilities record, @Param("example") HouseFacilitiesExample example);

    int updateByExample(@Param("record") HouseFacilities record, @Param("example") HouseFacilitiesExample example);

    int updateByPrimaryKeySelective(HouseFacilities record);

    int updateByPrimaryKey(HouseFacilities record);

    HouseFacilities getFacilityByHouseid(int id);
}