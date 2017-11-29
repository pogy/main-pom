package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class SpreadTerm implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long termId;

    /**
     * 开始时间
     */
	private Date startTime;

    /**
     * 结束时间
     */
	private Date endTime;

    /**
     * 0广告售卖，1led活动
     */
	private Integer type;

    /**
     * 男装广告：man  女装广告：woman  全站广告放在男装广告中
     */
	private String manOrWoman;

	public void setTermId(Long termId) {
		this.termId = termId;
	}

	public Long getTermId() {
		return this.termId;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setManOrWoman(String manOrWoman) {
		this.manOrWoman = manOrWoman;
	}

	public String getManOrWoman() {
		return this.manOrWoman;
	}

}