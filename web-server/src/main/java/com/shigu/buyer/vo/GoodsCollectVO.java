package com.shigu.buyer.vo;

/**
 * 显示收藏的宝贝
 * Created by zhaohongbo on 17/3/13.
 */
public class GoodsCollectVO {

    /** 商品ID */
    private Long id;

    /** 站点 */
    private String website;

    /** 图片地址 */
    private String imgsrc;

    /** 批发价格 */
    private String piprice;

    /** 标题 */
    private String title;

    /** 市场归属 */
    private String marketname;

    /** 数据包ID */
    private Long goodsCollectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarketname() {
        return marketname;
    }

    public void setMarketname(String marketname) {
        this.marketname = marketname;
    }

    public Long getGoodsCollectId() {
        return goodsCollectId;
    }

    public void setGoodsCollectId(Long goodsCollectId) {
        this.goodsCollectId = goodsCollectId;
    }
}
