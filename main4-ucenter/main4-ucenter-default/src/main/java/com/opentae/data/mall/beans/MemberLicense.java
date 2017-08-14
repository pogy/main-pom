package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户权益
 * Created by zhaohongbo on 17/3/1.
 */
public class MemberLicense implements Serializable{

    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long userLicenseId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户权益类型，1代表实名认证，2代表邮箱认证，3代表密码安全，4代表绑定手机，5代表用户积分
     */
    private Integer licenseType;
    /**
     * 权益的内容
     */
    private String context;
    /**
     * 1代表有效，0代表无效
     */
    private Integer licenseFailure;

    public Long getUserLicenseId() {
        return userLicenseId;
    }

    public void setUserLicenseId(Long userLicenseId) {
        this.userLicenseId = userLicenseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getLicenseFailure() {
        return licenseFailure;
    }

    public void setLicenseFailure(Integer licenseFailure) {
        this.licenseFailure = licenseFailure;
    }
}
