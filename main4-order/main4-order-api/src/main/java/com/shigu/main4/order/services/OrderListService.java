package com.shigu.main4.order.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.servicevo.OrderDetailTotalVO;
import com.shigu.main4.order.servicevo.ShowOrderDetailVO;
import com.shigu.main4.order.vo.OrderDetailExpressVO;

import java.text.ParseException;

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
     * @方法名：removeOrder
     * @功能： 删除订单
     * @param: orderId 订单ID
     * @return: 如果大于0就删除成功
     * @exception: 
     * ====================================================================================
     * 
     */
    int removeOrder(Long orderId);

    /**
     * ====================================================================================
     * @方法名：取消订单
     * @功能： 
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    int cancelOrder(Long orderId);

    /**
     * ====================================================================================
     * @方法名：selectExpress
     * @功能： 查询订单的快递信息
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    OrderDetailExpressVO selectExpress(Long orderId) throws Main4Exception, ParseException;//

    /**
     * ====================================================================================
     * @方法名：selectMyorder
     * @功能： 查询主订单的信息
     * @param: 
     * @return: 
     * @exception: 
     * ===============================================================================
     * 
     */
    ShowOrderDetailVO selectMyorder(Long orderId);


}