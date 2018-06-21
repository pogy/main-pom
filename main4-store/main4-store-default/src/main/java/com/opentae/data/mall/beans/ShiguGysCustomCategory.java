package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguGysCustomCategory implements Serializable {
    /**
     * 店铺自定义类目id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long gcId;

    /**
     * 店铺自定义类目名
     */
	private String gcName;

    /**
     * 店铺id
     */
	private Long sId;

    /**
     * 店铺自定义类目状态-1：删除，1：正常
     */
	private Integer gcStatus;

	public void setGcId(Long gcId) {
		this.gcId = gcId;
	}

	public Long getGcId() {
		return this.gcId;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public String getGcName() {
		return this.gcName;
	}

	public void setSId(Long sId) {
		this.sId = sId;
	}

	public Long getSId() {
		return this.sId;
	}

	public void setGcStatus(Integer gcStatus) {
		this.gcStatus = gcStatus;
	}

	public Integer getGcStatus() {
		return this.gcStatus;
	}

}