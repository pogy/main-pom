package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class LogisticsTemplateProv implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String tpId;

    /**
     * 规则ID
     */
	private String ruleId;

    /**
     * 省份ID
     */
	private String provId;

    /**
     * 模板ID
     */
	private String templateId;

	public void setTpId(String tpId) {
		this.tpId = tpId;
	}

	public String getTpId() {
		return this.tpId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleId() {
		return this.ruleId;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

	public String getProvId() {
		return this.provId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateId() {
		return this.templateId;
	}

}