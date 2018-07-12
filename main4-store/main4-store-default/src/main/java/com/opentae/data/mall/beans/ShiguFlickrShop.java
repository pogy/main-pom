package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguFlickrShop implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long flickrStoreId;

    /**
     * 相册档口号
     */
	private String flickrStroeName;

    /**
     * 类目id
     */
	private Long cId;

    /**
     * 手机号码
     */
	private String phone;

    /**
     * 市场id
     */
	private Long marketId;

    /**
     * 楼层id
     */
	private Long marketFloorId;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 创建人
     */
	private Long creator;

    /**
     * 关联店铺id
     */
	private Long relevancyShopId;

    /**
     * 站点
     */
	private String webSite;

    /**
     * 虚拟档口状态1：正常，-1：删除
     */
	private Integer sfsStatus;

	public void setFlickrStoreId(Long flickrStoreId) {
		this.flickrStoreId = flickrStoreId;
	}

	public Long getFlickrStoreId() {
		return this.flickrStoreId;
	}

	public void setFlickrStroeName(String flickrStroeName) {
		this.flickrStroeName = flickrStroeName;
	}

	public String getFlickrStroeName() {
		return this.flickrStroeName;
	}

	public void setCId(Long cId) {
		this.cId = cId;
	}

	public Long getCId() {
		return this.cId;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getMarketId() {
		return this.marketId;
	}

	public void setMarketFloorId(Long marketFloorId) {
		this.marketFloorId = marketFloorId;
	}

	public Long getMarketFloorId() {
		return this.marketFloorId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Long getCreator() {
		return this.creator;
	}

	public void setRelevancyShopId(Long relevancyShopId) {
		this.relevancyShopId = relevancyShopId;
	}

	public Long getRelevancyShopId() {
		return this.relevancyShopId;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setSfsStatus(Integer sfsStatus) {
		this.sfsStatus = sfsStatus;
	}

	public Integer getSfsStatus() {
		return this.sfsStatus;
	}

}