package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 市场页展示规则
 *
 * @author shigu_zjb
 * @date 2017/02/27 18:42
 *
 */
public class ShiguOuterMarket implements Serializable{

    /** 主键 */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long ruleId;

    /** 分站标识 */
    private String webSite;

    /** 市场ID */
    private Long marketId;

    /** 排序号，越小排越前 */
    private Integer sortOrder;

    /** 显示市场名 */
    private String marketName;

    /** 外部楼层ID串，中间用,分开 */
    private String outerFloorIds;

    /** 是否显示市场 */
    private Integer markerShow;

    /** 指向市场名称 */
    @Transient
    private String pointMarketName;

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getOuterFloorIds() {
        return outerFloorIds;
    }

    public void setOuterFloorIds(String outerFloorIds) {
        this.outerFloorIds = outerFloorIds;
    }

    public String getPointMarketName() {
        return pointMarketName;
    }

    public void setPointMarketName(String pointMarketName) {
        this.pointMarketName = pointMarketName;
    }

    public Integer getMarkerShow() {
        return markerShow;
    }

    public void setMarkerShow(Integer markerShow) {
        this.markerShow = markerShow;
    }
}
