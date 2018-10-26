package com.shigu.main4.pay.requests;

import java.io.Serializable;

/**
 * 类名：XzbAlipayToCashedRequest
 * 类路径： com.shigu.main4.pay.requests.XzbAlipayToCashedRequest
 * 创建者： whx
 * 创建时间： 8/10/18 2:46 PM
 * 项目： main-pom
 * 描述：提现申请
 */
public class XzbAlipayToCashedRequest implements Serializable {
    /**
     * 账户ID
     */
    private Long accountId;

    /**
     * 提现金额，精确到分
     */
    private Long cashAmount;

    /**
     * 账户ID
     */
    private Long xzUserId;

    /**
     * 支付宝账号
     */
    private String alipayUserId;

    /**
     * 实名信息
     */
    private String alipayRealName;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Long cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Long getXzUserId() {
        return xzUserId;
    }

    public void setXzUserId(Long xzUserId) {
        this.xzUserId = xzUserId;
    }

    public String getAlipayUserId() {
        return alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId;
    }

    public String getAlipayRealName() {
        return alipayRealName;
    }

    public void setAlipayRealName(String alipayRealName) {
        this.alipayRealName = alipayRealName;
    }
}
