package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 类名：GoodsAggsVO
 * 类路径：com.shigu.main4.item.vo.GoodsAggsVO
 * 创建者：王浩翔
 * 创建时间：2017-10-24 17:34
 * 项目：main-pom
 * 描述：
 */
public class GoodsAggsVO implements Serializable {
    //商品上传量
    private Integer goodsUpNum = 0;
    //销售量
    private Integer saleCount = 0;
    //面料
    private String fabric;
    //里料
    private String inFabric;
    //是否设置过最低零售价
    private Integer hasRetailPriceSet;
    //商品主图视频
    private String videoUrl;
    //风格id
    private Long styleId;
    //风格id
    // TODO: 18-1-22 暂时留下,兼容线上版本
    @Deprecated
    private Integer goodsStyleId;
    //风格名
    private String goodsStyleName;

    /**
     * 增加上传量
     * @param upNum
     */
    public void addGoodsupNum(int upNum){
        this.goodsUpNum += upNum;
    }

    /**
     * 增加销售量
     * @param saleCount
     */
    public void addSaleCount(int saleCount){
        this.saleCount += saleCount;
    }

    public Integer getGoodsUpNum() {
        return goodsUpNum;
    }

    public void setGoodsUpNum(Integer goodsUpNum) {
        this.goodsUpNum = goodsUpNum;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getInFabric() {
        return inFabric;
    }

    public void setInFabric(String inFabric) {
        this.inFabric = inFabric;
    }

    public Integer getHasRetailPriceSet() {
        return hasRetailPriceSet;
    }

    public void setHasRetailPriceSet(Integer hasRetailPriceSet) {
        this.hasRetailPriceSet = hasRetailPriceSet;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Long getStyleId() {
        return styleId;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }

    public Integer getGoodsStyleId() {
        return goodsStyleId;
    }

    public void setGoodsStyleId(Integer goodsStyleId) {
        this.goodsStyleId = goodsStyleId;
    }

    public String getGoodsStyleName() {
        return this.goodsStyleName;
    }

    public void setGoodsStyleName(String goodsStyleName) {
        this.goodsStyleName = goodsStyleName;
    }
}
