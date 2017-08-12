package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class GoatItemData implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long dataId;

    /**
     * 广告ID
     */
	private Long goatId;

    /**
     * 
     */
	private Long userId;

    /**
     * 开始时间
     */
	private Date fromTime;

    /**
     * 结束时间
     */
	private Date toTime;

    /**
     * 广告的内容
     */
	private String context;

    /**
     * 1有效，0无效，2预设
     */
	private Integer status;

    /**
     * 最后创建时间
     */
	private Date lastPublishTime;

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public Long getDataId() {
		return this.dataId;
	}

	public void setGoatId(Long goatId) {
		this.goatId = goatId;
	}

	public Long getGoatId() {
		return this.goatId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}

	public Date getFromTime() {
		return this.fromTime;
	}

	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}

	public Date getToTime() {
		return this.toTime;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return this.context;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setLastPublishTime(Date lastPublishTime) {
		this.lastPublishTime = lastPublishTime;
	}

	public Date getLastPublishTime() {
		return this.lastPublishTime;
	}

}