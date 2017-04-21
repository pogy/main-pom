package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 第三方用户绑定
 * Created by zhaohongbo on 17/3/4.
 */
public class BindPhoneBO implements Serializable{
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 图片验证码
     */
    private String phoneVerify;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhoneVerify() {
        return phoneVerify;
    }

    public void setPhoneVerify(String phoneVerify) {
        this.phoneVerify = phoneVerify;
    }
}
