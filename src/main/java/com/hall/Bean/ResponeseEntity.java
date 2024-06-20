package com.hall.Bean;

import java.util.Map;

public class ResponeseEntity {

    private String dataDesc;
    private String requestStatus;

    private Map<String,Object> data;

    public ResponeseEntity() {
    }

    public ResponeseEntity(String dataDesc, String requestStatus, Map<String, Object> data) {
        this.dataDesc = dataDesc;
        this.requestStatus = requestStatus;
        this.data = data;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
