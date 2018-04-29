package com.shigu.photo.bo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.bo.AuthApplySearchBO
 * 工程: main-pom
 * 时间: 18-4-29 下午1:16
 * 创建人: wanghaoxiang
 * 描述:
 */
public class AuthApplySearchBO implements Serializable {

    // 审核状态，0:未处理 1:通过 2:驳回 ,未传默认为0
    private Integer status;

    // 认证手机号
    private String concatPhone;

    //1:模特,2:摄影师,3摄影公司,4:场地
    private Integer authType;

    //用户名
    private String photoUserName;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getConcatPhone() {
        return concatPhone;
    }

    public void setConcatPhone(String concatPhone) {
        this.concatPhone = concatPhone;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getPhotoUserName() {
        return photoUserName;
    }

    public void setPhotoUserName(String photoUserName) {
        this.photoUserName = photoUserName;
    }
}
