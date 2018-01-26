package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguNewActivity implements Serializable {
    /**
     * 送现金活动ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 活动名称
     */
	private String title;

    /**
     * 活动总金额
     */
	private String amount;

    /**
     * 首页banner图片地址
     */
	private String bannerImgUrl;

    /**
     * 奖品图片链接地址
     */
	private String goodsImgUrl;

    /**
     * 活动开始时间
     */
	private Date startTime;

    /**
     * 活动结束时间
     */
	private Date endTime;

    /**
     * 最多中奖人数
     */
	private Integer winnersNum;

    /**
     * 活动规则
     */
	private String activeRules;

    /**
     * 记录创建时间
     */
	private Date gmtCreate;

    /**
     * 记录最近更新时间
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setBannerImgUrl(String bannerImgUrl) {
		this.bannerImgUrl = bannerImgUrl;
	}

	public String getBannerImgUrl() {
		return this.bannerImgUrl;
	}

	public void setGoodsImgUrl(String goodsImgUrl) {
		this.goodsImgUrl = goodsImgUrl;
	}

	public String getGoodsImgUrl() {
		return this.goodsImgUrl;
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

	public void setWinnersNum(Integer winnersNum) {
		this.winnersNum = winnersNum;
	}

	public Integer getWinnersNum() {
		return this.winnersNum;
	}

	public void setActiveRules(String activeRules) {
		this.activeRules = activeRules;
	}

	public String getActiveRules() {
		return this.activeRules;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public Date getGmtModify() {
		return this.gmtModify;
	}

}