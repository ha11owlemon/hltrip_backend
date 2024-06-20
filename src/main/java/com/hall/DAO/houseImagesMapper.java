package com.hall.DAO;

import com.hall.Bean.houseImages;
import com.hall.Bean.houseImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface houseImagesMapper {
    long countByExample(houseImagesExample example);

    int deleteByExample(houseImagesExample example);

    int deleteByPrimaryKey(Integer imageid);

    int insert(houseImages record);

    int insertSelective(houseImages record);

    List<houseImages> selectByExample(houseImagesExample example);

    houseImages selectByPrimaryKey(Integer imageid);

    int updateByExampleSelective(@Param("record") houseImages record, @Param("example") houseImagesExample example);

    int updateByExample(@Param("record") houseImages record, @Param("example") houseImagesExample example);

    int updateByPrimaryKeySelective(houseImages record);

    int updateByPrimaryKey(houseImages record);

    List<String> getBriefUrlbyHouseId(int houseid);
}