package com.opentae.data.mall.beans;

import com.opentae.common.beans.MoreSiteBean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * 市场
 *
 */
public class ShiguMarket {

    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long marketId;
    private String marketName;
    private Long parentMarketId;
    private String parentMarketName;
    private Long isParent;
    private Long buycityId;
    private Long provinceId;
    private String provinceName;
    private Long cityId;
    private String cityName;
    private String marketAddr;
    private Long sortOrder;
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
    private String remark11;
    private String remark12;
    private String remark13;
    private String remark14;
    private String remark15;
    private String remark16;
    private String remark17;
    private String remark18;
    private String remark19;
    private String remark20;
    private Long areaId;
    private String areaName;
    private String marketFullName;
    private String nature;
    private String floors;
    private Integer storeInTotal;
    private String marketPingyin;
    private Integer canRegist;
    private String webSite;

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Long getParentMarketId() {
        return parentMarketId;
    }

    public void setParentMarketId(Long parentMarketId) {
        this.parentMarketId = parentMarketId;
    }

    public String getParentMarketName() {
        return parentMarketName;
    }

    public void setParentMarketName(String parentMarketName) {
        this.parentMarketName = parentMarketName;
    }

    public Long getIsParent() {
        return isParent;
    }

    public void setIsParent(Long isParent) {
        this.isParent = isParent;
    }

    public Long getBuycityId() {
        return buycityId;
    }

    public void setBuycityId(Long buycityId) {
        this.buycityId = buycityId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMarketAddr() {
        return marketAddr;
    }

    public void setMarketAddr(String marketAddr) {
        this.marketAddr = marketAddr;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
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

    public String getRemark11() {
        return remark11;
    }

    public void setRemark11(String remark11) {
        this.remark11 = remark11;
    }

    public String getRemark12() {
        return remark12;
    }

    public void setRemark12(String remark12) {
        this.remark12 = remark12;
    }

    public String getRemark13() {
        return remark13;
    }

    public void setRemark13(String remark13) {
        this.remark13 = remark13;
    }

    public String getRemark14() {
        return remark14;
    }

    public void setRemark14(String remark14) {
        this.remark14 = remark14;
    }

    public String getRemark15() {
        return remark15;
    }

    public void setRemark15(String remark15) {
        this.remark15 = remark15;
    }

    public String getRemark16() {
        return remark16;
    }

    public void setRemark16(String remark16) {
        this.remark16 = remark16;
    }

    public String getRemark17() {
        return remark17;
    }

    public void setRemark17(String remark17) {
        this.remark17 = remark17;
    }

    public String getRemark18() {
        return remark18;
    }

    public void setRemark18(String remark18) {
        this.remark18 = remark18;
    }

    public String getRemark19() {
        return remark19;
    }

    public void setRemark19(String remark19) {
        this.remark19 = remark19;
    }

    public String getRemark20() {
        return remark20;
    }

    public void setRemark20(String remark20) {
        this.remark20 = remark20;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getMarketFullName() {
        return marketFullName;
    }

    public void setMarketFullName(String marketFullName) {
        this.marketFullName = marketFullName;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public Integer getStoreInTotal() {
        return storeInTotal;
    }

    public void setStoreInTotal(Integer storeInTotal) {
        this.storeInTotal = storeInTotal;
    }

    public String getMarketPingyin() {
        return marketPingyin;
    }

    public void setMarketPingyin(String marketPingyin) {
        this.marketPingyin = marketPingyin;
    }

    public Integer getCanRegist() {
        return canRegist;
    }

    public void setCanRegist(Integer canRegist) {
        this.canRegist = canRegist;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
