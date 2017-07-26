package com.shigu.order.services;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.order.enums.ReturnGoodsStatusEnum;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.services.ReturnGoodsService;
import com.shigu.main4.order.servicevo.OrderInfoVO;
import com.shigu.main4.order.servicevo.ReturnGoodsInfoVO;
import com.shigu.main4.order.servicevo.ReturnableExpressInfoVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.order.bo.AfterSaleBo;
import com.shigu.order.decorateVo.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
public class AfterSaleService {
    @Autowired
    private ReturnGoodsService returnGoodsService;

    @Autowired
    private ItemOrderService itemOrderService;
    @Autowired
    private LogisticsService logisticsService;


    public Long applyReturnOrder(AfterSaleBo bo) throws JsonErrException {
        Long aLong = returnGoodsService.returnGoodsApply(Long.parseLong(bo.getChildOrderId()), bo.getRefundCount(), bo.getRefundMoney()
                , bo.getRefundReason(), bo.getRefundDesc());
        return aLong;
    }

    public void chooseExpress(String childOrderId, String expressId, String expressCode) {
        ReturnableExpressInfoVO returnableExpressInfoVO = returnGoodsService.chooseExpress(Long.parseLong(childOrderId)
                , Long.parseLong(expressId), expressCode);
    }

    public Map<String,Object> returnOrChange(String childOrderId) {
//
//        SubOrderInfoVO subOrderInfoVO = itemOrderService.suborderInfo(Long.parseLong(childOrderId));
//        OrderInfoVO orderInfoVO = itemOrderService.orderInfo(subOrderInfoVO.getOrderId());
//        Map<String, Object> stringObjectMap = refundBaseMap(subOrderInfoVO, orderInfoVO);

        //TODO 这块要重新规划
        ReturnGoodsInfoVO returnGoodsInfoVO = returnGoodsService.retrunGoodsInfo(Long.parseLong("111"));

        AbstractRefundVo vo = new OrderRefundVo();
        AbstractRefundVo vo1 = new SubWithOrderRefundDecorate(vo,itemOrderService,Long.parseLong(childOrderId));

        AbstractRefundVo vo2 = new RefundInfoDecorate(vo1,returnGoodsInfoVO);


        Map<String, Object> viewVo = vo2.getViewVo();


        return viewVo;
    }



    public Map<String, Object> refundChildOrder(String childOrderId) {
        AbstractRefundVo vo = new OrderRefundVo();
        AbstractRefundVo vo1 = new SubWithOrderRefundDecorate(vo,itemOrderService,Long.parseLong(childOrderId));
        Map<String, Object> viewVo = vo1.getViewVo();
        viewVo.put("refundStateNum",1);//这个是申请退货

        return viewVo;
    }

    public Map<String, Object> refund(String refundId) {
        Long childOrderId = returnGoodsService.selChildOrderId(Long.parseLong(refundId));
        ReturnGoodsInfoVO returnGoodsInfoVO = returnGoodsService.retrunGoodsInfo(Long.parseLong(refundId));
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


        return vo2.getViewVo();
    }
}
