package com.shigu.main4.order.model;

/**
 * 子订单
 * Created by zhaohongbo on 17/6/1.
 */
public interface SubOrder{
    /**
     * 标记为已发
     */
    void sended();

    /**
     * 关闭子订单
     * 没支付前,使用关闭
     */
    void closed();
    /**
     * 退款
     * @param money
     */
    Long refund(Long money);

    /**
     * 添加备注
     * @param msg
     */
    void addMark(String msg);
}
