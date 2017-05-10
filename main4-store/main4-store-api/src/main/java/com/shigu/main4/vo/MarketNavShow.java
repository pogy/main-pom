package com.shigu.main4.vo;

import java.io.Serializable;


/**
 * 市场数据
 *
 * 为网站导航展现市场数据
 *
 */
public class MarketNavShow implements Serializable {

    private Long mid;

    private String marketName;

    private String webSite;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}

