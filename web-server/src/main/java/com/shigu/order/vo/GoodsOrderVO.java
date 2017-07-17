package com.shigu.order.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class GoodsOrderVO {
    private Long shopId;
    private String marketName;
    private String storeNum;
    private String imWw;
    private String imQq;
    private List<ChildGoodsOrder> childOrders = new ArrayList();

    public Long getShopId() {
        return shopId;
    }

    public void setShopId( Long shopId ) {
        this.shopId = shopId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName( String marketName ) {
        this.marketName = marketName;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum( String storeNum ) {
        this.storeNum = storeNum;
    }

    public String getImWw() {
        return imWw;
    }

    public void setImWw( String imWw ) {
        this.imWw = imWw;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq( String imQq ) {
        this.imQq = imQq;
    }

    public List<ChildGoodsOrder> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders( List<ChildGoodsOrder> childOrders ) {
        this.childOrders = childOrders;
    }
}
