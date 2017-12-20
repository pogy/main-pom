package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShopFitmentModule implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long moduleId;

    /**
     * 1、宝贝推荐，2、宝贝搜索，3、自定义，4、宝贝分类，5、宽屏图片，6、图片轮播，7、全屏轮播\n
     */
	private Integer type;

    /**
     * 位置类型，1左侧，2右侧，3全屏
     */
	private Integer sideType;

    /**
     * 在哪个模块后
     */
	private Long afterModuleId;

    /**
     * 模块ID
     */
	private Long areaId;

    /**
     * 模块特殊信息
     */
	private String moduleData;

    /**
     * 模块中的值
     */
	private String moduleValue;

    /**
     * 1（true）能，0（false）不能
     */
	private Boolean canDel;

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public Long getModuleId() {
		return this.moduleId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setSideType(Integer sideType) {
		this.sideType = sideType;
	}

	public Integer getSideType() {
		return this.sideType;
	}

	public void setAfterModuleId(Long afterModuleId) {
		this.afterModuleId = afterModuleId;
	}

	public Long getAfterModuleId() {
		return this.afterModuleId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getAreaId() {
		return this.areaId;
	}

	public void setModuleData(String moduleData) {
		this.moduleData = moduleData;
	}

	public String getModuleData() {
		return this.moduleData;
	}

	public void setModuleValue(String moduleValue) {
		this.moduleValue = moduleValue;
	}

	public String getModuleValue() {
		return this.moduleValue;
	}

	public void setCanDel(Boolean canDel) {
		this.canDel = canDel;
	}

	public Boolean getCanDel() {
		return this.canDel;
	}

}