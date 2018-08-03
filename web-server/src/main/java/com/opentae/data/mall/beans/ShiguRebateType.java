package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguRebateType implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long typeId;

    /**
     * 类型描述
     */
	private String typeName;

    /**
     * 返点 万分之几
     */
	private Integer rebateNum;

    /**
     * 是否默认类型
     */
	private Integer isDefault;

    /**
     * 是否有效 1 有效 0 无效
     */
	private Integer isActive;

    /**
     * 
     */
	private String typeAbridge;

    /**
     * 
     */
	private Date gmtCreate;

    /**
     * 
     */
	private Date gmtUpdate;

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setRebateNum(Integer rebateNum) {
		this.rebateNum = rebateNum;
	}

	public Integer getRebateNum() {
		return this.rebateNum;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getIsDefault() {
		return this.isDefault;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsActive() {
		return this.isActive;
	}

	public void setTypeAbridge(String typeAbridge) {
		this.typeAbridge = typeAbridge;
	}

	public String getTypeAbridge() {
		return this.typeAbridge;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtUpdate(Date gmtUpdate) {
		this.gmtUpdate = gmtUpdate;
	}

	public Date getGmtUpdate() {
		return this.gmtUpdate;
	}

}