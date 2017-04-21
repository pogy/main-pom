package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 注册手机验证
 * Created by zhaohongbo on 17/3/2.
 */
public class RegistVerifyBO implements Serializable{
    /**
     * 手机号
     */
    @NotEmpty(message = "手机号不能为空")
    private String phone;
    /**
     * 图片验证码
     */
    @NotEmpty(message = "图片验证码不能为空")
    private String authCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
