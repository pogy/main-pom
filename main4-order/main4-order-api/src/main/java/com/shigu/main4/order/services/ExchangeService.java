package com.shigu.main4.order.services;

import com.shigu.main4.order.vo.ChooseEcpressVo;
import com.shigu.main4.order.vo.ExchangeApplyVo;
import com.shigu.main4.order.vo.ExchangeVo;
import com.shigu.main4.order.vo.ExpressVo;

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
     * @方法名： exchange
     * @功能： 换货展现
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    ExchangeVo exchange(Long orderChildId);


    /**
     * ====================================================================================
     * @方法名：exchangeApply
     * @功能： 换货申请
     * @param: orderChildId 订单子单id，refundReason退货换原因  refundDesc退款说明
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    ExchangeApplyVo exchangeApply(Long orderChildId, String refundReason, String refundDesc);

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
     * @param: orderChildId 订单子单id   expressId快递公司id，expressCode快递单号
     * @return: 返回
     * @exception: 
     * ====================================================================================
     * 
     */
    ChooseEcpressVo chooseExpress(Long orderChildId	, Long  expressId, String expressCode);

    /**
     * ====================================================================================
     * @方法名：modifyExpress
     * @功能： 修改快递公司
     * @param: orderChildId 订单子单id   expressId快递公司id，expressCode快递单号
     * @return: 返回
     * @exception:
     * ====================================================================================
     *
     */
    ChooseEcpressVo modifyExpress(Long orderChildId	, Long  expressId, String expressCode);
    /**
     * ====================================================================================
     * @方法名：exchangeFinish
     * @功能： 换货完成
     * @param: orderChildId 订单子单id
     * @return: 返回换货完成
     * @exception: 
     * ====================================================================================
     * 
     */
    ExchangeVo exchangeFinish(Long orderChildId);
}
