package com.shigu.main4.photo.vo;

import java.io.Serializable;

/**
 * 路径: AuthApplyInfoVO
 * 工程: main-pom
 * 时间: 18-4-29 下午12:46
 * 创建人: wanghaoxiang
 * 描述: 用户授权信息
 */
public class AuthApplyInfoVO implements Serializable {

    // 用户摄影基地身份认证申请id
    private Long photoAuthApplyId;

    // 用户id
    private Long userId;

    // 摄影基地认证用户名
    private String photoUserName;

    // 用户类型 模特、摄影师、摄影公司、场地
    private String userType;

    // 联系手机号
    private String concatPhone;

    // 封面图片地址
    private String showImgUrl;

    // 二维码图片地址
    private String codeImgUrl;

    // 操作记录
    private String logMessage;

    // 申请时间
    private String applyTime;

    // 最后修改时间
    private String modifyTime;

    //申请风格列表显示，如果之后有需求可以加进来
    private String styles;

    public Long getPhotoAuthApplyId() {
        return photoAuthApplyId;
    }

    public void setPhotoAuthApplyId(Long photoAuthApplyId) {
        this.photoAuthApplyId = photoAuthApplyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhotoUserName() {
        return photoUserName;
    }

    public void setPhotoUserName(String photoUserName) {
        this.photoUserName = photoUserName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getConcatPhone() {
        return concatPhone;
    }

    public void setConcatPhone(String concatPhone) {
        this.concatPhone = concatPhone;
    }

    public String getShowImgUrl() {
        return showImgUrl;
    }

    public void setShowImgUrl(String showImgUrl) {
        this.showImgUrl = showImgUrl;
    }

    public String getCodeImgUrl() {
        return codeImgUrl;
    }

    public void setCodeImgUrl(String codeImgUrl) {
        this.codeImgUrl = codeImgUrl;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }
}
