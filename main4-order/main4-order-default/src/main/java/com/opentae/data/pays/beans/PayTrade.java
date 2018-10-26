package com.opentae.data.pays.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class PayTrade implements Serializable {
    /**
     * 支付交易号
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long payId;

    /**
     * 交易类型，1充值，2买入，3退款，4提现，5系统扣款，6打拿货款，7打邮费，8打代发费，9卷兑换
     */
	private Integer type;

    /**
     * 扣款种类，1支付宝扣款，2星座宝扣款，3微信扣款，4抵价卷扣款，5星座宝卷混合
     */
	private Integer debitType;

    /**
     * 支付宝交易号
     */
	private String alipayNo;

    /**
     * 微信交易号
     */
	private String wxNo;

    /**
     * 抵价卷ID，格式例如id1:subouterId1;id2:subouterId2 没有用到
     */
	private String povIds;

    /**
     * 充值记录ID
     */
	private Long rechargeId;

    /**
     * 代扣款账户ID，这里的账户，仅限于星座宝账户
     */
	private Long behalfAccountId;

    /**
     * 付款方账户ID
     */
	private Long fromAccountId;

    /**
     * 收款方账户ID
     */
	private Long toAccountId;

    /**
     * 外部交易订单号
     */
	private String outTradeNo;

    /**
     * 外部交易子订单号
     */
	private String outSubTradeNo;

    /**
     * 交易金额，按分计算
     */
	private Long price;

    /**
     * 外部备注
     */
	private String outComments;

    /**
     * 系统备注
     */
	private String comments;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 1拒单、2缺货、3欠货、4清货、5买家退货
     */
	private Integer refundType;

    /**
     * 如果退货退邮费的话，记录邮费
     */
	private Long tpFee;

    /**
     * 用户实际出的手续费，以分为单位
     */
	private Long serviceCharge;

	public void setPayId(Long payId) {
		this.payId = payId;
	}

	public Long getPayId() {
		return this.payId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setDebitType(Integer debitType) {
		this.debitType = debitType;
	}

	public Integer getDebitType() {
		return this.debitType;
	}

	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}

	public String getAlipayNo() {
		return this.alipayNo;
	}

	public void setWxNo(String wxNo) {
		this.wxNo = wxNo;
	}

	public String getWxNo() {
		return this.wxNo;
	}

	public void setPovIds(String povIds) {
		this.povIds = povIds;
	}

	public String getPovIds() {
		return this.povIds;
	}

	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}

	public Long getRechargeId() {
		return this.rechargeId;
	}

	public void setBehalfAccountId(Long behalfAccountId) {
		this.behalfAccountId = behalfAccountId;
	}

	public Long getBehalfAccountId() {
		return this.behalfAccountId;
	}

	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Long getFromAccountId() {
		return this.fromAccountId;
	}

	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Long getToAccountId() {
		return this.toAccountId;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setOutSubTradeNo(String outSubTradeNo) {
		this.outSubTradeNo = outSubTradeNo;
	}

	public String getOutSubTradeNo() {
		return this.outSubTradeNo;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setOutComments(String outComments) {
		this.outComments = outComments;
	}

	public String getOutComments() {
		return this.outComments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getComments() {
		return this.comments;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setRefundType(Integer refundType) {
		this.refundType = refundType;
	}

	public Integer getRefundType() {
		return this.refundType;
	}

	public void setTpFee(Long tpFee) {
		this.tpFee = tpFee;
	}

	public Long getTpFee() {
		return this.tpFee;
	}

	public void setServiceCharge(Long serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public Long getServiceCharge() {
		return this.serviceCharge;
	}

}