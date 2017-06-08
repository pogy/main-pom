package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemCart implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String cartId;

    /**
     * 用户ID
     */
	private String userId;

    /**
     * 产品ID
     */
	private String pid;

    /**
     * 
     */
	private String webSite;

    /**
     * 产品skuID
     */
	private String skuId;

    /**
     * 店铺ID
     */
	private String shopId;

    /**
     * 数量
     */
	private String num;

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getCartId() {
		return this.cartId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPid() {
		return this.pid;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getSkuId() {
		return this.skuId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopId() {
		return this.shopId;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNum() {
		return this.num;
	}

}