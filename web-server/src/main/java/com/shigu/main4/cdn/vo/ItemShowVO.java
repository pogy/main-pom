package com.shigu.main4.cdn.vo;

import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.vo.ShopBaseForCdn;
import com.shigu.main4.vo.ShopCat;
import com.shigu.main4.vo.StoreRelation;

import java.io.Serializable;
import java.util.List;

/**
 * 商品页面前台展示
 * Created by zhaohongbo on 17/2/21.
 */
public class ItemShowVO implements Serializable {

    private static final long serialVersionUID = 6981558712227435799L;
    /**
     * 店铺联系方式
     */
    private StoreRelation storeRelation;
    /**
     * 商品基本信息
     */
    private CdnItem cdnItem;
    /**
     * true为在售,false是已下架
     */
    private boolean onsale;
    /**
     * 店内类目
     */
    private List<ShopCat> shopCats;
    /**
     * 商品点击量
     */
    private Long clicks;
    /**
     * 店铺星星数
     */
    private Long starNum;

    private Long itemId;
    /**
     * 商品权益,存着value,查看com.shigu.main4.common.vo.ShiguTags
     */
    private List<String> tags;

    /**
     * 店铺中额外信息
     */
    private ShopBaseForCdn other;
    /**
     * 二级域名
     */
    private String domain;


    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public ShopBaseForCdn getOther() {
        return other;
    }

    public void setOther(ShopBaseForCdn other) {
        this.other = other;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public StoreRelation getStoreRelation() {
        return storeRelation;
    }

    public void setStoreRelation(StoreRelation storeRelation) {
        this.storeRelation = storeRelation;
    }

    public CdnItem getCdnItem() {
        return cdnItem;
    }

    public void setCdnItem(CdnItem cdnItem) {
        this.cdnItem = cdnItem;
    }

    public boolean isOnsale() {
        return onsale;
    }

    public void setOnsale(boolean onsale) {
        this.onsale = onsale;
    }

    public List<ShopCat> getShopCats() {
        return shopCats;
    }

    public void setShopCats(List<ShopCat> shopCats) {
        this.shopCats = shopCats;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public Long getStarNum() {
        return starNum;
    }

    public void setStarNum(Long starNum) {
        this.starNum = starNum;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
