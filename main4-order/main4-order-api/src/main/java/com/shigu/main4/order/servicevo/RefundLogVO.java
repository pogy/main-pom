package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.zfenums.UserTypeEnum;

import java.io.Serializable;

/**
 * 退款日志
 * Created by zhaohongbo on 17/7/14.
 */
public class RefundLogVO implements Serializable{
    /**
     * 用户类型: 0平台客服，1普通用户
     */
    private UserTypeEnum userType;
    /**
     * 昵称
     */
    private String userNick;
    /**
     * 头像
     */
    private String headImgUrl;
    /**
     * 记录创建时间
     */
    private String logTime;
    /**
     * 内容
     */
    private String logDesc;

    /**
     * 售后状态
     */
    private Integer toStatus;
    /**
     * 信息是否对客户可见
     */
    private Boolean afterSaleInfoShowIs;

    public Boolean getAfterSaleInfoShowIs() {
        return afterSaleInfoShowIs;
    }

    public void setAfterSaleInfoShowIs(Boolean afterSaleInfoShowIs) {
        this.afterSaleInfoShowIs = afterSaleInfoShowIs;
    }

    /**
     * 获取 用户类型: 0平台客服，1普通用户
     */
    public UserTypeEnum getUserType() {
        return this.userType;
    }

    /**
     * 设置 用户类型: 0平台客服，1普通用户
     */
    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    /**
     * 获取 昵称
     */
    public String getUserNick() {
        return this.userNick;
    }

    /**
     * 设置 昵称
     */
    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    /**
     * 获取 头像
     */
    public String getHeadImgUrl() {
        return this.headImgUrl;
    }

    /**
     * 设置 头像
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    /**
     * 获取 内容
     */
    public String getLogDesc() {
        return this.logDesc;
    }

    /**
     * 设置 内容
     */
    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    public Integer getToStatus() {
        return toStatus;
    }

    public void setToStatus(Integer toStatus) {
        this.toStatus = toStatus;
    }
}
