package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class GoodsBogusUploadRecords implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long brId;

    /**
     * 
     */
	private Long goodsId;

    /**
     * 
     */
	private Date time;

    /**
     * 
     */
	private String day;

    /**
     * 
     */
	private Integer type;

	public void setBrId(Long brId) {
		this.brId = brId;
	}

	public Long getBrId() {
		return this.brId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return this.time;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDay() {
		return this.day;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

}