package com.openJar.beans;

import com.openJar.utils.OpenBean;

public class JdItemProp extends OpenBean{
    /**
     * 
     */
	private Long jipid;

    /**
     * 类目属性ID
     */
	private Long pid;

    /**
     * 父级类目属性ID
     */
	private Long parentPid;

    /**
     * 父级类目属性值ID
     */
	private Long parentVid;

    /**
     * 类目属性名
     */
	private String name;

    /**
     * 是否关键属性： 1是true0是false
     */
	private Integer isKeyProp;

    /**
     * 是否销售属性：1是true0是false
     */
	private Integer isSaleProp;

    /**
     * 是否颜色属性：1是true0是false
     */
	private Integer isColorProp;

    /**
     * 是否选择属性1是true0是false
     */
	private Integer isEnumProp;

    /**
     * 是不是扩展属性
     */
	private Integer isItemProp;

    /**
     * 是不是品牌
     */
	private Integer isBrand;

    /**
     * 是否必须属性
     */
	private Integer must;

    /**
     * 是否多选属性
     */
	private Integer multi;

    /**
     * 是否有效
     */
	private String status;

    /**
     * 属性排序
     */
	private Long sortOrder;

    /**
     * 
     */
	private String childTemplate;

    /**
     * 是否个别名：1是true0是false
     */
	private Integer isAllowAlias;

    /**
     * 是否可自定义（输入）：1是true0是false
     */
	private Integer isInputProp;

    /**
     * 类目ID
     */
	private Long cid;

	public void setJipid(Long jipid) {
		this.jipid = jipid;
	}

	public Long getJipid() {
		return this.jipid;
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

	public void setIsBrand(Integer isBrand) {
		this.isBrand = isBrand;
	}

	public Integer getIsBrand() {
		return this.isBrand;
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

}