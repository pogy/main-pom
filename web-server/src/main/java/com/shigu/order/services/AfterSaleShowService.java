package com.shigu.order.services;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.servicevo.AfterSaleSimpleOrderVO;
import com.shigu.main4.order.servicevo.SubAfterSaleSimpleOrderVO;
import com.shigu.order.bo.AfterSaleBo;
import com.shigu.order.decorateVo.AbstractRefundVo;
import com.shigu.order.decorateVo.OrderRefundVo;
import com.shigu.order.decorateVo.OrderSimpleRefundDecorate;
import com.shigu.order.decorateVo.SubSimpleRefundDecorate;
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

        return vo2.getViewVo();
    }



    public Map<String, Object> refundChildOrder(String childOrderId) {

        SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO = afterSaleService.subAfterSaleSimpleOrder(Long.parseLong(childOrderId));
        AfterSaleSimpleOrderVO afterSaleSimpleOrderVO = afterSaleService.afterSaleSimpleOrder(Long.parseLong(childOrderId));
        AbstractRefundVo vo = new OrderRefundVo();
        AbstractRefundVo vo1 = new SubSimpleRefundDecorate(vo,subAfterSaleSimpleOrderVO);//子单信息
        AbstractRefundVo vo2 = new OrderSimpleRefundDecorate(vo1,afterSaleSimpleOrderVO);//主单信息

        Map<String, Object> viewVo = vo1.getViewVo();
        viewVo.put("refundStateNum",1);//这个是申请退货

        return null;
    }

    public Map<String, Object> refund(String refundId) {
       /* Long childOrderId = afterSaleService.selChildOrderId(Long.parseLong(refundId));
        ReturnGoodsInfoVO returnGoodsInfoVO = afterSaleService.retrunGoodsInfo(Long.parseLong(refundId));
        AbstractRefundVo vo,vo1,vo2;
        vo = new OrderRefundVo();
        vo1 = new SubWithOrderRefundDecorate(vo,itemOrderService,childOrderId);
        vo2 = new RefundInfoDecorate(vo1,returnGoodsInfoVO);
        AbstractRefundVo vo3 = null;
        if(returnGoodsInfoVO.getRetrunGoodsStatus() == ReturnGoodsStatusEnum.EXPRESS_SUBMIT){
            vo3 = new LogisticsDecorate(vo2,logisticsService,Long.parseLong(refundId));
        }
        if(vo3!=null){
            return vo3.getViewVo();
        }


        return vo2.getViewVo();*/
        return null;
    }
}
