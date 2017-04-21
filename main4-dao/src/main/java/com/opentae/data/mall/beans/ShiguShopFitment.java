package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 店铺装修
 * Created by zhaohongbo on 17/2/17.
 */
@Deprecated
public class ShiguShopFitment implements Serializable{
    @Transient
    private static final long serialVersionUID = 9095871009869958330L;
    /**
     * 装修ID
     */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long fitmentId;
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 店名
     */
    private String shopName;
    /**
     * 装修时间
     */
    private Date fitmentDate;
    /**
     * 主题
     */
    private String theme;
    /**
     * 店招
     */
    private String shopBanner;
    /**
     * 店招2
     */
    private String shopBanner2;
    /**
     * 店招3
     */
    private String shopBanner3;
    /**
     * 店招4
     */
    private String shopBanner4;
    /**
     * 店招5
     */
    private String shopBanner5;
    /**
     * 店logo
     */
    private String shopLogo;
    /**
     * 店铺描述
     */
    private String description;
    /**
     * 是否显示，1显示，0不显示,默认1
     */
    private Integer showLogo;
    /**
     * 是否显示幻灯片，1显示，0不显示,默认1
     */
    private Integer showSlide;
    /**
     * 是否显示描述,1显示,0不显示,默认1
     */
    private Integer showDescription;

    public Long getFitmentId() {
        return fitmentId;
    }

    public void setFitmentId(Long fitmentId) {
        this.fitmentId = fitmentId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getFitmentDate() {
        return fitmentDate;
    }

    public void setFitmentDate(Date fitmentDate) {
        this.fitmentDate = fitmentDate;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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
