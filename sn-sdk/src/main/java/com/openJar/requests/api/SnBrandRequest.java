package com.openJar.requests.api;

import com.openJar.beans.enums.SnEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.SnBrandResponse;

public class SnBrandRequest extends Request<SnBrandResponse> {
    private String categoryCode;
    private String username;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String restApiUrl() {
        return SnEnum.REST+"api/getBrand.json";
    }

    @Override
    public String testApiUrl() {
        return null;
    }
}
