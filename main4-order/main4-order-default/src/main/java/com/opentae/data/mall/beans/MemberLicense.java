package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class MemberLicense implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long userLicenseId;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 用户权益类型，1代表实名认证，2代表邮箱认证，3代表密码安全，4代表绑定手机，5会员积分
     */
	private Integer licenseType;

    /**
     * 权益内容，如果是实名认证，这里放“身份证号;图片url”
     */
	private String context;

    /**
     * 1代表有效，0代表无效
     */
	private Integer licenseFailure;

	public void setUserLicenseId(Long userLicenseId) {
		this.userLicenseId = userLicenseId;
	}

	public Long getUserLicenseId() {
		return this.userLicenseId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setLicenseType(Integer licenseType) {
		this.licenseType = licenseType;
	}

	public Integer getLicenseType() {
		return this.licenseType;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return this.context;
	}

	public void setLicenseFailure(Integer licenseFailure) {
		this.licenseFailure = licenseFailure;
	}

	public Integer getLicenseFailure() {
		return this.licenseFailure;
	}

}