package com.shigu.buyer.vo;

import java.io.Serializable;

/**
 * 类名：SimpleGoodsInfoVO
 * 类路径：com.shigu.buyer.vo.SimpleGoodsInfoVO
 * 创建者：王浩翔
 * 创建时间：2017-10-16 18:09
 * 项目：main-pom
 * 描述：
 */
public class SimpleGoodsInfoVO implements Serializable {
    //店铺上新商品id
    private Long goodsId;
    //店铺上新商品图片
    private String imgSrc;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
