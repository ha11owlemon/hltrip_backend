package com.hall.DAO;

import com.hall.Bean.houseFeatures;
import com.hall.Bean.houseFeaturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface houseFeaturesMapper {
    long countByExample(houseFeaturesExample example);

    int deleteByExample(houseFeaturesExample example);

    int deleteByPrimaryKey(Integer featureid);

    int insert(houseFeatures record);

    int insertSelective(houseFeatures record);

    List<houseFeatures> selectByExample(houseFeaturesExample example);

    houseFeatures selectByPrimaryKey(Integer featureid);

    int updateByExampleSelective(@Param("record") houseFeatures record, @Param("example") houseFeaturesExample example);

    int updateByExample(@Param("record") houseFeatures record, @Param("example") houseFeaturesExample example);

    int updateByPrimaryKeySelective(houseFeatures record);

    int updateByPrimaryKey(houseFeatures record);
}