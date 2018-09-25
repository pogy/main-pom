package com.shigu.main4.pay.responses;

import java.io.Serializable;

/**
 * 类名：XzbAlipayToCashEdResponse
 * 类路径： com.shigu.main4.pay.responses.XzbAlipayToCashEdResponse
 * 创建者： whx
 * 创建时间： 8/7/18 4:02 PM
 * 项目： main-pom
 * 描述： 星座宝提现
 */
public class XzbAlipayToCashEdResponse extends XzbResponse implements Serializable {
    /** 实际打款 */
    private Long actualAmount;

    /** 手续费 */
    private Long feeAmount;

    public Long getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Long actualAmount) {
        this.actualAmount = actualAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }
}
