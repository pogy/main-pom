package com.opentae.data.daifa.custom.beans;

public class TodayPostDetail {
    private String day;
    private String dfTradeId;
    private String expressName;
    private String expressCode;
    private String expressFee;

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDfTradeId() {
        return this.dfTradeId;
    }

    public void setDfTradeId(String dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public String getExpressName() {
        return this.expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCode() {
        return this.expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public String getExpressFee() {
        return this.expressFee;
    }

    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }
}
