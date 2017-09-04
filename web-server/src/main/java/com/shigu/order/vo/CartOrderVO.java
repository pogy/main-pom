package com.shigu.order.vo;

import java.util.Date;
import java.util.List;

/**
 * 购物车订单页面对象
 * Created by bugzy on 2017/6/20 0020.
 */
public class CartOrderVO implements Comparable<CartOrderVO> {

    private Long orderId;

    private Long shopId;

    private String marketName;

    private String storeNum;

    private String imWw;

    private String imQq;

    private String webSite;

    private Date lastModify;

    private List<CartChildOrderVO> childOrders;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getImWw() {
        return imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public List<CartChildOrderVO> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<CartChildOrderVO> childOrders) {
        this.childOrders = childOrders;
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

    @Override
    public int compareTo(CartOrderVO o) {
        if(lastModify == null){
            return -1;
        }
        return o == null||o.getLastModify() == null ? 1 : lastModify.compareTo(o.getLastModify());
    }
}
