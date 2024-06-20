package com.hall.DAO;

import com.hall.Bean.Avatars;
import com.hall.Bean.AvatarsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AvatarsMapper {
    long countByExample(AvatarsExample example);

    int deleteByExample(AvatarsExample example);

    int deleteByPrimaryKey(Integer avatarid);

    int insert(Avatars record);

    int insertSelective(Avatars record);

    List<Avatars> selectByExample(AvatarsExample example);

    Avatars selectByPrimaryKey(Integer avatarid);

    int updateByExampleSelective(@Param("record") Avatars record, @Param("example") AvatarsExample example);

    int updateByExample(@Param("record") Avatars record, @Param("example") AvatarsExample example);

    int updateByPrimaryKeySelective(Avatars record);

    int updateByPrimaryKey(Avatars record);
}