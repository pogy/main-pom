package com.shigu.session.main4;

import java.io.Serializable;

/**
 * 手机验证
 * Created by Licca on 17/2/28.
 */
public class PhoneVerify implements Serializable{

    public PhoneVerify() {
    }

    public PhoneVerify(String phone, String verify) {
        this.phone = phone;
        this.verify = verify;
    }

    /**
     * 忘记密码时,需要把用户ID拿到输入密码页面验证
     */
    private Long userId;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 验证码
     */
    private String verify;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}
