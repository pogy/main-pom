package com.shigu.main4.pay.requests;

import java.io.Serializable;
import java.util.List;

/**
 * 类名：XzbRefundRequest
 * 类路径： com.shigu.main4.pay.requests.XzbRefundRequest
 * 创建者： whx
 * 创建时间： 8/9/18 5:55 PM
 * 项目： main-pom
 * 描述：退款
 */
public class XzbRefundRequest implements Serializable {

    private String outTradeId;

    private List<String> subOutTradeId;

    private Long dfGroupId;

    private Integer refundType;

    private String refundReason;

    private Long money;

    public String getOutTradeId() {
        return outTradeId;
    }

    public void setOutTradeId(String outTradeId) {
        this.outTradeId = outTradeId;
    }

    public List<String> getSubOutTradeId() {
        return subOutTradeId;
    }

    public void setSubOutTradeId(List<String> subOutTradeId) {
        this.subOutTradeId = subOutTradeId;
    }

    public Long getDfGroupId() {
        return dfGroupId;
    }

    public void setDfGroupId(Long dfGroupId) {
        this.dfGroupId = dfGroupId;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
