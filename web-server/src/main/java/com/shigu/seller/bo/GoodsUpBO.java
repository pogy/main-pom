package com.shigu.seller.bo;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 商品上架BO
 * Created by zhaohongbo on 17/3/12.
 */
public class GoodsUpBO implements Serializable{
    /**
     * id串
     */
    @NotEmpty(message = "goodsIds参数异常")
    private String goodsIds;
    /**
     * 分站标识
     */
    private String webSite;

    public String getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
