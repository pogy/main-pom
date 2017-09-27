package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 类名：RefundHasItemMessage
 * 类路径：com.shigu.main4.order.mq.msg.RefundHasItemMessage
 * 创建者：王浩翔
 * 创建时间：2017-09-26 16:54
 * 项目：main-pom
 * 描述：代发已拿到货退款
 */
public class RefundHasItemMessage implements Serializable {
    //拆单id
    private Long psoid;
    //发起的金额(分)
    private Long money;

    public Long getPsoid() {
        return psoid;
    }

    public void setPsoid(Long psoid) {
        this.psoid = psoid;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
