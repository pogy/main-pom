package com.shigu.main4.ucenter.webvo;


import java.io.Serializable;

/**
 * 新版我的收藏VO
 *
 * @author shigu_zjb
 * @date 2017/01/13 10:32
 *
 */
public class ItemCollectInfoVO implements Serializable{

    private static final long serialVersionUID = 7420340379536757958L;

    /**
     * 商品收藏ID
     */
    private Long goodsCollectId;

    /**
     * 类别，1加数据包，2普通收藏
     */
    private Integer type;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 状态@0删除1有效
     */
    private Integer useStatus;

    /**
     * 店铺ID
     */
    private Long storeId;

    /**
     * 站点
     */
    private String website;

    public Long getGoodsCollectId() {
        return goodsCollectId;
    }

    public void setGoodsCollectId(Long goodsCollectId) {
        this.goodsCollectId = goodsCollectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
