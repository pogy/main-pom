package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

/**
 * 手机注册
 * Created by zhaohongbo on 17/3/2.
 */
public class RegistBO {
    /**
     * 手机号
     */
    @NotEmpty(message = "手机号不能为空")
    private String phone;
    /**
     * 手机验证码
     */
    @NotEmpty(message = "手机验证码不能为空")
    private String phoneCode;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Length(max = 50,min = 6,message = "密码必须在6-20位之间")
    private String password;
    /**
     * 用户昵称
     */
    @NotEmpty(message = "用户昵称不能为空")
    @SafeHtml(message = "userNick包含非法页面标签")
    private String userNick;
    /**
     * 阿里旺旺
     */
    @SafeHtml(message = "imAliww包含非法页面标签")
    private String imAliww;
    /**
     * QQ
     */
    @SafeHtml(message = "imQq包含非法页面标签")
    private String imQq;
    /**
     * 微信
     */
    @SafeHtml(message = "imWeixin包含非法页面标签")
    private String imWeixin;
    /**
     * 邮箱
     */
    @SafeHtml(message = "email包含非法页面标签")
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getImAliww() {
        return imAliww;
    }

    public void setImAliww(String imAliww) {
        this.imAliww = imAliww;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getImWeixin() {
        return imWeixin;
    }

    public void setImWeixin(String imWeixin) {
        this.imWeixin = imWeixin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
