package com.hall.DAO;

import com.hall.Bean.UserBrowsingHistory;
import com.hall.Bean.UserBrowsingHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBrowsingHistoryMapper {
    long countByExample(UserBrowsingHistoryExample example);

    int deleteByExample(UserBrowsingHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserBrowsingHistory record);

    int insertSelective(UserBrowsingHistory record);

    List<UserBrowsingHistory> selectByExampleWithBLOBs(UserBrowsingHistoryExample example);

    List<UserBrowsingHistory> selectByExample(UserBrowsingHistoryExample example);

    UserBrowsingHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserBrowsingHistory record, @Param("example") UserBrowsingHistoryExample example);

    int updateByExampleWithBLOBs(@Param("record") UserBrowsingHistory record, @Param("example") UserBrowsingHistoryExample example);

    int updateByExample(@Param("record") UserBrowsingHistory record, @Param("example") UserBrowsingHistoryExample example);

    int updateByPrimaryKeySelective(UserBrowsingHistory record);

    int updateByPrimaryKeyWithBLOBs(UserBrowsingHistory record);

    int updateByPrimaryKey(UserBrowsingHistory record);
}