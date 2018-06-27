package com.openJar.requests.img;

import com.openJar.beans.enums.SnEnum;
import com.openJar.requests.Request;
import com.openJar.responses.img.SnImgAddResponse;

public class SnImgAddRequest extends Request<SnImgAddResponse>{
    private String username;
    private String picContent;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicContent() {
        return picContent;
    }

    public void setPicContent(String picContent) {
        this.picContent = picContent;
    }

    @Override
    public String restApiUrl() {
        return SnEnum.REST+"api/imgAdd.json";
    }

    @Override
    public String testApiUrl() {
        return null;
    }
}
