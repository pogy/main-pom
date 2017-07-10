package com.shigu.main4.active.vo;

import com.shigu.main4.active.enums.ActivityStatus;
import com.shigu.main4.active.enums.ApplyStatus;

import java.io.Serializable;
import java.util.Date;

/**
 *  活动信息
 */
public class ShiguActivityVO implements Serializable {
	private Long activityId;

    /**
     * 活动标题
     */
	private String title;

	/**
	 * 活动图
	 */
	private String image;

	/**
	 * 活动准入数量
	 */
	private String nums;

    /**
     * 开始申请时间
     */
	private Date startApply;

    /**
     * 申请截止时间
     */
	private Date endApply;

    /**
     * 活动开始时间
     */
	private Date startTime;

    /**
     * 活动结束时间
     */
	private Date endTime;

    /**
     * 广告位置ID
     */
	private Long locationId;

    /**
     * 活动费用描述
     */
	private String costDesc;

    /**
     * 规则描述
     */
	private String ruleInfo;

    /**
     * 活动详情
     */
	private String descInfo;

	private String webSite;

	/**
	 * 活动状态
	 */
	private ActivityStatus status;

	/**
	 * 申请状态
	 */
	private ApplyStatus applyStatus;

	/**
	 * 活动转入服务
	 */
	private String services;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getActivityId() {
		return this.activityId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setStartApply(Date startApply) {
		this.startApply = startApply;
	}

	public Date getStartApply() {
		return this.startApply;
	}

	public void setEndApply(Date endApply) {
		this.endApply = endApply;
	}

	public Date getEndApply() {
		return this.endApply;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getLocationId() {
		return this.locationId;
	}

	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}

	public String getCostDesc() {
		return this.costDesc;
	}

	public void setRuleInfo(String ruleInfo) {
		this.ruleInfo = ruleInfo;
	}

	public String getRuleInfo() {
		return this.ruleInfo;
	}

	public void setDescInfo(String descInfo) {
		this.descInfo = descInfo;
	}

	public String getDescInfo() {
		return this.descInfo;
	}

	public ActivityStatus getStatus() {
		return status = ActivityStatus.check(this);
	}

	public ApplyStatus getApplyStatus() {
		return applyStatus = ApplyStatus.check(this);
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
}