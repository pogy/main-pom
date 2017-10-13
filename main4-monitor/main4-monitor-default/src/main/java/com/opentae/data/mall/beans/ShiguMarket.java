package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguMarket implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long marketId;

    /**
     * 市场名
     */
	private String marketName;

    /**
     * 上级市场ID
     */
	private Long parentMarketId;

    /**
     * 上级市场
     */
	private String parentMarketName;

    /**
     * 是否是顶级市场@0不是1是
     */
	private Integer isParent;

    /**
     * 站点id
     */
	private Long buycityId;

    /**
     * 省份ID
     */
	private Integer provinceId;

    /**
     * 省份
     */
	private String provinceName;

    /**
     * 城市ID
     */
	private Integer cityId;

    /**
     * 城市
     */
	private String cityName;

    /**
     * 市场地址
     */
	private String marketAddr;

    /**
     * 排序
     */
	private Integer sortOrder;

    /**
     * 介绍
     */
	private String remark1;

    /**
     * 招商电话
     */
	private String remark2;

    /**
     * 备用3
     */
	private String remark3;

    /**
     * 备用4
     */
	private String remark4;

    /**
     * 市场简称
     */
	private String remark5;

    /**
     * 市场排序
     */
	private String remark6;

    /**
     * 备用7
     */
	private String remark7;

    /**
     * 备用8
     */
	private String remark8;

    /**
     * 备用9
     */
	private String remark9;

    /**
     * 备用10
     */
	private String remark10;

    /**
     * 备用11
     */
	private String remark11;

    /**
     * 备用12
     */
	private String remark12;

    /**
     * 备用13
     */
	private String remark13;

    /**
     * 备用14
     */
	private String remark14;

    /**
     * 存放市场楼层顺序
     */
	private String remark15;

    /**
     * 备用16
     */
	private String remark16;

    /**
     * 备用17
     */
	private String remark17;

    /**
     * 备用18
     */
	private String remark18;

    /**
     * 备用19
     */
	private String remark19;

    /**
     * 备用20
     */
	private String remark20;

    /**
     * 区域ID
     */
	private Integer areaId;

    /**
     * 区域
     */
	private String areaName;

    /**
     * 市场全称
     */
	private String marketFullName;

    /**
     * 性质
     */
	private String nature;

    /**
     * 楼层
     */
	private String floors;

    /**
     * 已入住商家
     */
	private Integer storeInTotal;

    /**
     * 市场名拼音
     */
	private String marketPingyin;

    /**
     * 是否允许注册，1为允许，0为不允许
     */
	private Integer canRegist;

    /**
     * 分站标识
     */
	private String webSite;

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getMarketId() {
		return this.marketId;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketName() {
		return this.marketName;
	}

	public void setParentMarketId(Long parentMarketId) {
		this.parentMarketId = parentMarketId;
	}

	public Long getParentMarketId() {
		return this.parentMarketId;
	}

	public void setParentMarketName(String parentMarketName) {
		this.parentMarketName = parentMarketName;
	}

	public String getParentMarketName() {
		return this.parentMarketName;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public Integer getIsParent() {
		return this.isParent;
	}

	public void setBuycityId(Long buycityId) {
		this.buycityId = buycityId;
	}

	public Long getBuycityId() {
		return this.buycityId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setMarketAddr(String marketAddr) {
		this.marketAddr = marketAddr;
	}

	public String getMarketAddr() {
		return this.marketAddr;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark5() {
		return this.remark5;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public String getRemark6() {
		return this.remark6;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}

	public String getRemark7() {
		return this.remark7;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}

	public String getRemark8() {
		return this.remark8;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}

	public String getRemark9() {
		return this.remark9;
	}

	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	public String getRemark10() {
		return this.remark10;
	}

	public void setRemark11(String remark11) {
		this.remark11 = remark11;
	}

	public String getRemark11() {
		return this.remark11;
	}

	public void setRemark12(String remark12) {
		this.remark12 = remark12;
	}

	public String getRemark12() {
		return this.remark12;
	}

	public void setRemark13(String remark13) {
		this.remark13 = remark13;
	}

	public String getRemark13() {
		return this.remark13;
	}

	public void setRemark14(String remark14) {
		this.remark14 = remark14;
	}

	public String getRemark14() {
		return this.remark14;
	}

	public void setRemark15(String remark15) {
		this.remark15 = remark15;
	}

	public String getRemark15() {
		return this.remark15;
	}

	public void setRemark16(String remark16) {
		this.remark16 = remark16;
	}

	public String getRemark16() {
		return this.remark16;
	}

	public void setRemark17(String remark17) {
		this.remark17 = remark17;
	}

	public String getRemark17() {
		return this.remark17;
	}

	public void setRemark18(String remark18) {
		this.remark18 = remark18;
	}

	public String getRemark18() {
		return this.remark18;
	}

	public void setRemark19(String remark19) {
		this.remark19 = remark19;
	}

	public String getRemark19() {
		return this.remark19;
	}

	public void setRemark20(String remark20) {
		this.remark20 = remark20;
	}

	public String getRemark20() {
		return this.remark20;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setMarketFullName(String marketFullName) {
		this.marketFullName = marketFullName;
	}

	public String getMarketFullName() {
		return this.marketFullName;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getNature() {
		return this.nature;
	}

	public void setFloors(String floors) {
		this.floors = floors;
	}

	public String getFloors() {
		return this.floors;
	}

	public void setStoreInTotal(Integer storeInTotal) {
		this.storeInTotal = storeInTotal;
	}

	public Integer getStoreInTotal() {
		return this.storeInTotal;
	}

	public void setMarketPingyin(String marketPingyin) {
		this.marketPingyin = marketPingyin;
	}

	public String getMarketPingyin() {
		return this.marketPingyin;
	}

	public void setCanRegist(Integer canRegist) {
		this.canRegist = canRegist;
	}

	public Integer getCanRegist() {
		return this.canRegist;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

}