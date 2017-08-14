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
	private Long addressId;

    /**
     * 省份
     */
	private Long provId;

    /**
     * 市
     */
	private Long cityId;

    /**
     * 区
     */
	private Long townId;

    /**
     * 详细地址
     */
	private String address;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 手机号
     */
	private String telephone;

    /**
     * 邮编
     */
	private String zipCode;

    /**
     * 用户名
     */
	private String name;

    /**
     * 省名称冗余
     */
	private String provName;

    /**
     * 市名称冗余
     */
	private String cityName;

    /**
     * 区域名称冗余
     */
	private String townName;

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getAddressId() {
		return this.addressId;
	}

	public void setProvId(Long provId) {
		this.provId = provId;
	}

	public Long getProvId() {
		return this.provId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public Long getTownId() {
		return this.townId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getProvName() {
		return this.provName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getTownName() {
		return this.townName;
	}

}