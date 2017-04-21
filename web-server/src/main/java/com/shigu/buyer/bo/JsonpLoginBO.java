package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * jsonP登陆
 * Created by zhaohongbo on 17/3/8.
 */
public class JsonpLoginBO implements Serializable{
    /**
     * 回调
     */
    private String callback;
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名为空")
    private String userName;
    /**
     * 密码
     */
    @NotEmpty(message = "密码为空")
    private String userPassword;

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
