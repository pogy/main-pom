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
    @NotEmpty(message = "手机号不能为空")
    private String telephone;
    /**
     * 短信验证码
     */
    @NotEmpty(message = "短信验证码不能为空")
    private String msgValidate;

    @NotEmpty(message = "图片验证码不能为空")
    private String imgValidate;

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

    public String getImgValidate() {
        return imgValidate;
    }

    public void setImgValidate(String imgValidate) {
        this.imgValidate = imgValidate;
    }
}
