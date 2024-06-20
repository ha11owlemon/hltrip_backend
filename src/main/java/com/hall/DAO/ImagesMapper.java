package com.hall.DAO;

import com.hall.Bean.Images;
import com.hall.Bean.ImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImagesMapper {
    long countByExample(ImagesExample example);

    int deleteByExample(ImagesExample example);

    int deleteByPrimaryKey(Integer imageid);

    int insert(Images record);

    int insertSelective(Images record);

    List<Images> selectByExample(ImagesExample example);

    Images selectByPrimaryKey(Integer imageid);

    int updateByExampleSelective(@Param("record") Images record, @Param("example") ImagesExample example);

    int updateByExample(@Param("record") Images record, @Param("example") ImagesExample example);

    int updateByPrimaryKeySelective(Images record);

    int updateByPrimaryKey(Images record);
}