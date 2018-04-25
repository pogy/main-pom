package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaStockRecord implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long stockRecordId;

    /**
     * 
     */
	private Long stockId;

    /**
     * 
     */
	private Integer inOutType;

    /**
     * 入库时间
     */
	private Date inTime;

    /**
     * 出库时间
     */
	private Date outTime;

    /**
     * 退货成功时间
     */
	private Date returnTime;

    /**
     * 
     */
	private Long daifaWorkerId;

    /**
     * 操作人员
     */
	private String daifaWorker;

    /**
     * 出库批次
     */
	private String piCode;

	public void setStockRecordId(Long stockRecordId) {
		this.stockRecordId = stockRecordId;
	}

	public Long getStockRecordId() {
		return this.stockRecordId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getStockId() {
		return this.stockId;
	}

	public void setInOutType(Integer inOutType) {
		this.inOutType = inOutType;
	}

	public Integer getInOutType() {
		return this.inOutType;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getInTime() {
		return this.inTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public Date getOutTime() {
		return this.outTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public Date getReturnTime() {
		return this.returnTime;
	}

	public void setDaifaWorkerId(Long daifaWorkerId) {
		this.daifaWorkerId = daifaWorkerId;
	}

	public Long getDaifaWorkerId() {
		return this.daifaWorkerId;
	}

	public void setDaifaWorker(String daifaWorker) {
		this.daifaWorker = daifaWorker;
	}

	public String getDaifaWorker() {
		return this.daifaWorker;
	}

	public void setPiCode(String piCode) {
		this.piCode = piCode;
	}

	public String getPiCode() {
		return this.piCode;
	}

}