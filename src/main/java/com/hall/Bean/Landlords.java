package com.hall.Bean;

public class Landlords {
    private Integer landlordid;

    private String nickname;

    private String avatar;

    private Double balance;

    private String phonenumber;

    public Integer getLandlordid() {
        return landlordid;
    }

    public void setLandlordid(Integer landlordid) {
        this.landlordid = landlordid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }
}