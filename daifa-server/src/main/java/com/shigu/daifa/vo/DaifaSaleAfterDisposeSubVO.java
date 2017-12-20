package com.shigu.daifa.vo;

public class DaifaSaleAfterDisposeSubVO extends DaifaSaleAfterSubVO {
    private Integer afterSaleState;
    private Integer putInStorageType;
    private String afterSalePostCode;
    private String afterSalePostName;

    public Integer getAfterSaleState() {
        return this.afterSaleState;
    }

    public void setAfterSaleState(Integer afterSaleState) {
        this.afterSaleState = afterSaleState;
    }

    public Integer getPutInStorageType() {
        return this.putInStorageType;
    }

    public void setPutInStorageType(Integer putInStorageType) {
        this.putInStorageType = putInStorageType;
    }

    public String getAfterSalePostCode() {
        return this.afterSalePostCode;
    }

    public void setAfterSalePostCode(String afterSalePostCode) {
        this.afterSalePostCode = afterSalePostCode;
    }

    public String getAfterSalePostName() {
        return this.afterSalePostName;
    }

    public void setAfterSalePostName(String afterSalePostName) {
        this.afterSalePostName = afterSalePostName;
    }
}
