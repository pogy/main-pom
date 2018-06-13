package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.util.Date;

public class SnTokenInfo extends OpenBean {
    private String accessToken;//访问令牌
    private String tokenType;//令牌类型，只支持bearer
    private String refreshToken;
    private int expiresIn;//令牌过期时间
    private String suningUserName;
    private Long custnum;//用户会员编码
    private int module;//用户类型
    private Long vendorCode;//商家编码

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getSuningUserName() {
        return suningUserName;
    }

    public void setSuningUserName(String suningUserName) {
        this.suningUserName = suningUserName;
    }

    public Long getCustnum() {
        return custnum;
    }

    public void setCustnum(Long custnum) {
        this.custnum = custnum;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public Long getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(Long vendorCode) {
        this.vendorCode = vendorCode;
    }
}
