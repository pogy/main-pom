package com.shigu.daifa.vo;

/**
 * Created by pc on 2017-08-31.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class WaitSendOrderVO extends ChildOrderVO{
    private Integer takeGoodsState;
    private Integer refundState;
    private String childServersFee;//子单服务费
    private String childRemark;//子单备注
    private Boolean noSaleIs;
    private String barCodeKey;




    public Integer getTakeGoodsState() {
        return takeGoodsState;
    }

    public void setTakeGoodsState(Integer takeGoodsState) {
        this.takeGoodsState = takeGoodsState;
    }

    public Integer getRefundState() {
        return refundState;
    }

    public void setRefundState(Integer refundState) {
        this.refundState = refundState;
    }

    public String getChildServersFee() {
        return this.childServersFee;
    }

    public void setChildServersFee(String childServersFee) {
        this.childServersFee = childServersFee;
    }

    public String getChildRemark() {
        return this.childRemark;
    }

    public void setChildRemark(String childRemark) {
        this.childRemark = childRemark;
    }

    public Boolean getNoSaleIs() {
        return this.noSaleIs;
    }

    public void setNoSaleIs(Boolean noSaleIs) {
        this.noSaleIs = noSaleIs;
    }

    public String getBarCodeKey() {
        return this.barCodeKey;
    }

    public void setBarCodeKey(String barCodeKey) {
        this.barCodeKey = barCodeKey;
    }
}
