package com.shigu.main4.order.bo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by gtx on 2018/9/3 0003.
 *
 * @author gtx
 * @since
 */
public class KdnSelBO implements Serializable {
    /**
     * 订单编号
     */
    @JSONField(name = "OrderCode")
    private String orderCode;

    /**
     * 快递公司编码
     */
    @JSONField(name = "ShipperCode")
    private String shipperCode;

    /**
     * 物流单号
     */
    @JSONField(name = "LogisticCode")
    private String logisticCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }
}
