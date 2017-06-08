package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderCity implements Serializable {
    /**
     * 城市主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String cityId;

    /**
     * 城市名
     */
	private String cityName;

    /**
     * 省份ID
     */
	private String provId;

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

	public String getProvId() {
		return this.provId;
	}

}