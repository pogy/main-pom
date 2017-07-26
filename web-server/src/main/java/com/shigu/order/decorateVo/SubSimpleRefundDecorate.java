package com.shigu.order.decorateVo;

import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.servicevo.OrderInfoVO;
import com.shigu.main4.order.servicevo.SubAfterSaleSimpleOrderVO;
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
public class SubSimpleRefundDecorate extends RefundVoDecorate{
    private SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO;
    public SubSimpleRefundDecorate(AbstractRefundVo vo, SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrderVO) {
        super(vo);
        this.subAfterSaleSimpleOrderVO = subAfterSaleSimpleOrderVO;
    }


    private void setRefundInfo(){


        Map<String,Object> map = new HashMap<>();
        System.out.println("设置退款子单信息");
        map.put("childOrderId",subAfterSaleSimpleOrderVO.getSubOrderId());
        map.put("childOrderImgSrc",subAfterSaleSimpleOrderVO.getPicUrl());
        map.put("childOrderCode",subAfterSaleSimpleOrderVO.getGoodsNo());
        map.put("childOrderColor",subAfterSaleSimpleOrderVO.getColor());
        map.put("childOrderSize",subAfterSaleSimpleOrderVO.getSize());
        map.put("refundGoodsPrice",subAfterSaleSimpleOrderVO.getPrice());
        map.put("refundNumber",subAfterSaleSimpleOrderVO.getNum()
                -(subAfterSaleSimpleOrderVO.getRefundNum()==null?0:subAfterSaleSimpleOrderVO.getRefundNum()));
        super.addMap(map);
    }

    @Override
    public void doAdd() {
        setRefundInfo();
        super.doAdd();
    }
}
