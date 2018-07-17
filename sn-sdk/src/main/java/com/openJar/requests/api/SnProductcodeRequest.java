package com.openJar.requests.api;

import com.openJar.beans.enums.SnEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.SnProductcodeResponse;

public class SnProductcodeRequest extends Request<SnProductcodeResponse>{

    private String username;

    private String applycode;

    private String suppliercmcode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApplycode() {
        return applycode;
    }

    public void setApplycode(String applycode) {
        this.applycode = applycode;
    }

    public String getSuppliercmcode() {
        return suppliercmcode;
    }

    public void setSuppliercmcode(String suppliercmcode) {
        this.suppliercmcode = suppliercmcode;
    }

    @Override
    public String restApiUrl() {
        return SnEnum.REST+"api/getProductcode.json";
    }

    @Override
    public String testApiUrl() {
        return SnEnum.REST+"api/getProductcode.json";
    }
}
