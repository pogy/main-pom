package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.bo.OrderBO;
import com.shigu.main4.daifa.exceptions.DaifaException;

import java.util.Date;
import java.util.List;

/**
 * 订单管理
 * Created by zhaohongbo on 17/8/8.
 */
public interface OrderManageProcess {
    /**
     * 新进单子
     * @param order 订单数据
     */
    void newOrder(OrderBO order);

    /**
     * 子单备注
     * @param subOrderId 子订单数据
     * @param mark 备注内容
     */
    void markSubOrder(Long subOrderId,String mark) throws DaifaException;

    /**
     * 设置有货时间
     * @param subOrderId 子订单数据
     * @param time 有货时间
     */
    void haveGoodsTime(Long subOrderId,Date time) throws DaifaException;

    /**
     * 标记下架
     * @param subOrderId 子订单数据
     */
    void markDown(Long subOrderId) throws DaifaException;

    /**
     * 订单超时
     */
    void orderTimeout();

    /**
     * 尝试退款
     * @param outerSubOrderId 外部子订单号
     * @param num 要退的件数
     * @return true 为可退
     */
    boolean tryRefund(String outerSubOrderId,Integer num);

}
