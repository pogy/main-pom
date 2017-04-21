package com.shigu.seller.vo;

import com.shigu.main4.monitor.vo.HotUpItem;
import com.shigu.main4.monitor.vo.NoUpItem;

import java.io.Serializable;

/**
 * 商户中心热卖
 * Created by zhaohongbo on 17/3/19.
 */
public class HotItemVO implements Serializable{

    private String picUrl;

    private Long goodsId;

    private String piPriceString;

    public HotItemVO(HotUpItem hot) {
        goodsId=hot.getGoodsId();
        picUrl=hot.getImgUrl();
        piPriceString=hot.getPrice();
    }

    public HotItemVO(NoUpItem noup){
        goodsId=noup.getGoodsId();
        picUrl=noup.getImgUrl();
        piPriceString=noup.getPrice();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getPiPriceString() {
        return piPriceString;
    }

    public void setPiPriceString(String piPriceString) {
        this.piPriceString = piPriceString;
    }
}
