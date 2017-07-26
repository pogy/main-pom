package com.shigu.order.decorateVo;

import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.servicevo.OrderInfoVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-25.
 *加基本订单信息
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class SubWithOrderRefundDecorate extends RefundVoDecorate{
    private ItemOrderService itemOrderService;
    private Long childOrderId;

    public SubWithOrderRefundDecorate(AbstractRefundVo vo,ItemOrderService itemOrderService,Long childOrderId){
        super(vo);
        this.itemOrderService = itemOrderService;
        this.childOrderId = childOrderId;
    }

    private void setRefundInfo(){

        SubOrderInfoVO subOrderInfoVO = itemOrderService.suborderInfo(this.childOrderId);
        OrderInfoVO orderInfoVO = itemOrderService.orderInfo(subOrderInfoVO.getOrderId());
        Map<String,Object> map = new HashMap<>();
        System.out.println("设置退款订单信息");
        map.put("childOrderId",subOrderInfoVO.getChildOrderId());
        map.put("childOrderImgSrc",subOrderInfoVO.getImgsrc());
        map.put("childOrderCode",subOrderInfoVO.getGoodsNo());
        map.put("childOrderColor",subOrderInfoVO.getColor());
        map.put("childOrderSize",subOrderInfoVO.getSize());
        map.put("orderId",subOrderInfoVO.getOrderId());
        map.put("orderDealTime", DateUtil.dateToString(orderInfoVO.getOrderDealTime(),DateUtil.patternD));
        map.put("orderGoodsPrice",subOrderInfoVO.getPrice());
        map.put("refundNumber",subOrderInfoVO.getNum()-(subOrderInfoVO.getRefundNum() == null? 0:1));
        map.put("orderExpressPrice",orderInfoVO.getExpressPrice());
        map.put("orderServicePrice",orderInfoVO.getServicePrice());
        map.put("orderTotalPrice",orderInfoVO.getTotalPrice());
        super.addMap(map);
    }

    @Override
    public Map<String, Object> getViewVo() {
        setRefundInfo();
        return super.getViewVo();
    }
}
