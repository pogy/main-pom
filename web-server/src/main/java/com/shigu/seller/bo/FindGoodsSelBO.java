package com.shigu.seller.bo;

/**
 * 发现好货挑款查询参数
 * Created by zhaohongbo on 17/5/27.
 */
public class FindGoodsSelBO {

    private String q;

    private Double startPrice;

    private Double endPrice;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Double endPrice) {
        this.endPrice = endPrice;
    }
}
