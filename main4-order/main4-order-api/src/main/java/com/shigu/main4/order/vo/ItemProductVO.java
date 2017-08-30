package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 商品产品式数据
 * Created by zhaohongbo on 17/6/1.
 */
public class ItemProductVO extends ProductVO implements Serializable{
    /**
     * 主键
     */
    private Long pid;

    /**
     * 星座商品ID
     */
    private Long goodsId;

    /**
     * 分站标识
     */
    private String webSite;

    /**
     * 首图
     */
    private String picUrl;

    /**
     * 标题
     */
    private String title;

    /**
     * 所以市场名
     */
    private String marketName;

    /**
     * 楼层
     */
    private String floor;

    /**
     * 档口号
     */
    private String shopNum;

    /**
     * 市场ID
     */
    private Long marketId;

    /**
     * 楼层ID
     */
    private Long floorId;

    /**
     * 档口ID
     */
    private Long shopId;

    /**
     * 单位：克
     */
    private Long weight;

    /**
     * 当前被选sku
     */
    private ItemSkuVO selectiveSku;

    /**
     * 货号
     */
    private String goodsNo;

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public ItemSkuVO getSelectiveSku() {
        return selectiveSku;
    }

    public void setSelectiveSku(ItemSkuVO selectiveSku) {
        this.selectiveSku = selectiveSku;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }
}
