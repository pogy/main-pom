package com.openJar.requests.api;

import com.openJar.beans.SnGood;
import com.openJar.beans.enums.SnEnum;
import com.openJar.requests.Request;
import com.openJar.responses.api.SnItemAddResponse;

public class SnItemAddRequest extends Request<SnItemAddResponse> {
    private String username;
    private SnGood snGood;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SnGood getSnGood() {
        return snGood;
    }

    public void setSnGood(SnGood snGood) {
        this.snGood = snGood;
    }

    @Override
    public String restApiUrl() {
        return SnEnum.REST+"api/itemAdd.json";
    }

    @Override
    public String testApiUrl() {
        return SnEnum.REST+"api/itemAdd.json";
    }
}
