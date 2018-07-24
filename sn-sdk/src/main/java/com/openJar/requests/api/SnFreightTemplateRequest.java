package com.openJar.requests.api;

import com.openJar.beans.enums.SnEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.SnFreightTemplateResponse;

public class SnFreightTemplateRequest extends Request<SnFreightTemplateResponse> {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String restApiUrl() {
        return SnEnum.REST+"api/getFreight.json";
    }

    @Override
    public String testApiUrl() {
        return SnEnum.REST+"api/getFreight.json";
    }
}
