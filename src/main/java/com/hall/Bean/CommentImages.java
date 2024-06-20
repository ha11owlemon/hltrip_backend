package com.hall.Bean;

import java.util.Date;

public class CommentImages {
    private Integer imageid;

    private Integer commentid;

    private String url;

    private String imgpath;

    private Integer userid;

    private Date uplaodtime;

    public Integer getImageid() {
        return imageid;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getUplaodtime() {
        return uplaodtime;
    }

    public void setUplaodtime(Date uplaodtime) {
        this.uplaodtime = uplaodtime;
    }
}