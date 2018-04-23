package com.openJar.beans;

import com.openJar.utils.OpenBean;

public class JdPropValue extends OpenBean {
    /**
     * 
     */
	private Long jdVid;

    /**
     * 类目ID
     */
	private Long cid;

    /**
     * 类目属性ID
     */
	private Long pid;

    /**
     * 属性名
     */
	private String propName;

    /**
     * 类目属性值ID
     */
	private Long vid;

    /**
     * 类目属性值
     */
	private String name;

    /**
     * 类目属性值别名
     */
	private String nameAlias;

    /**
     * 是否父级类目属性值：1是true0是false
     */
	private Integer isParent;

    /**
     * 
     */
	private String status;

    /**
     * 
     */
	private Long sortOrder;

	public void setJdVid(Long jdVid) {
		this.jdVid = jdVid;
	}

	public Long getJdVid() {
		return this.jdVid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropName() {
		return this.propName;
	}

	public void setVid(Long vid) {
		this.vid = vid;
	}

	public Long getVid() {
		return this.vid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setNameAlias(String nameAlias) {
		this.nameAlias = nameAlias;
	}

	public String getNameAlias() {
		return this.nameAlias;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public Integer getIsParent() {
		return this.isParent;
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

}