package com.shigu.order.decorateUtil.concreteDetorates;

import com.shigu.main4.order.servicevo.AfterSaleSimpleOrderVO;

import com.shigu.order.decorateUtil.AbstractRefundVo;
import com.shigu.order.decorateUtil.RefundVoDecorate;
import com.shigu.zf.utils.PriceConvertUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-26.
 *售后订单简要信息修饰
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
        map.put("orderGoodsPrice", PriceConvertUtils.priceToString(afterSaleSimpleOrderVO.getOrderPrice()));
        map.put("orderExpressPrice",PriceConvertUtils.priceToString(afterSaleSimpleOrderVO.getExpressPrice()));
        map.put("orderServicePrice",PriceConvertUtils.priceToString(afterSaleSimpleOrderVO.getServicePrice()));
        map.put("orderTotalPrice",PriceConvertUtils.priceToString(afterSaleSimpleOrderVO.getTotalPrice()));

        super.addMap(map);

    }

    @Override
    public void doAdd() {
        setOrderSimpleInfo();
        super.doAdd();
    }


}
