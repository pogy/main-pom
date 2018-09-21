package com.shigu.main4.order.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by gtx on 2018/9/4 0004.
 *
 * @author gtx
 * @since
 */
public class KdnSubscribeResult implements Serializable {
    /**
     * 用户ID
     */
    @JSONField(name = "EBusinessID")
    private String eBusinessID;
    /**
     * 更新时间
     * YYYY-MM-DD HH:mm:ss
     */
    @JSONField(name = "UpdateTime")
    private String updateTime;
    /**
     * 成功与否：true，false
     */
    @JSONField(name = "Success")
    private Boolean success;
    /**
     * 失败原因
     */
    @JSONField(name = "Reason")
    private String reason;
    /**
     * 订单预计到货时间yyyy-mm-dd（即将上线）
     */
    @JSONField(name = "EstimatedDeliveryTime")
    private String estimatedDeliveryTime;

    public String geteBusinessID() {
        return eBusinessID;
    }

    public void seteBusinessID(String eBusinessID) {
        this.eBusinessID = eBusinessID;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

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

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
}
