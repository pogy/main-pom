package com.shigu.seller.vo;

/**
 * 报名商品信息
 * Created by bugzy on 2017/7/2 0002.
 */
public class ApplyItemVO {

    private Long itemId;

    private String href;

    private String imgUrl;
    private String title;
    private String price;
    private String marketName;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getHref() {
        return href = "http://www.571xz.com/item.htm?id=" + itemId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
