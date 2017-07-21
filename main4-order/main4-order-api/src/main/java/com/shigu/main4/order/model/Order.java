package com.shigu.main4.order.model;

import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.order.vo.PayedVO;
import com.shigu.main4.order.vo.SubOrderVO;

import java.util.List;

/**
 * 订单
 * Created by zhaohongbo on 17/6/1.
 */
public interface Order{
    /**
     * 支付申请
     * @param payType 支付类别
     * @return
     */
    PayApplyVO payApply(PayType payType);

    /**
     * 追加子订单
     * @param subOrders 子订单
     */
    void addSubOrder(List<SubOrderVO> subOrders);

    /**
     * 二次支付申请
     * @param type 支付类型
     * @return
     */
    PayApplyVO repayApply(PayType type);

    /**
     * 已支付的情况查询
     * @return
     */
    List<PayedVO> payedInfo();

    /**
     * 付款确认
     * @param applyId
     * @param money
     * @return
     */
    Long pay(Long applyId,Long money);

    /**
     * 全单退订
     * @param money
     */
    void refunds(Long money);

    /**
     * 添加备注
     * @param msg
     */
    void addMark(String msg);

    /**
     * 支付完成
     */
    void payed();//支付完成

    /**
     * 交易完成
     */
    void finished();//交易完成

    /**
     * 交易关闭
     */
    void closed();//交易关闭
}
