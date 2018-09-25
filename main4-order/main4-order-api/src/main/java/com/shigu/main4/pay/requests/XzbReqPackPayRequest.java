package com.shigu.main4.pay.requests;

import java.io.Serializable;

/**
 * 类名：XzbReqPackPayRequest
 * 类路径： com.shigu.main4.pay.requests.XzbReqPackPayRequest
 * 创建者： whx
 * 创建时间： 8/10/18 6:48 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbReqPackPayRequest implements Serializable {

    /** 订单总金额 */
    private Long payAmount;

    /** 用户ID */
    private Long xzUserId;

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public Long getXzUserId() {
        return xzUserId;
    }

    public void setXzUserId(Long xzUserId) {
        this.xzUserId = xzUserId;
    }
}
