package com.shigu.main4.order.services.impl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.examples.ItemOrderRefundExample;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.opentae.data.mall.interfaces.SubOrderSoidpsMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.model.SoidsCreater;
import com.shigu.main4.order.model.SubItemOrder;
import com.shigu.main4.order.mq.producter.OrderMessageProducter;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.zfenums.*;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
@Service("afterSaleService")
public class AfterSaleServiceImpl implements AfterSaleService {

    private static final Logger logger = LoggerFactory.getLogger(AfterSaleServiceImpl.class);

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    private OrderMessageProducter orderMessageProducter;

    @Autowired
    private OrderConstantService orderConstantService;

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private SubOrderSoidpsMapper subOrderSoidpsMapper;

    @Autowired
    private SoidsCreater soidsCreater;

    @Autowired
    private RedisIO redisIO;

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
        for (RefundTypeEnum type : RefundTypeEnum.values()) {
            RefundVO refundVO = subItemOrder.refundInfos(type);
            if (refundVO != null) {
                vo.setRefundNum(vo.getRefundNum() + (type.type==5?refundVO.getFailNumber():refundVO.getNumber()));
            }
        }
        vo.setOtherRefundPrice(0L);

        Long oid = subItemOrderVO.getOid();
        ItemOrder order = SpringBeanFactory.getBean(ItemOrder.class, oid);
        List<SubItemOrderVO> subOrders = order.subOrdersInfo();
        List<Long> allSubId = subOrders.stream().map(SubItemOrderVO::getSoid).collect(Collectors.toList());
        int allSubNum = subOrders.stream().mapToInt(SubItemOrderVO::getNum).sum();
        ItemOrderRefund refund = new ItemOrderRefund();
        refund.setOid(oid);
        List<ItemOrderRefund> refunds = itemOrderRefundMapper.select(refund);
        allSubId.removeAll(refunds.stream().map(ItemOrderRefund::getSoid).distinct().collect(Collectors.toList()));
        //除本单以外，其它全部已经退款成功
        int allrefunded = refunds.stream().mapToInt(ItemOrderRefund::getNumber).sum();
        //除本单外，其它都已退
        if (allrefunded == allSubNum - subItemOrderVO.getNum() && allSubId.size() == 1 && allSubId.get(0).equals(subOrderId)) {
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
        vo.setOrderPrice(itemOrder.subOrdersInfo().stream().mapToLong(o -> o.getProduct().getPrice() * o.getNum()).sum());
        List<LogisticsVO> logisticsVOS = itemOrder.selLogisticses();
        vo.setExpressPrice(logisticsVOS.isEmpty() ? 0L : logisticsVOS.get(0).getMoney());
        List<OrderServiceVO> orderServiceVOS = itemOrder.selServices();
        vo.setServicePrice(orderServiceVOS.isEmpty() ? 0L : orderServiceVOS.stream().mapToLong(OrderServiceVO::getMoney).sum());
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
        //1、本订单退过款，不能再发起
        ItemOrderRefundExample refundExample = new ItemOrderRefundExample();
        refundExample.createCriteria().andSoidEqualTo(subOrderId).andTypeEqualTo(RefundTypeEnum.ONLY_REFUND.type);
        if (itemOrderRefundMapper.countByExample(refundExample) > 0) {
            throw new OrderException("退款失败，同一子单不能发起两次退款");
        }
        Long refundId = SpringBeanFactory.getBean(SubItemOrder.class, subOrderId)
                .refundApply(1, refundCount, refundMoney, "发起退款申请");

        // 仅退款消息推送
        orderMessageProducter.orderRefundNoItem(refundId, subOrderId, new ArrayList<>(soidsCreater.soidToSoidps(subOrderId).subList(0, refundCount)));
        return refundId;
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
    public Long returnGoodsApply(Long subOrderId, int refundCount, Long refundMoney, String refundReason, String refundDesc) throws OrderException {
        if (hasReturnGoodsOrExchange(subOrderId)) {
            throw new OrderException("已经进行过退货/换货");
        }
        SubItemOrder subItemOrder = SpringBeanFactory.getBean(SubItemOrder.class, subOrderId);
        Long refundId = subItemOrder.refundApply(2, refundCount, refundMoney, refundReason + "," + refundDesc);
        ItemOrderSub itemOrderSub = itemOrderSubMapper.selectByPrimaryKey(subOrderId);
        orderMessageProducter.orderRefundHasItem(refundId, itemOrderSub.getOid(), subOrderId, refundCount, refundMoney, refundReason + "," + refundDesc, 1);
        return refundId;
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
        if (hasReturnGoodsOrExchange(subOrderId)) {
            throw new OrderException("已经进行过退货/换货");
        }
        ItemOrderSub itemOrderSub = itemOrderSubMapper.selectByPrimaryKey(subOrderId);
        ItemOrderRefundExample itemOrderRefundExample = new ItemOrderRefundExample();
        itemOrderRefundExample.createCriteria().andSoidEqualTo(subOrderId);
        List<ItemOrderRefund> itemOrderRefunds = itemOrderRefundMapper.selectByExample(itemOrderRefundExample);
        int alreadyRefundNumber = 0;
        for (ItemOrderRefund itemOrderRefund : itemOrderRefunds) {
            if (itemOrderRefund.getType() == 5) {
                alreadyRefundNumber+=itemOrderRefund.getFailNumber();
                continue;
            }
            alreadyRefundNumber+=itemOrderRefund.getNumber();
        }
        Long refundId = SpringBeanFactory.getBean(SubItemOrder.class, subOrderId)
                .refundApply(3, itemOrderSub.getNum()-alreadyRefundNumber, 0L, refundReason + "," + refundDesc);
        // TODO: 换货消息推送，换货数量,暂时用剩余所有未进行过退款和售后的数量
        orderMessageProducter.orderRefundHasItem(refundId, itemOrderSub.getOid(), subOrderId, itemOrderSub.getNum()-alreadyRefundNumber, 0L, refundReason + "," + refundDesc, 2);
        return refundId;
    }

    private boolean hasReturnGoodsOrExchange(Long soid) {
        ItemOrderRefundExample refundExample = new ItemOrderRefundExample();
        //查出子单是否有退换货记录
        refundExample.createCriteria().andSoidEqualTo(soid).andTypeIn(Lists.newArrayList(2, 3));
        return itemOrderRefundMapper.countByExample(refundExample) > 0;
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
                afterSaleStatus = ReturnGoodsStatusEnum.REFUND_FAIL;
                break;
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
        if(RefundStateEnum.SELLER_REFUND.equals(refundinfo.getRefundState())){
            statusVo.setContent(refundinfo.getFailMsg());
        }else{
            statusVo.setContent(refundinfo.getReason());
        }
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
        if (refundinfo.getRefundState().equals(RefundStateEnum.ENT_REFUND)) {
            infoVO.setRefundPrice(refundinfo.getRefundMoney());
        } else {
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
            vo.setHeadImgUrl(o.getImBuyer() ? "http://shigu.oss-cn-hangzhou.aliyuncs.com/mall/buyer_42px.jpg" : "http://shigu.oss-cn-hangzhou.aliyuncs.com/mall/seller_42px.jpg");
            vo.setUserNick(o.getImBuyer() ? "你" : "卖家");
            vo.setToStatus(o.getToStatus());
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
        return orderConstantService.selExpresses();
    }

    /**
     * 选择快递公司并提交
     *
     * @param refundId    :退换货id
     * @param companyName :快递公司名称
     * @param expressCode :快递单号
     * @create: zf
     */
    @Override
    public void chooseExpress(Long refundId, String companyName, String expressCode) {
        modExpress(refundId, companyName, expressCode, false);
    }

    private void modExpress(Long refundId, String company, String expressCode, boolean modify) {
        SpringBeanFactory.getBean(RefundItemOrder.class, refundId).userSended(expressCode);
        orderMessageProducter.refundCourierNumberModify(refundId, company, expressCode, modify);
    }

    private String selCompanyById(Long expressId) {
        ExpressVo expressCompany = orderConstantService.selByExpressId(expressId);
        return expressCompany == null ? "" : expressCompany.getExpressName();
    }

    /**
     * ====================================================================================
     * 修改快递公司
     *
     * @param refundId
     * @param companyName
     * @param expressCode
     * @create: zf
     * @param: refundId 退换货id   companyName快递公司名称，expressCode快递单号
     * @return:
     */
    @Override
    public void modifyExpress(Long refundId, String companyName, String expressCode) {
        modExpress(refundId, companyName, expressCode, true);
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
        vo.setReturnableExpressTime(refundinfo.getBuyerReturnTime() != null ? refundinfo.getBuyerReturnTime().getTime() : null);
//        try {
//            vo.setExpressDetails(itemOrderService.expressLog("", refundinfo.getBuyerCourier()));
//        } catch (ParseException e) {
//            throw new Main4Exception(e.getMessage());
//        }
        return vo;
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
        if(redisIO.get("doRefundMoney_zf_20171130_"+refundId)!=null){
            throw new RefundException("退款执行中,请勿重复操作");
        }
        redisIO.putTemp("doRefundMoney_zf_20171130_"+refundId,1,360);
        try {
            RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, refundId);
            RefundVO refundinfo=refundItemOrder.refundinfo();
            if(refundinfo.getRefundState()!=RefundStateEnum.SELLER_REPRICE){
                throw new RefundException("订单状态错误");
            }
            if (isAgree) {
                refundItemOrder.buyerReprice();
            } else {
                refundItemOrder.buyerNoReprice();
            }
            orderMessageProducter.repriceAgree(refundId, isAgree);
        } finally {
            redisIO.del("doRefundMoney_zf_20171130_"+refundId);
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

    @Override
    public void wipeOffNewTip(Long refundId) {
        ItemOrderRefund refund = new ItemOrderRefund();
        refund.setRefundId(refundId);
        refund.setUserShow(true);
        itemOrderRefundMapper.updateByPrimaryKeySelective(refund);
    }

    /**
     * 已拿到货未发退款
     *
     * @param psoid
     * @param money
     * @return
     * @throws OrderException
     * @throws RefundException
     * @throws PayerException
     */
    @Override
    public Long refundHasItem(Long psoid, Long money) throws OrderException, RefundException, PayerException {
        Long soid = soidsCreater.selSoidBySoidp(psoid);
        SubItemOrder subItemOrder = SpringBeanFactory.getBean(SubItemOrder.class, soid);
        Long refundId = subItemOrder.refundApply(5, 1, money, "已拿到货退款");
        SpringBeanFactory.getBean(RefundItemOrder.class, refundId).refundHasItem(psoid, money);
        return refundId;
    }

    /**
     * 换货完成接口
     * @param refundId
     * @param userId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void finishExchange(Long refundId, Long userId) throws OrderException {
        RefundItemOrder refundModel = SpringBeanFactory.getBean(RefundItemOrder.class, refundId);
        if (!userId.equals(SpringBeanFactory.getBean(ItemOrder.class,refundModel.refundinfo().getOid()).orderInfo().getUserId())) {
            throw new OrderException("不能操作他人订单");
        }
        refundModel.finishExchange();
    }
}
