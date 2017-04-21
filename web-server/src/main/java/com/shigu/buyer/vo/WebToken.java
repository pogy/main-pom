package com.shigu.buyer.vo;

/**
 * 网页accessToken
 * Created by Administrator on 2016-11-06-0006.
 */
public class WebToken extends Token {
    private String refresh_token;
    private String openid;
    private String scope;

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
