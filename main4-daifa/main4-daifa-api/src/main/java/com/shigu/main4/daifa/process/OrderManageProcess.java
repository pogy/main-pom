package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.bo.OrderBO;

import java.util.Date;

/**
 * 订单管理
 * Created by zhaohongbo on 17/8/8.
 */
public interface OrderManageProcess {
    /**
     * 新进单子
     * @param order
     */
    void newOrder(OrderBO order);

    /**
     * 子单备注
     * @param subOrderId
     * @param mark
     */
    void markSubOrder(Long subOrderId,String mark);

    /**
     * 设置有货时间
     * @param subOrderId
     * @param time
     */
    void haveGoodsTime(Long subOrderId,Date time);

    /**
     * 标记下架
     * @param subOrderId
     */
    void markDown(Long subOrderId);

    /**
     * 订单超时
     * @param orderId
     */
    void orderTimeout(Long orderId);
}
