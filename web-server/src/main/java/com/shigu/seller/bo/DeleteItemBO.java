package com.shigu.seller.bo;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 删除商品BO
 * Created by zhaohongbo on 17/3/12.
 */
public class DeleteItemBO implements Serializable{
    @NotEmpty(message = "ids参数异常")
    private String goodsIds;

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
