package com.shigu.main4.order.services;

import com.shigu.main4.order.enums.ShStatusEnum;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.vo.ExpressVo;
import com.shigu.main4.order.vo.ReturnableAddressVO;

import java.util.List;

/**
 * Created by zf on 2017/7/26.
 */
public interface AfterSaleService {
    /**
     * 售后页面的子单简单数据
     * @create: zf
     * @param subOrderId:订单子单id
     * @return
     */
    SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrder(Long subOrderId);

    /**
     * 售后页面的主单简要数据
     * @create: zf
     * @param subOrderId:订单子单id
     * @return
     */
    AfterSaleSimpleOrderVO afterSaleSimpleOrder(Long subOrderId);

    /**
     * 获取该子单还可退的款
     * @param subOrderId:订单子单id
     * @return refundablePrice:可退的金额
     */
    Long refundablePrice(Long subOrderId);

    /**
     * 申请退货退款
     * @create: zf
     * @param subOrderId:订单子单id
     * @param refundCount:退货件数
     * @param refundMoney:退货金额
     * @param refundReason:退货原因
     * @param refundDesc:退款说明
     * @return refundId:退换货id
     */
    Long returnGoodsApply(Long subOrderId,int refundCount,String refundMoney,String refundReason,String refundDesc);

    /**
     * 换货申请
     * @create: zf
     * @param subOrderId:子单ID
     * @param refundReason:换货原因
     * @param refundDesc:换货说明
     * @return refundId:退换货id
     */
    Long exchangeApply(Long subOrderId, String refundReason, String refundDesc);

    /**
     * 获取售后类型
     * @create: zf
     * @param refundId:退换货id
     * @return
     */
    ShStatusEnum queryAfterSaleType(Long refundId);



    /**
     * 获取当前售后状态
     * @create: zf
     * @param refundId:退换货id
     * @return
     */
    AfterSaleStatusVO afterSaleStatus(Long refundId);

    /**
     * 获取退款信息
     * 根据售后ID获取退款金额(该refundId下的金额,不校验是否真正完成退款)
     * @create: zf
     * @param refundId:退换货id
     * @return
     */
    AfterSaleInfoVO afterSaleInfo(Long refundId);

    /**
     * 申请记录
     * @create: zf
     * @param refundId:退换货id
     * @return
     */
    List<RefundLogVO> afterSaleApplication(Long refundId);

    /**
     * 退货地址
     * @create: zf
     * @param refundId:退换货id
     * @return
     */
    ReturnableAddressVO retrunGoodsAddress(Long refundId);

    /**
     * ====================================================================================
     * 查询快递公司
     * @create: zf
     * @return:
     */
    List<ExpressVo> selectExpress();

    /**
     * 选择快递公司并提交
     * @create: zf
     * @param refundId:退换货id
     * @param expressId:快递公司id
     * @param expressCode:快递单号
     */
    void chooseExpress(Long refundId, Long  expressId, String expressCode);

    /**
     * 获取已填写的快递信息
     * @create: zf
     * @param refundId:退换货id
     * @return
     */
    ReturnableExpressInfoVO queryExpress(Long refundId);

    /**
     * ====================================================================================
     * 修改快递公司
     * @create: zf
     * @param: refundId 退换货id   expressId快递公司id，expressCode快递单号
     * @return:
     */
    void modifyExpress(Long refundId, Long  expressId, String expressCode);

    /**
     * 退货简要信息
     * @create: zf
     * @param refundId:退换货id
     * @return
     */
    ReturnableExpressInfoVO retrunGoodsExpressInfo(Long refundId);

    /**
     * 同意(拒绝)退款金额
     * @create: zf
     * @param isAgree
     * @param refundId:退换货id
     */
    void agreeOrRejectRefundPrice(Long refundId,boolean isAgree);
}
