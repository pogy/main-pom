package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：SubOrderExpressBO
 * @文件路径：com.shigu.main4.daifa.bo.SubOrderExpressBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/10 15:05
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class SubOrderExpressBO implements Serializable {

    private Long orderId;//子订单ID
    private String storeGoodsCode;//商家编码
    private String propStr;//颜色尺码
    private Integer goodsNum;//商品数量

    public Long getOrderId () {
        return orderId;
    }

    public void setOrderId (Long orderId) {
        this.orderId = orderId;
    }

    public String getStoreGoodsCode () {
        return storeGoodsCode;
    }

    public void setStoreGoodsCode (String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public String getPropStr () {
        return propStr;
    }

    public void setPropStr (String propStr) {
        this.propStr = propStr;
    }

    public Integer getGoodsNum () {
        return goodsNum;
    }

    public void setGoodsNum (Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}
