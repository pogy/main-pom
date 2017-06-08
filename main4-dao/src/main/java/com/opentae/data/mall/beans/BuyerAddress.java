package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class BuyerAddress implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String addressId;

    /**
     * 省份
     */
	private String provId;

    /**
     * 市
     */
	private String cityId;

    /**
     * 区
     */
	private String townId;

    /**
     * 详细地址
     */
	private String address;

    /**
     * 用户ID
     */
	private String userId;

    /**
     * 手机号
     */
	private String telephone;

    /**
     * 邮编
     */
	private String zipCode;

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressId() {
		return this.addressId;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

	public String getProvId() {
		return this.provId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setTownId(String townId) {
		this.townId = townId;
	}

	public String getTownId() {
		return this.townId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCode() {
		return this.zipCode;
	}

}