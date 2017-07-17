package com.shigu.spread.vo;

/**
 * 商品简单信息
 * Created by zhaohongbo on 17/4/10.
 */
public class ItemSimpleInfo {
    private Long goodsId;

    private String style;

    private String element;

    private String shopTitle;

    public ItemSimpleInfo() {
    }

    public ItemSimpleInfo(Long goodsId, String style, String element, String shopTitle) {
        this.goodsId = goodsId;
        this.style = style;
        this.element = element;
        this.shopTitle = shopTitle;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
