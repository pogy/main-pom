package com.shigu.main4.pay.requests;

import java.io.Serializable;

/**
 * 类名：XzbInviteRechargeRequest
 * 类路径： com.shigu.main4.pay.requests.XzbInviteRechargeRequest
 * 创建者： whx
 * 创建时间： 8/10/18 4:58 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbInviteRechargeRequest implements Serializable {
    // 用户ID
    private Long xzUserId;

    // 返现金额
    private Long rebateAmount;

    // 返现订单号
    private Long rebateOrderNo;

    public Long getXzUserId() {
        return xzUserId;
    }

    public void setXzUserId(Long xzUserId) {
        this.xzUserId = xzUserId;
    }

    public Long getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(Long rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    public Long getRebateOrderNo() {
        return rebateOrderNo;
    }

    public void setRebateOrderNo(Long rebateOrderNo) {
        this.rebateOrderNo = rebateOrderNo;
    }
}
