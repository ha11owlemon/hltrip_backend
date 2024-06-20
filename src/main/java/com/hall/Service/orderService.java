package com.hall.Service;

import com.hall.Bean.Orders;
import com.hall.Bean.Withdrawals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface orderService {
    int insertOrder(Orders record);

    void startTimer(int id);


    void closeorderFromuser(String ordernum);

    void closeorder(int id);

    boolean canGenOrder(int hid, Date st, Date et, int uid);

    void closeSameTypeOrder(String orderNum);

    boolean querySameOrder(int hid, Date st, Date et);

    boolean checkOrderStatus(String orderNum);

    boolean checkAmount(String orderNum, BigDecimal pamount, Date payTime, String pno);

    Orders getOrderInfo(String orderNum);

    List<Orders> getOrdersByUID(int id);

    //    查找的是全部的订单
    List<Orders> getOrderListByUid(int uid);

    List<Orders> getOrderListByLid(int lid);

    void cancleBooking(Date st, Date et, int hid);


    boolean cashWithdrawal(double amount, int lid);

    void insertWithdrawal(Withdrawals record);

    BigDecimal noArrived(int lid);

    void ChangeStateToComplete();

    void ChangeStateToCheckIn();
}
