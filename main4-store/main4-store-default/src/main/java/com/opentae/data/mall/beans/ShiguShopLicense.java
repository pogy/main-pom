package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguShopLicense implements Serializable {
    /**
     * 权益ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long licenseId;

    /**
     * 店ID
     */
	private Long shopId;

    /**
     * 7、店铺同步授权，内容为淘宝userId\n8、用户云盘空间，内容为空间大小，单位KB
     */
	private Integer licenseType;

    /**
     * 权益内容
     */
	private String context;

    /**
     * 权益有效性，0表示有效，1表示失效
     */
	private Integer licenseFailure;

	public void setLicenseId(Long licenseId) {
		this.licenseId = licenseId;
	}

	public Long getLicenseId() {
		return this.licenseId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
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