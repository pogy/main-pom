package com.shigu.main4.item.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 类名：GoodsShelfInfoForEs
 * 类路径：com.shigu.main4.item.vo.GoodsShelfInfoForEs
 * 创建者：王浩翔
 * 创建时间：2017-10-20 10:10
 * 项目：main-pom
 * 描述：档口商品上下架时推到redis里的商品信息
 */
public class GoodsShelfInfoForEs implements Serializable {
    //商品id
    private Long goodsId;
    //修改时间
    private Date modified;
    //true 上架,false 下架
    private Boolean onShelfIs;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Boolean getOnShelfIs() {
        return onShelfIs;
    }

    public void setOnShelfIs(Boolean onShelfIs) {
        this.onShelfIs = onShelfIs;
    }
}