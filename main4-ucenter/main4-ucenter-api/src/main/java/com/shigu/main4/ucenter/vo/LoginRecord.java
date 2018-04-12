package com.shigu.main4.ucenter.vo;

import com.shigu.session.main4.enums.LoginFromType;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建记录
 * Created by Licca on 17/2/20.
 */
public class LoginRecord  implements Serializable {
    private Long subUserId;
    private Long userId;
    private String subUserName;
    /**
     * 1：供应商 0 分销商
     */
    private Integer userType;
    /**
     * 存的时候，存它的value
     */
    private LoginFromType loginFromType;
    private Date time;
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LoginFromType getLoginFromType() {
        return loginFromType;
    }

    public void setLoginFromType(LoginFromType loginFromType) {
        this.loginFromType = loginFromType;
    }

    public Long getSubUserId() {
        return subUserId;
    }

    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
    }

    public String getSubUserName() {
        return subUserName;
    }

    public void setSubUserName(String subUserName) {
        this.subUserName = subUserName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
