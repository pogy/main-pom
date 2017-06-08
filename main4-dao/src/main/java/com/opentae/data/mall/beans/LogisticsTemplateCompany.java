package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class LogisticsTemplateCompany implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long tcId;

    /**
     * 
     */
	private Long ruleId;

    /**
     * 物流公司ID
     */
	private Long companyId;

    /**
     * 模板ID
     */
	private Long templateId;

	public void setTcId(Long tcId) {
		this.tcId = tcId;
	}

	public Long getTcId() {
		return this.tcId;
	}

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}

	public Long getRuleId() {
		return this.ruleId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getTemplateId() {
		return this.templateId;
	}

}