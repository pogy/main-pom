package com.shigu.buyer.vo;

import org.sword.wechat4j.api.response.ApiResponse;

/**
 * accessToken 响应
 * Created by sean on 2016-07-17-0017.
 */
public class Token extends ApiResponse {

    private String access_token;
    private Long expires_in;

    public String getAccess_token() {
        return access_token;
    }
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    public Long getExpires_in() {
        return expires_in;
    }
    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }
}
