package com.shigu.main4.ucenter.vo;

import java.io.Serializable;

/**
 * 用户注册
 * Created by Licca on 17/2/20.
 */
public class RegisterUser implements Serializable{
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 昵称
     */
    private String userNick;
    /**
     * 密码
     */
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
}
