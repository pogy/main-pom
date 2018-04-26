package com.shigu.photo.bo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.bo.PhotoUserInfoEditBO
 * 工程: main-pom
 * 时间: 18-4-25 下午4:10
 * 创建人: wanghaoxiang
 * 描述: 用户信息编辑数据
 */
public class PhotoUserInfoEditBO implements Serializable {

    //用户头像
    private String headImg;

    //根据user_type字段决定含义,当user_type=0或1时,该字段代表性别(0:未知,1:男,2:女),当user_type=2时,该字段代表机构类型(1:摄影公司,2:摄影师)
    private Integer subUserType;

    //地址
    private String address;

    //联系手机号
    private String contactPhone;

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getSubUserType() {
        return subUserType;
    }

    public void setSubUserType(Integer subUserType) {
        this.subUserType = subUserType;
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
}
