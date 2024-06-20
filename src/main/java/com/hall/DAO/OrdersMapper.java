package com.hall.DAO;

import com.hall.Bean.Orders;
import com.hall.Bean.OrdersExample;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    List<Orders> findOverlappingOrders(@Param("houseid") int houseid,
                                      @Param("startTime") Date startTime,
                                      @Param("endTime") Date endTime);
    int closeSameOrder(@Param("houseid") int houseid,
                  @Param("startTime") Date startTime,
                  @Param("endTime") Date endTime);

    Orders getOrderBriefInfo(String orderNum);

    BigDecimal getNotArrived(int lid);
}