package com.shigu.seller.bo;

import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * 发布的商品信息
 * Created by zhaohongbo on 17/3/18.
 */
public class GoodsInfoBO implements Serializable{

    @Valid
    private GoodsOfferBO offer;
    @SafeHtml(message = "货号包含非法页面标签")
    private String huohao;

    public GoodsOfferBO getOffer() {
        return offer;
    }

    public void setOffer(GoodsOfferBO offer) {
        this.offer = offer;
    }

    public String getHuohao() {
        return huohao;
    }

    public void setHuohao(String huohao) {
        this.huohao = huohao;
    }
}
