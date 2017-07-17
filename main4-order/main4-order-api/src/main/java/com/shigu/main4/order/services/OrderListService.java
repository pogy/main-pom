package com.shigu.main4.order.services;

import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.vo.OrderVO;


import java.util.List;

/**
 * @类编号
 * @类名称：OrderListService
 * @文件路径：com.shigu.main4.order.services.OrderListService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/14 16:37
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public interface OrderListService {
    /**
     * ====================================================================================
     * @方法名：myOrder
     * @功能： 我的订单
     * @param: vo查询条件  vo一定要有所有订单，待付款，已付款，配货中，交易完成，交易关闭的标记
     * @return: 返回订单列表
     * @exception: 
     * ====================================================================================
     * 
     */
    List<OrderVO> myOrder(OrderBO bo);
    /**
     * ====================================================================================
     * @方法名：payTaoOrder
     * @功能： 立即付款
     * @param: tbid
     * @return: 返回到支付方式页面
     * @exception: 
     * ====================================================================================
     * 
     */
    Long payTaoOrder(Long tbid);

    /**
     * ====================================================================================
     * @方法名：removeOrder
     * @功能： 删除订单
     * @param: tbid 订单ID
     * @return: 如果大于0就删除成功
     * @exception: 
     * ====================================================================================
     * 
     */
    int removeOrder(Long tbid);

}
