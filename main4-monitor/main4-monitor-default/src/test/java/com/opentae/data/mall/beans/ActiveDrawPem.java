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
     * 创建时间
     */
	private Date createTime;

    /**
     * 期次展示
     */
	private Integer term;

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

}