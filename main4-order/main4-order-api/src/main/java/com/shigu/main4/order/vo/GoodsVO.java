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
    /**
     * 商品ID
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 主图
     */
    private String imgSrc;
    /**
     * 价格
     */
    private String price;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 市场名
     */
    private String marketName;
    /**
     * 档口号
     */
    private String storeNum;

    /**
     * 获取 商品ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置 商品ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 主图
     */
    public String getImgSrc() {
        return this.imgSrc;
    }

    /**
     * 设置 主图
     */
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    /**
     * 获取 价格
     */
    public String getPrice() {
        return this.price;
    }

    /**
     * 设置 价格
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取 货号
     */
    public String getGoodsNo() {
        return this.goodsNo;
    }

    /**
     * 设置 货号
     */
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    /**
     * 获取 市场名
     */
    public String getMarketName() {
        return this.marketName;
    }

    /**
     * 设置 市场名
     */
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    /**
     * 获取 档口号
     */
    public String getStoreNum() {
        return this.storeNum;
    }

    /**
     * 设置 档口号
     */
    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }
}
