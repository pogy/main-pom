package com.opentae.data.jd.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class JdLogistTemplate implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 用户京东ID
     */
	private Long jdUid;

    /**
     * 京东模板ID
     */
	private Long templateId;

    /**
     * 顺序号
     */
	private Integer templateIndex;

    /**
     * 模板名称
     */
	private String templateName;

    /**
     * 计费规则 
     */
	private Integer ruleType;

    /**
     * 是否卖家包邮
     */
	private Integer isFree;

    /**
     * 创建时间
     */
	private Date gmtCreate;

    /**
     * 修改时间
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setJdUid(Long jdUid) {
		this.jdUid = jdUid;
	}

	public Long getJdUid() {
		return this.jdUid;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getTemplateId() {
		return this.templateId;
	}

	public void setTemplateIndex(Integer templateIndex) {
		this.templateIndex = templateIndex;
	}

	public Integer getTemplateIndex() {
		return this.templateIndex;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateName() {
		return this.templateName;
	}

	public void setRuleType(Integer ruleType) {
		this.ruleType = ruleType;
	}

	public Integer getRuleType() {
		return this.ruleType;
	}

	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}

	public Integer getIsFree() {
		return this.isFree;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public Date getGmtModify() {
		return this.gmtModify;
	}

}