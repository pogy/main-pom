package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 档口展现表
 */
@Deprecated
public class ShiguStoreNumShow {

    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long storeNumId;
    private Long parentMarketId;
    private String parentMarket;
    private Long marketId;
    private String market;
    private Long buycityId;
    private String webSite;
    private String storeNum;
    private Double sortOrder;
    private Integer useStatus;
    private Integer displayMarket;
    private Long storeId;
    private String mainType;
    private String storeNumDesc;
    private String services;
    private Integer recommendIs;
    private Long recommendSort;
    private String visitUrl;
    private Date dealDate;
    private String remark1;
    private String remark2;
    private String remark3;
    private String remark4;
    private String remark5;
    private String remark6;
    private String remark7;
    private String remark8;
    private String remark9;
    private String remark10;
    private Date lastModifyTime;

    public Long getStoreNumId() {
        return storeNumId;
    }

    public void setStoreNumId(Long storeNumId) {
        this.storeNumId = storeNumId;
    }

    public Long getParentMarketId() {
        return parentMarketId;
    }

    public void setParentMarketId(Long parentMarketId) {
        this.parentMarketId = parentMarketId;
    }

    public String getParentMarket() {
        return parentMarket;
    }

    public void setParentMarket(String parentMarket) {
        this.parentMarket = parentMarket;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Long getBuycityId() {
        return buycityId;
    }

    public void setBuycityId(Long buycityId) {
        this.buycityId = buycityId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public Double getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Double sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Integer getDisplayMarket() {
        return displayMarket;
    }

    public void setDisplayMarket(Integer displayMarket) {
        this.displayMarket = displayMarket;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public String getStoreNumDesc() {
        return storeNumDesc;
    }

    public void setStoreNumDesc(String storeNumDesc) {
        this.storeNumDesc = storeNumDesc;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public Integer getRecommendIs() {
        return recommendIs;
    }

    public void setRecommendIs(Integer recommendIs) {
        this.recommendIs = recommendIs;
    }

    public Long getRecommendSort() {
        return recommendSort;
    }

    public void setRecommendSort(Long recommendSort) {
        this.recommendSort = recommendSort;
    }

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark7() {
        return remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark8() {
        return remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark9() {
        return remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark10() {
        return remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
