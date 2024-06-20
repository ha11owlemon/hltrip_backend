package com.hall.DAO;

import com.hall.Bean.LocationTest;
import com.hall.Bean.LocationTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocationTestMapper {
    long countByExample(LocationTestExample example);

    int deleteByExample(LocationTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LocationTest record);

    int insertSelective(LocationTest record);

    List<LocationTest> selectByExample(LocationTestExample example);

    LocationTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LocationTest record, @Param("example") LocationTestExample example);

    int updateByExample(@Param("record") LocationTest record, @Param("example") LocationTestExample example);

    int updateByPrimaryKeySelective(LocationTest record);

    int updateByPrimaryKey(LocationTest record);
}