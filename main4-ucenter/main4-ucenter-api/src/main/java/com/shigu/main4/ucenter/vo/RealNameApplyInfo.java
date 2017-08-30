package com.shigu.main4.ucenter.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 实名认证简单信息查询
 * Created by zhaohongbo on 17/3/14.
 */
public class RealNameApplyInfo  implements Serializable {
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 1通过，0未审核，-1不通过
     */
    private Integer applyStatus;
    /**
     * 原因
     */
    private String reason;

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
