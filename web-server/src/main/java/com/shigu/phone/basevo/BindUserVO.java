package com.shigu.phone.basevo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-18/9:41
 */
public class BindUserVO implements Serializable {
    //用户ID	必须
    private Long userId;
    //是否卖家	必须
    private Boolean imSeller;
    //头像	必须
    private String imgsrc;
    //用户昵称	必须
    private String userNick;
    //每次登陆，用户的唯一码	必须
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
