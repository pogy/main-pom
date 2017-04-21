package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 提供入驻的市场
 * Created by zhaohongbo on 17/2/23.
 */
public class MarketForRegist implements Serializable{
    /**
     * 市场ID
     */
    private Long marketId;
    /**
     * 市场名
     */
    private String marketName;

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
}
