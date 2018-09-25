package com.shigu.main4.pay.requests;

import com.shigu.main4.pay.bo.XzbPayTrade;

import java.io.Serializable;

/**
 * 类名：XzbPayRequest
 * 类路径： com.shigu.main4.pay.requests.XzbPayRequest
 * 创建者： whx
 * 创建时间： 8/9/18 4:00 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbPayRequest implements Serializable {
    /**
     * 代发的用户ID,和星座网用户ID一样
     */
    private Long xzUserId;
    /**
     * 资金账户ID
     */
    private Long accountId;

    /**
     * 交易信息
     */
    private XzbPayTrade trade;

    public Long getXzUserId() {
        return xzUserId;
    }

    public void setXzUserId(Long xzUserId) {
        this.xzUserId = xzUserId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public XzbPayTrade getTrade() {
        return trade;
    }

    public void setTrade(XzbPayTrade trade) {
        this.trade = trade;
    }
}
