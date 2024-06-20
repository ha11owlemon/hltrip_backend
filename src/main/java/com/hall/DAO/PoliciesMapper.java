package com.hall.DAO;

import com.hall.Bean.Policies;
import com.hall.Bean.PoliciesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoliciesMapper {
    long countByExample(PoliciesExample example);

    int deleteByExample(PoliciesExample example);

    int deleteByPrimaryKey(Integer policyid);

    int insert(Policies record);

    int insertSelective(Policies record);

    List<Policies> selectByExample(PoliciesExample example);

    Policies selectByPrimaryKey(Integer policyid);

    int updateByExampleSelective(@Param("record") Policies record, @Param("example") PoliciesExample example);

    int updateByExample(@Param("record") Policies record, @Param("example") PoliciesExample example);

    int updateByPrimaryKeySelective(Policies record);

    int updateByPrimaryKey(Policies record);
}