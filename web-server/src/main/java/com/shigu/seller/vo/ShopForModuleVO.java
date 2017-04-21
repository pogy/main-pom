package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * 给模块用的店铺信息
 * Created by zhaohongbo on 17/4/19.
 */
public class ShopForModuleVO implements Serializable{

    private Long shopId;

    private String webSite;

    private String domain;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
