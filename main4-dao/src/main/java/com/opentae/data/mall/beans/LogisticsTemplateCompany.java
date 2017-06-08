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
	private String tcId;

    /**
     * 
     */
	private String ruleId;

    /**
     * 物流公司ID
     */
	private String companyId;

    /**
     * 模板ID
     */
	private String templateId;

	public void setTcId(String tcId) {
		this.tcId = tcId;
	}

	public String getTcId() {
		return this.tcId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleId() {
		return this.ruleId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateId() {
		return this.templateId;
	}

}