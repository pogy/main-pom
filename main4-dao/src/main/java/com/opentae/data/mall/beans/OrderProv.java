package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderProv implements Serializable {
    /**
     * 省份ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String provId;

    /**
     * 省份名
     */
	private String provName;

	public void setProvId(String provId) {
		this.provId = provId;
	}

	public String getProvId() {
		return this.provId;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getProvName() {
		return this.provName;
	}

}