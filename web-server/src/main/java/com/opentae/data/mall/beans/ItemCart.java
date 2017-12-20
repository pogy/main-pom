package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ItemCart implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long cartId;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 产品ID
     */
	private Long pid;

    /**
     * 
     */
	private String webSite;

    /**
     * 产品skuID
     */
	private Long skuId;

    /**
     * 店铺ID
     */
	private Long shopId;

    /**
     * 数量
     */
	private Integer num;

    /**
     * 进货车最后修改
     */
	private Date lastModify;

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getCartId() {
		return this.cartId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getSkuId() {
		return this.skuId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}

	public Date getLastModify() {
		return this.lastModify;
	}

}