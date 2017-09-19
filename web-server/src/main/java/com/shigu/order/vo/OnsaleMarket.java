package com.shigu.order.vo;

import com.opentae.core.mybatis.config.Column;

public class OnsaleMarket {

    @Column("shigu_market.market_id")
    private Long marketId;

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
}
