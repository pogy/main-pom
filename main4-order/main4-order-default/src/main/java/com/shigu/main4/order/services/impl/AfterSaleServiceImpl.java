package com.shigu.main4.order.services.impl;

import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.interfaces.ExpressCompanyMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.model.SubItemOrder;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.zfenums.*;
import com.shigu.main4.tools.SpringBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class AfterSaleServiceImpl implements AfterSaleService{

    private static final Logger logger = LoggerFactory.getLogger(AfterSaleServiceImpl.class);

    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;

    /**
     * 售后页面的子单简单数据
     *
     * @param subOrderId :订单子单id
     * @return
     * @create: zf
     */
    @Override
    public SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrder(Long subOrderId) {
        SubItemOrder subItemOrder = SpringBeanFactory.getBean(SubItemOrder.class, subOrderId);
        SubItemOrderVO subItemOrderVO = subItemOrder.subOrderInfo();
        ItemProductVO product = subItemOrderVO.getProduct();
        SubAfterSaleSimpleOrderVO vo = BeanMapper.map(subItemOrderVO, SubAfterSaleSimpleOrderVO.class);
        vo.setSubOrderId(subItemOrderVO.getSoid());
        vo.setPicUrl(product.getPicUrl());
        vo.setPrice(product.getPrice());
        vo.setRefundNum(0);
        for (RefundTypeEnum type: RefundTypeEnum.values()) {
            RefundVO refundVO = subItemOrder.refundInfos(type);
            if (refundVO != null) {
                vo.setRefundNum(vo.getRefundNum() + refundVO.getNumber());
            }
        }
        vo.setOtherRefundPrice(0L);

        Long oid = subItemOrderVO.getOid();
        ItemOrder order = SpringBeanFactory.getBean(ItemOrder.class, oid);
        List<Long> allSubId = order.subOrdersInfo().stream().map(SubItemOrderVO::getSoid).collect(Collectors.toList());
        ItemOrderRefund refund = new ItemOrderRefund();
        refund.setOid(oid);
        allSubId.removeAll(itemOrderRefundMapper.select(refund).stream().map(ItemOrderRefund::getSoid).distinct().collect(Collectors.toList()));
        if (allSubId.size() == 1 && allSubId.get(0).equals(subOrderId)) {
            vo.setOtherRefundPrice(order.orderOtherAmount());
        }
        return vo;
    }

    /**
     * 售后页面的主单简要数据
     *
     * @param subOrderId :订单子单id
     * @return
     * @create: zf
     */
    @Override
    public AfterSaleSimpleOrderVO afterSaleSimpleOrder(Long subOrderId) {
        SubItemOrder subItemOrder = SpringBeanFactory.getBean(SubItemOrder.class, subOrderId);
        Long oid = subItemOrder.subOrderInfo().getOid();
        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, oid);
        ItemOrderVO itemOrderVO = itemOrder.orderInfo();

        AfterSaleSimpleOrderVO vo = new AfterSaleSimpleOrderVO();
        vo.setOrderId(itemOrderVO.getOrderId());
        vo.setEndDate(DateUtil.dateToString(itemOrderVO.getCreateTime(), DateUtil.patternD));
        vo.setOrderPrice(itemOrder.subOrdersInfo().stream().mapToLong(o -> o.getProduct().getPrice()).sum());
        vo.setExpressPrice(itemOrder.selLogisticses().get(0).getMoney());
        vo.setServicePrice(itemOrder.selServices().get(0).getMoney());
        vo.setTotalPrice(itemOrderVO.getTotalFee());
        return vo;
    }

    /**
     * 售前退款申请
     *
     * @param subOrderId
     * @param refundCount
     * @param refundMoney
     * @return
     */
    @Override
    public Long preRefundApply(Long subOrderId, int refundCount, Long refundMoney) throws OrderException {
        return SpringBeanFactory.getBean(SubItemOrder.class, subOrderId)
                .refundApply(1, refundCount, refundMoney, "发起退款申请");
    }


    /**
     * 申请退货退款
     *
     * @param subOrderId   :订单子单id
     * @param refundCount  :退货件数
     * @param refundMoney  :退货金额
     * @param refundReason :退货原因
     * @param refundDesc   :退款说明
     * @return refundId:退换货id
     * @create: zf
     */
    @Override
    public Long returnGoodsApply(Long subOrderId, int refundCount, Long refundMoney,String refundReason, String refundDesc) throws OrderException {
        return SpringBeanFactory.getBean(SubItemOrder.class, subOrderId)
                .refundApply(2, refundCount, refundMoney, refundReason+"@_@"+refundDesc);
    }

    /**
     * 换货申请
     *
     * @param subOrderId   :子单ID
     * @param refundReason :换货原因
     * @param refundDesc   :换货说明
     * @return refundId:退换货id
     * @create: zf
     */
    @Override
    public Long exchangeApply(Long subOrderId, String refundReason, String refundDesc) throws OrderException {
        return SpringBeanFactory.getBean(SubItemOrder.class, subOrderId)
                .refundApply(3, -1, -1L, refundReason+"@_@"+refundDesc);
    }

    /**
     * 获取售后类型
     *
     * @param refundId :退换货id
     * @return
     * @create: zf
     */
    @Override
    public ShStatusEnum queryAfterSaleType(Long refundId) {
        return SpringBeanFactory.getBean(RefundItemOrder.class, refundId).refundinfo().getType() == 3 ? ShStatusEnum.CHANGE : ShStatusEnum.REFUND;
    }

    /**
     * 获取当前售后状态
     *
     * @param refundId :退换货id
     * @return
     * @create: zf
     */
    @Override
    public AfterSaleStatusVO afterSaleStatus(Long refundId) {
        RefundVO refundinfo = SpringBeanFactory.getBean(RefundItemOrder.class, refundId).refundinfo();

        AfterSaleStatusVO statusVo = new AfterSaleStatusVO();
        statusVo.setSubOrderId(refundinfo.getSoid());
        ReturnGoodsStatusEnum afterSaleStatus = ReturnGoodsStatusEnum.DISPOSE_RETRUN_GOODS;
        switch (refundinfo.getRefundState()) {
            case APPLY_REFUND:
                break;
            case DISPOSE_REFUND:
                afterSaleStatus = ReturnGoodsStatusEnum.AGREE_PROCESS;
                break;
            case ENT_REFUND:
                afterSaleStatus = ReturnGoodsStatusEnum.RETURN_ENT;
                break;
            case SELLER_REFUND:
                afterSaleStatus = ReturnGoodsStatusEnum.REFUSE_PROCESS;
                break;
            case NOT_REFUND:
                //TODO: 该状态没有对应
                throw new IllegalStateException(String.format("该状态没有对应: state[%s]", RefundStateEnum.BUYER_NOREPRICE));
            case BUYER_SEND:
                afterSaleStatus = ReturnGoodsStatusEnum.EXPRESS_SUBMIT;
                break;
            case SELLER_CACHED:
                afterSaleStatus = ReturnGoodsStatusEnum.EXPRESS_SUBMIT;
                break;
            case SELLER_REPRICE:
                afterSaleStatus = ReturnGoodsStatusEnum.REFUND_MONEY_CHANGED;
                break;
            case BUYER_NOREPRICE:
                afterSaleStatus = ReturnGoodsStatusEnum.REFUSE_MONEY_CHANGED;
                break;
        }
        statusVo.setAfterSaleStatus(afterSaleStatus);
        statusVo.setContent(refundinfo.getReason());
        statusVo.setModifyRefundPrice(refundinfo.getSellerProposalMoney());
        return statusVo;
    }

    /**
     * 获取退款信息
     * 根据售后ID获取退款金额(该refundId下的金额,不校验是否真正完成退款)
     *
     * @param refundId :退换货id
     * @return
     * @create: zf
     */
    @Override
    public AfterSaleInfoVO afterSaleInfo(Long refundId) {
        RefundVO refundinfo = SpringBeanFactory.getBean(RefundItemOrder.class, refundId).refundinfo();
        AfterSaleInfoVO infoVO = new AfterSaleInfoVO();
        infoVO.setRefundId(refundId);
        //如果退完成,返回实际退款
        if(refundinfo.getRefundState().equals(RefundStateEnum.ENT_REFUND)){
            infoVO.setRefundPrice(refundinfo.getRefundMoney());
        }else{
            infoVO.setRefundPrice(refundinfo.getHopeMoney());
        }
        return infoVO;
    }

    /**
     * 申请记录
     *
     * @param refundId :退换货id
     * @return
     * @create: zf
     */
    @Override
    public List<RefundLogVO> afterSaleApplication(Long refundId) {
        List<RefundProcessVO> refundProcessVOS = SpringBeanFactory.getBean(RefundItemOrder.class, refundId).refundLogs();
        return refundProcessVOS.stream().map(o -> {
            RefundLogVO vo = new RefundLogVO();
            vo.setLogTime(DateUtil.dateToString(o.getCreateTime(), null));
            vo.setLogDesc(o.getMsg());
            vo.setUserType(o.getImBuyer() ? UserTypeEnum.BUYER : UserTypeEnum.CUSTOM_SERVICE);
            vo.setHeadImgUrl("");// TODO:期待一个默认头像
            vo.setUserNick(o.getImBuyer() ? "你" : "卖家");
            return vo;
        }).collect(Collectors.toList());
    }

    /**
     * 退货地址
     *
     * @param refundId :退换货id
     * @return
     * @create: zf
     */
    @Override
    public ReturnableAddressVO retrunGoodsAddress(Long refundId) {
        Long oid = SpringBeanFactory.getBean(RefundItemOrder.class, refundId).refundinfo().getOid();
        SenderVO senderVO = SpringBeanFactory.getBean(ItemOrder.class, oid).selSender();

        ReturnableAddressVO vo = new ReturnableAddressVO();
        vo.setReceiverAddress(senderVO.getAddress());
        vo.setReceiverName(senderVO.getName());
        vo.setReceiverPhone(senderVO.getTelephone());
        return vo;
    }

    /**
     * ====================================================================================
     * 查询快递公司
     *
     * @create: zf
     * @return:
     */
    @Override
    public List<ExpressVo> selectExpress() {
        throw new RuntimeException("what are you 弄啥咧.");
    }

    /**
     * 选择快递公司并提交
     *
     * @param refundId    :退换货id
     * @param expressId   :快递公司id
     * @param expressCode :快递单号
     * @create: zf
     */
    @Override
    public void chooseExpress(Long refundId, Long expressId, String expressCode) {
        SpringBeanFactory.getBean(RefundItemOrder.class, refundId).userSended(expressCode);
    }

    /**
     * 获取已填写的快递信息
     *
     * @param refundId :退换货id
     * @return
     * @create: zf
     */
    @Override
    public ReturnableExpressInfoVO queryExpress(Long refundId) throws Main4Exception {
        RefundVO refundinfo = SpringBeanFactory.getBean(RefundItemOrder.class, refundId).refundinfo();

        ReturnableExpressInfoVO vo = new ReturnableExpressInfoVO();
        String[] buyerCourier = refundinfo.getBuyerCourier().split(":");
        vo.setExpressCode(refundinfo.getBuyerCourier());
        vo.setExpressName("");// TODO：没有保存退货发货的公司
        vo.setReturnableExpressTime(refundinfo.getBuyerReturnTime()!=null?refundinfo.getBuyerReturnTime().getTime():null);
//        try {
//            vo.setExpressDetails(itemOrderService.expressLog("", refundinfo.getBuyerCourier()));
//        } catch (ParseException e) {
//            throw new Main4Exception(e.getMessage());
//        }
        return vo;
    }

    /**
     * ====================================================================================
     * 修改快递公司
     *
     * @param refundId
     * @param expressId
     * @param expressCode
     * @create: zf
     * @param: refundId 退换货id   expressId快递公司id，expressCode快递单号
     * @return:
     */
    @Override
    public void modifyExpress(Long refundId, Long expressId, String expressCode) {
        chooseExpress(refundId, expressId, expressCode);
    }

    /**
     * 退货简要信息
     *
     * @param refundId :退换货id
     * @return
     * @create: zf
     */
    @Override
    public ReturnableExpressInfoVO retrunGoodsExpressInfo(Long refundId) throws Main4Exception {
        return queryExpress(refundId);
    }

    /**
     * 同意(拒绝)退款金额
     *
     * @param refundId :退换货id
     * @param isAgree
     * @create: zf
     */
    @Override
    public void agreeOrRejectRefundPrice(Long refundId, boolean isAgree) throws Main4Exception {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, refundId);
        if (isAgree) {
            refundItemOrder.buyerReprice();
        } else {
            refundItemOrder.buyerNoReprice();
        }
    }

    /**
     * 售后结束信息(结束时间,如果是退货退款的单,还返回钱款去向数据)
     *
     * @param refundId
     * @return
     */
    @Override
    public AfterSaleEntVO afterEnt(Long refundId) {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, refundId);
        RefundVO refundinfo = refundItemOrder.refundinfo();
        AfterSaleEntVO vo = new AfterSaleEntVO();
        vo.setAfterSeleEntDate("售后流程未完成");
        if (refundinfo.getRefundState() == RefundStateEnum.ENT_REFUND) {
            List<RefundProcessVO> refundProcessVOS = refundItemOrder.refundLogs();
            if (!refundProcessVOS.isEmpty()) {
                RefundProcessVO refundProcessVO = refundProcessVOS.get(refundProcessVOS.size() - 1);
                vo.setAfterSeleEntDate(DateUtil.dateToString(refundProcessVO.getCreateTime(), null));
            }
        }
        if (refundinfo.getType() != 3) {
            vo.setPrice(refundinfo.getRefundMoney());
            vo.setPriceGoto("原路退回");
        }
        return vo;
    }
}
