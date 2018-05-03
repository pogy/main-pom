package com.shigu.photo.vo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.vo.PhotoAuthWorkUserInfoWebVO
 * 工程: main-pom
 * 时间: 18-4-26 下午1:53
 * 创建人: wanghaoxiang
 * 描述:
 */
public class PhotoAuthWorkUserInfoWebVO implements Serializable {

    //用户id
    private Long userId;

    //用户头像或封面
    private String imgSrc;

    //用户昵称
    private String nick;

    // 用户性别 0男 1女
    private Integer sex;

    //作者类型 男模 女模 摄影师 摄影机构 场地
    private String typeName;

    //作者类型 1：模特 2：摄影师 3：摄影机构 4：场地
    private Integer authType;

    //用户手机号
    private String tele;

    //用户所在地
    private String address;

    //用户微信二维码图片
    private String wxQrCode;

    //个人简介
    private String profile;

    //作品总数 无为0
    private Integer worksCount;

    //是否已关注,暂无用
    private Boolean focusOnIs;

    //封面
    private String coverImgSrc;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWxQrCode() {
        return wxQrCode;
    }

    public void setWxQrCode(String wxQrCode) {
        this.wxQrCode = wxQrCode;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getWorksCount() {
        return worksCount;
    }

    public void setWorksCount(Integer worksCount) {
        this.worksCount = worksCount;
    }

    public Boolean getFocusOnIs() {
        return focusOnIs;
    }

    public void setFocusOnIs(Boolean focusOnIs) {
        this.focusOnIs = focusOnIs;
    }

    //封面
    public String getCoverImgSrc() {
        return this.coverImgSrc;
    }

    //封面
    public void setCoverImgSrc(String coverImgSrc) {
        this.coverImgSrc = coverImgSrc;
    }
}
