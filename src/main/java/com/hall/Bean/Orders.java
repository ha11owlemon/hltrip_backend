package com.hall.Bean;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private Integer orderid;

    private String guestinfo;

    private Date ordertime;

    private Date endtime;

    private String ostatus;

    private BigDecimal totalprice;

    private Integer hid;

    private BigDecimal pamount;

    private Date ptime;

    private String pstatus;

    private String ptransactionid;

    private Integer uid;

    private Integer lid;

    private String ordernumber;

    private Date ordergentime;

    private Date ordercompletetime;

    private Date starttime;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getGuestinfo() {
        return guestinfo;
    }

    public void setGuestinfo(String guestinfo) {
        this.guestinfo = guestinfo == null ? null : guestinfo.trim();
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getOstatus() {
        return ostatus;
    }

    public void setOstatus(String ostatus) {
        this.ostatus = ostatus == null ? null : ostatus.trim();
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public BigDecimal getPamount() {
        return pamount;
    }

    public void setPamount(BigDecimal pamount) {
        this.pamount = pamount;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus == null ? null : pstatus.trim();
    }

    public String getPtransactionid() {
        return ptransactionid;
    }

    public void setPtransactionid(String ptransactionid) {
        this.ptransactionid = ptransactionid == null ? null : ptransactionid.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber == null ? null : ordernumber.trim();
    }

    public Date getOrdergentime() {
        return ordergentime;
    }

    public void setOrdergentime(Date ordergentime) {
        this.ordergentime = ordergentime;
    }

    public Date getOrdercompletetime() {
        return ordercompletetime;
    }

    public void setOrdercompletetime(Date ordercompletetime) {
        this.ordercompletetime = ordercompletetime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
}