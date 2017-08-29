package com.openJar.responses.app;

import com.openJar.responses.Response;

/**
 * 类名：BindUserResponse
 * 类路径：com.openJar.responses.app.BindUserResponse
 * 创建者：王浩翔
 * 创建时间：2017-08-29 13:32
 * 项目：main-pom
 * 描述：app端用户绑定手机响应
 */
public class BindUserResponse extends Response {
    //用户ID
    private Long userId;
    //是否卖家
    private Boolean imSeller;
    //头像
    private String imgsrc;
    //用户昵称
    private String userNick;
    //每次登陆，用户的唯一码
    private String token;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getImSeller() {
        return imSeller;
    }

    public void setImSeller(Boolean imSeller) {
        this.imSeller = imSeller;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
