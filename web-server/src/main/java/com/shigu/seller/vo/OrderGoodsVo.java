package com.shigu.seller.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: OrderGoodsVo
 * @Author: sy
 * @CreateDate: 2018/5/4 0004 16:27
 */
public class OrderGoodsVo implements Serializable{

    private String tradePay;
    private String imgsrc;
    private Long goodsId;
    private String title;
    private String goodsNo;
    private String price;
    private String xzPrice;
    private Integer totalCount;
    private List<SkusGoodsVo> skus;


    public String getTradePay() {
        return tradePay;
    }

    public void setTradePay(String tradePay) {
        this.tradePay = tradePay;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getXzPrice() {
        return xzPrice;
    }

    public void setXzPrice(String xzPrice) {
        this.xzPrice = xzPrice;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<SkusGoodsVo> getSkus() {
        return skus;
    }

    public void setSkus(List<SkusGoodsVo> skus) {
        this.skus = skus;
    }
}
