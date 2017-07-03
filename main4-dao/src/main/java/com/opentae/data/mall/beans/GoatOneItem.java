package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

    /**
 * 一个广告
 * Created by zhaohongbo on 17/5/5.
     */
public class GoatOneItem {

    @Id
    @GeneratedValue(generator = "JDBC")
	private Long goatId;

    /**
     * 广告位置ID
     */
	private Long localId;

    /**
     * 是否禁用,true为禁用
     */
	private Boolean disEnabled;

    /**
     * 排序,升序
     */
	private Integer sort;

	private String recommon;

    public String getRecommon() {
        return recommon;
    }

    public void setRecommon(String recommon) {
        this.recommon = recommon;
    }

    public Long getGoatId() {
        return goatId;
    }

	public void setGoatId(Long goatId) {
		this.goatId = goatId;
	}

    public Long getLocalId() {
        return localId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

    public Boolean getDisEnabled() {
        return disEnabled;
	}

	public void setDisEnabled(Boolean disEnabled) {
		this.disEnabled = disEnabled;
	}

    public Integer getSort() {
        return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	}
