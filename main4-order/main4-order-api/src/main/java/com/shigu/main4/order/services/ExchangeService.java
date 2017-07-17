package com.shigu.main4.order.services;

import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.RefundLogVO;
import com.shigu.main4.order.vo.*;

import java.util.List;

/**
 * @类编号
 * @类名称：ExchangeService
 * @文件路径：com.shigu.main4.order.services.ExchangeService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/14 17:19
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public interface ExchangeService {

    /**
     * ====================================================================================
     * @方法名：exchangeApply
     * @功能： 换货申请
     * @param: orderChildId 订单子单id，refundReason退货换原因  refundDesc退款说明
     * @return: refundId 退换货ID
     * @exception: 
     * ====================================================================================
     * 
     */
    Long exchangeApply(Long orderChildId, String refundReason, String refundDesc);

    /**
     * ====================================================================================
     * @方法名：selectExpress
     * @功能： 查询快递公司
     * @param:
     * @return: 快递公司列表
     * @exception:
     * ====================================================================================
     *
     */
    List<ExpressVo> selectExpress();
    /**
     * ====================================================================================
     * @方法名：chooseExpress
     * @功能： 选择快递公司
     * @param: refundId 退换货id expressId快递公司id，expressCode快递单号
     * @return: 返回
     * @exception:
     * ====================================================================================
     *
     */
    ReturnableExpressInfoVO chooseExpress(Long refundId, Long  expressId, String expressCode);

    /**
     * ====================================================================================
     * @方法名：modifyExpress
     * @功能： 修改快递公司
     * @param: refundId 退换货id   expressId快递公司id，expressCode快递单号
     * @return: 返回
     * @exception:
    * ====================================================================================
    *
    */
    ReturnableExpressInfoVO modifyExpress(Long refundId, Long  expressId, String expressCode);

    /**
     * 换货日志
     * @param refundId
     * @return
     */
    List<RefundLogVO> exchangeLog(Long refundId);

    /**
     * 换货地址
     * @param refundId
     * @return
     */
    ReturnableAddressVO exchangeAddress(Long refundId);

    /**
     * 换货简要信息
     * @param refundId
     * @return
     */
    ReturnableExpressInfoVO exchangeExpressInfo(Long refundId);

    /**
     * 快递日志列表
     * @param refundId
     * @return
     */
    List<ExpressLogVO> exchangeExpressLogs(Long refundId);

    /**
     * 换货状态信息
     * @param refundId
     * @return
     */
    ExchangeInfoVO exchangeInfo(Long refundId);
}
