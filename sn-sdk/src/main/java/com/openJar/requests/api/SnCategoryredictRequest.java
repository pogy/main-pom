package com.openJar.requests.api;

import com.openJar.beans.enums.SnEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.SnCategoryredictResponse;

public class SnCategoryredictRequest extends Request<SnCategoryredictResponse>{
    private String username;

    public SnCategoryredictRequest(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String restApiUrl() {
        return SnEnum.REST+"api/snCategoryredict.json";
    }

    @Override
    public String testApiUrl() {
        return null;
    }
}
