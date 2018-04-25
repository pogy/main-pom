package com.opentae.data.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPhotoCat implements Serializable {
    /**
     * 类目ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long cid;

    /**
     * 类目名
     */
	private String cname;

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

}