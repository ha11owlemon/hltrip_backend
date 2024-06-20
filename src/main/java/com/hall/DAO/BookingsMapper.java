package com.hall.DAO;

import com.hall.Bean.Bookings;
import com.hall.Bean.BookingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookingsMapper {
    long countByExample(BookingsExample example);

    int deleteByExample(BookingsExample example);

    int deleteByPrimaryKey(Integer bookingid);

    int insert(Bookings record);

    int insertSelective(Bookings record);

    List<Bookings> selectByExample(BookingsExample example);

    Bookings selectByPrimaryKey(Integer bookingid);

    int updateByExampleSelective(@Param("record") Bookings record, @Param("example") BookingsExample example);

    int updateByExample(@Param("record") Bookings record, @Param("example") BookingsExample example);

    int updateByPrimaryKeySelective(Bookings record);

    int updateByPrimaryKey(Bookings record);
}