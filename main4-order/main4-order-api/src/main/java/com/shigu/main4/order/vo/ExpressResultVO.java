package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by jmb on 2017/7/20.
 */
public class ExpressResultVO implements Serializable{
    /**
     *快递鸟的appid
     */
    private String EBusinessID;
    /**
     * 物流跟踪信息
     */
    private List<SingleMsgVO> Traces;
    /**
     * 订单编号
     */
    private String OrderCode;
    /**
     * 快递公司编码
     */
    private String ShipperCode;
    /**
     * 物流单号
     */
    private String LogisticCode;
    /**
     * 是否请求成功
     */
    private String Success;
    /**
     * 请求失败原因
     */
    private  String Reason;

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public List<SingleMsgVO> getTraces() {
        return Traces;
    }

    public void setTraces(List<SingleMsgVO> traces) {
        Traces = traces;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }

    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }
}
