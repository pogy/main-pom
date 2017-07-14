package com.shigu.main4.order.services;

import com.shigu.main4.order.servicevo.ExpressInfoVO;
import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.OrderInfoVO;
import com.shigu.main4.order.servicevo.OrderLogVO;
import com.shigu.main4.order.servicevo.RefundInfoVO;
import com.shigu.main4.order.servicevo.RefundLogVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;

import java.util.List;

/**
 *
 * Created by zhaohongbo on 17/7/14.
 */
public interface OrderService2 {
    /**
     * 查询订单的物流信息
     * @param orderId
     * @return
     */
    ExpressInfoVO expressInfo(Long orderId);

    /**
     * 查询物流日志
     * @param expressId
     * @return
     */
    List<ExpressLogVO> expressLog(Long expressId);

    /**
     * 子订单信息
     * @param subOrderId
     * @return
     */
    SubOrderInfoVO suborderInfo(Long subOrderId);

    /**
     * 主单简要信息
     * 不包含子单
     * @param orderId
     * @return
     */
    OrderInfoVO orderInfo(Long orderId);

    /**
     * 订单日志
     * @param orderId
     * @return
     */
    List<OrderLogVO> orderLog(Long orderId);

    /**
     * 子订单信息,按主单查
     * @param orderId
     * @return
     */
    List<SubOrderInfoVO> suborderInfoByOrderId(Long orderId);

    /**
     * 申请退款
     * @param subOrderId
     * @param number
     * @return 退款编号
     */
    Long refundApply(Long subOrderId,Integer number);

    /**
     * 退款信息查询
     * @param refundId
     * @return
     */
    RefundInfoVO refundInfo(Long refundId);

    /**
     * 退款信息日志
     * @param refundId
     * @return
     */
    List<RefundLogVO> refundLog(Long refundId);

}
