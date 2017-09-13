package com.shigu.main4.ucenter.vo;

import java.io.Serializable;

/**
 * 用户基础信息
 * Created by Licca on 17/2/21.
 */
public class UserInfo implements Serializable{
    /**
     * 头像
     */
    private String headUrl;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 用户昵称
     */
    private String userNick;
    /**
     * 用户名
     */
    private String userName;
    /**
     * email
     */
    private String email;
    /**
     * 手机号码
     */
    private String telephone;
    /**
     * 性别
     */
    private String sex;
    /**
     * QQ号码
     */
    private String imQq;
    /**
     * 微信
     */
    private String imWx;
    /**
     * 旺旺
     */
    private String imWw;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getImWw() {
        return imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
    }

    public String getImWx() {
        return imWx;
    }

    public void setImWx(String imWx) {
        this.imWx = imWx;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

