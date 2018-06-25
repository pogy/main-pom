package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class ShiguActivity implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long activityId;

    /**
     * 活动图片
     */
	private String image;

    /**
     * background-color
     */
	private String bkcolor;

    /**
     * banner
     */
	private String banner;

    /**
     * 活动准入数量
     */
	private String nums;

    /**
     * 活动标题
     */
	private String title;

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

    /**
     * 
     */
	private String services;

    /**
     * 分站
     */
	private String webSite;

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getActivityId() {
		return this.activityId;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return this.image;
	}

	public void setBkcolor(String bkcolor) {
		this.bkcolor = bkcolor;
	}

	public String getBkcolor() {
		return this.bkcolor;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getBanner() {
		return this.banner;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public String getNums() {
		return this.nums;
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

	public void setServices(String services) {
		this.services = services;
	}

	public String getServices() {
		return this.services;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

}