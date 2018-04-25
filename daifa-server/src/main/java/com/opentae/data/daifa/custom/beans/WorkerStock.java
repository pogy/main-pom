package com.opentae.data.daifa.custom.beans;

public class WorkerStock {
    private Long stockId;
    private Long dfOrderId;

    public Long getStockId() {
        return this.stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getDfOrderId() {
        return this.dfOrderId;
    }

    public void setDfOrderId(Long dfOrderId) {
        this.dfOrderId = dfOrderId;
    }
}
