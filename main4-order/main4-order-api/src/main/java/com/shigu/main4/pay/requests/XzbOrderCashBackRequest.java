package com.shigu.main4.pay.requests;

import java.io.Serializable;

/**
 * 类名：XzbOrderCashBackRequest
 * 类路径： com.shigu.main4.pay.requests.XzbOrderCashBackRequest
 * 创建者： whx
 * 创建时间： 8/10/18 5:52 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbOrderCashBackRequest implements Serializable {

    // 用户ID
    private Long xzUserId;

    // 返现金额
    private Long cashbackAmount;

    // 返现订单号
    private Long cashbackOrderNo;

    public Long getXzUserId() {
        return xzUserId;
    }

    public void setXzUserId(Long xzUserId) {
        this.xzUserId = xzUserId;
    }

    public Long getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(Long cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public Long getCashbackOrderNo() {
        return cashbackOrderNo;
    }

    public void setCashbackOrderNo(Long cashbackOrderNo) {
        this.cashbackOrderNo = cashbackOrderNo;
    }
}
