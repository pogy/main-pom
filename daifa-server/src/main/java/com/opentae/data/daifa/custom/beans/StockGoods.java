package com.opentae.data.daifa.custom.beans;

public class StockGoods {
    private String inStockDay;
    private String dfTradeId;
    private String marketName;
    private String storeNum;
    private String goodsNo;
    private String piPriceString;

    public String getInStockDay() {
        return this.inStockDay;
    }

    public void setInStockDay(String inStockDay) {
        this.inStockDay = inStockDay;
    }

    public String getDfTradeId() {
        return this.dfTradeId;
    }

    public void setDfTradeId(String dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public String getMarketName() {
        return this.marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getStoreNum() {
        return this.storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getGoodsNo() {
        return this.goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPiPriceString() {
        return this.piPriceString;
    }

    public void setPiPriceString(String piPriceString) {
        this.piPriceString = piPriceString;
    }
}
