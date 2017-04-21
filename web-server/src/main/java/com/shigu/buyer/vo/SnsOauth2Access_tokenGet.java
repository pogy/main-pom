package com.shigu.buyer.vo;

import org.sword.wechat4j.api.request.ApiRequest;

/**
 * 网页access_token
 * Created by Administrator on 2016-11-06-0006.
 */
public class SnsOauth2Access_tokenGet extends ApiRequest<WebToken> {
    private String appid;
    private String secret;
    private String code;
    private String grant_type="authorization_code";

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
