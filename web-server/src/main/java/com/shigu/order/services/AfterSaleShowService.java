package com.shigu.order.services;

import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.daifa.process.SaleAfterProcess;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.vo.ReturnableAddressVO;
import com.shigu.main4.order.zfenums.ShStatusEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.order.bo.AfterSaleBo;
import com.shigu.order.decorateUtil.AbstractRefundVo;
import com.shigu.order.decorateUtil.concreteCompents.OrderExchangeVo;
import com.shigu.order.decorateUtil.concreteCompents.OrderReturnVo;
import com.shigu.order.decorateUtil.concreteDetorates.*;
import com.shigu.order.vo.SubRefundOrderVO;
import com.shigu.zf.utils.PriceConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-07-25.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class AfterSaleShowService {
    @Autowired
    private AfterSaleService afterSaleService;
    @Autowired
    private PreSaleShowService preSaleShowService;
    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;
    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;
    @Autowired
    private ItemOrderMapper itemOrderMapper;

    public Long applyReturnOrder(AfterSaleBo bo) throws JsonErrException, OrderException {
        //TODO:: 退货为什么要加一个分配验证？？ 能退货不是代表已经收到货了吗？
//        ItemOrderSub ordersub = itemOrderSubMapper.selectByPrimaryKey(bo.getChildOrderId());
//        if(ordersub != null && orderManageProcess.tryRefund(bo.getChildOrderId()).size() == ordersub.getNum()){
//            throw new OrderException("订单已经被分配，暂时无法退款");
//        }
        SubRefundOrderVO sub=preSaleShowService.selSubRefundOrderVO(Long.parseLong(bo.getChildOrderId()));
        Long aLong = PriceConvertUtils.StringToLong(sub.getRefundGoodsPrice());
        Long refundMoney = bo.getRefundCount()*aLong;
        if (20<bo.getRefundReason().length()+(bo.getRefundDesc()==null?4:bo.getRefundDesc().length())) {
            throw new JsonErrException("申请理由过长");
        }
        return afterSaleService.returnGoodsApply(Long.parseLong(bo.getChildOrderId()), bo.getRefundCount()
                ,refundMoney
                , bo.getRefundReason(), bo.getRefundDesc());
    }

    public void chooseExpress(String refundId, String expressName, String expressCode) {
        afterSaleService.chooseExpress(Long.parseLong(refundId), expressName, expressCode);
    }

    public Map<String, Object> returnOrChange(String childOrderId) {
        SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO = afterSaleService.subAfterSaleSimpleOrder(Long.parseLong(childOrderId));
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(Long.parseLong(childOrderId));

        AbstractRefundVo vo = new OrderReturnVo();
        AbstractRefundVo vo1 = new SubSimpleRefundDecorate(vo, subAfterSaleSimpleOrderVO);//子单信息
        AbstractRefundVo vo2 = new OrderSimpleRefundDecorate(vo1, afterSaleSimpleOrderVO);//主单信息
        vo2.doAdd();
        return vo2.getViewVo();
    }


    public Map<String, Object> refundChildOrder(String childOrderId) {

        SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO = afterSaleService.subAfterSaleSimpleOrder(Long.parseLong(childOrderId));
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(Long.parseLong(childOrderId));
        AbstractRefundVo vo = new OrderReturnVo();
        AbstractRefundVo vo1 = new SubSimpleRefundDecorate(vo, subAfterSaleSimpleOrderVO);//子单信息
        AbstractRefundVo vo2 = new OrderSimpleRefundDecorate(vo1, afterSaleSimpleOrderVO);//主单信息
        vo2.doAdd();
        Map<String, Object> viewVo = vo2.getViewVo();

        viewVo.put("refundStateNum", 1);//这个是申请退货

        return viewVo;
    }

    public Map<String, Object> refund(String refundIds, Integer express) throws Main4Exception, ParseException {
        Long refundId = Long.parseLong(refundIds);
        ShStatusEnum shStatusEnum = afterSaleService.queryAfterSaleType(refundId);
        if (shStatusEnum == null || shStatusEnum.shStatus == 2) {
            return null;
        }
        ItemOrderRefund itemOrderRefund = itemOrderRefundMapper.selectByPrimaryKey(refundId);
        ItemOrderSub itemOrderSub = itemOrderSubMapper.selectByPrimaryKey(itemOrderRefund.getSoid());
        AfterSaleStatusVO afterSaleStatusVO = afterSaleService.afterSaleStatus(refundId);
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(afterSaleStatusVO.getSubOrderId());
        AfterSaleInfoVO afterSaleInfoVO = afterSaleService.afterSaleInfo(refundId);
        List<RefundLogVO> rlist = afterSaleService.afterSaleApplication(refundId);
        AbstractRefundVo vo = new OrderReturnVo();
        //主单信息修饰
        AbstractRefundVo vo1 = new OrderSimpleRefundDecorate(vo, afterSaleSimpleOrderVO);
        //退款状态信息修饰
        AbstractRefundVo vo2 = new ReturnStatusInfoDecorate(vo1, afterSaleStatusVO);
        //退款信息编号和钱修饰
        AbstractRefundVo vo3 = new RefundSimpleInfoDecorate(vo2, afterSaleInfoVO);
        //申请信息修饰
        AbstractRefundVo vo4 = new RefundLogDecorate(vo3, rlist,itemOrderRefund);
        AbstractRefundVo von = null;
        switch (afterSaleStatusVO.getAfterSaleStatus()) {
            case REFUND_FAIL: {
                //页面3-4
                break;
            }
            case RETURN_ENT: {
                //页面4
                AfterSaleEntVO afterSaleEntVO = afterSaleService.afterEnt(refundId);
                //退款完成修饰
                von = new RefundEndDecorate(vo4, afterSaleEntVO);
                break;
            }
            case AGREE_PROCESS: {
                //页面3-1
                ReturnableAddressVO returnableAddressVO = afterSaleService.retrunGoodsAddress(refundId);
//                List<ExpressVo> expressVos = afterSaleService.selectExpress();
                //退货地址修饰
                AbstractRefundVo vo5 = new ReturnAddressDecorate(vo4, returnableAddressVO);
                //快递列表修饰
                von = new RefundExpressDetorate(vo5, null);
                break;
            }
            case EXPRESS_SUBMIT: {
                //页面3-2
               von = chooseDecorate(refundId,express,vo4);
                break;
            }
            case REFUSE_PROCESS: {
                //页面2-2
                break;
            }
            case REFUSE_MONEY_CHANGED: {
                //页面3-4

                break;
            }
            case DISPOSE_RETRUN_GOODS: {
                //2-1

                break;
            }
            case REFUND_MONEY_CHANGED: {
                //3-3
                break;
            }
            default: {
                break;
            }


        }

        Map<String, Object> returnmap;
        if (von == null) {
            von = vo4;
        }
        von.doAdd();
        returnmap = von.getViewVo();
        //修改快递特殊处理
        if (!StringUtils.isEmpty(express) && express == 1
                && (returnmap.get("refundStateNum") != null && (Integer) returnmap.get("refundStateNum") == 3)
                && (returnmap.get("returnState") != null && (Integer) returnmap.get("returnState") == 2)
                ) {
            returnmap.put("express", express);
            returnmap.replace("refundStateNum", 3);
            returnmap.replace("returnState", 1);
        }
        returnmap.put("childOrderCode",itemOrderSub.getGoodsNo());
        returnmap.put("childOrderColor",itemOrderSub.getColor());
        returnmap.put("childOrderSize",itemOrderSub.getSize());
        returnmap.put("afterGoodsNum",itemOrderRefund.getNumber());
        return returnmap;


    }

    public Map<String, Object> exchangeChildOrder(long childOrderId) {
        SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO = afterSaleService.subAfterSaleSimpleOrder(childOrderId);
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(childOrderId);
        AbstractRefundVo vo = new OrderExchangeVo();
        //子单信息修饰
        AbstractRefundVo vo1 = new SubSimpleRefundDecorate(vo, subAfterSaleSimpleOrderVO);
        //主单信息修饰
        AbstractRefundVo vo2 = new OrderSimpleRefundDecorate(vo1, afterSaleSimpleOrderVO);
        vo2.doAdd();
        Map<String, Object> viewVo = vo2.getViewVo();

        viewVo.put("exchangeStateNum", 1);//这个是申请退货

        return viewVo;
    }

    public Map<String, Object> exchange(long refundId, Integer express) throws Main4Exception, ParseException {

        ShStatusEnum shStatusEnum = afterSaleService.queryAfterSaleType(refundId);
        if (shStatusEnum == null || shStatusEnum.shStatus == 1) {
            return null;
        }
        ItemOrderRefund itemOrderRefund = itemOrderRefundMapper.selectByPrimaryKey(refundId);
        AfterSaleStatusVO afterSaleStatusVO = afterSaleService.afterSaleStatus(refundId);
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(afterSaleStatusVO.getSubOrderId());
        AbstractRefundVo vo = new OrderExchangeVo();
        //主单信息
        AbstractRefundVo vo1 = new OrderSimpleRefundDecorate(vo, afterSaleSimpleOrderVO);
        AfterSaleInfoVO afterSaleInfoVO = afterSaleService.afterSaleInfo(refundId);
        List<RefundLogVO> rlist = afterSaleService.afterSaleApplication(refundId);
        //换货退款状态信息修饰
        AbstractRefundVo vo2 = new ExchangeStatusInfoDecorate(vo1, afterSaleStatusVO);
        //退款信息编号和钱修饰
        AbstractRefundVo vo3 = new RefundSimpleInfoDecorate(vo2, afterSaleInfoVO);
        //申请信息修饰
        AbstractRefundVo vo4 = new RefundLogDecorate(vo3, rlist,itemOrderRefund);
        AbstractRefundVo von = null;

        switch (afterSaleStatusVO.getAfterSaleStatus()) {
            // 2-1
            case DISPOSE_RETRUN_GOODS: {
                break;
            }
            //2-4
            case REFUSE_PROCESS: {
                break;
            }
            //2-3
            case EXPRESS_SUBMIT: {
                von = chooseDecorate(refundId,express,vo4);

                break;
            }
            //2-2
            case AGREE_PROCESS: {
                ReturnableAddressVO returnableAddressVO = afterSaleService.retrunGoodsAddress(refundId);
//                List<ExpressVo> expressVos = afterSaleService.selectExpress();
                //退货地址修饰
                AbstractRefundVo vo5 = new ReturnAddressDecorate(vo4, returnableAddressVO);
                //快递列表修饰
                von = new RefundExpressDetorate(vo5, null);
                break;
            }
            case REFUND_FAIL:{
                //换货失败
                break;
            }
            //3
            case RETURN_ENT: {
                AfterSaleEntVO afterSaleEntVO = afterSaleService.afterEnt(refundId);
                //退款完成修饰
                von = new ExchangeEndDecorate(vo4, afterSaleEntVO);
                break;
            }
            default: {
                break;
            }


        }

        Map<String, Object> returnmap;
        if (von == null) {
            von = vo4;
        }
        von.doAdd();
        returnmap = von.getViewVo();
        //修改快递特殊处理
        if (!StringUtils.isEmpty(express) && express == 1
                && (returnmap.get("exchangeStateNum") != null && (Integer) returnmap.get("exchangeStateNum") == 2)
                && (returnmap.get("exchangeWaitState") != null && (Integer) returnmap.get("exchangeWaitState") == 3)
                ) {
            returnmap.put("express", express);
            returnmap.replace("exchangeStateNum", 2);
            returnmap.replace("exchangeWaitState", 2);
        }
        return returnmap;
    }

    public void modifyExpress(String refundId, String expressName, String expressCode) {
        afterSaleService.modifyExpress(Long.parseLong(refundId), expressName, expressCode);
    }

    public Long exchangeApply(AfterSaleBo bo) throws OrderException {
        if ((bo.getRefundDesc()==null?4:bo.getRefundDesc().length())+bo.getRefundReason().length()>20) {
            throw new OrderException("申请原因过长");
        }
        return afterSaleService.exchangeApply(Long.parseLong(bo.getChildOrderId()), bo.getRefundReason(), bo.getRefundDesc());
    }

    public void agreeRefunMoney(long refundId, Integer agreeState) throws Main4Exception {
        boolean isAgree = false;
        switch (agreeState) {
            case 1: {
                isAgree = true;
                break;
            }
            case 2: {
                isAgree = false;
                break;
            }
            default: {
                break;
            }
        }
        afterSaleService.agreeOrRejectRefundPrice(refundId, isAgree);

    }

    /**
     * 换货完成
     * @param refundId
     * @param userId
     * @throws OrderException
     */
    @Transactional(rollbackFor = Exception.class)
    public void finishExchange(Long refundId,Long userId) throws OrderException, DaifaException {
        afterSaleService.finishExchange(refundId,userId);
        Long senderId = itemOrderMapper.getSenderIdByRefundId(refundId);
        SaleAfterProcess saleAfterProcess= SpringBeanFactory.getBean("saleAfterProcess_"+senderId,SaleAfterProcess.class);
        saleAfterProcess.changeEnt(refundId);
    }

    //修改快递和提教快递判断处理
    private AbstractRefundVo chooseDecorate(Long refundId, Integer express, AbstractRefundVo vo4) throws Main4Exception, ParseException {
        AbstractRefundVo von;
        if (express == null || express != 1) {
            //退货简要信息修饰
            ReturnableExpressInfoVO returnableExpressInfoVO = afterSaleService.retrunGoodsExpressInfo(refundId);
          //  List<ExpressLogVO> expressLogVOS = itemOrderService.expressLog(Long.parseLong(
          //          returnableExpressInfoVO.getExpressCode()));
            //物流信息修饰
            von = new RefundExpressInfoDecorate(vo4, returnableExpressInfoVO, null);
        } else {
            ReturnableAddressVO returnableAddressVO = afterSaleService.retrunGoodsAddress(refundId);
//            List<ExpressVo> expressVos = afterSaleService.selectExpress();
            //退货地址修饰
            AbstractRefundVo vo5 = new ReturnAddressDecorate(vo4, returnableAddressVO);
            //快递列表修饰
            von = new RefundExpressDetorate(vo5, null);
        }
        return von;
    }
}
