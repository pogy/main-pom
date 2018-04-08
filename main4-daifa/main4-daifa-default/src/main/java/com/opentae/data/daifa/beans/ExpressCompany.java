package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ExpressCompany implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long expressCompanyId;

    /**
     * 快递公司名
     */
	private String expressName;

    /**
     * 简称
     */
	private String shortName;

    /**
     * 英文名
     */
	private String enName;

    /**
     * 状态@0无效1有效
     */
	private Integer useStatus;

    /**
     * 备用
     */
	private String remark1;

    /**
     * 快递公司编码
     */
	private String remark2;

    /**
     * 备用
     */
	private String remark3;

    /**
     * 备用
     */
	private String remark4;

    /**
     * 备用
     */
	private String remark5;

	public void setExpressCompanyId(Long expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

	public Long getExpressCompanyId() {
		return this.expressCompanyId;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public String getExpressName() {
		return this.expressName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getEnName() {
		return this.enName;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public Integer getUseStatus() {
		return this.useStatus;
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

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark5() {
		return this.remark5;
	}

}