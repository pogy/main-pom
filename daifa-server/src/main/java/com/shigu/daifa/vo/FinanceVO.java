package com.shigu.daifa.vo;

public class FinanceVO {
    private String haveToTakeFee;
    private String daifaServerFee;
    private String shipmentsFee;
    private String refundedGoodsFee;


    private String allotmentFee;
    private String inventoryGoodsFee;
    private String inTheBackGoodsFee;


    public String getDaifaServerFee() {
        return this.daifaServerFee;
    }

    public void setDaifaServerFee(String daifaServerFee) {
        this.daifaServerFee = daifaServerFee;
    }

    public String getShipmentsFee() {
        return this.shipmentsFee;
    }

    public void setShipmentsFee(String shipmentsFee) {
        this.shipmentsFee = shipmentsFee;
    }


    public String getHaveToTakeFee() {
        return this.haveToTakeFee;
    }

    public void setHaveToTakeFee(String haveToTakeFee) {
        this.haveToTakeFee = haveToTakeFee;
    }

    public String getAllotmentFee() {
        return this.allotmentFee;
    }

    public void setAllotmentFee(String allotmentFee) {
        this.allotmentFee = allotmentFee;
    }

    public String getInventoryGoodsFee() {
        return this.inventoryGoodsFee;
    }

    public void setInventoryGoodsFee(String inventoryGoodsFee) {
        this.inventoryGoodsFee = inventoryGoodsFee;
    }

    public String getInTheBackGoodsFee() {
        return this.inTheBackGoodsFee;
    }

    public void setInTheBackGoodsFee(String inTheBackGoodsFee) {
        this.inTheBackGoodsFee = inTheBackGoodsFee;
    }

    public String getRefundedGoodsFee() {
        return this.refundedGoodsFee;
    }

    public void setRefundedGoodsFee(String refundedGoodsFee) {
        this.refundedGoodsFee = refundedGoodsFee;
    }
}
