package com.shigu.seller.vo;

public class GoodsInfoSkuSizeVO {
    private String sizeId;
    private String sizeText;
    private String price;
    private Integer num;


    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSizeId() {
        return this.sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeText() {
        return this.sizeText;
    }

    public void setSizeText(String sizeText) {
        this.sizeText = sizeText;
    }
}
