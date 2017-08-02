package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguActivityApply implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long applyId;

    /**
     * 活动id
     */
	private Long activityId;

    /**
     * 审核通过
     */
	private Integer choose;

    /**
     * 店铺ID
     */
	private Long shopId;

    /**
     * 商品链接 ;
     */
	private String items;

    /**
     * 用户
     */
	private Long userId;

    /**
     * 电话
     */
	private String phone;

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Long getApplyId() {
		return this.applyId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getActivityId() {
		return this.activityId;
	}

	public void setChoose(Integer choose) {
		this.choose = choose;
	}

	public Integer getChoose() {
		return this.choose;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getItems() {
		return this.items;
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

}