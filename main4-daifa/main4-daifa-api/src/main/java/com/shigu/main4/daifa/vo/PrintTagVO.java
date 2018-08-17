package com.shigu.main4.daifa.vo;

import java.io.Serializable;

/**
 * 打印标签返回值
 * Created by zhaohongbo on 17/8/8.
 */
public class PrintTagVO implements Serializable {
    private static final long serialVersionUID = 2364822351466967739L;
    private String dateIncBatch;//日期加批次
    private String barCode;//条形码内容
    private String goodsSku;//商品sku
    private int packages;//件数
    private String index;//第几主单
    private int type;//1单单 2多单
    private String specialStr;//特殊标注符:主单编号
    private String remarks;//备注:缺货天数
    private String orderSort;//子单编号
    private String receiverName;//收货人姓名
    private String buyerName;//买家昵称
    private String buyerWw;//
    private String priceAndBarCode;//批发价和条形码内容
    private String postName;//快递名称
    private String buyerNick;//下单人昵称
    private String daifaName;

    public String getDateIncBatch() {
        return dateIncBatch;
    }

    public void setDateIncBatch(String dateIncBatch) {
        this.dateIncBatch = dateIncBatch;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(String goodsSku) {
        this.goodsSku = goodsSku;
    }

    public int getPackages() {
        return packages;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSpecialStr() {
        return specialStr;
    }

    public void setSpecialStr(String specialStr) {
        this.specialStr = specialStr;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOrderSort() {
        return orderSort;
    }

    public void setOrderSort(String orderSort) {
        this.orderSort = orderSort;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerWw() {
        return buyerWw;
    }

    public void setBuyerWw(String buyerWw) {
        this.buyerWw = buyerWw;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPriceAndBarCode() {
        return this.priceAndBarCode;
    }

    public void setPriceAndBarCode(String priceAndBarCode) {
        this.priceAndBarCode = priceAndBarCode;
    }

    public String getDaifaName() {
        return this.daifaName;
    }

    public void setDaifaName(String daifaName) {
        this.daifaName = daifaName;
    }
}
