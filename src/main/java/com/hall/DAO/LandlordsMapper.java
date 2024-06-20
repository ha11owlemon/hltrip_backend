package com.hall.DAO;

import com.hall.Bean.Landlords;
import com.hall.Bean.LandlordsExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandlordsMapper {
    long countByExample(LandlordsExample example);

    int deleteByExample(LandlordsExample example);

    int deleteByPrimaryKey(Integer landlordid);

    int insert(Landlords record);

    int insertSelective(Landlords record);

    List<Landlords> selectByExample(LandlordsExample example);

    Landlords selectByPrimaryKey(Integer landlordid);

    int updateByExampleSelective(@Param("record") Landlords record, @Param("example") LandlordsExample example);

    int updateByExample(@Param("record") Landlords record, @Param("example") LandlordsExample example);

    int updateByPrimaryKeySelective(Landlords record);

    int updateByPrimaryKey(Landlords record);

    String getLandlordTel(int id);

    Landlords getBrief(int id);

    int reduceBalance(@Param("lid") int lid,@Param("amount") BigDecimal amount);
    List<Integer> getAllHouseId();
    int addBalance(@Param("lid") int lid,@Param("amount") BigDecimal amount);
}