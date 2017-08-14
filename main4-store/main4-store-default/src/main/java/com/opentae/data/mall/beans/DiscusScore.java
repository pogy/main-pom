package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DiscusScore implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long dsId;

    /**
     * 店铺ID
     */
	private Long storeId;

    /**
     * 分站
     */
	private String webSite;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 星星数量
     */
	private Integer scoreNum;

    /**
     * 创建时间
     */
	private Date createdTime;

	public void setDsId(Long dsId) {
		this.dsId = dsId;
	}

	public Long getDsId() {
		return this.dsId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setScoreNum(Integer scoreNum) {
		this.scoreNum = scoreNum;
	}

	public Integer getScoreNum() {
		return this.scoreNum;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

}