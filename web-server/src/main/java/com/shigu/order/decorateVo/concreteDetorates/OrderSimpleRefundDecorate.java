package com.shigu.order.decorateVo.concreteDetorates;

import com.shigu.main4.order.servicevo.AfterSaleSimpleOrderVO;
import com.shigu.order.decorateVo.AbstractRefundVo;
import com.shigu.order.decorateVo.RefundVoDecorate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class OrderSimpleRefundDecorate extends RefundVoDecorate {
    private AfterSaleSimpleOrderVO afterSaleSimpleOrderVO;
    public OrderSimpleRefundDecorate(AbstractRefundVo vo, AfterSaleSimpleOrderVO afterSaleSimpleOrderVO){
        super(vo);
        this.afterSaleSimpleOrderVO = afterSaleSimpleOrderVO;
    }
    private void setOrderSimpleInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("orderId",afterSaleSimpleOrderVO.getOrderId());
        map.put("orderDealTime",afterSaleSimpleOrderVO.getEndDate());
        map.put("orderGoodsPrice",afterSaleSimpleOrderVO.getOrderPrice());
        map.put("orderExpressPrice",afterSaleSimpleOrderVO.getExpressPrice());
        map.put("orderServicePrice",afterSaleSimpleOrderVO.getServicePrice());
        map.put("orderTotalPrice",afterSaleSimpleOrderVO.getTotalPrice());

        super.addMap(map);

    }

    @Override
    public void doAdd() {
        setOrderSimpleInfo();
        super.doAdd();
    }
}
