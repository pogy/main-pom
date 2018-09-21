package com.shigu.main4.order.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gtx on 2018/9/3 0003.
 *
 * @author gtx
 * @since
 */
public class KdnSelVO implements Serializable {
    /**
     * 成功与否
     */
    @JSONField(name = "Success")
    private Boolean success;
    /**
     * 失败原因
     */
    @JSONField(name = "Reason")
    private String reason;
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
     * 物流运单号
     */
    @JSONField(name = "LogisticCode")
    private String logisticCode;
    /**
     * 物流状态：2-在途中,3-签收,4-问题件
     */
    @JSONField(name = "State")
    private String state;

    @JSONField(name = "Traces")
    private List<KdnCallBackTrace> kdnCallBackTraces;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<KdnCallBackTrace> getKdnCallBackTraces() {
        return kdnCallBackTraces;
    }

    public void setKdnCallBackTraces(List<KdnCallBackTrace> kdnCallBackTraces) {
        this.kdnCallBackTraces = kdnCallBackTraces;
    }
}
