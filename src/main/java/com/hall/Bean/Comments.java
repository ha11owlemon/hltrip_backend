package com.hall.Bean;

import java.util.Date;

public class Comments {
    private Integer commentid;

    private Integer houseid;

    private Integer userid;

    private String username;

    private Integer landlordid;

    private Boolean hasimage;

    private Double cleanliness;

    private Double accuracy;

    private Double locationtransport;

    private Double safety;

    private Double valueformmoney;

    private Double rating;

    private Date commenttime;

    private Date replytime;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getLandlordid() {
        return landlordid;
    }

    public void setLandlordid(Integer landlordid) {
        this.landlordid = landlordid;
    }

    public Boolean getHasimage() {
        return hasimage;
    }

    public void setHasimage(Boolean hasimage) {
        this.hasimage = hasimage;
    }

    public Double getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(Double cleanliness) {
        this.cleanliness = cleanliness;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Double getLocationtransport() {
        return locationtransport;
    }

    public void setLocationtransport(Double locationtransport) {
        this.locationtransport = locationtransport;
    }

    public Double getSafety() {
        return safety;
    }

    public void setSafety(Double safety) {
        this.safety = safety;
    }

    public Double getValueformmoney() {
        return valueformmoney;
    }

    public void setValueformmoney(Double valueformmoney) {
        this.valueformmoney = valueformmoney;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }
}