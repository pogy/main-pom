package com.openJar.requests.api;

import com.openJar.beans.enums.SnEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.SnCategoryResponse;

public class SnCategoryRequest extends Request<SnCategoryResponse>{
    private String username;
    public SnCategoryRequest(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String restApiUrl() {
        return SnEnum.REST+ "api/snCategory.json";
    }

    @Override
    public String testApiUrl() {
        return null;
    }
}
