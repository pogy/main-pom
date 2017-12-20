package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 活动抽奖店铺数据
 *
 * @author shigu_zjb
 * @date 2017/05/12 18:27
 *
 */
public class ActiveDrawShop {

	/** 主键ID */
	@Id
	@GeneratedValue(
			generator = "JDBC"
	)
	private Long id;

	/** 期次ID */
	private Long pemId;

	/** 店铺ID */
	private Long shopId;

	private Long pitId;

	private String uText;

	private String dText;

	/** 图片 */
	private String picUrl;

	/** 排序 */
	private Integer sort;

	/** 创建时间 */
	private Date createTime;

	/** 更新时间 */
	private Date modifyTime;

	/** 数据有效性 */
	private Boolean enabled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPemId() {
		return pemId;
	}

	public void setPemId(Long pemId) {
		this.pemId = pemId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getuText() {
		return uText;
	}

	public void setuText(String uText) {
		this.uText = uText;
	}

	public String getdText() {
		return dText;
	}

	public void setdText(String dText) {
		this.dText = dText;
	}

	public Long getPitId() {
		return pitId;
	}

	public void setPitId(Long pitId) {
		this.pitId = pitId;
	}
}

