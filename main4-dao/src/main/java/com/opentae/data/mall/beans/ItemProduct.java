package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemProduct implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long pid;

    /**
     * 星座商品ID
     */
	private Long goodsId;

    /**
     * 分站标识
     */
	private String webSite;

    /**
     * 首图
     */
	private String picUrl;

    /**
     * 标题
     */
	private String title;

    /**
     * 单价
     */
	private Long price;

    /**
     * 所以市场名
     */
	private String marketName;

    /**
     * 楼层
     */
	private String floor;

    /**
     * 档口号
     */
	private String shopNum;

    /**
     * 市场ID
     */
	private Long marketId;

    /**
     * 楼层ID
     */
	private Long floorId;

    /**
     * 档口ID
     */
	private Long shopId;

    /**
     * 单位：克
     */
	private Long weight;

    /**
     * 货号
     */
	private String goodsNo;

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketName() {
		return this.marketName;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getFloor() {
		return this.floor;
	}

	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}

	public String getShopNum() {
		return this.shopNum;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getMarketId() {
		return this.marketId;
	}

	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}

	public Long getFloorId() {
		return this.floorId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public Long getWeight() {
		return this.weight;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getGoodsNo() {
		return this.goodsNo;
	}

}