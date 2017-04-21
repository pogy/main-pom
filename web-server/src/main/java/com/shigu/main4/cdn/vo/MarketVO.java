package com.shigu.main4.cdn.vo;

import java.util.List;

/**
 * 市场列表页中的全部值
 * Created by Licca on 17/3/25.
 */
public class MarketVO {
    /**
     * 主营
     */
    private List<CateVO> cates;
    /**
     * 市场
     */
    private List<MarketTagVO> marketTags;
    /**
     * 楼层
     */
    private List<FloorVO> floorVOs;

    /**
     * 当前市场名称
     */
    private String marketName;
    /**
     * 分站
     */
    private String webSite;

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public List<CateVO> getCates() {
        return cates;
    }

    public void setCates(List<CateVO> cates) {
        this.cates = cates;
    }

    public List<FloorVO> getFloorVOs() {
        return floorVOs;
    }

    public void setFloorVOs(List<FloorVO> floorVOs) {
        this.floorVOs = floorVOs;
    }

    public List<MarketTagVO> getMarketTags() {
        return marketTags;
    }

    public void setMarketTags(List<MarketTagVO> marketTags) {
        this.marketTags = marketTags;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
