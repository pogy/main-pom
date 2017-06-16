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
	private Long id;

    /**
     * 包材ID
     */
	private Long metarialId;

    /**
     * 总价格
     */
	private Long money;

    /**
     * 数量
     */
	private Integer num;

    /**
     * 订单号
     */
	private Long oid;

    /**
     * 包材名
     */
	private String name;

    /**
     * 已退金额
     */
	private Long refundMoney;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setMetarialId(Long metarialId) {
		this.metarialId = metarialId;
	}

	public Long getMetarialId() {
		return this.metarialId;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Long getMoney() {
		return this.money;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return this.num;
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

	public void setRefundMoney(Long refundMoney) {
		this.refundMoney = refundMoney;
	}

	public Long getRefundMoney() {
		return this.refundMoney;
	}

}