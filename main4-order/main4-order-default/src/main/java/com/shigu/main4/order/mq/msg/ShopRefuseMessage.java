package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 类名：ShopRefuseMessage
 * 类路径：com.shigu.main4.order.mq.msg.ShopRefuseMessage
 * 创建者：王浩翔
 * 创建时间：2017-09-21 9:49
 * 项目：main-pom
 * 描述：退货失败消息
 */
public class ShopRefuseMessage implements Serializable {

    //售后id
    private Long refundId;
    //本次售后记录中退货失败总件数
    private Integer num;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
