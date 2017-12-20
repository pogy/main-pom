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
	private Long id;

    /**
     * 物流公司ID
     */
	private Long companyId;

    /**
     * 快递单号
     */
	private String courierNumber;

    /**
     * 费用
     */
	private Long money;

    /**
     * 
     */
	private Long provId;

    /**
     * 
     */
	private Long cityId;

    /**
     * 
     */
	private Long townId;

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
	private Long oid;

    /**
     * 
     */
	private String name;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCourierNumber(String courierNumber) {
		this.courierNumber = courierNumber;
	}

	public String getCourierNumber() {
		return this.courierNumber;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Long getMoney() {
		return this.money;
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

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}