package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

public class ShiguOuterFloor implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long outerFloorId;

    /**
     * 对应的内部楼层ID，如果没有，果断填-1
     */
	private String floorIds;

    /**
     * 对外显示楼层号
     */
	private String showName;

    /**
     * 楼层额外加的档口
     */
	private String addedShop;

    /**
     * 排序，越小排越前
     */
	private Integer sortOrder;

    /**
     * 
     */
	private String parentStyleIds;

	@Transient
	private String floorNames;

	public void setOuterFloorId(Long outerFloorId) {
		this.outerFloorId = outerFloorId;
	}

	public Long getOuterFloorId() {
		return this.outerFloorId;
	}

	public void setFloorIds(String floorIds) {
		this.floorIds = floorIds;
	}

	public String getFloorIds() {
		return this.floorIds;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowName() {
		return this.showName;
	}

	public void setAddedShop(String addedShop) {
		this.addedShop = addedShop;
	}

	public String getAddedShop() {
		return this.addedShop;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setParentStyleIds(String parentStyleIds) {
		this.parentStyleIds = parentStyleIds;
	}

	public String getParentStyleIds() {
		return this.parentStyleIds;
	}

	public String getFloorNames() {
		return floorNames;
	}

	public void setFloorNames(String floorNames) {
		this.floorNames = floorNames;
	}
}