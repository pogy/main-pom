package com.shigu.main4.cdn.vo;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.vo.Discus;
import com.shigu.main4.vo.ShopBaseForCdn;
import com.shigu.main4.vo.ShopLicense;
import com.shigu.main4.vo.StoreRelation;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺讨论区数据
 * Created by zhaohongbo on 17/3/8.
 */
public class ShopCommentVO implements Serializable{
    /**
     * 店铺中额外信息
     */
    private ShopBaseForCdn other;
    /**
     * 授权同步信息,0代表没有授权,1代表已授权,2代表授权过期
     */
    private int hasAuth;

    /**
     * 店铺权益
     */
    private List<ShopLicense> shopLicenses;
    /**
     * 店铺联系方式
     */
    private StoreRelation storeRelation;
    /**
     * 讨论的信息
     */
    private ShiguPager<Discus> discus;
    /**
     * 平均名
     */
    private String scoreAvg;
    /**
     * 累计评论
     */
    private int totalCount;
    /**
     * 星星数
     */
    private Long starNum = 0L;

    public Long getStarNum() {
        return starNum;
    }

    public void setStarNum(Long starNum) {
        this.starNum = starNum;
    }

    public ShiguPager<Discus> getDiscus() {
        return discus;
    }

    public void setDiscus(ShiguPager<Discus> discus) {
        this.discus = discus;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public ShopBaseForCdn getOther() {
        return other;
    }

    public void setOther(ShopBaseForCdn other) {
        this.other = other;
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

    public StoreRelation getStoreRelation() {
        return storeRelation;
    }

    public void setStoreRelation(StoreRelation storeRelation) {
        this.storeRelation = storeRelation;
    }

    public String getScoreAvg() {
        return scoreAvg;
    }

    public void setScoreAvg(String scoreAvg) {
        this.scoreAvg = scoreAvg;
    }
}
