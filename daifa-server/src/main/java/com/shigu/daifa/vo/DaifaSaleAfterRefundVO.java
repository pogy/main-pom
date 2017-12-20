package com.shigu.daifa.vo;

import java.util.List;

public class DaifaSaleAfterRefundVO {
    private Long refundId;
    private Integer afterSaleState;
    private String afterSalePostCode;
    private String afterSalePostName;
    private String opeReason;
    private Integer refundState;
    private Integer refundFeeType;
    private String refundForShop;
    private List<String> editInfo;
    private List<DaifaSaleAfterStockVO> putInStorageState;
    private List<DaifaSaleAfterSubVO> childOrders;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
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

    public String getOpeReason() {
        return this.opeReason;
    }

    public void setOpeReason(String opeReason) {
        this.opeReason = opeReason;
    }

    public Integer getRefundState() {
        return this.refundState;
    }

    public void setRefundState(Integer refundState) {
        this.refundState = refundState;
    }

    public Integer getRefundFeeType() {
        return this.refundFeeType;
    }

    public void setRefundFeeType(Integer refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    public String getRefundForShop() {
        return this.refundForShop;
    }

    public void setRefundForShop(String refundForShop) {
        this.refundForShop = refundForShop;
    }

    public List<String> getEditInfo() {
        return this.editInfo;
    }

    public void setEditInfo(List<String> editInfo) {
        this.editInfo = editInfo;
    }

    public List<DaifaSaleAfterStockVO> getPutInStorageState() {
        return this.putInStorageState;
    }

    public void setPutInStorageState(List<DaifaSaleAfterStockVO> putInStorageState) {
        this.putInStorageState = putInStorageState;
    }

    public List<DaifaSaleAfterSubVO> getChildOrders() {
        return this.childOrders;
    }

    public void setChildOrders(List<DaifaSaleAfterSubVO> childOrders) {
        this.childOrders = childOrders;
    }
}
