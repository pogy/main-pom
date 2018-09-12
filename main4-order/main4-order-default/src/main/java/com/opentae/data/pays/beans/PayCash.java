package com.opentae.data.pays.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class PayCash implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long cashId;

    /**
     * 账户ID
     */
	private Long accountId;

    /**
     * 星座宝ID
     */
	private Long xzUserId;

    /**
     * 提现金额
     */
	private Long cashMoney;

    /**
     * 提现类型
     */
	private String cashType;

    /**
     * 提现备注
     */
	private String cashRemark;

    /**
     * 提现状态，normal为正常未提现，cashed为已提现，casherr为提现失败
     */
	private String cashStatus;

    /**
     * 提现失败原因、备注
     */
	private String errReason;

    /**
     * 提现时间
     */
	private Date cashTime;

    /**
     * 打款时间
     */
	private Date madeTime;

    /**
     * 最后操作时间
     */
	private Date cashModifyTime;

    /**
     * 支付宝交易号
     */
	private String alipayNo;

    /**
     * 提现时间
     */
	private Date payCashTime;

    /**
     * 提现操作人
     */
	private Long payCashId;

    /**
     * 支付宝实际打款金额
     */
	private String alipayMoney;

    /**
     * 提现用的支付宝账户
     */
	private String alipayUserId;

    /**
     * 支付宝实名
     */
	private String alipayUserName;

    /**
     * 用户提现时，申请的总额，单位为分
     */
	private Long cashTotalApply;

    /**
     * 用户提现时用户实际支付的手续费
     */
	private Long poundageToUser;

    /**
     * 用户提现时按公司设定的手续费的计算值
     */
	private String poundageSet;

    /**
     * 用户提现时，按公司设定手续费计算值在以分为单位后，小数位上有值，进1位到分，用户多出的一部分手续费
     */
	private String extraIncomePoundage;

	public void setCashId(Long cashId) {
		this.cashId = cashId;
	}

	public Long getCashId() {
		return this.cashId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setXzUserId(Long xzUserId) {
		this.xzUserId = xzUserId;
	}

	public Long getXzUserId() {
		return this.xzUserId;
	}

	public void setCashMoney(Long cashMoney) {
		this.cashMoney = cashMoney;
	}

	public Long getCashMoney() {
		return this.cashMoney;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
	}

	public String getCashType() {
		return this.cashType;
	}

	public void setCashRemark(String cashRemark) {
		this.cashRemark = cashRemark;
	}

	public String getCashRemark() {
		return this.cashRemark;
	}

	public void setCashStatus(String cashStatus) {
		this.cashStatus = cashStatus;
	}

	public String getCashStatus() {
		return this.cashStatus;
	}

	public void setErrReason(String errReason) {
		this.errReason = errReason;
	}

	public String getErrReason() {
		return this.errReason;
	}

	public void setCashTime(Date cashTime) {
		this.cashTime = cashTime;
	}

	public Date getCashTime() {
		return this.cashTime;
	}

	public void setMadeTime(Date madeTime) {
		this.madeTime = madeTime;
	}

	public Date getMadeTime() {
		return this.madeTime;
	}

	public void setCashModifyTime(Date cashModifyTime) {
		this.cashModifyTime = cashModifyTime;
	}

	public Date getCashModifyTime() {
		return this.cashModifyTime;
	}

	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}

	public String getAlipayNo() {
		return this.alipayNo;
	}

	public void setPayCashTime(Date payCashTime) {
		this.payCashTime = payCashTime;
	}

	public Date getPayCashTime() {
		return this.payCashTime;
	}

	public void setPayCashId(Long payCashId) {
		this.payCashId = payCashId;
	}

	public Long getPayCashId() {
		return this.payCashId;
	}

	public void setAlipayMoney(String alipayMoney) {
		this.alipayMoney = alipayMoney;
	}

	public String getAlipayMoney() {
		return this.alipayMoney;
	}

	public void setAlipayUserId(String alipayUserId) {
		this.alipayUserId = alipayUserId;
	}

	public String getAlipayUserId() {
		return this.alipayUserId;
	}

	public void setAlipayUserName(String alipayUserName) {
		this.alipayUserName = alipayUserName;
	}

	public String getAlipayUserName() {
		return this.alipayUserName;
	}

	public void setCashTotalApply(Long cashTotalApply) {
		this.cashTotalApply = cashTotalApply;
	}

	public Long getCashTotalApply() {
		return this.cashTotalApply;
	}

	public void setPoundageToUser(Long poundageToUser) {
		this.poundageToUser = poundageToUser;
	}

	public Long getPoundageToUser() {
		return this.poundageToUser;
	}

	public void setPoundageSet(String poundageSet) {
		this.poundageSet = poundageSet;
	}

	public String getPoundageSet() {
		return this.poundageSet;
	}

	public void setExtraIncomePoundage(String extraIncomePoundage) {
		this.extraIncomePoundage = extraIncomePoundage;
	}

	public String getExtraIncomePoundage() {
		return this.extraIncomePoundage;
	}

}