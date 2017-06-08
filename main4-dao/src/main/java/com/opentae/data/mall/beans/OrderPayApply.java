package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderPayApply implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String applyId;

    /**
     * 钱数
     */
	private String money;

    /**
     * 支付链接
     */
	private String payLink;

    /**
     * 1微信、2支付宝、3星座宝
     */
	private String type;

    /**
     * 创建时间
     */
	private String createTime;

    /**
     * 支付理由，1星座进货
     */
	private String payFor;

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getApplyId() {
		return this.applyId;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMoney() {
		return this.money;
	}

	public void setPayLink(String payLink) {
		this.payLink = payLink;
	}

	public String getPayLink() {
		return this.payLink;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setPayFor(String payFor) {
		this.payFor = payFor;
	}

	public String getPayFor() {
		return this.payFor;
	}

}