package com.hall.Bean;

import java.util.Date;

public class verifyCodeStatus {
    private String phonenumber;

    private String verifycode;

    public verifyCodeStatus(String phonenumber, String verifycode, Date codegentime) {
        this.phonenumber = phonenumber;
        this.verifycode = verifycode;
        this.codegentime = codegentime;
    }

    public verifyCodeStatus() {
    }

    private Date codegentime;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode == null ? null : verifycode.trim();
    }

    public Date getCodegentime() {
        return codegentime;
    }

    public void setCodegentime(Date codegentime) {
        this.codegentime = codegentime;
    }
}