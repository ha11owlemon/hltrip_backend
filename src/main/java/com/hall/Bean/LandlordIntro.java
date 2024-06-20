package com.hall.Bean;

public class LandlordIntro {
    private Integer id;

    private String introtitle;

    private String introcont;

    private Integer landlordid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntrotitle() {
        return introtitle;
    }

    public void setIntrotitle(String introtitle) {
        this.introtitle = introtitle == null ? null : introtitle.trim();
    }

    public String getIntrocont() {
        return introcont;
    }

    public void setIntrocont(String introcont) {
        this.introcont = introcont == null ? null : introcont.trim();
    }

    public Integer getLandlordid() {
        return landlordid;
    }

    public void setLandlordid(Integer landlordid) {
        this.landlordid = landlordid;
    }
}