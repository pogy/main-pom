package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class TaobaoPropValue implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long tbVid;

    /**
     * 
     */
	private Long cid;

    /**
     * 
     */
	private Long pid;

    /**
     * 
     */
	private String propName;

    /**
     * 
     */
	private Long vid;

    /**
     * 
     */
	private String name;

    /**
     * 
     */
	private String nameAlias;

    /**
     * 1是true0是false
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

	public void setTbVid(Long tbVid) {
		this.tbVid = tbVid;
	}

	public Long getTbVid() {
		return this.tbVid;
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