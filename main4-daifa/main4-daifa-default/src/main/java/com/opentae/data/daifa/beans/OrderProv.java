package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderProv implements Serializable {
    /**
     * 省份ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long provId;

    /**
     * 省份名
     */
	private String provName;

	public void setProvId(Long provId) {
		this.provId = provId;
	}

	public Long getProvId() {
		return this.provId;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getProvName() {
		return this.provName;
	}

}