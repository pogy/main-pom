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
    private String telephone;
    /**
     * 图片验证码
     */
    @NotEmpty(message = "图片验证码不能为空")
    private String imgValidate;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImgValidate() {
        return imgValidate;
    }

    public void setImgValidate(String imgValidate) {
        this.imgValidate = imgValidate;
    }
}
