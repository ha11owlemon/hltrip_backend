package com.hall.DAO;

import com.hall.Bean.LandlordIntro;
import com.hall.Bean.LandlordIntroExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandlordIntroMapper {
    long countByExample(LandlordIntroExample example);

    int deleteByExample(LandlordIntroExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LandlordIntro record);

    int insertSelective(LandlordIntro record);

    List<LandlordIntro> selectByExample(LandlordIntroExample example);

    LandlordIntro selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LandlordIntro record, @Param("example") LandlordIntroExample example);

    int updateByExample(@Param("record") LandlordIntro record, @Param("example") LandlordIntroExample example);

    int updateByPrimaryKeySelective(LandlordIntro record);

    int updateByPrimaryKey(LandlordIntro record);
}