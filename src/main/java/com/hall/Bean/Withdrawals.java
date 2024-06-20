package com.hall.Bean;

import java.math.BigDecimal;
import java.util.Date;

public class Withdrawals {
    private Integer id;

    private String withdrawalnumber;

    private Integer lid;

    private BigDecimal amount;

    private BigDecimal fee;

    private BigDecimal actualamount;

    private Date initiationtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWithdrawalnumber() {
        return withdrawalnumber;
    }

    public void setWithdrawalnumber(String withdrawalnumber) {
        this.withdrawalnumber = withdrawalnumber == null ? null : withdrawalnumber.trim();
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getActualamount() {
        return actualamount;
    }

    public void setActualamount(BigDecimal actualamount) {
        this.actualamount = actualamount;
    }

    public Date getInitiationtime() {
        return initiationtime;
    }

    public void setInitiationtime(Date initiationtime) {
        this.initiationtime = initiationtime;
    }
}