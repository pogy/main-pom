package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class TaobaoItemProp implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long tipid;

    /**
     * 
     */
	private Long pid;

    /**
     * 
     */
	private Long parentPid;

    /**
     * 
     */
	private Long parentVid;

    /**
     * 
     */
	private String name;

    /**
     * 1是true0是false
     */
	private Integer isKeyProp;

    /**
     * 1是true0是false
     */
	private Integer isSaleProp;

    /**
     * 1是true0是false
     */
	private Integer isColorProp;

    /**
     * 1是true0是false
     */
	private Integer isEnumProp;

    /**
     * 1是true0是false
     */
	private Integer isItemProp;

    /**
     * 
     */
	private Integer must;

    /**
     * 
     */
	private Integer multi;

    /**
     * 
     */
	private String status;

    /**
     * 
     */
	private Long sortOrder;

    /**
     * 
     */
	private String childTemplate;

    /**
     * 1是true0是false
     */
	private Integer isAllowAlias;

    /**
     * 1是true0是false
     */
	private Integer isInputProp;

    /**
     * 
     */
	private Long cid;

    /**
     * 
     */
	private String remark10;

    /**
     * 
     */
	private String remark9;

    /**
     * 
     */
	private String remark8;

    /**
     * 
     */
	private String remark7;

    /**
     * 
     */
	private String remark6;

    /**
     * 
     */
	private String remark5;

    /**
     * 
     */
	private String remark4;

    /**
     * 
     */
	private String remark3;

    /**
     * 
     */
	private String remark1;

    /**
     * 
     */
	private String remark2;

	public void setTipid(Long tipid) {
		this.tipid = tipid;
	}

	public Long getTipid() {
		return this.tipid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setParentPid(Long parentPid) {
		this.parentPid = parentPid;
	}

	public Long getParentPid() {
		return this.parentPid;
	}

	public void setParentVid(Long parentVid) {
		this.parentVid = parentVid;
	}

	public Long getParentVid() {
		return this.parentVid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setIsKeyProp(Integer isKeyProp) {
		this.isKeyProp = isKeyProp;
	}

	public Integer getIsKeyProp() {
		return this.isKeyProp;
	}

	public void setIsSaleProp(Integer isSaleProp) {
		this.isSaleProp = isSaleProp;
	}

	public Integer getIsSaleProp() {
		return this.isSaleProp;
	}

	public void setIsColorProp(Integer isColorProp) {
		this.isColorProp = isColorProp;
	}

	public Integer getIsColorProp() {
		return this.isColorProp;
	}

	public void setIsEnumProp(Integer isEnumProp) {
		this.isEnumProp = isEnumProp;
	}

	public Integer getIsEnumProp() {
		return this.isEnumProp;
	}

	public void setIsItemProp(Integer isItemProp) {
		this.isItemProp = isItemProp;
	}

	public Integer getIsItemProp() {
		return this.isItemProp;
	}

	public void setMust(Integer must) {
		this.must = must;
	}

	public Integer getMust() {
		return this.must;
	}

	public void setMulti(Integer multi) {
		this.multi = multi;
	}

	public Integer getMulti() {
		return this.multi;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Long getSortOrder() {
		return this.sortOrder;
	}

	public void setChildTemplate(String childTemplate) {
		this.childTemplate = childTemplate;
	}

	public String getChildTemplate() {
		return this.childTemplate;
	}

	public void setIsAllowAlias(Integer isAllowAlias) {
		this.isAllowAlias = isAllowAlias;
	}

	public Integer getIsAllowAlias() {
		return this.isAllowAlias;
	}

	public void setIsInputProp(Integer isInputProp) {
		this.isInputProp = isInputProp;
	}

	public Integer getIsInputProp() {
		return this.isInputProp;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	public String getRemark10() {
		return this.remark10;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}

	public String getRemark9() {
		return this.remark9;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}

	public String getRemark8() {
		return this.remark8;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}

	public String getRemark7() {
		return this.remark7;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public String getRemark6() {
		return this.remark6;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark5() {
		return this.remark5;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark2() {
		return this.remark2;
	}

}