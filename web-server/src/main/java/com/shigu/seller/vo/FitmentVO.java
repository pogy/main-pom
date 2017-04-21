package com.shigu.seller.vo;

import com.shigu.main4.vo.ShopFitmentForUpadte;

import java.io.Serializable;
import java.util.Date;

/**
 * 装修显示对象
 * Created by zhaohongbo on 17/3/13.
 */
public class FitmentVO implements Serializable{

    private String description;
    private Date fitmentDate;
    private Long fitmentId;
    private String image1;
    private String image2;
    private String image3;
    private Date lastModifyTime;

    private Integer status;
    private String storeBanner;
    private String storeBanner2;
    private String storeBanner3;
    private String storeBanner4;
    private String storeBanner5;

    private Long storeId;
    private String storeLogo;
    private String storeName;

    private String remark4;
    private String remark5;
    private String remark6;

    public FitmentVO(ShopFitmentForUpadte fitment) {
        setDescription(fitment.getDescription());
//        setFitmentDate(fitment.get);
        setFitmentId(fitment.getFitmentId());
//        setImage1();
//        setImage2();
//        setImage3();
        setStoreBanner(fitment.getShopBanner());
        setStoreBanner2(fitment.getShopBanner2());
        setStoreBanner3(fitment.getShopBanner3());
        setStoreBanner4(fitment.getShopBanner4());
        setStoreBanner5(fitment.getShopBanner5());
//        setStoreId(fitment.get);
        setStoreLogo(fitment.getShopLogo());
        setStoreName(fitment.getShopName());
        setRemark4(fitment.getShowLogo()==null?"0":fitment.getShowLogo().toString());
        setRemark5(fitment.getShowSlide()==null?"0":fitment.getShowSlide().toString());
        setRemark6(fitment.getShowDescription()==null?"0":fitment.getShowDescription().toString());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFitmentDate() {
        return fitmentDate;
    }

    public void setFitmentDate(Date fitmentDate) {
        this.fitmentDate = fitmentDate;
    }

    public Long getFitmentId() {
        return fitmentId;
    }

    public void setFitmentId(Long fitmentId) {
        this.fitmentId = fitmentId;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStoreBanner() {
        return storeBanner;
    }

    public void setStoreBanner(String storeBanner) {
        this.storeBanner = storeBanner;
    }

    public String getStoreBanner2() {
        return storeBanner2;
    }

    public void setStoreBanner2(String storeBanner2) {
        this.storeBanner2 = storeBanner2;
    }

    public String getStoreBanner3() {
        return storeBanner3;
    }

    public void setStoreBanner3(String storeBanner3) {
        this.storeBanner3 = storeBanner3;
    }

    public String getStoreBanner4() {
        return storeBanner4;
    }

    public void setStoreBanner4(String storeBanner4) {
        this.storeBanner4 = storeBanner4;
    }

    public String getStoreBanner5() {
        return storeBanner5;
    }

    public void setStoreBanner5(String storeBanner5) {
        this.storeBanner5 = storeBanner5;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }
}
