package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 第三方回调BO
 * Created by zhaohongbo on 17/2/27.
 */
public class LoginBackBO implements Serializable{
    /**
     * 第三方用户名
     */
    @NotEmpty(message = "第三方用户名不能为空")
    private String userName;
    /**
     * 第三方唯一码
     */
    private String key;
    /**
     * 验签
     */
//    @NotEmpty(message = "验证不能为空")
    private String sign;
    /**
     * 类型
     * tb  淘宝
     * ali  阿里
     * wx   微信
     */
    @NotEmpty(message = "第三方登陆类型不能为空")
    private String type;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
