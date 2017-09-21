package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 类名：RepriceApplyMessage
 * 类路径：com.shigu.main4.order.mq.msg.RepriceApplyMessage
 * 创建者：王浩翔
 * 创建时间：2017-09-21 10:56
 * 项目：main-pom
 * 描述：议价申请
 */
public class RepriceApplyMessage implements Serializable {

    //退货ID
    private Long refundId;
    //店家能给的退货款
    private Long storeMoney;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getStoreMoney() {
        return storeMoney;
    }

    public void setStoreMoney(Long storeMoney) {
        this.storeMoney = storeMoney;
    }
}
