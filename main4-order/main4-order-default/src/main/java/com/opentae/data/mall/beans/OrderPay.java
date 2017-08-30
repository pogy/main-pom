package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class OrderPay implements Serializable {
    /**
     * 支付ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long payId;

    /**
     * 钱数，分为单位
     */
	private Long money;

    /**
     * 0
     */
	private Long refundMoney;

    /**
     * 支付时间
     */
	private Date createTime;

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
	private Integer payFor;

    /**
     * 1微信、2支付宝、3星座宝
     */
	private Integer type;

    /**
     * 发起支付请求ID
     */
	private Long applyId;

	public void setPayId(Long payId) {
		this.payId = payId;
	}

	public Long getPayId() {
		return this.payId;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Long getMoney() {
		return this.money;
	}

	public void setRefundMoney(Long refundMoney) {
		this.refundMoney = refundMoney;
	}

	public Long getRefundMoney() {
		return this.refundMoney;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
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

	public void setPayFor(Integer payFor) {
		this.payFor = payFor;
	}

	public Integer getPayFor() {
		return this.payFor;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Long getApplyId() {
		return this.applyId;
	}

}