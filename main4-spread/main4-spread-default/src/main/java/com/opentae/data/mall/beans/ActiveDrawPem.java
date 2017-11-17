package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ActiveDrawPem implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 每期的额外信息。
     */
	private String info;

    /**
     * 开始时间
     */
	private Date startTime;

    /**
     * 截止时间
     */
	private Date endTime;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 期次展示
     */
	private Integer term;

    /**
     * 活动类别，1表示发现好货，2表示秋款上新
     */
	private Integer activeType;

    /**
     * 中奖信息标题
     */
	private String title;

    /**
     * 活动类型标记 代金券活动voucher
     */
	private String flag;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return this.info;
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

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Integer getTerm() {
		return this.term;
	}

	public void setActiveType(Integer activeType) {
		this.activeType = activeType;
	}

	public Integer getActiveType() {
		return this.activeType;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return this.flag;
	}

}