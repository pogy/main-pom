package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class DaifaPostCustomer implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long postCustomerId;

    /**
     * 代发ID
     */
	private Long dfSellerId;

    /**
     * 
     */
	private Integer useStatus;

    /**
     * 
     */
	private Long expressId;

    /**
     * 快递名
     */
	private String express;

    /**
     * 快递公司简称代码
     */
	private String expressCompanyCode;

    /**
     * 
     */
	private Integer isNeedCustomer;

    /**
     * 电子面单账户名
     */
	private String customerName;

    /**
     * 
     */
	private String customerPwd;

    /**
     * 
     */
	private String monthCode;

    /**
     * 
     */
	private String sendSite;

    /**
     * 快递单号
     */
	private String logisticCode;

    /**
     * 子快递类型
     */
	private Integer expType;

    /**
     * 手动发货标记
     */
	private Integer manual;

	public void setPostCustomerId(Long postCustomerId) {
		this.postCustomerId = postCustomerId;
	}

	public Long getPostCustomerId() {
		return this.postCustomerId;
	}

	public void setDfSellerId(Long dfSellerId) {
		this.dfSellerId = dfSellerId;
	}

	public Long getDfSellerId() {
		return this.dfSellerId;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public Integer getUseStatus() {
		return this.useStatus;
	}

	public void setExpressId(Long expressId) {
		this.expressId = expressId;
	}

	public Long getExpressId() {
		return this.expressId;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public String getExpress() {
		return this.express;
	}

	public void setExpressCompanyCode(String expressCompanyCode) {
		this.expressCompanyCode = expressCompanyCode;
	}

	public String getExpressCompanyCode() {
		return this.expressCompanyCode;
	}

	public void setIsNeedCustomer(Integer isNeedCustomer) {
		this.isNeedCustomer = isNeedCustomer;
	}

	public Integer getIsNeedCustomer() {
		return this.isNeedCustomer;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}

	public String getCustomerPwd() {
		return this.customerPwd;
	}

	public void setMonthCode(String monthCode) {
		this.monthCode = monthCode;
	}

	public String getMonthCode() {
		return this.monthCode;
	}

	public void setSendSite(String sendSite) {
		this.sendSite = sendSite;
	}

	public String getSendSite() {
		return this.sendSite;
	}

	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}

	public String getLogisticCode() {
		return this.logisticCode;
	}

	public void setExpType(Integer expType) {
		this.expType = expType;
	}

	public Integer getExpType() {
		return this.expType;
	}

	public void setManual(Integer manual) {
		this.manual = manual;
	}

	public Integer getManual() {
		return this.manual;
	}

}