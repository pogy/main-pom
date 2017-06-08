package com.shigu.main4.test.active;

/**
 * Created by bugzy on 2017/6/6 0006.
 */
public class Goods {
    private Long goodsId;
    private Long sales;

    public Goods(Long goodsId, Long sales) {
        this.goodsId = goodsId;
        this.sales = sales;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }
}
