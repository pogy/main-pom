package com.shigu.main4.monitor.bo;

import java.io.Serializable;

/**
 * 页面信息
 * Created by zhaohongbo on 17/3/8.
 */
public class PageInfoBO implements Serializable{
    /**
     * 原始链接
     */
    private String url;
    /**
     * 页面来源
     */
    private String referer;
    /**
     * 分站
     */
    private String webSite;
    /**
     * 暂时用于广告key
     */
    private String connectKey;
    /**
     * 如果商品的话,这里放商品ID
     */
    private Long itemId;
    /**
     * 如果店铺,这里放店铺ID
     */
    private Long shopId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getConnectKey() {
        return connectKey;
    }

    public void setConnectKey(String connectKey) {
        this.connectKey = connectKey;
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
}
