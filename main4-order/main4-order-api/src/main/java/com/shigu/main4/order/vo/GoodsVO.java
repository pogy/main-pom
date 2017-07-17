package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：GoodsVO
 * @文件路径：com.shigu.main4.order.vo.GoodsVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/14 15:58
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class GoodsVO implements Serializable{
    //至少要有以下字段
    //商品ID
    private Long goodsId;
    private Long numIid;
    private String title;
    private String imgUrl;
    private String price;
    private String marketName;
    private String shopNum;
    public Long getGoodsId() {
        return this.goodsId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getNumIid() {
        return this.numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMarketName() {
        return this.marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopNum() {
        return this.shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }
}
