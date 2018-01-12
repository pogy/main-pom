package com.shigu.main4.vo;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * 商品展示块
 * Created by zhaohongbo on 17/2/16.
 */
public class ItemShowBlock implements Serializable{

    private static final long serialVersionUID = -2072870176373443783L;
    /**
     * 展示图
     */
    private String imgUrl;
    /**
     * 标题
     */
    private String title;
    /**
     * 宝贝Id
     */
    private Long itemId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 宝贝价格
     */
    private String price;
    /**
     * 分站
     */
    private String webSite;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 下架时间,yyyy-MM-dd
     */
    private String soldOutTime;

    public String getSoldOutTime() {
        return soldOutTime;
    }

    public void setSoldOutTime(String soldOutTime) {
        this.soldOutTime = soldOutTime;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getPrice() {
        return price;
    }

    public String parsePrice(Long priceLong){
        if(priceLong==null){
            return "--";
        }
        Double priceValue = priceLong.doubleValue()/100;
        DecimalFormat df=new DecimalFormat("0.00");
        return df.format(priceValue);
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public ItemShowBlock getThis() {
        return this;
    }
}
