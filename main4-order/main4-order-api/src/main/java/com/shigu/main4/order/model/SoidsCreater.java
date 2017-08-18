package com.shigu.main4.order.model;

import com.shigu.main4.order.exceptions.OrderException;

import java.util.List;

/**
 * 订单生成
 */
public interface SoidsCreater {

    List<Long> makeSoidps(Long soid,Integer number);
    /**
     * 产生soidps
     * 如果有，查询
     * 如果没有创建
     * 如果不足，创建
     * 如果多出，异常
     * @param soid
     * @return
     */
    List<Long> soidToSoidps(Long soid);

    /**
     * 按soidp查soid
     * @param soidp
     * @return
     */
    Long selSoidBySoidp(Long soidp);
}
