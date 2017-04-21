package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 市场页显示的数据
 * Created by zhaohongbo on 17/2/27.
 */
public class MarketShow implements Serializable{
    private String webSite;
    private String pingying;
    private Long marketId;
    private Long marketOuterId;
    private List<FloorShow> floors;
    /**
     * 市场名
     */
    private String marketName;

    /**
     * 这个站点的其它市场,里面不需要floors\otherMarkets
     */
    private List<MarketShow> otherMarkets;


    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Long getMarketOuterId() {
        return marketOuterId;
    }

    public void setMarketOuterId(Long marketOuterId) {
        this.marketOuterId = marketOuterId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getPingying() {
        return pingying;
    }

    public void setPingying(String pingying) {
        this.pingying = pingying;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public List<FloorShow> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorShow> floors) {
        this.floors = floors;
    }

    public List<MarketShow> getOtherMarkets() {
        return otherMarkets;
    }

    public void setOtherMarkets(List<MarketShow> otherMarkets) {
        this.otherMarkets = otherMarkets;
    }
}
