package com.shigu.buyer.bo;

import java.io.Serializable;

/**
 * 微信登陆参数
 * Created by zhaohongbo on 17/4/14.
 */
public class WxLoginBO implements Serializable{
    /**
     * 手机号
     */
    private String phone;
    /**
     * 验证码
     */
    private String ckCode;
    /**
     * 回调地址
     */
    private String backUrl;
    /**
     * 微信按钮带入的code
     */
    private String code;
    /**
     * 微信openIid
     */
    private String openIid;
    /**
     * state
     */
    private String state;

    public String getOpenIid() {
        return openIid;
    }

    public void setOpenIid(String openIid) {
        this.openIid = openIid;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCkCode() {
        return ckCode;
    }

    public void setCkCode(String ckCode) {
        this.ckCode = ckCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
