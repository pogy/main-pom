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

    //性别 0:未知,1:男,2:女
    private Integer sex;

    //地址
    private String address;

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
}
