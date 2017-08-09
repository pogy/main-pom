package com.shigu.main4.daifa.model;

import java.util.Date;

/**
 * 子单
 * 多例,描述了一个子单的所有变化
 * 有直接构建子单与按子单ID构建两种
 * Created by zhaohongbo on 17/8/9.
 */
public interface SubOrderModel {
    /**
     * 创建子订单
     */
    void init();

    /**
     * 设置有货时间
     * @param time
     */
    void haveGoodsTime(Date time);

    /**
     * 标记下架
     */
    void markDown();

    /**
     * 已拿到货
     */
    void haveTake();

    /**
     * 缺货
     */
    void noTake();
}
