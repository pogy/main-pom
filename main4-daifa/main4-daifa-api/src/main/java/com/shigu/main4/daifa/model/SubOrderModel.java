package com.shigu.main4.daifa.model;

import com.shigu.main4.daifa.exceptions.DaifaException;

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
     * cdkey
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
     * 备注
     * @param context
     */
    void mark(String context) throws  DaifaException;

    /**
     * 已拿到货(该方法会校验分配时间,必须是今天分配的数据)
     */
    void haveTake() throws DaifaException;

    /**
     * 缺货(该方法不校验分配时间,只要是已分配的,都可以被这里设置缺货)
     */
    void noTake() throws DaifaException;

    /**
     * 产生cdKey
     * @return cdKey
     */
    String cdkeyCreate();
}
