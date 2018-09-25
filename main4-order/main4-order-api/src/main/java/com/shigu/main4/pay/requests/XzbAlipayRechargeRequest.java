package com.shigu.main4.pay.requests;

import java.io.Serializable;

/**
 * 类名：XzbAlipayRechargeRequest
 * 类路径： com.shigu.main4.pay.requests.XzbAlipayRechargeRequest
 * 创建者： whx
 * 创建时间： 8/8/18 3:22 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbAlipayRechargeRequest implements Serializable {

    /**
     * 支付宝充值单号
     */
    private String alipayNo;

    /**
     * 星座网用户id
     */
    private Long xzUserId;

    /**
     * 充值金额
     */
    private Long payAmount;

    /**
     * 支付系统账户id
     */
    private Long accountId;

    public String getAlipayNo() {
        return alipayNo;
    }

    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo;
    }

    public Long getXzUserId() {
        return xzUserId;
    }

    public void setXzUserId(Long xzUserId) {
        this.xzUserId = xzUserId;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
