package com.shigu.buyer.vo;

import java.io.Serializable;

/**
 * 用户信息,供前台修改
 * Created by zhaohongbo on 17/3/1.
 */
public class UserInfoVO implements Serializable{
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
    /**
     * 用户ID
     */
    private Long userId;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if("保密".equals(sex)){
            this.sex="-1";
        }else if("男".equals(sex)){
            this.sex="0";
        }else if("女".equals(sex)){
            this.sex="1";
        }
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getImWx() {
        return imWx;
    }

    public void setImWx(String imWx) {
        this.imWx = imWx;
    }

    public String getImWw() {
        return imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
    }
}
