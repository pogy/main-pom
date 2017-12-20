package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShopFitmentPage implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long pageId;

    /**
     * 页面名称
     */
	private String name;

    /**
     * 店铺ID
     */
	private Long shopId;

    /**
     * 1、首页，2搜索页，3、用户自定义
     */
	private Integer type;

    /**
     * 背景图
     */
	private String backgroundPic;

    /**
     * 1、平铺，2、纵向平铺，3、横向平铺，4、不平铺
     */
	private Integer backgroundType;

    /**
     * 查询Code
     */
	private Long code;

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	public Long getPageId() {
		return this.pageId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
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

	public void setBackgroundPic(String backgroundPic) {
		this.backgroundPic = backgroundPic;
	}

	public String getBackgroundPic() {
		return this.backgroundPic;
	}

	public void setBackgroundType(Integer backgroundType) {
		this.backgroundType = backgroundType;
	}

	public Integer getBackgroundType() {
		return this.backgroundType;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getCode() {
		return this.code;
	}

}