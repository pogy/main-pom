package com.shigu.main4.order.services;

import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.RefundLogVO;
import com.shigu.main4.order.servicevo.ReturnableExpressInfoVO;
import com.shigu.main4.order.servicevo.ReturnGoodsInfoVO;
import com.shigu.main4.order.vo.ApplyOperaterVo;
import com.shigu.main4.order.vo.ReturnableAddressVO;

import java.util.List;

/**
 * @类编号
 * @类名称：ReturnGoodsService
 * @文件路径：com.shigu.main4.order.services.ReturnGoodsService
 * @内容摘要：退货
 * @编码作者：gzy
 * @创建日期：2017/7/14 17:56
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public interface ReturnGoodsService {

    /**
     * ====================================================================================
     * @方法名：returnGoodsApply
     * @create: zf
     * @功能： 退货申请
     * @param: orderChildId订单子单id，refundCount退货件数，refundMoney退货金额，refundReason退货换原因，refundDesc退款说明
     * @return: refundId
     * @exception: 
     * ====================================================================================
     * 
     */
    Long returnGoodsApply(Long orderChildId,int refundCount,String refundMoney,String refundReason,String refundDesc);
    /**
     * ====================================================================================
     * @方法名：chooseExpress
     * @create: zf
     * @功能： 选择快递公司并提交
     * @param: refundId 退换货id  expressId快递公司id，expressCode快递单号
     * @return: 返回
     * @exception:
     * ====================================================================================
     *
     */
    ReturnableExpressInfoVO chooseExpress(Long refundId, Long  expressId, String expressCode);

    /**
     * ====================================================================================
     * @方法名：modifyExpress
     * @create: zf
     * @功能： 修改快递公司
     * @param: refundId 退换货id   expressId快递公司id，expressCode快递单号
     * @return: 返回
     * @exception:
     * ====================================================================================
     *
     */
    ReturnableExpressInfoVO modifyExpress(Long refundId	, Long  expressId, String expressCode);

    /**
     * 退货日志
     * @create: zf
     * @param refundId
     * @return
     */
    List<RefundLogVO> retrunGoodsLog(Long refundId);

    /**
     * 退货地址
     * @create: zf
     * @param refundId
     * @return
     */
    ReturnableAddressVO retrunGoodsAddress(Long refundId);

    /**
     * 退货简要信息
     * @create: zf
     * @param refundId
     * @return
     */
    ReturnableExpressInfoVO retrunGoodsExpressInfo(Long refundId);

    /**
     * 快递日志列表
     * @create: zf
     * @param refundId
     * @return
     */
    List<ExpressLogVO> retrunGoodsExpressLogs(Long refundId);

    /**
     * 退货状态信息
     * @create: zf
     * @param refundId
     * @return
     */
    ReturnGoodsInfoVO retrunGoodsInfo(Long refundId);

    /**
     * 查询操作员操作记录
     * @param refundId 申请退款id
     * @return collection
     */
    List<ApplyOperaterVo> returnGoodsOperater(Long refundId);

    /**
     * 查询子单id
     * @param refundId 申请退货id
     * @return long
     */
    Long selChildOrderId(Long refundId);
}
