package com.shigu.order.bo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zf on 2017/7/25.
 * 加入进货车BO
 */
public class AddCartBO implements Serializable {
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * sku串
     */
    private List<AddCartPropBO> datalist;

    /**
     * 获取 商品ID
     */
    public Long getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置 商品ID
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取 sku串
     */
    public List<AddCartPropBO> getDatalist() {
        return this.datalist;
    }

    /**
     * 设置 sku串
     */
    public void setDatalist(List<AddCartPropBO> datalist) {
        this.datalist = datalist;
    }
}
