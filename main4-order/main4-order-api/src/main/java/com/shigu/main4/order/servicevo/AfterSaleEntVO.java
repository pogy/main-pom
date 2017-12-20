package com.shigu.main4.order.servicevo;

import java.io.Serializable;

/**
 * Created by zf on 2017/7/26.
 * 售后结束(钱款去向?)
 */
public class AfterSaleEntVO implements Serializable{
    /**
     * 结束时间
     */
    private String afterSeleEntDate;
    /**
     * 退款金额,售后类型为退货退款时返回
     */
    private Long price;
    /**
     * 钱款去向,售后类型为退货退款时返回
     */
    private String priceGoto;

    /**
     * 获取 结束时间
     */
    public String getAfterSeleEntDate() {
        return this.afterSeleEntDate;
    }

    /**
     * 设置 结束时间
     */
    public void setAfterSeleEntDate(String afterSeleEntDate) {
        this.afterSeleEntDate = afterSeleEntDate;
    }

    /**
     * 获取 退款金额,售后类型为退货退款时返回
     */
    public Long getPrice() {
        return this.price;
    }

    /**
     * 设置 退款金额,售后类型为退货退款时返回
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取 钱款去向,售后类型为退货退款时返回
     */
    public String getPriceGoto() {
        return this.priceGoto;
    }

    /**
     * 设置 钱款去向,售后类型为退货退款时返回
     */
    public void setPriceGoto(String priceGoto) {
        this.priceGoto = priceGoto;
    }
}
