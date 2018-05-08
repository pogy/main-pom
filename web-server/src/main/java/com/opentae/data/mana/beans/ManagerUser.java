package com.opentae.data.mana.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户表
 * Created by zhaohongbo on 16/5/10.
 */
public class ManagerUser {
    /**
     * 用户ID,主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long userId;
    /**
     * 用户昵称
     */
    private String nick;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态，1可用，0不可用
     */
    private Integer status;
    /**
     * 头像
     */
    private String headUrl;
    /**
     * 最后登陆IP
     */
    private String lastLoginIp;

    /**
     * 万能密码
     */
    private String universalPassword;

    public String getUniversalPassword() {
        return universalPassword;
    }

    public void setUniversalPassword(String universalPassword) {
        this.universalPassword = universalPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
}
