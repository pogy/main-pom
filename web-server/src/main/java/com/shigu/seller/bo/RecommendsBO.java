package com.shigu.seller.bo;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 商品推荐
 * Created by zhaohongbo on 17/3/9.
 */
public class RecommendsBO implements Serializable{
    /**
     * 商品ID串
     */
    @NotEmpty(message = "商品ID串不能为空")
    private String goodsIds;
    /**
     * 要么1,要么0
     */
    private Integer isShowcase;

    public String getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds;
    }

    public Integer getIsShowcase() {
        return isShowcase;
    }

    public void setIsShowcase(Integer isShowcase) {
        if(isShowcase!=null&&isShowcase!=1&&isShowcase!=0){
            isShowcase=0;
        }
        this.isShowcase = isShowcase;
    }
}

