package com.shigu.photo.bo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.bo.PhotoUserProfileEditBO
 * 工程: main-pom
 * 时间: 18-4-28 下午5:57
 * 创建人: wanghaoxiang
 * 描述: 用户信息修改请求
 */
public class PhotoUserProfileEditBO implements Serializable {

    //性别
    private Integer sex;

    //省id
    private Long provId;

    //市id
    private Long cityId;

    //个人简介
    private String profile;

    //封面图片
    private String cover;

    //微信二维码
    private String wxQrcode;

    //手机号
    private String tele;

    //短信验证
    private String msgValidate;

    private String userHeadImg;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getProvId() {
        return provId;
    }

    public void setProvId(Long provId) {
        this.provId = provId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getWxQrcode() {
        return wxQrcode;
    }

    public void setWxQrcode(String wxQrcode) {
        this.wxQrcode = wxQrcode;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getMsgValidate() {
        return msgValidate;
    }

    public void setMsgValidate(String msgValidate) {
        this.msgValidate = msgValidate;
    }

    public String getUserHeadImg() {
        return this.userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }
}
