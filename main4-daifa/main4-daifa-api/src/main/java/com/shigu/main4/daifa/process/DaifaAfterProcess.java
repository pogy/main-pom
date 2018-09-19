package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.exceptions.DaifaException;

/**
 * Created by zyl on 2018/9/17 0017.
 *
 * @author zyl
 * @description
 * @since
 */
public interface DaifaAfterProcess {
    /**
     * 1,代发订单中:
     * 1.1,如果用户发起售后，最后没有提交快递单啥这种订单，自发起售后第一步之后30天,状态转为8
     * 1.2,如果用户之后填写快递,则转为用户已发货
     * 2、退款问题，一个月为结束时间,状态转为9
     * 2.1、如果状态为5(档口已退款),则直接判断是否超过1个月 apply_time
     * 2.2、如果状态为7(用户拒绝),则判断最后一次修改价格的时间  create_time
     * 2.3、如果用户之后同意或拒绝,则转为该状态
     */

    void runRefundFee() throws DaifaException;

    void runReceiveGoods() throws DaifaException;
}
