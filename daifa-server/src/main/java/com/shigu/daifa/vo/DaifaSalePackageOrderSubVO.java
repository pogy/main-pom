package com.shigu.daifa.vo;

public class DaifaSalePackageOrderSubVO extends ChildOrderVO{
    private String childServersFee;
    private Boolean isInCangKu;
    private String childRemark;
    private Integer afterSaleState;
    private String afterSalePostCode;
    private String afterSalePostName;
    private Boolean nowScanPostIs;

    public String getChildServersFee() {
        return this.childServersFee;
    }

    public void setChildServersFee(String childServersFee) {
        this.childServersFee = childServersFee;
    }

    public Boolean getIsInCangKu() {
        return this.isInCangKu;
    }

    public void setIsInCangKu(Boolean isInCangKu) {
        this.isInCangKu = isInCangKu;
    }

    public String getChildRemark() {
        return this.childRemark;
    }

    public void setChildRemark(String childRemark) {
        this.childRemark = childRemark;
    }

    public Integer getAfterSaleState() {
        return this.afterSaleState;
    }

    public void setAfterSaleState(Integer afterSaleState) {
        this.afterSaleState = afterSaleState;
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

    public Boolean getNowScanPostIs() {
        return this.nowScanPostIs;
    }

    public void setNowScanPostIs(Boolean nowScanPostIs) {
        this.nowScanPostIs = nowScanPostIs;
    }
}
