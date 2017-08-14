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
	private Long townId;

    /**
     * 镇名
     */
	private String townName;

    /**
     * 城市ID
     */
	private Long cityId;

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public Long getTownId() {
		return this.townId;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCityId() {
		return this.cityId;
	}

}