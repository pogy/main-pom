package com.shigu.main4.pay.responses;

import java.io.Serializable;

/**
 * 类名：XzbAlipayRechargeResponse
 * 类路径： com.shigu.main4.pay.responses.XzbAlipayRechargeResponse
 * 创建者： whx
 * 创建时间： 8/7/18 3:37 PM
 * 项目： main-pom
 * 描述： 充值响应
 */
public class XzbAlipayRechargeResponse extends XzbResponse implements Serializable {

    /** 充值金额 */
    private Long payAmount;

    /** 充值账户账号 */
    private String rechargeAlipayNick;

    public String getRechargeAlipayNick() {
        return rechargeAlipayNick;
    }

    public void setRechargeAlipayNick(String rechargeAlipayNick) {
        this.rechargeAlipayNick = rechargeAlipayNick;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }
}
