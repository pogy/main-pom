package com.shigu.seller.vo;

/**
 * 查询商品网盘
 * Created by zhaohongbo on 17/7/27.
 */
public class GoodsFileSearchVO {

    private Long goodsId;

    private String imgSrc;

    private String title;

    private String goodsNo;

    private String price;

    private boolean hasLinkGoods;

    private String linkFileId;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isHasLinkGoods() {
        return hasLinkGoods;
    }

    public void setHasLinkGoods(boolean hasLinkGoods) {
        this.hasLinkGoods = hasLinkGoods;
    }

    public String getLinkFileId() {
        return linkFileId;
    }

    public void setLinkFileId(String linkFileId) {
        this.linkFileId = linkFileId;
    }
}
