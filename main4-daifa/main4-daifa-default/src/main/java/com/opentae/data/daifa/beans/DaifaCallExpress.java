package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaCallExpress implements Serializable {
    /**
     * 代发订单ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long dfTradeId;

    /**
     * 代发机构ID
     */
	private Long sellerId;

    /**
     * 快递ID
     */
	private Long expressId;

    /**
     * 快递单号
     */
	private String expressCode;

    /**
     * 三段码
     */
	private String markDestination;

    /**
     * 集包地
     */
	private String packageName;

    /**
     * 
     */
	private String packageCode;

    /**
     * 调用快递鸟回来的所有数据的json格式
     */
	private String jsonData;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 
     */
	private String sortingCode;

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

	public void setExpressId(Long expressId) {
		this.expressId = expressId;
	}

	public Long getExpressId() {
		return this.expressId;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getExpressCode() {
		return this.expressCode;
	}

	public void setMarkDestination(String markDestination) {
		this.markDestination = markDestination;
	}

	public String getMarkDestination() {
		return this.markDestination;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public String getPackageCode() {
		return this.packageCode;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public String getJsonData() {
		return this.jsonData;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setSortingCode(String sortingCode) {
		this.sortingCode = sortingCode;
	}

	public String getSortingCode() {
		return this.sortingCode;
	}

}