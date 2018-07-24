package com.shigu.main4.cdn.vo;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.vo.*;

import java.util.List;

/**
 * 店铺数据
 * Created by zhaohongbo on 17/2/22.
 */
public class ShopShowVO {
    /**
     *  推荐商品
     */
    private List<ItemShowBlock> recommens;
    /**
     * 店内聚合类目
     */
    private List<CatPolymerization> catPolymerizations;
    /**
     * 店铺联系方式
     */
    private StoreRelation storeRelation;

    /**
     * 店内类目
     */
    private List<ShopCat> shopCats;
    /**
     * 商品列表
     */
    private ShiguPager<ItemShowBlock> itemList;
    /**
     * 店铺中额外信息
     */
    private ShopBaseForCdn other;
    /**
     * 店铺装修
     */
    private ShopFitment shopFitment;
    /**
     * 店铺权益
     */
    private List<ShopLicense> shopLicenses;
//    private Integer shopLicenses;
    /**
     * 授权同步信息,0代表没有授权,1代表已授权,2代表授权过期
     */
    private int hasAuth;

    /**
     * 二级域名
     */
    private String domain;
//    private String pageOption;
    /**
     * 商品数量
     */
    private Long goodsNum;
    /**
     * 星星数
     */
    private Long starNum;

    public Long getStarNum() {
        return starNum;
    }

    public void setStarNum(Long starNum) {
        this.starNum = starNum;
    }

    public Long getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getHasAuth() {
        return hasAuth;
    }

    public void setHasAuth(int hasAuth) {
        this.hasAuth = hasAuth;
    }

    public List<ShopLicense> getShopLicenses() {
        return shopLicenses;
    }

    public void setShopLicenses(List<ShopLicense> shopLicenses) {
        this.shopLicenses = shopLicenses;
    }

//    public Integer getShopLicenses() {
//        return shopLicenses;
//    }
//
//    public void setShopLicenses(Integer shopLicenses) {
//        this.shopLicenses = shopLicenses;
//    }

    public List<ItemShowBlock> getRecommens() {
        return recommens;
    }

    public void setRecommens(List<ItemShowBlock> recommens) {
        this.recommens = recommens;
    }

    public List<CatPolymerization> getCatPolymerizations() {
        return catPolymerizations;
    }

    public void setCatPolymerizations(List<CatPolymerization> catPolymerizations) {
        this.catPolymerizations = catPolymerizations;
    }

    public StoreRelation getStoreRelation() {
        return storeRelation;
    }

    public void setStoreRelation(StoreRelation storeRelation) {
        this.storeRelation = storeRelation;
    }

    public List<ShopCat> getShopCats() {
        return shopCats;
    }

    public void setShopCats(List<ShopCat> shopCats) {
        this.shopCats = shopCats;
    }

    public ShiguPager<ItemShowBlock> getItemList() {
        return itemList;
    }

    public void setItemList(ShiguPager<ItemShowBlock> itemList) {
        this.itemList = itemList;
    }

    public ShopBaseForCdn getOther() {
        return other;
    }

    public void setOther(ShopBaseForCdn other) {
        this.other = other;
    }

    public ShopFitment getShopFitment() {
        return shopFitment;
    }

    public void setShopFitment(ShopFitment shopFitment) {
        this.shopFitment = shopFitment;
    }

//    public String getPageOption() {
//        return pageOption;
//    }
//
//    public void setPageOption(String pageOption) {
//        this.pageOption = pageOption;
//    }
}
