package com.shigu.seller.vo;

public class UserGoodsStyleVo {
    //商品风格id
    private Long  goodsStyleId;
    //风格名称
    private  String goodsStyleName;
    //所属类目id
    private Long  categoryId;
    //所属类目名称
    private  String categoryName;
    //当前风格属性下的商品总数
    private Long  goodsNum;

    public Long getGoodsStyleId() {
        return goodsStyleId;
    }

    public void setGoodsStyleId(Long goodsStyleId) {
        this.goodsStyleId = goodsStyleId;
    }

    public String getGoodsStyleName() {
        return goodsStyleName;
    }

    public void setGoodsStyleName(String goodsStyleName) {
        this.goodsStyleName = goodsStyleName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }




}
