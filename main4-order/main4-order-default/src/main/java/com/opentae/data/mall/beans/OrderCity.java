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
	private Long cityId;

    /**
     * 城市名
     */
	private String cityName;

    /**
     * 省份ID
     */
	private Long provId;

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setProvId(Long provId) {
		this.provId = provId;
	}

	public Long getProvId() {
		return this.provId;
	}

}