package com.hall.Service.Imp;

import com.hall.Bean.*;
import com.hall.DAO.BookingsMapper;
import com.hall.DAO.LandlordsMapper;
import com.hall.DAO.OrdersMapper;
import com.hall.DAO.WithdrawalsMapper;
import com.hall.Service.orderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class orderServiceImp implements orderService {
    @Resource
    OrdersMapper ordersMapper;

    @Resource
    BookingsMapper bookingsMapper;

    @Resource
    LandlordsMapper landlordsMapper;

    @Resource
    WithdrawalsMapper withdrawalsMapper;
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    @Override
    public int insertOrder(Orders record){
        ordersMapper.insertSelective(record);
       return record.getOrderid();
    }

    @Override
    public void startTimer(int id){
        executor.schedule(() -> {
//            // 查询订单状态
            Orders orders = ordersMapper.selectByPrimaryKey(id);
            if (orders != null && orders.getOstatus().equals("待支付")) {
                // 如果订单状态为待支付，则取消订单
                closeorder(id);
            }
        }, 30, TimeUnit.MINUTES); // 30分钟后执行
    }


    @Override
    public void closeorderFromuser(String ordernum) {
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andOrdernumberEqualTo(ordernum);
        Orders record = new Orders();
        record.setOstatus("已取消");
        ordersMapper.updateByExampleSelective(record,ordersExample);
    }
    @Override
    public void closeorder(int id){
        Orders orders = new Orders();
        orders.setOrderid(id);
        orders.setOstatus("已关闭");
        ordersMapper.updateByPrimaryKeySelective(orders);
    }
    @Override
    public boolean canGenOrder(int hid, Date st, Date et, int uid){
        List<Orders> overlappingOrders = ordersMapper.findOverlappingOrders(hid, st, et);
        OrdersExample ordersExample = new OrdersExample();

        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andUidEqualTo(uid).andOstatusEqualTo("待支付");
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        System.out.println(orders);
        if(overlappingOrders.isEmpty()&&orders.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void closeSameTypeOrder(String orderNum){
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andOrdernumberEqualTo(orderNum);
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        Integer hid = orders.get(0).getHid();
        Date st = orders.get(0).getStarttime();
        Date et = orders.get(0).getEndtime();
        ordersMapper.closeSameOrder(hid,st,et);

        OrdersExample ordersExample1 = new OrdersExample();
        OrdersExample.Criteria criteria1 = ordersExample1.createCriteria();
        criteria1.andHidEqualTo(hid).andStarttimeEqualTo(st).andEndtimeEqualTo(et).andOrdernumberNotEqualTo(orderNum);
        Orders orders1 = new Orders();
        orders1.setOstatus("已关闭");
        ordersMapper.updateByExampleSelective(orders1,ordersExample1);
    }

    @Override
    public boolean querySameOrder(int hid, Date st, Date et){
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("进行中");
        strings.add("待入住");
        criteria.andHidEqualTo(hid).andStarttimeEqualTo(st).andEndtimeEqualTo(et).andOstatusIn(strings);
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        if(orders.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean checkOrderStatus(String orderNum){
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andOrdernumberEqualTo(orderNum);
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);

        if(orders.isEmpty()){
            return false;
        }else {
            Orders order_b = orders.get(0);
            String ostatus = order_b.getOstatus();
            if (ostatus.equals("已关闭")){
                return false;
            }else {
                return true;
            }
        }
    }

    @Override
    @Transactional
    public boolean checkAmount(String orderNum, BigDecimal pamount, Date payTime, String pno){
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andOrdernumberEqualTo(orderNum);
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        Orders sorder = orders.get(0);
        BigDecimal totalprice = sorder.getTotalprice();

        System.out.println(pamount);
        System.out.println(totalprice);
        int result = totalprice.compareTo(pamount);
        if(result==0){

            //        如果匹配,修改该订单状态,同时往预订表中增加相关数据
            System.out.println("---------------fdssfdfs-----------");
            sorder.setPstatus("已支付");
            sorder.setPamount(pamount);
            sorder.setPtime(payTime);
            sorder.setPtransactionid(pno);


            Date starttime = sorder.getStarttime();
            LocalDateTime checkinTime = starttime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime noon = checkinTime.withHour(12).withMinute(0).withSecond(0);

            if (LocalDateTime.now().isAfter(noon)) {
                sorder.setOstatus("待入住");
                System.out.println("现在的时间超过了指定日期的中午十二点");
            } else {
                sorder.setOstatus("待入住");
                System.out.println("现在的时间没有超过指定日期的中午十二点");
            }
            Bookings bookings = new Bookings();
            bookings.setHouseid(sorder.getHid());
            bookings.setUserid(sorder.getUid());
            bookings.setBstatus("Booked");
            bookings.setSdate(sorder.getStarttime());
            bookings.setEdate(sorder.getEndtime());
            bookingsMapper.insertSelective(bookings);
            ordersMapper.updateByExampleSelective(sorder,ordersExample);
            return true;

        }else{
            //        核对订单金额与实际金额是否匹配,如果不匹配,返回false,同时把该订单状态设置为交易异常,同时在controller中调用接口退款
            sorder.setPstatus("已退款");
            sorder.setPamount(pamount);
            sorder.setPtime(payTime);
            sorder.setPtransactionid(pno);
            sorder.setOstatus("交易异常");
            ordersMapper.updateByExampleSelective(sorder,ordersExample);
            return false;
        }

    }

    @Override
    public Orders getOrderInfo(String orderNum){
        return ordersMapper.getOrderBriefInfo(orderNum);
    }

//    查找的是已完成的订单
    @Override
    public List<Orders> getOrdersByUID(int id){
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andUidEqualTo(id).andOstatusEqualTo("已完成");
        return ordersMapper.selectByExample(ordersExample);
    }

//    查找的是全部的订单
    @Override
    public List<Orders> getOrderListByUid(int uid){
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria crta = ordersExample.createCriteria();
        crta.andUidEqualTo(uid);
        return ordersMapper.selectByExample(ordersExample);
    }
    @Override
    public List<Orders> getOrderListByLid(int lid){
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria crta = ordersExample.createCriteria();
        crta.andLidEqualTo(lid);
        return ordersMapper.selectByExample(ordersExample);
    }

    @Override
    public void cancleBooking(Date st,Date et,int hid){
        BookingsExample bookingsExample = new BookingsExample();
        BookingsExample.Criteria criteria = bookingsExample.createCriteria();
        criteria.andHouseidEqualTo(hid).andSdateEqualTo(st).andEdateEqualTo(et);
        Bookings bookings = new Bookings();
        bookings.setBstatus("Cancelled");
        bookingsMapper.updateByExampleSelective(bookings,bookingsExample);
    }


    @Override
    public boolean cashWithdrawal(double amount, int lid){
         Landlords landlords = landlordsMapper.selectByPrimaryKey(lid);
         Double balance = landlords.getBalance();
         if(balance>=amount){
             return true;
         }else {
//             调用阿里接口，返回一个布尔值
             return false;
         }
     }

    @Override
     public void insertWithdrawal(Withdrawals record){
        withdrawalsMapper.insertSelective(record);
     }
    @Override
    public BigDecimal noArrived(int lid){
        BigDecimal notArrived = ordersMapper.getNotArrived(lid);
        if(notArrived!=null){
            return notArrived;
        }else {
            return BigDecimal.valueOf(0);
        }

    }

    @Override
    public void ChangeStateToComplete(){
        List<Orders> orders = ordersMapper.selectByExample(null);
        for (Orders order : orders) {
            Date endtime = order.getEndtime();
            Date now = new Date();
            String nowStatus = order.getOstatus();
            if (now.getYear() == endtime.getYear() &&
                    now.getMonth() == endtime.getMonth() &&
                    now.getDate() == endtime.getDate()&& nowStatus.equals("进行中")) {
                System.out.println("两个 Date 对象表示同一天。");
                Integer lid = order.getLid();
                BigDecimal totalprice = order.getTotalprice();
                landlordsMapper.addBalance(lid,totalprice);
                order.setOstatus("已完成");
                ordersMapper.updateByPrimaryKeySelective(order);
            }
        }
    }
    @Override
    public void ChangeStateToCheckIn(){
        List<Orders> orders = ordersMapper.selectByExample(null);
        for (Orders order : orders) {
            Date starttime = order.getStarttime();
            Date now = new Date();
            String nowStatus = order.getOstatus();
            System.out.println(nowStatus);
            if (now.getYear() == starttime.getYear() &&
                    now.getMonth() == starttime.getMonth() &&
                    now.getDate() == starttime.getDate() && nowStatus.equals("待入住")) {
                order.setOstatus("进行中");
                ordersMapper.updateByPrimaryKeySelective(order);
            }
        }
    }

}
