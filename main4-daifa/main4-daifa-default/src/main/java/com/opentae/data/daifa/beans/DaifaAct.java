package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaAct implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long actId;

    /**
     * 
     */
	private Long workerId;

    /**
     * 
     */
	private String url;

    /**
     * 
     */
	private String param;

    /**
     * 
     */
	private Date created;

	public void setActId(Long actId) {
		this.actId = actId;
	}

	public Long getActId() {
		return this.actId;
	}

	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}

	public Long getWorkerId() {
		return this.workerId;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getParam() {
		return this.param;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCreated() {
		return this.created;
	}

}