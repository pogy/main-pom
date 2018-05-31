package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ExpressTemplateProv implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long etpId;

    /**
     * 父规则的id
     */
	private Long ruleId;

    /**
     * 省id
     */
	private Long provId;

    /**
     * 省名字
     */
	private String provName;

    /**
     * 所属模版id
     */
	private Long etId;

    /**
     * 是否删除 -1：删除，1：正常
     */
	private Integer etpStatus;

	public void setEtpId(Long etpId) {
		this.etpId = etpId;
	}

	public Long getEtpId() {
		return this.etpId;
	}

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}

	public Long getRuleId() {
		return this.ruleId;
	}

	public void setProvId(Long provId) {
		this.provId = provId;
	}

	public Long getProvId() {
		return this.provId;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getProvName() {
		return this.provName;
	}

	public void setEtId(Long etId) {
		this.etId = etId;
	}

	public Long getEtId() {
		return this.etId;
	}

	public void setEtpStatus(Integer etpStatus) {
		this.etpStatus = etpStatus;
	}

	public Integer getEtpStatus() {
		return this.etpStatus;
	}

}