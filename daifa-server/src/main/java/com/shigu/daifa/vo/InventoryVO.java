package com.shigu.daifa.vo;

public class InventoryVO {
    private Integer allInventoryNum;
    private Integer putInStorageNum;
    private Integer outBoundNum;

    public Integer getAllInventoryNum() {
        return this.allInventoryNum;
    }

    public void setAllInventoryNum(Integer allInventoryNum) {
        this.allInventoryNum = allInventoryNum;
    }

    public Integer getPutInStorageNum() {
        return this.putInStorageNum;
    }

    public void setPutInStorageNum(Integer putInStorageNum) {
        this.putInStorageNum = putInStorageNum;
    }

    public Integer getOutBoundNum() {
        return this.outBoundNum;
    }

    public void setOutBoundNum(Integer outBoundNum) {
        this.outBoundNum = outBoundNum;
    }
}
