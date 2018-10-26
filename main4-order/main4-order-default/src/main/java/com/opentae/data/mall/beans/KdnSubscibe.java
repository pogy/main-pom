package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class KdnSubscibe implements Serializable {
	/**
	 *
	 */
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;

	/**
	 * 星座网主订单id
	 */
	private Long oid;

	/**
	 * 快递单号
	 */
	private String logisticCode;

	/**
	 *
	 */
	private Integer logisticState;

	/**
	 * 自定义回调信息
	 */
	private String callBack;

	/**
	 *
	 */
	private Date gmtCreate;

	/**
	 *
	 */
	private Date gmtUpdate;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}

	public String getLogisticCode() {
		return this.logisticCode;
	}

	public void setLogisticState(Integer logisticState) {
		this.logisticState = logisticState;
	}

	public Integer getLogisticState() {
		return this.logisticState;
	}

	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}

	public String getCallBack() {
		return this.callBack;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtUpdate(Date gmtUpdate) {
		this.gmtUpdate = gmtUpdate;
	}

	public Date getGmtUpdate() {
		return this.gmtUpdate;
	}

}