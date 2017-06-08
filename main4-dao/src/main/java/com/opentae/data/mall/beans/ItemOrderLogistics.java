package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemOrderLogistics implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String id;

    /**
     * 物流公司ID
     */
	private String companyId;

    /**
     * 快递单号
     */
	private String courierNumber;

    /**
     * 费用
     */
	private String money;

    /**
     * 
     */
	private String provId;

    /**
     * 
     */
	private String cityId;

    /**
     * 
     */
	private String townId;

    /**
     * 详细地址
     */
	private String address;

    /**
     * 手机号
     */
	private String telephone;

    /**
     * 邮编
     */
	private String zipCode;

    /**
     * 订单ID
     */
	private String oid;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCourierNumber(String courierNumber) {
		this.courierNumber = courierNumber;
	}

	public String getCourierNumber() {
		return this.courierNumber;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMoney() {
		return this.money;
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

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOid() {
		return this.oid;
	}

}