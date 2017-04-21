package com.shigu.buyer.bo;

import java.io.Serializable;

/**
 * 手机登陆参数
 * Created by zhaohongbo on 17/3/19.
 */
public class LoginByPhoneBO implements Serializable {

    private String telephone;

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
