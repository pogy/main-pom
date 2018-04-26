package com.shigu.photo.vo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.vo.PhotoUserVO
 * 工程: main-pom
 * 时间: 18-4-25 下午3:04
 * 创建人: wanghaoxiang
 * 描述: 用户摄影基地信息
 */
public class PhotoUserVO implements Serializable {

    /**
     *
     */
    private Long photoUserId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 0:普通用户,1:模特,2:摄影机构,3:场地
     */
    private Integer userType;

    /**
     * 根据user_type字段决定含义,当user_type=0或1时,该字段代表性别(0:未知,1:男,2:女),当user_type=2时,该字段代表机构类型(1:摄影公司,2:摄影师)
     */
    private Integer subUserType;

    /**
     * 常用地址
     */
    private String address;

    /**
     * 个人简介
     */
    private String userInfo;

    /**
     * 联系方式
     */
    private String contactPhone;

    /**
     * 个人展示封面
     */
    private String showImg;

    /**
     * 二维码
     */
    private String codeImg;

    /**
     * 主风格ID
     */
    private Long mainStyleId;

    public void setPhotoUserId(Long photoUserId) {
        this.photoUserId = photoUserId;
    }

    public Long getPhotoUserId() {
        return this.photoUserId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getHeadImg() {
        return this.headImg;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserType() {
        return this.userType;
    }

    public void setSubUserType(Integer subUserType) {
        this.subUserType = subUserType;
    }

    public Integer getSubUserType() {
        return this.subUserType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg;
    }

    public String getShowImg() {
        return this.showImg;
    }

    public void setCodeImg(String codeImg) {
        this.codeImg = codeImg;
    }

    public String getCodeImg() {
        return this.codeImg;
    }

    public void setMainStyleId(Long mainStyleId) {
        this.mainStyleId = mainStyleId;
    }

    public Long getMainStyleId() {
        return this.mainStyleId;
    }
}
