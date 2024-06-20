package com.hall.Bean;

public class UserBrowsingHistory {
    private Integer id;

    private Integer userid;

    private String houseids;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getHouseids() {
        return houseids;
    }

    public void setHouseids(String houseids) {
        this.houseids = houseids == null ? null : houseids.trim();
    }


}