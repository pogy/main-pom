package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class DaifaGgoodsReturnFee implements Serializable {
    /**
     * 今日退回的拿货费用
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long returnId;

    /**
     * 今日代发机构ID
     */
	private Long daifaSellerId;

    /**
     * 代发用户ID
     */
	private Long daifaWorkerId;

    /**
     * 代发拿货退回费用的创建时间
     */
	private Date createTime;

    /**
     * 创建日期
     */
	private String createDate;

    /**
     * 商品拿货退回的费用
     */
	private String returnFee;

    /**
     * 拿货人员手机号
     */
	private String phone;

	public void setReturnId(Long returnId) {
		this.returnId = returnId;
	}

	public Long getReturnId() {
		return this.returnId;
	}

	public void setDaifaSellerId(Long daifaSellerId) {
		this.daifaSellerId = daifaSellerId;
	}

	public Long getDaifaSellerId() {
		return this.daifaSellerId;
	}

	public void setDaifaWorkerId(Long daifaWorkerId) {
		this.daifaWorkerId = daifaWorkerId;
	}

	public Long getDaifaWorkerId() {
		return this.daifaWorkerId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setReturnFee(String returnFee) {
		this.returnFee = returnFee;
	}

	public String getReturnFee() {
		return this.returnFee;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

}