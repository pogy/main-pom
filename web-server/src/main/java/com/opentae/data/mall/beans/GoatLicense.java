package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class GoatLicense implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long licenseId;

    /**
     * 店铺Id
     */
	private Long shopId;

    /**
     * 广告ID
     */
	private Long goatId;

    /**
     * 广告管理权开始时间
     */
	private Date licenseFromTime;

    /**
     * 广告管理权结束时间
     */
	private Date licenseToTime;

    /**
     * 广告开始时间
     */
	private Date spreadFromTime;

    /**
     * 广告结束时间
     */
	private Date spreadToTime;

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

	public void setGoatId(Long goatId) {
		this.goatId = goatId;
	}

	public Long getGoatId() {
		return this.goatId;
	}

	public void setLicenseFromTime(Date licenseFromTime) {
		this.licenseFromTime = licenseFromTime;
	}

	public Date getLicenseFromTime() {
		return this.licenseFromTime;
	}

	public void setLicenseToTime(Date licenseToTime) {
		this.licenseToTime = licenseToTime;
	}

	public Date getLicenseToTime() {
		return this.licenseToTime;
	}

	public void setSpreadFromTime(Date spreadFromTime) {
		this.spreadFromTime = spreadFromTime;
	}

	public Date getSpreadFromTime() {
		return this.spreadFromTime;
	}

	public void setSpreadToTime(Date spreadToTime) {
		this.spreadToTime = spreadToTime;
	}

	public Date getSpreadToTime() {
		return this.spreadToTime;
	}

}