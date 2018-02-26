package com.shigu.main4.ucenter.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 供修改的用户基本信息
 * Created by Licca on 17/2/21.
 */
public class UserInfoUpdate implements Serializable{
    /**
     * 用户ID
     */
    private Long userId;
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
     * 最后一次登陆时间
     */
    private Date lastTime;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
