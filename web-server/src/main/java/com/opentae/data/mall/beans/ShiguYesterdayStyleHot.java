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
     * 
     */
	private Long parentStyleId;

    /**
     * 
     */
	private String showDay;

    /**
     * 
     */
	private Long goodsId;

    /**
     * 
     */
	private String piPrice;

    /**
     * 
     */
	private String picPath;

    /**
     * 
     */
	private String marketName;

    /**
     * 
     */
	private String shopNum;

    /**
     * 
     */
	private Long shopId;

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

}