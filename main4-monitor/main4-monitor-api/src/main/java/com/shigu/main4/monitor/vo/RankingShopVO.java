package com.shigu.main4.monitor.vo;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 类名：RankingShopVO
 * 类路径：com.shigu.main4.monitor.vo.RankingShopVO
 * 创建者：王浩翔
 * 创建时间：2017-09-27 16:31
 * 项目：main-pom
 * 描述：排行榜展示用店铺数据
 */
public class RankingShopVO implements Serializable {

    //排名
    private Integer rank;
    //	店铺id
    private Long shopId;
    //	店铺全称
    private String fullShopName;
    //	店铺信誉值
    private Long shopLevel;
    //  店铺商品总数
    private Integer goodsCount;
    //	店铺排行榜升降值
    private Integer changeNum;
    //	店铺排行榜指数
    private Long exponent;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getFullShopName() {
        return fullShopName;
    }

    public void setFullShopName(String fullShopName) {
        this.fullShopName = fullShopName;
    }

    public Long getShopLevel() {
        return shopLevel;
    }

    public void setShopLevel(Long shopLevel) {
        this.shopLevel = shopLevel;
    }

    public Integer getChangeNum() {
        return changeNum;
    }

    public void setChangeNum(Integer changeNum) {
        this.changeNum = changeNum;
    }

    public Long getExponent() {
        return exponent;
    }

    public void setExponent(Long exponent) {
        this.exponent = exponent;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public static class RankingShopComparator implements Comparator<RankingShopVO> {

        @Override
        public int compare(RankingShopVO o1, RankingShopVO o2) {
            return (int) (o2.getExponent() - o1.getExponent());
        }
    }
}
