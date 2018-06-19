package com.shigu.seller.vo;

import java.util.List;

public class GoodsInfoSkuColorVO {
    private String colorId;
    private String colorText;
    private List<GoodsInfoSkuSizeVO> sizes;


    public List<GoodsInfoSkuSizeVO> getSizes() {
        return this.sizes;
    }

    public void setSizes(List<GoodsInfoSkuSizeVO> sizes) {
        this.sizes = sizes;
    }

    public String getColorId() {
        return this.colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getColorText() {
        return this.colorText;
    }

    public void setColorText(String colorText) {
        this.colorText = colorText;
    }
}
