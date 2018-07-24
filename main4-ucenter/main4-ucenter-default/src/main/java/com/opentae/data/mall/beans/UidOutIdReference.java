package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class UidOutIdReference implements Serializable {
    /**
     * 用户外部id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 用户id
     */
	private Long uid;

    /**
     * 
     */
	private Date gmtCreate;

    /**
     * 
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public Date getGmtModify() {
		return this.gmtModify;
	}

}