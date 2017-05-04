package com.shigu.main4.goat.vo;

/**
 * 商品广告
 *
 * -Long itemId
 -String title
 -String picUrl
 * Created by zhaohongbo on 17/5/4.
 */
public class ItemGoatVO extends GoatVO{
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
}
