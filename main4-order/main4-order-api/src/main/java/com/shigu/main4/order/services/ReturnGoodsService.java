package com.shigu.main4.order.services;

import com.shigu.main4.order.vo.ChooseEcpressVo;
import com.shigu.main4.order.vo.ExpressVo;
import com.shigu.main4.order.vo.ReturnGoodsVo;

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
     * @方法名：returnGoodsIndex
     * @功能： 退货的展现页面
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    ReturnGoodsVo returnGoodsIndex(Long orderChildId);
    /**
     * ====================================================================================
     * @方法名：returnGoodsApply
     * @功能： 退货申请
     * @param: orderChildId订单子单id，refundCount退货件数，refundMoney退货金额，refundReason退货换原因，refundDesc退款说明
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    ReturnGoodsVo returnGoodsApply(Long orderChildId,int refundCount,String refundMoney,String refundReason,String refundDesc);

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
     * @方法名：returnGoodsFinish
     * @功能： 退货完成
     * @param: orderChildId 订单子单id
     * @return: 返回换货完成
     * @exception:
     * ====================================================================================
     *
     */
    ReturnGoodsVo returnGoodsFinish(Long orderChildId);

}
