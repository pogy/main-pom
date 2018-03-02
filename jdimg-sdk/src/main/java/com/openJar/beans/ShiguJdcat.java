package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

public class ShiguJdcat extends OpenBean {
    /**
     * 类目ID
     */
	private Long cid;

    /**
     * 类目名
     */
	private String cname;

    /**
     * 父类目ID
     */
	private Long parentCid;

    /**
     * 父类目
     */
	private String parentCname;

    /**
     * 是否是顶级类目
     */
	private Integer isParent;

    /**
     * 示显排序
     */
	private String remark1;

    /**
     * 对应的淘宝类目ID
     */
	private Long tbCid;

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCname() {
		return this.cname;
	}

	public void setParentCid(Long parentCid) {
		this.parentCid = parentCid;
	}

	public Long getParentCid() {
		return this.parentCid;
	}

	public void setParentCname(String parentCname) {
		this.parentCname = parentCname;
	}

	public String getParentCname() {
		return this.parentCname;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public Integer getIsParent() {
		return this.isParent;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setTbCid(Long tbCid) {
		this.tbCid = tbCid;
	}

	public Long getTbCid() {
		return this.tbCid;
	}

}