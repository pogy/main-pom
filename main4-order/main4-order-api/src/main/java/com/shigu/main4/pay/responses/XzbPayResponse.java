package com.shigu.main4.pay.responses;

import java.io.Serializable;

/**
 * 类名：XzbPayResponse
 * 类路径： com.shigu.main4.pay.responses.XzbPayResponse
 * 创建者： whx
 * 创建时间： 8/7/18 3:46 PM
 * 项目： main-pom
 * 描述： 星座宝支付返回
 */
public class XzbPayResponse extends XzbResponse implements Serializable {
    private Long payId;

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
}
