package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class GoodsCountForsearch implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long searchId;

    /**
     * 0
     */
	private Long goodsId;

    /**
     * 0
     */
	private Long click;

    /**
     * ip
     */
	private Long clickIp;

    /**
     * 交易量
     */
	private Long trade;

    /**
     * 上款次数
     */
	private Long up;

    /**
     * 上款人数
     */
	private Long upMan;

    /**
     * 0没做过广告，1做过广告
     */
	private Integer hadGoat;

    /**
     * 
     */
	private String webSite;

    /**
     * 
     */
	private Date flowFixedTime;

	public void setSearchId(Long searchId) {
		this.searchId = searchId;
	}

	public Long getSearchId() {
		return this.searchId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setClick(Long click) {
		this.click = click;
	}

	public Long getClick() {
		return this.click;
	}

	public void setClickIp(Long clickIp) {
		this.clickIp = clickIp;
	}

	public Long getClickIp() {
		return this.clickIp;
	}

	public void setTrade(Long trade) {
		this.trade = trade;
	}

	public Long getTrade() {
		return this.trade;
	}

	public void setUp(Long up) {
		this.up = up;
	}

	public Long getUp() {
		return this.up;
	}

	public void setUpMan(Long upMan) {
		this.upMan = upMan;
	}

	public Long getUpMan() {
		return this.upMan;
	}

	public void setHadGoat(Integer hadGoat) {
		this.hadGoat = hadGoat;
	}

	public Integer getHadGoat() {
		return this.hadGoat;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setFlowFixedTime(Date flowFixedTime) {
		this.flowFixedTime = flowFixedTime;
	}

	public Date getFlowFixedTime() {
		return this.flowFixedTime;
	}

}