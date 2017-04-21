package com.shigu.main4.cdn.bo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 收藏宝贝参数
 * Created by zhaohongbo on 17/3/7.
 */
public class ScGoodsBO implements Serializable{

    @NotNull(message = "商品ID不存在")
    private Long goodsId;

    private String callback;

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
