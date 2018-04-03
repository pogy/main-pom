package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguShopStyleRelation implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 店铺id
     */
	private Long shopId;

    /**
     * 
     */
	private String shopParentStyleIds;

    /**
     * 分站
     */
	private String webSite;

    /**
     * 创建时间
     */
	private Date gmtCreate;

    /**
     * >最后修改时间
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setShopParentStyleIds(String shopParentStyleIds) {
		this.shopParentStyleIds = shopParentStyleIds;
	}

	public String getShopParentStyleIds() {
		return this.shopParentStyleIds;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public Date getGmtModify() {
		return this.gmtModify;
	}

}