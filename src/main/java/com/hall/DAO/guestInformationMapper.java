package com.hall.DAO;

import com.hall.Bean.guestInformation;
import com.hall.Bean.guestInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface guestInformationMapper {
    long countByExample(guestInformationExample example);

    int deleteByExample(guestInformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(guestInformation record);

    int insertSelective(guestInformation record);

    List<guestInformation> selectByExample(guestInformationExample example);

    guestInformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") guestInformation record, @Param("example") guestInformationExample example);

    int updateByExample(@Param("record") guestInformation record, @Param("example") guestInformationExample example);

    int updateByPrimaryKeySelective(guestInformation record);

    int updateByPrimaryKey(guestInformation record);
}