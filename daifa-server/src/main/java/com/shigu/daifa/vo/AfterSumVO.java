package com.shigu.daifa.vo;

public class AfterSumVO {
    private Integer afterOrderNum;
    private Integer refundsNum;
    private Integer exchangeNum;
    private String beenShippedGoodsFee;
    private Integer stockoutNum;

    public Integer getAfterOrderNum() {
        return this.afterOrderNum;
    }

    public void setAfterOrderNum(Integer afterOrderNum) {
        this.afterOrderNum = afterOrderNum;
    }

    public Integer getRefundsNum() {
        return this.refundsNum;
    }

    public void setRefundsNum(Integer refundsNum) {
        this.refundsNum = refundsNum;
    }

    public Integer getExchangeNum() {
        return this.exchangeNum;
    }

    public void setExchangeNum(Integer exchangeNum) {
        this.exchangeNum = exchangeNum;
    }

    public String getBeenShippedGoodsFee() {
        return this.beenShippedGoodsFee;
    }

    public void setBeenShippedGoodsFee(String beenShippedGoodsFee) {
        this.beenShippedGoodsFee = beenShippedGoodsFee;
    }

    public Integer getStockoutNum() {
        return this.stockoutNum;
    }

    public void setStockoutNum(Integer stockoutNum) {
        this.stockoutNum = stockoutNum;
    }
}
