package com.openJar.requests.api;

import com.openJar.beans.enums.SnEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.SnGetProductCodeResponse;

public class SnGetProductCodeRequest extends Request<SnGetProductCodeResponse> {
    private String username;
    private String applyCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    @Override
    public String restApiUrl() {
        return SnEnum.REST+"api/getCode.json";
    }

    @Override
    public String testApiUrl() {
        return SnEnum.REST+"api/getCode.json";
    }
}
