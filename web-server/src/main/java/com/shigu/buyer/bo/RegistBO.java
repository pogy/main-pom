package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 手机注册
 * Created by zhaohongbo on 17/3/2.
 */
public class RegistBO {
    /**
     * 手机号
     */
    @NotEmpty(message = "手机号不能为空")
    private String telephone;
    /**
     * 手机验证码
     */
    @NotEmpty(message = "手机验证码不能为空")
    private String msgValidate;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Length(max = 50,min = 6,message = "密码必须在6-20位之间")
    private String password;
    /**
     * 邀请码
     */
    private String inviteCode;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMsgValidate() {
        return msgValidate;
    }

    public void setMsgValidate(String msgValidate) {
        this.msgValidate = msgValidate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
