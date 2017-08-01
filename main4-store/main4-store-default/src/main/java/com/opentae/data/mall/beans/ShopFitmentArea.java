package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShopFitmentArea implements Serializable {
    /**
     * 区域ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long areaId;

    /**
     * 店铺ID
     */
	private Long shopId;

    /**
     * 页面ID
     */
	private Long pageId;

    /**
     * 在哪个区域后
     */
	private Long afterAreaId;

    /**
     * 2、顶部页头，这种区域不需要page_id，3、左右区域 1、通栏区域
     */
	private Integer areaType;

    /**
     * true是可以，false是不可以
     */
	private Boolean canDel;

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getAreaId() {
		return this.areaId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	public Long getPageId() {
		return this.pageId;
	}

	public void setAfterAreaId(Long afterAreaId) {
		this.afterAreaId = afterAreaId;
	}

	public Long getAfterAreaId() {
		return this.afterAreaId;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}

	public Integer getAreaType() {
		return this.areaType;
	}

	public void setCanDel(Boolean canDel) {
		this.canDel = canDel;
	}

	public Boolean getCanDel() {
		return this.canDel;
	}

}