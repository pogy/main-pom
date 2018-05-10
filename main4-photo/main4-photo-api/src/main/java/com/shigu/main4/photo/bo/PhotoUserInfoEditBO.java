package com.shigu.main4.photo.bo;

import java.io.Serializable;

/**
 * 路径: PhotoUserInfoEditBO
 * 工程: main-pom
 * 时间: 18-4-25 下午4:10
 * 创建人: wanghaoxiang
 * 描述: 用户信息编辑数据
 */
public class PhotoUserInfoEditBO implements Serializable {

    //用户头像
    private String headImg;

    // 性别 0:未知,1:男,2:女
    private Integer sex;

    //地址
    private String address;

    //联系手机号
    private String contactPhone;

    // 封面
    private String showImg;

    // 微信二维码
    private String codeImg;

    // 个人简介
    private String userInfo;

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg;
    }

    public String getCodeImg() {
        return codeImg;
    }

    public void setCodeImg(String codeImg) {
        this.codeImg = codeImg;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
