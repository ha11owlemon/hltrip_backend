package com.hall.DAO;

import com.hall.Bean.user;
import com.hall.Bean.userExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userMapper {
    long countByExample(userExample example);

    int deleteByExample(userExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(user record);

    int insertSelective(user record);

    List<user> selectByExample(userExample example);

    user selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") user record, @Param("example") userExample example);

    int updateByExample(@Param("record") user record, @Param("example") userExample example);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
    int selectCountUserByPhonenNumber(String phoneNumber);
    user selectUserByPhonenNumber(String phoneNumber);

    int updateUserByPhonenNumber(user user);

    int loginByPwd(@Param("phoneNumber") String phoneNumber,@Param("password") String password);

    int updatePwd(@Param("phoneNumber") String phoneNumber,@Param("password") String password);

    int queryLoginRecord(@Param("userId") String userId,@Param("token") String token);
    public user getUserprofile(int userid);
}