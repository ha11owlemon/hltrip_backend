package com.hall.DAO;

import com.hall.Bean.verifyCodeStatus;
import com.hall.Bean.verifyCodeStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface verifyCodeStatusMapper {
    long countByExample(verifyCodeStatusExample example);

    int deleteByExample(verifyCodeStatusExample example);

    int deleteByPrimaryKey(String phonenumber);

    int insert(verifyCodeStatus record);

    int insertSelective(verifyCodeStatus record);

    List<verifyCodeStatus> selectByExample(verifyCodeStatusExample example);

    verifyCodeStatus selectByPrimaryKey(String phonenumber);

    int updateByExampleSelective(@Param("record") verifyCodeStatus record, @Param("example") verifyCodeStatusExample example);

    int updateByExample(@Param("record") verifyCodeStatus record, @Param("example") verifyCodeStatusExample example);

    int updateByPrimaryKeySelective(verifyCodeStatus record);

    int updateByPrimaryKey(verifyCodeStatus record);

    verifyCodeStatus verify(@Param("phoneNumber") String phoneNumber,@Param("code") String code);
}