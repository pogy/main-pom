package com.opentae.data.daifa.custom.beans;

public class WorkerTakeNum {
    private String name;
    private Long workerId;
    private String num;
    private String notTakePrice;
    private String totalPrice;
    private String takePrice;
    private String repaidFee;
    private boolean reapidFeeError;
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNotTakePrice() {
        return this.notTakePrice;
    }

    public void setNotTakePrice(String notTakePrice) {
        this.notTakePrice = notTakePrice;
    }

    public String getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTakePrice() {
        return this.takePrice;
    }

    public void setTakePrice(String takePrice) {
        this.takePrice = takePrice;
    }

    public String getRepaidFee() {
        return this.repaidFee;
    }

    public void setRepaidFee(String repaidFee) {
        this.repaidFee = repaidFee;
    }

    public boolean isReapidFeeError() {
        return this.reapidFeeError;
    }

    public void setReapidFeeError(boolean reapidFeeError) {
        this.reapidFeeError = reapidFeeError;
    }

    public Long getWorkerId() {
        return this.workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
}
