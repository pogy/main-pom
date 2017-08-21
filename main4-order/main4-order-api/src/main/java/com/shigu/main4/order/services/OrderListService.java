package com.shigu.main4.order.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.servicevo.OrderDetailTotalVO;
import com.shigu.main4.order.servicevo.ShowOrderDetailVO;
import com.shigu.main4.order.servicevo.ShowOrderVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.vo.OrderAddrInfoVO;
import com.shigu.main4.order.vo.OrderDetailExpressVO;
import com.shigu.main4.order.zfenums.ShStatusEnum;

import java.text.ParseException;
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
     *
     * 查询售后列表
     * @param shStatus
     * @param page
     * @param pageSize
     * @param userId
     * @return
     */
    ShiguPager<ShowOrderVO> selectCountShManaOrder(ShStatusEnum shStatus,Integer page,Integer pageSize, Long userId) throws ParseException;


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
     * @方法名：selectOrderAddrInfo
     * @功能： 查询订单地址信息
     * @param: 
     * @return:
     * @exception:
     * ====================================================================================
     * 
     */
    OrderAddrInfoVO selectOrderAddrInfo(Long orderId);

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
    OrderDetailExpressVO selectExpress(Long orderId) throws Main4Exception, ParseException, Main4Exception, ParseException;//

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

    /**
     * ====================================================================================
     * @方法名：selectSubList
     * @功能： 根据主单id查询出子单列表
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    List<SubOrderInfoVO> selectSubList(Long orderId);

    /**
     * ====================================================================================
     * @方法名：selectTotal
     * @功能： 根据主单查询总数
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    OrderDetailTotalVO selectTotal(Long orderId);


}