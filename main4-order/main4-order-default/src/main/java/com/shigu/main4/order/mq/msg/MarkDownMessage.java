package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * Created by gtx on 2018/5/23.
 * 商品下架
 * @author gtx
 * @description
 * @since
 */
public class MarkDownMessage implements Serializable {
    /**
     * 拆单id
      */
    private Long orderPartitionId;

    public Long getOrderPartitionId() {
        return orderPartitionId;
    }

    public void setOrderPartitionId(Long orderPartitionId) {
        this.orderPartitionId = orderPartitionId;
    }
}
