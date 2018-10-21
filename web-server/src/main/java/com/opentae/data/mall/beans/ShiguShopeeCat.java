package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguShopeeCat implements Serializable {
    /**
     * 0
     */
    @Id
    @GeneratedValue(generator = "JDBC")
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
     * 父类目名
     */
	private String parentCname;

    /**
     * 
     */
	private Boolean isParent;

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

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Boolean getIsParent() {
		return this.isParent;
	}

}