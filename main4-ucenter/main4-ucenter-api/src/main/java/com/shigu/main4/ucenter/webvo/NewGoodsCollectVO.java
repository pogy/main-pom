package com.shigu.main4.ucenter.webvo;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 类名：NewGoodsCollectVO
 * 类路径：com.shigu.main4.ucenter.webvo.NewGoodsCollectVO
 * 创建者：王浩翔
 * 创建时间：2017-10-13 14:08
 * 项目：main-pom
 * 描述：新商品收藏
 */
public class NewGoodsCollectVO implements Serializable{
    //商品id
    private Long goodsId;
    //收藏id
    private Long collId;
    //档口是否在售
    private Boolean onSaleIs;
    //市场名
    private String marketName;
    //档口号
    private String shopNum;
    //旺旺
    private String imWw;
    //QQ
    private String imQq;
    //商品图片
    private String imgSrc;
    //商品标题
    private String title;
    //批发价
    private String piprice;
    //商品货号
    private String goodsNo;
    //档口id
    private Long shopId;


    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Boolean getOnSaleIs() {
        return onSaleIs;
    }

    public void setOnSaleIs(Boolean onSaleIs) {
        this.onSaleIs = onSaleIs;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
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

    public Long getCollId() {
        return collId;
    }

    public void setCollId(Long collId) {
        this.collId = collId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}