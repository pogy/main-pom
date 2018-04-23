package com.shigu.main4.daifa.bo;

import java.io.Serializable;

public class MoveShopDataBO implements Serializable {

    private Long shopId;
    private Long marketId;
    private Long floorId;
    private String shopNum;
    private String marketName;
    private String floorName;

    public Long getMarketId() {
        return this.marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getFloorId() {
        return this.floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getShopNum() {
        return this.shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getMarketName() {
        return this.marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getFloorName() {
        return this.floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Long getShopId() {
        return this.shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
