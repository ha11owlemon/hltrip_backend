package com.hall.Controller;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.*;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.hall.Bean.*;
import com.hall.Service.HouseService;
import com.hall.Service.UserService;
import com.hall.Service.orderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class orderController {
    @Resource
    orderService orderService;
    @Resource
    HouseService houseService;

    @Resource
    UserService userService;

    private String privateKey = "";
    private String publicKey = "";

    @GetMapping("/getOrder")
    public ResponeseEntity getOrder(@RequestParam int hid,
            @RequestParam int uid,
            @RequestParam int lid,
            @RequestParam(required = false) String startTimeStr,
            @RequestParam(required = false) String endTimeStr,
            @RequestParam(required = false) BigDecimal totalprice,
            @RequestParam(required = false) String guestInfo,
            @RequestParam String housename) throws AlipayApiException {
        System.out.println(hid);
        System.out.println(uid);
        System.out.println(lid);
        System.out.println(endTimeStr);
        System.out.println(totalprice);
        System.out.println(guestInfo);
        Date endTime;
        Date startTime;
        // 处理一下时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            endTime = sdf.parse(endTimeStr);
            startTime = sdf.parse(startTimeStr);
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponeseEntity("时间格式不对", "400", null);
        }
        boolean canGenOrder = orderService.canGenOrder(hid, startTime, endTime, uid);
        boolean isSameOrder = orderService.querySameOrder(hid, startTime, endTime);
        // 生成订单前先查询该房子在该时间段内有无冲突，如果冲突了就不能正常生成订单
        if (canGenOrder && !isSameOrder) {
            // 生成订单号

            String timestamp = String.valueOf(System.currentTimeMillis());
            String orderNum = timestamp + "s" + hid + "s" + lid + "s" + uid;
            Orders orders = new Orders();
            orders.setHid(hid);
            orders.setUid(uid);
            orders.setLid(lid);
            orders.setTotalprice(totalprice);
            orders.setGuestinfo(guestInfo);
            orders.setOrdernumber(orderNum);

            // 记录生成时间，后面要用
            Date genTime = new Date();
            orders.setOrdertime(genTime);
            orders.setStarttime(startTime);
            orders.setEndtime(endTime);
            orders.setOstatus("待支付");
            orders.setPstatus("未支付");
            int orderid = orderService.insertOrder(orders);
            orderService.startTimer(orderid);
            AlipayClient alipayClient = new DefaultAlipayClient(getAlipayConfig());
            AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
            request.setNotifyUrl("");
            JSONObject bizContent = new JSONObject();
            bizContent.put("out_trade_no", orderNum);
            bizContent.put("total_amount", String.valueOf(totalprice));
            bizContent.put("subject", housename);
            // 获取当前时间
            LocalDateTime currentTime = LocalDateTime.now();

            // 计算30分钟后的时间
            LocalDateTime expireTime = currentTime.plusMinutes(30);

            // 格式化时间为字符串
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String expireTimeString = expireTime.format(formatter);
            bizContent.put("product_code", "QUICK_MSECURITY_PAY");
            bizContent.put("time_expire", expireTimeString);

            request.setBizContent(bizContent.toString());
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            String orderStr = response.getBody();

            if (response.isSuccess()) {
                System.out.println("订单调用成功");
                HashMap<String, Object> data = new HashMap<>();
                data.put("orderStr", orderStr);
                data.put("orderNum", orderNum);
                data.put("genTime", genTime);
                return new ResponeseEntity("success", "200", data);
            } else {
                System.out.println("调用失败");
                return new ResponeseEntity("fail", "400", null);
            }
        } else {
            return new ResponeseEntity("order has been crushed", "401", null);
        }

    }

    @GetMapping("/canIpay")
    public boolean canIpay(@RequestParam String orderNum) {
        // 在支付的前一刻查询订单状态，查看是否订单有被关闭
        return orderService.checkOrderStatus(orderNum);
    }

    @GetMapping("/checkPayStatus")
    public ResponeseEntity checkPayStatus(@RequestParam String orderNum) throws AlipayApiException {
        // 初始化SDK
        AlipayClient alipayClient = new DefaultAlipayClient(getAlipayConfig());

        // 构造请求参数以调用接口
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();

        // 设置订单支付时传入的商户订单号
        model.setOutTradeNo(orderNum);

        // 设置查询选项
        List<String> queryOptions = new ArrayList<String>();
        queryOptions.add("trade_settle_info");
        model.setQueryOptions(queryOptions);

        request.setBizModel(model);
        AlipayTradeQueryResponse response = alipayClient.certificateExecute(request);
        String jsonString = response.getBody();

        if (response.isSuccess()) {
            System.out.println("调用成功");
            HashMap<String, Object> data = new HashMap<>();
            JSONObject jsonObject = JSON.parseObject(jsonString);

            JSONObject queryResult = jsonObject.getJSONObject("alipay_trade_query_response");
            // 实际需要的数据嵌套在了这一层
            String TradeNo = queryResult.getString("trade_no");
            BigDecimal totalAmount = queryResult.getBigDecimal("total_amount");
            // 实付金额
            BigDecimal buyerPayAmount = queryResult.getBigDecimal("buyer_pay_amount");

            Date sendPayDate = queryResult.getDate("send_pay_date");
            // public boolean checkAmount(String orderNum, BigDecimal pamount, Date payTime,
            // String pno)
            boolean is_pay_vaild = orderService.checkAmount(orderNum, totalAmount, sendPayDate, TradeNo);
            System.out.println(is_pay_vaild);
            if (is_pay_vaild) {
                // 对于预订时间有重叠,并且订单状态处于未支付的订单进行关闭
                orderService.closeSameTypeOrder(orderNum);

                return new ResponeseEntity("pay success", "200", null);
            } else {
                // 交易异常,直接退款
                // 构造请求参数以调用接口
                AlipayTradeRefundRequest request1 = new AlipayTradeRefundRequest();
                AlipayTradeRefundModel model1 = new AlipayTradeRefundModel();
                // 设置商户订单号
                model1.setOutTradeNo(orderNum);

                // 设置查询选项
                List<String> queryOptions1 = new ArrayList<String>();
                queryOptions1.add("refund_detail_item_list");
                model1.setQueryOptions(queryOptions);

                // 设置退款金额
                model1.setRefundAmount(String.valueOf(totalAmount));

                // 设置退款包含的商品列表信息

                // 设置退款原因说明
                model1.setRefundReason("支付异常");

                request1.setBizModel(model1);
                AlipayTradeRefundResponse response1 = alipayClient.execute(request1);
                System.out.println(response1.getBody());

                if (response.isSuccess()) {
                    System.out.println("退款调用成功");
                } else {
                    System.out.println("退款调用失败");
                    // sdk版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
                    // String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
                    // System.out.println(diagnosisUrl);
                }
                return new ResponeseEntity("amount exception", "301", null);
            }

        } else {
            System.out.println("调用失败");
            // sdk版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
            // String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            // System.out.println(diagnosisUrl);
            return new ResponeseEntity("fail", "300", null);
        }

    }

    @GetMapping("/getOrderInfo")
    public ResponeseEntity getOrderInfo(String orderNum) {
        Orders orderInfo = orderService.getOrderInfo(orderNum);
        Integer hid = orderInfo.getHid();
        Integer uid = orderInfo.getUid();
        List<Object> infoList = houseService.getSingleHouseBriefByHouseid(hid, uid);
        HashMap<String, Object> dataItem = (HashMap<String, Object>) infoList.get(4);
        dataItem.put("orderInfo", orderInfo);

        Policies housePolicy = houseService.getHousePolicy(hid);
        dataItem.put("policy", housePolicy);
        return new ResponeseEntity("success", "200", dataItem);
    }

    @GetMapping("/closeOrder")
    public void closeOrder(String orderNum) {
        orderService.closeorderFromuser(orderNum);
    }

    @GetMapping("/cancelOrder")
    public void cancelOrder(int oid) {
        orderService.closeorder(oid);
    }

    @GetMapping("/getUserOrders")
    public ResponeseEntity getUserOrders(@RequestParam int uid) {
        // 用户的订单对象列表
        List<Orders> orderListByUid = orderService.getOrderListByUid(uid);

        ArrayList<Object> orderList = new ArrayList<>();
        for (Orders orderObj : orderListByUid) {
            HashMap<String, Object> orderItem = new HashMap<>();

            Integer hid = orderObj.getHid();
            HouseOverview hov = houseService.getHouseOverview(hid);

            orderItem.put("order", orderObj);
            orderItem.put("hov", hov);
            orderList.add(orderItem);
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("orderList", orderList);
        return new ResponeseEntity("success", "200", data);
    }

    @GetMapping("/getLandlordOrders")
    public ResponeseEntity getLandlordOrders(@RequestParam int lid) {
        // 用户的订单对象列表
        List<Orders> orderListByUid = orderService.getOrderListByLid(lid);

        ArrayList<Object> orderList = new ArrayList<>();
        for (Orders orderObj : orderListByUid) {
            HashMap<String, Object> orderItem = new HashMap<>();

            Integer hid = orderObj.getHid();
            HouseOverview hov = houseService.getHouseOverview(hid);

            orderItem.put("order", orderObj);
            orderItem.put("hov", hov);
            orderList.add(orderItem);
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("orderList", orderList);
        return new ResponeseEntity("success", "200", data);
    }

    @GetMapping("/canIcancleOrder")
    public boolean canIcancleOrder(@RequestParam String onum) {
        Orders orderInfo = orderService.getOrderInfo(onum);

        Integer hid = orderInfo.getHid();
        Date ordertime = orderInfo.getOrdertime();
        LocalDateTime ot = ordertime.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(ot, currentTime);
        Policies housePolicy = houseService.getHousePolicy(hid);
        if (housePolicy != null) {
            String cancelpolicy = housePolicy.getCancelpolicy();
            if (cancelpolicy.equals("30")) {
                if (duration.toMinutes() > 30) {
                    return false;
                } else {
                    return true;
                }
            } else {
                int cancelDay = Integer.parseInt(cancelpolicy);
                if (duration.toDays() > cancelDay) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    @GetMapping("/confirmCancle")
    public boolean cancleOrder(@RequestParam String onum) {
        try {
            boolean canCancle = canIcancleOrder(onum);

            // 取消订单
            orderService.closeorderFromuser(onum);

            // 修改掉预订表
            Orders orderInfo = orderService.getOrderInfo(onum);
            Date starttime = orderInfo.getStarttime();
            Date endtime = orderInfo.getEndtime();
            Integer hid = orderInfo.getHid();
            orderService.cancleBooking(starttime, endtime, hid);
            // 退钱
            BigDecimal totalprice = orderInfo.getTotalprice();

            // 能退退，不能退就不退
            if (canCancle) {

                // 初始化SDK
                AlipayClient alipayClient = new DefaultAlipayClient(getAlipayConfig());

                // 构造请求参数以调用接口
                AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
                AlipayTradeRefundModel model = new AlipayTradeRefundModel();

                // 设置商户订单号
                model.setOutTradeNo(onum);

                // 设置查询选项
                List<String> queryOptions = new ArrayList<String>();
                queryOptions.add("refund_detail_item_list");
                model.setQueryOptions(queryOptions);

                // 设置退款金额
                model.setRefundAmount(String.valueOf(totalprice));

                // 设置退款原因说明
                model.setRefundReason("用户申请退款");

                request.setBizModel(model);
                AlipayTradeRefundResponse response = alipayClient.certificateExecute(request);
                System.out.println(response.getBody());

                if (response.isSuccess()) {
                    System.out.println("调用成功");
                } else {
                    System.out.println("调用失败");
                    // sdk版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
                    // String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
                    // System.out.println(diagnosisUrl);
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @GetMapping("/withdrawal")
    public HashMap<String, Object> cashWithdrawal(@RequestParam double amount, @RequestParam String account,
            @RequestParam int lid) {
        HashMap<String, Object> data = new HashMap<>();
        boolean isBalanceEnough = orderService.cashWithdrawal(amount, lid);
        if (isBalanceEnough) {
            // 生成提现单号
            String timestamp = String.valueOf(System.currentTimeMillis());
            String wdid = timestamp + lid + amount;
            BigDecimal amountDecimal = BigDecimal.valueOf(amount);
            BigDecimal rand_amount = amountDecimal.setScale(2, RoundingMode.HALF_UP);
            BigDecimal actAmount = BigDecimal.valueOf(amount - amount * 0.01);
            BigDecimal rand_actAmount = actAmount.setScale(2, RoundingMode.HALF_UP);
            boolean isSuccess = alipaywithDrawal(rand_actAmount, account, wdid);
            if (isSuccess) {
                // 修改账户余额
                userService.updateLBalance(rand_amount, lid);
                // 提现表新增一条记录
                Withdrawals withdrawals = new Withdrawals();
                withdrawals.setActualamount(rand_actAmount);
                withdrawals.setLid(lid);
                withdrawals.setInitiationtime(new Date());
                withdrawals.setFee(rand_amount.multiply(new BigDecimal("0.01")));
                withdrawals.setAmount(rand_amount);
                withdrawals.setWithdrawalnumber(wdid);
                // 插入到数据库
                orderService.insertWithdrawal(withdrawals);
                data.put("status", 200);
                data.put("desc", "提现成功");
                return data;
            } else {
                data.put("status", 301);
                data.put("reason", "请检查账户是否正确");
                return data;
            }
        } else {
            data.put("status", 300);
            data.put("reason", "余额不足，提现失败");
            return data;
        }
    }

    public boolean alipaywithDrawal(BigDecimal amount, String account, String wdid) {
        try {
            // 初始化SDK
            AlipayClient alipayClient = new DefaultAlipayClient(getAlipayConfig());

            // 构造请求参数以调用接口
            AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
            AlipayFundTransUniTransferModel model = new AlipayFundTransUniTransferModel();

            // 设置转账业务的标题
            model.setOrderTitle("用户提现");

            // 设置描述特定的业务场景
            model.setBizScene("DIRECT_TRANSFER");

            // 设置转账业务请求的扩展参数
            model.setBusinessParams("{\"payer_show_name_use_alias\":\"true\"}");

            // 设置商家侧唯一订单号
            model.setOutBizNo(wdid);

            model.setProductCode("TRANS_ACCOUNT_NO_PWD");
            model.setBizScene("DIRECT_TRANSFER");
            model.setOrderTitle("提现到账");
            // 设置订单总金额
            model.setTransAmount(String.valueOf(amount));

            System.out.println(account);
            // 设置收款方信息
            Participant payeeInfo = new Participant();
            payeeInfo.setIdentityType("ALIPAY_LOGON_ID");
            payeeInfo.setIdentity(account);
            payeeInfo.setName("wrrrlx5819");
            model.setPayeeInfo(payeeInfo);

            request.setBizModel(model);
            AlipayFundTransUniTransferResponse response = alipayClient.certificateExecute(request);
            System.out.println(response.getBody());

            if (response.isSuccess()) {
                System.out.println("调用成功");
                return true;
            } else {
                System.out.println("调用失败");
                // sdk版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
                // String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
                // System.out.println(diagnosisUrl);
                return false;
            }

        } catch (Exception e) {
            System.out.println("调用异常");
            System.out.println(e.getMessage());
            return false;
        }
    }

    private AlipayConfig getAlipayConfig() {

        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl("https://openapi-sandbox.dl.alipaydev.com/gateway.do");
        alipayConfig.setAppId("9021000136664929");
        alipayConfig.setPrivateKey(privateKey);
        alipayConfig.setFormat("json");
        alipayConfig.setAlipayPublicKey(publicKey);
        alipayConfig.setCharset("UTF-8");
        alipayConfig.setSignType("RSA2");
        alipayConfig.setAppCertPath("/certs/appPublicCert.crt");
        alipayConfig.setAlipayPublicCertPath("/certs/alipayPublicCert.crt");
        alipayConfig.setRootCertPath("/certs/alipayRootCert.crt");
        return alipayConfig;
    }
}
