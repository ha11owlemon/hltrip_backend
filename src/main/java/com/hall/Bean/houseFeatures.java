package com.hall.Bean;

public class houseFeatures {
    private Integer featureid;

    private Integer houseid;

    private String featuretype;

    private String featurecontent;

    public Integer getFeatureid() {
        return featureid;
    }

    public void setFeatureid(Integer featureid) {
        this.featureid = featureid;
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public String getFeaturetype() {
        return featuretype;
    }

    public void setFeaturetype(String featuretype) {
        this.featuretype = featuretype == null ? null : featuretype.trim();
    }

    public String getFeaturecontent() {
        return featurecontent;
    }

    public void setFeaturecontent(String featurecontent) {
        this.featurecontent = featurecontent == null ? null : featurecontent.trim();
    }
}