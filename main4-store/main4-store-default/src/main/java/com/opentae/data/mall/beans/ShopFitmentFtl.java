package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShopFitmentFtl implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long ftlId;

    /**
     * 页面ID
     */
	private Long pageId;

    /**
     * 模板原文
     */
	private String context;

    /**
     * 店铺ID
     */
	private Long shopId;

    /**
     * 
     */
	private Integer type;

	public void setFtlId(Long ftlId) {
		this.ftlId = ftlId;
	}

	public Long getFtlId() {
		return this.ftlId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	public Long getPageId() {
		return this.pageId;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return this.context;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

}