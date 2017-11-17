package com.shigu.session.main4;

import java.io.Serializable;

/**
 * 店铺的session,main4里面用
 * Created by Licca on 17/2/21.
 */
public class ShopSession implements Serializable{
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 档口号
     */
    private String shopNum;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 市场
     */
    private String market;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 市场ID
     */
    private Long marketId;
    /**
     * 楼层ID
     */
    private Long floorId;
    /**
     * 分站
     */
    private String webSite;
    /**
     * 淘宝昵称
     */
    private String tbNick;

    /**
     * 1淘宝店铺，2普通店铺
     */
    private Integer type;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
