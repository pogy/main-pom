package com.shigu.photo.bo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 路径: com.shigu.photo.bo.PhotoUserValidBO
 * 工程: main-pom
 * 时间: 18-4-28 下午12:56
 * 创建人: wanghaoxiang
 * 描述:
 */
public class PhotoUserValidBO implements Serializable {

    //	用户名称
    @NotNull(message = "用户名不能为空")
    private String username;

    //职业类型. 1模特，2摄影师，3摄影公司，4场地
    @NotNull(message = "请选择职业类型")
    private Integer roleStyle;

    //	手机号码
    @NotNull(message = "手机号错误")
    private String workphone;

    //短信验证码
    @NotNull(message = "验证码错误")
    private String msgCode;

    //用户封面图片链接
    private String userCover;

    //微信二维码
    private String wxQrCode;

    //作者主要风格
    private String styles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRoleStyle() {
        return roleStyle;
    }

    public void setRoleStyle(Integer roleStyle) {
        this.roleStyle = roleStyle;
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getUserCover() {
        return userCover;
    }

    public void setUserCover(String userCover) {
        this.userCover = userCover;
    }

    public String getWxQrCode() {
        return wxQrCode;
    }

    public void setWxQrCode(String wxQrCode) {
        this.wxQrCode = wxQrCode;
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }
}
