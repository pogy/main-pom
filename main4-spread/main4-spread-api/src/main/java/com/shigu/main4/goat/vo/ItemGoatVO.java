package com.shigu.main4.goat.vo;

import java.io.Serializable;

/**
 * 商品广告
 *
 * -Long itemId
 -String title
 -String picUrl
 * Created by zhaohongbo on 17/5/4.
 */
public class ItemGoatVO extends GoatVO implements Serializable{
    /**
     * 商品ID
     */
    private Long itemId;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片链接
      */
    private String picUrl;
    /**
     * 风格
     */
    private String style;
    /**
     * 元素
     */
    private String element;
    /**
     * 店铺标题
     */
    private String shopTitle;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }
}
