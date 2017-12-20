package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class GoatOneItem implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long goatId;

    /**
     * 广告位置ID
     */
	private Long localId;

    /**
     * 是否禁用 true 禁用 false启用
     */
	private Boolean disEnabled;

    /**
     * 位置，小的在前
     */
	private Integer sort;

    /**
     * 备注
     */
	private String recommon;

	public void setGoatId(Long goatId) {
		this.goatId = goatId;
	}

	public Long getGoatId() {
		return this.goatId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	public Long getLocalId() {
		return this.localId;
	}

	public void setDisEnabled(Boolean disEnabled) {
		this.disEnabled = disEnabled;
	}

	public Boolean getDisEnabled() {
		return this.disEnabled;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setRecommon(String recommon) {
		this.recommon = recommon;
	}

	public String getRecommon() {
		return this.recommon;
	}

}