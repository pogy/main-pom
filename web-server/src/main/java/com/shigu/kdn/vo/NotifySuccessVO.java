package com.shigu.kdn.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by gtx on 2018/8/31 0031.
 *
 * @author gtx
 * @since
 */
public class NotifySuccessVO implements Serializable {

    @JSONField(name = "EBusinessID")
    private String eBusinessId;
    @JSONField(name = "UpdateTime")
    private String updateTime;
    @JSONField(name = "Success")
    private boolean success;
    @JSONField(name = "Reason")
    //String(50)
    private String reason;

    public String geteBusinessId() {
        return eBusinessId;
    }

    public void seteBusinessId(String eBusinessId) {
        this.eBusinessId = eBusinessId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
