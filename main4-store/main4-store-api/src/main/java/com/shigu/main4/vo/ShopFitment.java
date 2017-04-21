package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺装修
 * Created by zhaohongbo on 17/2/22.
 */
public class ShopFitment implements Serializable{
    /**
     * 店铺logo
     */
    private String shopLogo;
    /**
     * 店内轮播图
     */
    private List<String> banners;
    /**
     * 店内自定义详情
     */
    private String description;

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public List<String> getBanners() {
        return banners;
    }

    public void setBanners(List<String> banners) {
        this.banners = banners;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description!=null){
            description=description.replace("网商园","").replace("wsy.com","");
        }
        this.description = description;
    }
}
