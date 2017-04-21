package com.shigu.search.vo;

import java.io.Serializable;

/**
 * 店铺搜索中的商品
 * Created by zhaohongbo on 17/4/5.
 */
public class GoodsInStoreSearch implements Serializable{
    /**
     * 档口商品id
     */
    private String id;
    /**
     * 档口商品图片
     */
    private String imgsrc;
    /**
     * 档口商品批发价（12.00）
     */
    private String piprice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }
}
