package com.hall.Bean;

public class Avatars {
    private Integer avatarid;

    private String url;

    private String imgpath;

    private Integer uid;

    private String role;

    public Integer getAvatarid() {
        return avatarid;
    }

    public void setAvatarid(Integer avatarid) {
        this.avatarid = avatarid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}