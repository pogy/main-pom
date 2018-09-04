package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.order.mq.msg
 * @ClassName: UpdateExpressCodeMessage
 * @Author: sy
 * @CreateDate: 2018/8/22 0022 13:59
 */
public class UpdateExpressCodeMessage implements Serializable{

    private Long orderId;
    private String expressCode;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
}
