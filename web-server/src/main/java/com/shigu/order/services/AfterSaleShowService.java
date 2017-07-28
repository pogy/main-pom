package com.shigu.order.services;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.zfenums.ReturnGoodsStatusEnum;
import com.shigu.main4.order.zfenums.ShStatusEnum;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.vo.ExpressVo;
import com.shigu.main4.order.vo.ReturnableAddressVO;
import com.shigu.order.bo.AfterSaleBo;
import com.shigu.order.decorateVo.*;
import com.shigu.order.decorateVo.concreteCompents.OrderExchangeVo;
import com.shigu.order.decorateVo.concreteCompents.OrderRefundVo;
import com.shigu.order.decorateVo.concreteDetorates.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    private ItemOrderService itemOrderService;
    //TODO 测试用
    private static ReturnGoodsStatusEnum testStatus = ReturnGoodsStatusEnum.REFUND_MONEY_CHANGED;
    private static ReturnGoodsStatusEnum testStatusC = ReturnGoodsStatusEnum.AGREE_PROCESS;


    public Long applyReturnOrder(AfterSaleBo bo) throws JsonErrException {
        return afterSaleService.returnGoodsApply(Long.parseLong(bo.getChildOrderId()), bo.getRefundCount(), bo.getRefundMoney()
                , bo.getRefundReason(), bo.getRefundDesc());
    }

    public void chooseExpress(String refundId, String expressId, String expressCode) {
        afterSaleService.chooseExpress(Long.parseLong(refundId), Long.parseLong(expressId), expressCode);
        testStatus = ReturnGoodsStatusEnum.EXPRESS_SUBMIT;
        testStatusC = ReturnGoodsStatusEnum.EXPRESS_SUBMIT;
    }

    public Map<String, Object> returnOrChange(String childOrderId) {
        SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO = afterSaleService.subAfterSaleSimpleOrder(Long.parseLong(childOrderId));
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(Long.parseLong(childOrderId));

        AbstractRefundVo vo = new OrderRefundVo();
        AbstractRefundVo vo1 = new SubSimpleRefundDecorate(vo, subAfterSaleSimpleOrderVO);//子单信息
        AbstractRefundVo vo2 = new OrderSimpleRefundDecorate(vo1, afterSaleSimpleOrderVO);//主单信息
        vo2.doAdd();
        return vo2.getViewVo();
    }


    public Map<String, Object> refundChildOrder(String childOrderId) {

        SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO = afterSaleService.subAfterSaleSimpleOrder(Long.parseLong(childOrderId));
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(Long.parseLong(childOrderId));
        AbstractRefundVo vo = new OrderRefundVo();
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

        AfterSaleStatusVO afterSaleStatusVO = afterSaleService.afterSaleStatus(refundId);
        afterSaleStatusVO.setAfterSaleStatus(testStatus);
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(afterSaleStatusVO.getSubOrderId());
        AfterSaleInfoVO afterSaleInfoVO = afterSaleService.afterSaleInfo(refundId);
        List<RefundLogVO> rlist = afterSaleService.afterSaleApplication(refundId);
        AbstractRefundVo vo = new OrderRefundVo();
        AbstractRefundVo vo1 = new OrderSimpleRefundDecorate(vo, afterSaleSimpleOrderVO);//主单信息
        AbstractRefundVo vo2 = new RefundStatusInfoDecorate(vo1, afterSaleStatusVO);//退款状态信息
        AbstractRefundVo vo3 = new RefundSimpleInfoDecorate(vo2, afterSaleInfoVO);  //退款信息编号和钱
        AbstractRefundVo vo4 = new RefundLogDecorate(vo3, rlist);//申请信息
        AbstractRefundVo von = null;
        switch (afterSaleStatusVO.getAfterSaleStatus()) {
            case RETURN_ENT: {
                //页面4
                AfterSaleEntVO afterSaleEntVO = afterSaleService.afterEnt(refundId);
                von = new RefundEndDecorate(vo4, afterSaleEntVO);//退款完成
                break;
            }
            case AGREE_PROCESS: {
                //页面3-1
                ReturnableAddressVO returnableAddressVO = afterSaleService.retrunGoodsAddress(refundId);
                List<ExpressVo> expressVos = afterSaleService.selectExpress();
                AbstractRefundVo vo5 = new ReturnAddressDecorate(vo4, returnableAddressVO);//退货地址
                von = new RefundExpressDetorate(vo5, expressVos);//快递列表
                break;
            }
            case EXPRESS_SUBMIT: {
                //页面3-2
               von = chooseDecorate(refundId,express,vo4,von);
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

        return returnmap;


    }

    public Map<String, Object> exchangeChildOrder(long childOrderId) {
        SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO = afterSaleService.subAfterSaleSimpleOrder(childOrderId);
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(childOrderId);
        AbstractRefundVo vo = new OrderExchangeVo();
        AbstractRefundVo vo1 = new SubSimpleRefundDecorate(vo, subAfterSaleSimpleOrderVO);//子单信息
        AbstractRefundVo vo2 = new OrderSimpleRefundDecorate(vo1, afterSaleSimpleOrderVO);//主单信息
        vo2.doAdd();
        Map<String, Object> viewVo = vo2.getViewVo();

        viewVo.put("exchangeStateNum", 1);//这个是申请退货

        return viewVo;
    }

    public Map<String, Object> exchange(long refundId, Integer express) throws Main4Exception, ParseException {

        ShStatusEnum shStatusEnum = afterSaleService.queryAfterSaleType(refundId);
        shStatusEnum = ShStatusEnum.CHANGE;
        if (shStatusEnum == null || shStatusEnum.shStatus == 1) {
            return null;
        }
        AfterSaleStatusVO afterSaleStatusVO = afterSaleService.afterSaleStatus(refundId);
        //TODO 测试用
        testStatusC = ReturnGoodsStatusEnum.RETURN_ENT;
        afterSaleStatusVO.setAfterSaleStatus(testStatusC);

        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(afterSaleStatusVO.getSubOrderId());
        AbstractRefundVo vo = new OrderExchangeVo();
        AbstractRefundVo vo1 = new OrderSimpleRefundDecorate(vo, afterSaleSimpleOrderVO);//主单信息
        AfterSaleInfoVO afterSaleInfoVO = afterSaleService.afterSaleInfo(refundId);
        List<RefundLogVO> rlist = afterSaleService.afterSaleApplication(refundId);
        AbstractRefundVo vo2 = new ExchangeStatusInfoDecorate(vo1, afterSaleStatusVO);//换货退款状态信息
        AbstractRefundVo vo3 = new RefundSimpleInfoDecorate(vo2, afterSaleInfoVO);  //退款信息编号和钱
        AbstractRefundVo vo4 = new RefundLogDecorate(vo3, rlist);//申请信息
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
                von = chooseDecorate(refundId,express,vo4,von);

                break;
            }
            //2-2
            case AGREE_PROCESS: {
                ReturnableAddressVO returnableAddressVO = afterSaleService.retrunGoodsAddress(refundId);
                List<ExpressVo> expressVos = afterSaleService.selectExpress();
                AbstractRefundVo vo5 = new ReturnAddressDecorate(vo4, returnableAddressVO);//退货地址
                von = new RefundExpressDetorate(vo5, expressVos);//快递列表
                break;
            }
            //3
            case RETURN_ENT: {
                AfterSaleEntVO afterSaleEntVO = afterSaleService.afterEnt(refundId);
                von = new ExchangeEndDecorate(vo4, afterSaleEntVO);//退款完成
                break;
            }
            default: {
                break;
            }


        }

        if (express != null && express == 1) {
            ReturnableAddressVO returnableAddressVO = afterSaleService.retrunGoodsAddress(refundId);
            List<ExpressVo> expressVos = afterSaleService.selectExpress();
            AbstractRefundVo vo5 = new ReturnAddressDecorate(vo4, returnableAddressVO);//退货地址
            von = new RefundExpressDetorate(vo5, expressVos);//快递列表
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
                && (returnmap.get("exchangeWaitState") != null && (Integer) returnmap.get("exchangeWaitState") == 2)
                ) {
            returnmap.put("express", express);
            returnmap.replace("refundStateNum", 2);
            returnmap.replace("returnState", 1);
        }
        return returnmap;
    }

    public void modifyExpress(String refundId, String expressId, String expressCode) {
        afterSaleService.modifyExpress(Long.parseLong(refundId), Long.parseLong(expressId), expressCode);
    }

    public Long exchangeApply(AfterSaleBo bo) {
        return afterSaleService.exchangeApply(Long.parseLong(bo.getChildOrderId()), bo.getRefundReason(), bo.getRefundDesc());
    }

    public void agreeRefunMoney(long refundId, Integer agreeState) {
        boolean isAgree = false;
        switch (agreeState) {
            case 1: {
                isAgree = true;
                testStatus = ReturnGoodsStatusEnum.RETURN_ENT;
                break;
            }
            case 2: {
                isAgree = false;
                testStatus = ReturnGoodsStatusEnum.REFUSE_MONEY_CHANGED;
                break;
            }
            default: {
                break;
            }
        }
        afterSaleService.agreeOrRejectRefundPrice(refundId, isAgree);

    }

    //修改快递和提教快递判断处理
    private AbstractRefundVo chooseDecorate(Long refundId, Integer express, AbstractRefundVo vo4, AbstractRefundVo von) throws Main4Exception, ParseException {
        if (express == null || express != 1) {
            ReturnableExpressInfoVO returnableExpressInfoVO = afterSaleService.retrunGoodsExpressInfo(refundId);//退货简要信息
            List<ExpressLogVO> expressLogVOS = itemOrderService.expressLog(Long.parseLong(
                    returnableExpressInfoVO.getExpressCode()));
            von = new RefundExpressInfoDecorate(vo4, returnableExpressInfoVO, expressLogVOS);//物流信息修饰
        } else {
            ReturnableAddressVO returnableAddressVO = afterSaleService.retrunGoodsAddress(refundId);
            List<ExpressVo> expressVos = afterSaleService.selectExpress();
            AbstractRefundVo vo5 = new ReturnAddressDecorate(vo4, returnableAddressVO);//退货地址
            von = new RefundExpressDetorate(vo5, expressVos);//快递列表
        }
        return von;
    }
}
