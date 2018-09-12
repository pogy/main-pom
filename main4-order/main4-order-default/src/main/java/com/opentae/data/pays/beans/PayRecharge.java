package com.opentae.data.pays.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class PayRecharge implements Serializable {
    /**
     * 充值记录ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long rechargeId;

    /**
     * 充值类型，1用户充值，2微信过款，3收退款，4代发内部收款（拿货员离职时，给主管打余款）
     */
	private Integer type;

    /**
     * 
     */
	private String alipayNo;

    /**
     * 支付用户ID
     */
	private String accountId;

    /**
     * 充值状态，1完成，2出错
     */
	private Integer status;

    /**
     * 充值金额，分为单位，如果有卷，包含卷部分
     */
	private Long price;

    /**
     * 记录时间
     */
	private Date createTime;

    /**
     * 
     */
	private String volumeIds;

    /**
     * 卷部分的总金额
     */
	private Long volumePrice;

    /**
     * 
     */
	private String chargeMethod;

	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}

	public Long getRechargeId() {
		return this.rechargeId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}

	public String getAlipayNo() {
		return this.alipayNo;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setVolumeIds(String volumeIds) {
		this.volumeIds = volumeIds;
	}

	public String getVolumeIds() {
		return this.volumeIds;
	}

	public void setVolumePrice(Long volumePrice) {
		this.volumePrice = volumePrice;
	}

	public Long getVolumePrice() {
		return this.volumePrice;
	}

	public void setChargeMethod(String chargeMethod) {
		this.chargeMethod = chargeMethod;
	}

	public String getChargeMethod() {
		return this.chargeMethod;
	}

}