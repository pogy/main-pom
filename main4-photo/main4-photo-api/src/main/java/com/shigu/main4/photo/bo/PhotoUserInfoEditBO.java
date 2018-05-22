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


    // 性别 0:未知,1:男,2:女
    private Integer sex;

    //地址
    private String address;

    //联系手机号
    private String contactPhone;

    // 个人简介
    private String userInfo;


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

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
