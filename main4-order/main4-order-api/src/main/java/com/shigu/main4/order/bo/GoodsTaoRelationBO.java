package com.shigu.main4.order.bo;

import java.io.Serializable;

/**
 * 淘宝商品关联
 */
public class GoodsTaoRelationBO implements Serializable{

    private Long userId;//用户ID
    private Long numIid;//淘宝numIid
    private Long goodsId;//商品ID
    private String webSite;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
