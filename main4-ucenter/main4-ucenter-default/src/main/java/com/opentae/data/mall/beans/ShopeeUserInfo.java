package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShopeeUserInfo implements Serializable {
    /**
     * 虾皮店铺id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long shopId;

    /**
     * 店铺名
     */
	private String shopName;

    /**
     * 国家、地区编码
     */
	private String country;

    /**
     * 店铺描述
     */
	private String shopDescription;

    /**
     * 店铺商品数量限制
     */
	private Long itemLimit;

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void setShopDescription(String shopDescription) {
		this.shopDescription = shopDescription;
	}

	public String getShopDescription() {
		return this.shopDescription;
	}

	public void setItemLimit(Long itemLimit) {
		this.itemLimit = itemLimit;
	}

	public Long getItemLimit() {
		return this.itemLimit;
	}

}