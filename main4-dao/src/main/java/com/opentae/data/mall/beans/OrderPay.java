package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderPay implements Serializable {
    /**
     * 支付ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String payId;

    /**
     * 钱数，分为单位
     */
	private String money;

    /**
     * 
     */
	private String refundMoney;

    /**
     * 支付时间
     */
	private String createTime;

    /**
     * 外部支付单号
     */
	private String outerPid;

    /**
     * 支付用户名
     */
	private String outerPuser;

    /**
     * 支付理由，1星座进货
     */
	private String payFor;

    /**
     * 1微信、2支付宝、3星座宝
     */
	private String type;

    /**
     * 发起支付请求ID
     */
	private String applyId;

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPayId() {
		return this.payId;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMoney() {
		return this.money;
	}

	public void setRefundMoney(String refundMoney) {
		this.refundMoney = refundMoney;
	}

	public String getRefundMoney() {
		return this.refundMoney;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setOuterPid(String outerPid) {
		this.outerPid = outerPid;
	}

	public String getOuterPid() {
		return this.outerPid;
	}

	public void setOuterPuser(String outerPuser) {
		this.outerPuser = outerPuser;
	}

	public String getOuterPuser() {
		return this.outerPuser;
	}

	public void setPayFor(String payFor) {
		this.payFor = payFor;
	}

	public String getPayFor() {
		return this.payFor;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getApplyId() {
		return this.applyId;
	}

}