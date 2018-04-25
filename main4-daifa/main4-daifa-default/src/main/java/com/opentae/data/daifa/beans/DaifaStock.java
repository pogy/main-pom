package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class DaifaStock implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long stockId;

    /**
     * 
     */
	private Long dfOrderId;

    /**
     * 
     */
	private Long dfTradeId;

    /**
     * 
     */
	private Long sellerId;

    /**
     * 
     */
	private Date startInTime;

    /**
     * 
     */
	private String stockRemark;

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getStockId() {
		return this.stockId;
	}

	public void setDfOrderId(Long dfOrderId) {
		this.dfOrderId = dfOrderId;
	}

	public Long getDfOrderId() {
		return this.dfOrderId;
	}

	public void setDfTradeId(Long dfTradeId) {
		this.dfTradeId = dfTradeId;
	}

	public Long getDfTradeId() {
		return this.dfTradeId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getSellerId() {
		return this.sellerId;
	}

	public void setStartInTime(Date startInTime) {
		this.startInTime = startInTime;
	}

	public Date getStartInTime() {
		return this.startInTime;
	}

	public void setStockRemark(String stockRemark) {
		this.stockRemark = stockRemark;
	}

	public String getStockRemark() {
		return this.stockRemark;
	}

}