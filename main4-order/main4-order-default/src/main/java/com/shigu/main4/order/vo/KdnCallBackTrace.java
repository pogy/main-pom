package com.shigu.main4.order.vo;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 物流轨迹
 * @author qianyi
 *
 */
public class KdnCallBackTrace {

	/**
	 * acceptStation	String	描述	R
	 */
	@JSONField(name = "AcceptStation")
	private String acceptStation;
	/**
	 * acceptTime	String	时间	R
	 */
	@JSONField(name = "AcceptTime",format = "yyyy-MM-dd HH:mm:ss")
	private Date acceptTime;

	/**
     *remark	String	备注	O
	 */
	@JSONField(name = "Remark")
	private String remark;

	public String getAcceptStation() {
		return acceptStation;
	}

	public void setAcceptStation(String acceptStation) {
		this.acceptStation = acceptStation;
	}

	public Date getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
