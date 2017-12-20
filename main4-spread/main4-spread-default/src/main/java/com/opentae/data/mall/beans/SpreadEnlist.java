package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class SpreadEnlist implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long enlistId;

    /**
     * 姓名
     */
	private String name;

    /**
     * 手机号
     */
	private String telephone;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 店铺ID
     */
	private Long shopId;

    /**
     * 1中奖，0不中
     */
	private Integer draw;

    /**
     * 活动ID
     */
	private Long activityId;

    /**
     * 
     */
	private Date createTime;

	public void setEnlistId(Long enlistId) {
		this.enlistId = enlistId;
	}

	public Long getEnlistId() {
		return this.enlistId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getDraw() {
		return this.draw;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getActivityId() {
		return this.activityId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

}