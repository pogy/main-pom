package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 供修改的店铺装修
 * Created by zhaohongbo on 17/2/25.
 */
public class ShopFitmentForUpadte implements Serializable{
    /**
     * 主键
     */
    private Long fitmentId;
    /**
     * 店铺名
     */
    private String shopName;
    /**
     * 轮播1
     */
    private String shopBanner;
    /**
     * 轮播2
     */
    private String shopBanner2;
    /**
     * 轮播3
     */
    private String shopBanner3;
    /**
     * 轮播4
     */
    private String shopBanner4;
    /**
     * 轮播5
     */
    private String shopBanner5;
    /**
     * 店铺logo
     */
    private String shopLogo;
    /**
     * 店铺装修
     */
    private String description;
    /**
     * 1显示0不显示
     */
    private Integer showLogo;
    /**
     * 是否显示幻灯片，1显示，0不显示
     */
    private Integer showSlide;
    /**
     * 是否显示装修，1显示，0不显示
     */
    private Integer showDescription;

    public Long getFitmentId() {
        return fitmentId;
    }

    public void setFitmentId(Long fitmentId) {
        this.fitmentId = fitmentId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopBanner() {
        return shopBanner;
    }

    public void setShopBanner(String shopBanner) {
        this.shopBanner = shopBanner;
    }

    public String getShopBanner2() {
        return shopBanner2;
    }

    public void setShopBanner2(String shopBanner2) {
        this.shopBanner2 = shopBanner2;
    }

    public String getShopBanner3() {
        return shopBanner3;
    }

    public void setShopBanner3(String shopBanner3) {
        this.shopBanner3 = shopBanner3;
    }

    public String getShopBanner4() {
        return shopBanner4;
    }

    public void setShopBanner4(String shopBanner4) {
        this.shopBanner4 = shopBanner4;
    }

    public String getShopBanner5() {
        return shopBanner5;
    }

    public void setShopBanner5(String shopBanner5) {
        this.shopBanner5 = shopBanner5;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getShowLogo() {
        return showLogo;
    }

    public void setShowLogo(Integer showLogo) {
        this.showLogo = showLogo;
    }

    public Integer getShowSlide() {
        return showSlide;
    }

    public void setShowSlide(Integer showSlide) {
        this.showSlide = showSlide;
    }

    public Integer getShowDescription() {
        return showDescription;
    }

    public void setShowDescription(Integer showDescription) {
        this.showDescription = showDescription;
    }
}
