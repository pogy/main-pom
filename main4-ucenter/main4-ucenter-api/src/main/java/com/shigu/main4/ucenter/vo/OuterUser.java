package com.shigu.main4.ucenter.vo;

import com.shigu.session.main4.enums.LoginFromType;

import java.io.Serializable;
import java.util.Date;

/**
 * 第三方绑定账号
 * Created by zhaohongbo on 17/2/23.
 */
public class OuterUser implements Serializable{
    /**
     * 子账号ID
     */
    private Long subUserId;
    /**
     * 账号来源类型
     */
    private LoginFromType loginFromType;
    /**
     * 外部平台名称
     */
    private String outerNick;
    /**
     * 绑定时间
     */
    private Date createTime;

    public LoginFromType getLoginFromType() {
        return loginFromType;
    }

    public void setLoginFromType(LoginFromType loginFromType) {
        this.loginFromType = loginFromType;
    }

    public String getOuterNick() {
        return outerNick;
    }

    public void setOuterNick(String outerNick) {
        this.outerNick = outerNick;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getSubUserId() {
        return subUserId;
    }

    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
    }
}
