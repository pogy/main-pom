package com.shigu.order.services;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.order.enums.ShStatusEnum;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.servicevo.AfterSaleSimpleOrderVO;
import com.shigu.main4.order.servicevo.AfterSaleStatusVO;
import com.shigu.main4.order.servicevo.SubAfterSaleSimpleOrderVO;
import com.shigu.order.bo.AfterSaleBo;
import com.shigu.order.decorateVo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Map<String, Object> refund(String refundId) {
        ShStatusEnum shStatusEnum = afterSaleService.queryAfterSaleType(Long.parseLong(refundId));
        if(shStatusEnum == null||shStatusEnum.shStatus == 2){
            return null;
        }
        AfterSaleStatusVO afterSaleStatusVO = afterSaleService.afterSaleStatus(Long.parseLong(refundId));
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(afterSaleStatusVO.getSubOrderId());
        AbstractRefundVo vo = new OrderRefundVo();
        AbstractRefundVo vo1 = new OrderSimpleRefundDecorate(vo,afterSaleSimpleOrderVO);//主单信息
        AbstractRefundVo vo2 = new RefundStatusInfoDecorate(vo1,afterSaleStatusVO);
        switch (afterSaleStatusVO.getAfterSaleStatus()){
            case RETURN_ENT:{
                break;
            }
            case AGREE_PROCESS:{
                break;
            }
            case EXPRESS_SUBMIT:{
                break;
            }
            case REFUSE_PROCESS:{
                break;
            }
            case WAIT_AFTER_SALE:{
                break;
            }
            case DISPOSE_RETRUN_GOODS:{
                break;
            }
            case REFUND_MONEY_CHANGED:{
            }
            default:{
                break;
            }
        }

        return null;
    }
}
