package com.shigu.seller.vo;

/**
 * 类目选项卡数据封装类
 */
public class CategoryTabsVo {

    //类目id
    private String cateId;
    //类目名称
    private String cateName;
    //该类目下的商品数量
    private Long goodsNum;

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Long getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }

}
