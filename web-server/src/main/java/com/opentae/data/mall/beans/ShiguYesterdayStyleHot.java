package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguYesterdayStyleHot implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 顶级风格id
     */
	private Long parentStyleId;

    /**
     * 
     */
	private String showDay;

    /**
     * 商品
     */
	private Long goodsId;

    /**
     * 批价
     */
	private String piPrice;

    /**
     * 主图
     */
	private String picPath;

    /**
     * 市场
     */
	private String marketName;

    /**
     * 档口
     */
	private String shopNum;

    /**
     * 档口id
     */
	private Long shopId;

    /**
     * hz
     */
	private String webSite;

    /**
     * 
     */
	private Integer sex;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setParentStyleId(Long parentStyleId) {
		this.parentStyleId = parentStyleId;
	}

	public Long getParentStyleId() {
		return this.parentStyleId;
	}

	public void setShowDay(String showDay) {
		this.showDay = showDay;
	}

	public String getShowDay() {
		return this.showDay;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setPiPrice(String piPrice) {
		this.piPrice = piPrice;
	}

	public String getPiPrice() {
		return this.piPrice;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPicPath() {
		return this.picPath;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketName() {
		return this.marketName;
	}

	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}

	public String getShopNum() {
		return this.shopNum;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return this.sex;
	}

}