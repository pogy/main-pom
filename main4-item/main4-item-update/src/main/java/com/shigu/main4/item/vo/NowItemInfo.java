package com.shigu.main4.item.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 进入重排的商品信息
 * Created by zhaohongbo on 17/2/26.
 */
public class NowItemInfo implements Serializable{
    /**
     * 商品ID
     */
    private Long itemId;
    /**
     * 店铺ID
     */
    private Long storeId;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 淘宝类目ID
     */
    private Long cid;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 批发价
     */
    private String piPrice;
    /**
     * 分站标识
     */
    private String webSite;
    /**
     * 关联商品ID,此字段,remove时传入
     */
    private Long relationLevelId;
    /**
     * a类品或者b类品,此字段,remove时传入
     */
    private String goodsLevel;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getRelationLevelId() {
        return relationLevelId;
    }

    public void setRelationLevelId(Long relationLevelId) {
        this.relationLevelId = relationLevelId;
    }

    public String getGoodsLevel() {
        return goodsLevel;
    }

    public void setGoodsLevel(String goodsLevel) {
        this.goodsLevel = goodsLevel;
    }
}
