package com.hall.Bean;

public class Policies {
    private Integer policyid;

    private Integer houseid;

    private String cancelpolicy;

    private Double allowaddguests;

    private Double deposit;

    private String needtoknow;

    public Integer getPolicyid() {
        return policyid;
    }

    public void setPolicyid(Integer policyid) {
        this.policyid = policyid;
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public String getCancelpolicy() {
        return cancelpolicy;
    }

    public void setCancelpolicy(String cancelpolicy) {
        this.cancelpolicy = cancelpolicy == null ? null : cancelpolicy.trim();
    }

    public Double getAllowaddguests() {
        return allowaddguests;
    }

    public void setAllowaddguests(Double allowaddguests) {
        this.allowaddguests = allowaddguests;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getNeedtoknow() {
        return needtoknow;
    }

    public void setNeedtoknow(String needtoknow) {
        this.needtoknow = needtoknow == null ? null : needtoknow.trim();
    }
}