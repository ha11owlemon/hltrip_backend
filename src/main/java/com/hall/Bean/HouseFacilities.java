package com.hall.Bean;

public class HouseFacilities {
    private Integer facilitiesid;

    private Integer houseid;

    private String service;

    private String basic;

    private String bathroom;

    private String kitchen;

    private String surrounding;

    private String safety;

    private String entertainment;

    private String leisure;

    private String children;

    public Integer getFacilitiesid() {
        return facilitiesid;
    }

    public void setFacilitiesid(Integer facilitiesid) {
        this.facilitiesid = facilitiesid;
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic == null ? null : basic.trim();
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom == null ? null : bathroom.trim();
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen == null ? null : kitchen.trim();
    }

    public String getSurrounding() {
        return surrounding;
    }

    public void setSurrounding(String surrounding) {
        this.surrounding = surrounding == null ? null : surrounding.trim();
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety == null ? null : safety.trim();
    }

    public String getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(String entertainment) {
        this.entertainment = entertainment == null ? null : entertainment.trim();
    }

    public String getLeisure() {
        return leisure;
    }

    public void setLeisure(String leisure) {
        this.leisure = leisure == null ? null : leisure.trim();
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children == null ? null : children.trim();
    }
}