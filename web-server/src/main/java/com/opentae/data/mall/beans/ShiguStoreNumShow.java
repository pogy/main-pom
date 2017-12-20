package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguStoreNumShow implements Serializable {
    /**
     * 档口ID 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long storeNumId;

    /**
     * 市场ID
     */
	private Long parentMarketId;

    /**
     * 市场
     */
	private String parentMarket;

    /**
     * 楼层ID
     */
	private Long marketId;

    /**
     * 楼层
     */
	private String market;

    /**
     * 站点id
     */
	private Long buycityId;

    /**
     * 站点
     */
	private String webSite;

    /**
     * 档口号
     */
	private String storeNum;

    /**
     * 排序
     */
	private String sortOrder;

    /**
     * 状态@0没有店铺入住1有店铺入住
     */
	private Integer useStatus;

    /**
     * 是否在市场显示@0不显示1显示
     */
	private Integer displayMarket;

    /**
     * 店铺ID
     */
	private Long storeId;

    /**
     * 
     */
	private String mainType;

    /**
     * 说明
     */
	private String storeNumDesc;

    /**
     * 服务:Red红色退换商品 Blue蓝色换款商品 Green绿色换问题品  Black黑色不退不换
     */
	private String services;

    /**
     * 是否推荐@0否1是
     */
	private Integer recommendIs;

    /**
     * 推荐排序
     */
	private Integer recommendSort;

    /**
     * 访问地址
     */
	private String visitUrl;

    /**
     * 入驻时间
     */
	private Date dealDate;

    /**
     * 备用1
     */
	private String remark1;

    /**
     * 备用2
     */
	private String remark2;

    /**
     * 备用3
     */
	private String remark3;

    /**
     * 默认快递公司
     */
	private String remark4;

    /**
     * 风格
     */
	private String remark5;

    /**
     * 备用6
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
     * 最后刷新时间
     */
	private Date lastModifyTime;

	public void setStoreNumId(Long storeNumId) {
		this.storeNumId = storeNumId;
	}

	public Long getStoreNumId() {
		return this.storeNumId;
	}

	public void setParentMarketId(Long parentMarketId) {
		this.parentMarketId = parentMarketId;
	}

	public Long getParentMarketId() {
		return this.parentMarketId;
	}

	public void setParentMarket(String parentMarket) {
		this.parentMarket = parentMarket;
	}

	public String getParentMarket() {
		return this.parentMarket;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getMarketId() {
		return this.marketId;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getMarket() {
		return this.market;
	}

	public void setBuycityId(Long buycityId) {
		this.buycityId = buycityId;
	}

	public Long getBuycityId() {
		return this.buycityId;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getStoreNum() {
		return this.storeNum;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSortOrder() {
		return this.sortOrder;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public Integer getUseStatus() {
		return this.useStatus;
	}

	public void setDisplayMarket(Integer displayMarket) {
		this.displayMarket = displayMarket;
	}

	public Integer getDisplayMarket() {
		return this.displayMarket;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setMainType(String mainType) {
		this.mainType = mainType;
	}

	public String getMainType() {
		return this.mainType;
	}

	public void setStoreNumDesc(String storeNumDesc) {
		this.storeNumDesc = storeNumDesc;
	}

	public String getStoreNumDesc() {
		return this.storeNumDesc;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getServices() {
		return this.services;
	}

	public void setRecommendIs(Integer recommendIs) {
		this.recommendIs = recommendIs;
	}

	public Integer getRecommendIs() {
		return this.recommendIs;
	}

	public void setRecommendSort(Integer recommendSort) {
		this.recommendSort = recommendSort;
	}

	public Integer getRecommendSort() {
		return this.recommendSort;
	}

	public void setVisitUrl(String visitUrl) {
		this.visitUrl = visitUrl;
	}

	public String getVisitUrl() {
		return this.visitUrl;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public Date getDealDate() {
		return this.dealDate;
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

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Date getLastModifyTime() {
		return this.lastModifyTime;
	}

}