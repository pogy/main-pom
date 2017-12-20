package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class GoatOneLocation implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long localId;

    /**
     * 编号
     */
	private String localCode;

    /**
     * 描述
     */
	private String description;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * true禁用，false启用
     */
	private Boolean disEnabled;

    /**
     * 分站
     */
	private String webSite;

    /**
     * 广告类型，0图片广告，1商品广告，2文字广告
     */
	private Integer goatType;

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	public Long getLocalId() {
		return this.localId;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public String getLocalCode() {
		return this.localCode;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setDisEnabled(Boolean disEnabled) {
		this.disEnabled = disEnabled;
	}

	public Boolean getDisEnabled() {
		return this.disEnabled;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setGoatType(Integer goatType) {
		this.goatType = goatType;
	}

	public Integer getGoatType() {
		return this.goatType;
	}

}