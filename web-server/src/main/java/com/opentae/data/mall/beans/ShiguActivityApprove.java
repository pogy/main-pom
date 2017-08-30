package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguActivityApprove implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long approveId;

    /**
     * 
     */
	private Long activityId;

    /**
     * 
     */
	private Long shopId;

    /**
     * 
     */
	private String item;

    /**
     * 
     */
	private Long userId;

    /**
     * 
     */
	private String phone;

    /**
     * 
     */
	private Long cateId;

	public void setApproveId(Long approveId) {
		this.approveId = approveId;
	}

	public Long getApproveId() {
		return this.approveId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getActivityId() {
		return this.activityId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public Long getCateId() {
		return this.cateId;
	}

}