package com.shigu.order.services;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.zfenums.ShStatusEnum;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.vo.ExpressVo;
import com.shigu.main4.order.vo.ReturnableAddressVO;
import com.shigu.order.bo.AfterSaleBo;
import com.shigu.order.decorateVo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private LogisticsService logisticsService;


    public Long applyReturnOrder(AfterSaleBo bo) throws JsonErrException {
        Long aLong = afterSaleService.returnGoodsApply(Long.parseLong(bo.getChildOrderId()), bo.getRefundCount(), bo.getRefundMoney()
                , bo.getRefundReason(), bo.getRefundDesc());
        return aLong;
    }

    public void chooseExpress(String childOrderId, String expressId, String expressCode) {

    }

    public Map<String,Object> returnOrChange(String childOrderId) {
        SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO = afterSaleService.subAfterSaleSimpleOrder(Long.parseLong(childOrderId));
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(Long.parseLong(childOrderId));

        AbstractRefundVo vo = new OrderRefundVo();
        AbstractRefundVo vo1 = new SubSimpleRefundDecorate(vo,subAfterSaleSimpleOrderVO);//子单信息
        AbstractRefundVo vo2 = new OrderSimpleRefundDecorate(vo1,afterSaleSimpleOrderVO);//主单信息
        vo2.doAdd();
        return vo2.getViewVo();
    }



    public Map<String, Object> refundChildOrder(String childOrderId) {

        SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO = afterSaleService.subAfterSaleSimpleOrder(Long.parseLong(childOrderId));
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(Long.parseLong(childOrderId));
        AbstractRefundVo vo = new OrderRefundVo();
        AbstractRefundVo vo1 = new SubSimpleRefundDecorate(vo,subAfterSaleSimpleOrderVO);//子单信息
        AbstractRefundVo vo2 = new OrderSimpleRefundDecorate(vo1,afterSaleSimpleOrderVO);//主单信息
        vo2.doAdd();
        Map<String, Object> viewVo = vo2.getViewVo();

        viewVo.put("refundStateNum",1);//这个是申请退货

        return viewVo;
    }

    public Map<String, Object> refund(String refundIds) {
        Long refundId = Long.parseLong(refundIds);
        ShStatusEnum shStatusEnum = afterSaleService.queryAfterSaleType(refundId);
        if(shStatusEnum == null||shStatusEnum.shStatus == 2){
            return null;
        }

        AfterSaleStatusVO afterSaleStatusVO = afterSaleService.afterSaleStatus(refundId);
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(afterSaleStatusVO.getSubOrderId());
        AfterSaleInfoVO afterSaleInfoVO = afterSaleService.afterSaleInfo(refundId);
        List<RefundLogVO> rlist = afterSaleService.afterSaleApplication(refundId);
        AbstractRefundVo vo = new OrderRefundVo();
        AbstractRefundVo vo1 = new OrderSimpleRefundDecorate(vo,afterSaleSimpleOrderVO);//主单信息
        AbstractRefundVo vo2 = new RefundStatusInfoDecorate(vo1,afterSaleStatusVO);//退款状态信息
        AbstractRefundVo vo3 = new RefundSimpleInfoDecorate(vo2,afterSaleInfoVO);  //退款信息编号和钱
        AbstractRefundVo vo4 = new RefundLogDecorate(vo3,rlist);//申请信息
        AbstractRefundVo von = null;
        switch (afterSaleStatusVO.getAfterSaleStatus()){
            case RETURN_ENT:{
                //页面4
                AfterSaleEntVO afterSaleEntVO = afterSaleService.afterEnt(refundId);
                von = new RefundEndDecorate(vo4,afterSaleEntVO);//退款完成
                break;
            }
            case AGREE_PROCESS:{
                //页面3-1
                ReturnableAddressVO returnableAddressVO = afterSaleService.retrunGoodsAddress(refundId);
                List<ExpressVo> expressVos = afterSaleService.selectExpress();
                AbstractRefundVo vo5 = new ReturnAddressDecorate(vo4,returnableAddressVO);//退货地址
                von = new RefundExpressDetorate(vo5,expressVos);//快递列表
                break;
            }
            case EXPRESS_SUBMIT:{
                //页面3-2
                ReturnableExpressInfoVO returnableExpressInfoVO = afterSaleService.retrunGoodsExpressInfo(refundId);//退货简要信息
                von = new RefundExpressInfoDecorate(vo4,returnableExpressInfoVO);
                break;
            }
            case REFUSE_PROCESS:{
                //页面2-2
                break;
            }
            case REFUSE_MONEY_CHANGED:{
                //页面3-4

                break;
            }
            case DISPOSE_RETRUN_GOODS:{
                //2-1

                break;
            }
            case REFUND_MONEY_CHANGED:{
                //3-3
                break;
            }
            default:{
                break;
            }


        }
        if(von == null){
            vo4.doAdd();
           return vo4.getViewVo();
        }else{
            von.doAdd();
            return von.getViewVo();
        }


    }
}
