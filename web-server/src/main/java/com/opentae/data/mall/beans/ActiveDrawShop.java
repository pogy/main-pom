package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ActiveDrawShop implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 期次ID
     */
	private Long pemId;

    /**
     * 店铺ID
     */
	private Long shopId;

    /**
     * 店铺图片
     */
	private String picUrl;

    /**
     * 排序
     */
	private Integer sort;

    /**
     * 
     */
	private Long pitId;

    /**
     * 上一段文字
     */
	private String uText;

    /**
     * 下一段文字
     */
	private String dText;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 更新时间
     */
	private Date modifyTime;

    /**
     * 数据有效性
     */
	private Boolean enabled;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setPemId(Long pemId) {
		this.pemId = pemId;
	}

	public Long getPemId() {
		return this.pemId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setPitId(Long pitId) {
		this.pitId = pitId;
	}

	public Long getPitId() {
		return this.pitId;
	}

	public void setUText(String uText) {
		this.uText = uText;
	}

	public String getUText() {
		return this.uText;
	}

	public void setDText(String dText) {
		this.dText = dText;
	}

	public String getDText() {
		return this.dText;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

}