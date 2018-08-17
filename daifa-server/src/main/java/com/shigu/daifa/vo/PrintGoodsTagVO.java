package com.shigu.daifa.vo;

import java.io.Serializable;

public class PrintGoodsTagVO implements Serializable {
    private String dateIncBatch;//日期加批次
    private String barCode;//条形码内容
    private String goodsSku;//商品sku
    private String stockoutDay;//备注:缺货天数
    private String orderSort;//子单编号
    private String receiverName;//收货人姓名
    private String buyerName;//买家昵称
    private String priceAndBarCode;//批发价和条形码内容
    private String postName;//快递名称
    private String buyerNick;//下单人昵称
    private String specialStr;
    private String queNum;//缺货天数（先用这个字段）
    private String daifaName;

    public String getDateIncBatch() {
        return this.dateIncBatch;
    }

    public void setDateIncBatch(String dateIncBatch) {
        this.dateIncBatch = dateIncBatch;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getGoodsSku() {
        return this.goodsSku;
    }

    public void setGoodsSku(String goodsSku) {
        this.goodsSku = goodsSku;
    }

    public String getStockoutDay() {
        return this.stockoutDay;
    }

    public void setStockoutDay(String stockoutDay) {
        this.stockoutDay = stockoutDay;
    }

    public String getOrderSort() {
        return this.orderSort;
    }

    public void setOrderSort(String orderSort) {
        this.orderSort = orderSort;
    }

    public String getReceiverName() {
        return this.receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getBuyerName() {
        return this.buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getPostName() {
        return this.postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getBuyerNick() {
        return this.buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public String getPriceAndBarCode() {
        return this.priceAndBarCode;
    }

    public void setPriceAndBarCode(String priceAndBarCode) {
        this.priceAndBarCode = priceAndBarCode;
    }

    public String getSpecialStr() {
        return this.specialStr;
    }

    public void setSpecialStr(String specialStr) {
        this.specialStr = specialStr;
    }

    public String getQueNum () {
        return queNum;
    }

    public void setQueNum (String queNum) {
        this.queNum = queNum;
    }

    public String getDaifaName() {
        return this.daifaName;
    }

    public void setDaifaName(String daifaName) {
        this.daifaName = daifaName;
    }
}
