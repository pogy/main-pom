package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemOrderPackage implements Serializable {
    /**
     * 包材ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String id;

    /**
     * 包材ID
     */
	private String metarialId;

    /**
     * 总价格
     */
	private String money;

    /**
     * 数量
     */
	private String num;

    /**
     * 订单号
     */
	private String oid;

    /**
     * 包材名
     */
	private String name;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setMetarialId(String metarialId) {
		this.metarialId = metarialId;
	}

	public String getMetarialId() {
		return this.metarialId;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMoney() {
		return this.money;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNum() {
		return this.num;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOid() {
		return this.oid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}