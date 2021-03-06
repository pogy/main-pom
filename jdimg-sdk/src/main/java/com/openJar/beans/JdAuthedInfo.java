package com.openJar.beans;

import com.openJar.utils.OpenBean;

public class JdAuthedInfo extends OpenBean{
    /**授权用户对应的京东ID*/
    private Long uid;
    /**授权用户对应的京东昵称*/
    private String userNick;
    /**授权的时间点（UNIX时间戳，单位：毫秒）*/
    private Long authTime;
    /**失效时间（从授权时间算起，单位：秒）*/
    private Integer expiresIn;
    /**获取的token*/
    private String accessToken;
    /**用来刷新access_tokend的刷新token*/
    private String refreshToken;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public Long getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Long authTime) {
        this.authTime = authTime;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
