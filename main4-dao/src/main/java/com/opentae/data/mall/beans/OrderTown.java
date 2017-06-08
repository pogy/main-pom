package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderTown implements Serializable {
    /**
     * 镇ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String townId;

    /**
     * 镇名
     */
	private String townName;

    /**
     * 城市ID
     */
	private String cityId;

	public void setTownId(String townId) {
		this.townId = townId;
	}

	public String getTownId() {
		return this.townId;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityId() {
		return this.cityId;
	}

}