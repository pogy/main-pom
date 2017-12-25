package com.opentae.data.jd.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class JdShopInfo implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 对应用户的京东uid
     */
	private Long jdUid;

    /**
     * 	商家编号 
     */
	private Long venderId;

    /**
     * 京东店铺编号
     */
	private Long jdShopId;

    /**
     * 京东店铺名称
     */
	private String jdShopName;

    /**
     * 京东店铺LOGO地址
     */
	private String jdShopLogoUrl;

    /**
     * 开店时间
     */
	private Date openTime;

    /**
     * 主营类目编号 
     */
	private Long categoryMain;

    /**
     * 
     */
	private String categoryMainName;

    /**
     * 
     */
	private String brief;

    /**
     * 创建时间
     */
	private Date gmtCreate;

    /**
     * 修改时间
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setJdUid(Long jdUid) {
		this.jdUid = jdUid;
	}

	public Long getJdUid() {
		return this.jdUid;
	}

	public void setVenderId(Long venderId) {
		this.venderId = venderId;
	}

	public Long getVenderId() {
		return this.venderId;
	}

	public void setJdShopId(Long jdShopId) {
		this.jdShopId = jdShopId;
	}

	public Long getJdShopId() {
		return this.jdShopId;
	}

	public void setJdShopName(String jdShopName) {
		this.jdShopName = jdShopName;
	}

	public String getJdShopName() {
		return this.jdShopName;
	}

	public void setJdShopLogoUrl(String jdShopLogoUrl) {
		this.jdShopLogoUrl = jdShopLogoUrl;
	}

	public String getJdShopLogoUrl() {
		return this.jdShopLogoUrl;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getOpenTime() {
		return this.openTime;
	}

	public void setCategoryMain(Long categoryMain) {
		this.categoryMain = categoryMain;
	}

	public Long getCategoryMain() {
		return this.categoryMain;
	}

	public void setCategoryMainName(String categoryMainName) {
		this.categoryMainName = categoryMainName;
	}

	public String getCategoryMainName() {
		return this.categoryMainName;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getBrief() {
		return this.brief;
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