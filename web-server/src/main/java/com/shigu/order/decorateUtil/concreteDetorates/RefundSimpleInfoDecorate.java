package com.shigu.order.decorateUtil.concreteDetorates;

import com.shigu.main4.order.servicevo.AfterSaleInfoVO;

import com.shigu.order.decorateUtil.AbstractRefundVo;
import com.shigu.order.decorateUtil.RefundVoDecorate;
import com.shigu.zf.utils.PriceConvertUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-26.
 *售后id和金额修饰
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class RefundSimpleInfoDecorate extends RefundVoDecorate {
    private AfterSaleInfoVO afterSaleInfoVO;
    public RefundSimpleInfoDecorate(AbstractRefundVo vo, AfterSaleInfoVO afterSaleInfoVO){
        super(vo);
        this.afterSaleInfoVO = afterSaleInfoVO;
    }


    private void setAfterSaleInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("refundId",afterSaleInfoVO.getRefundId());
        map.put("refundAmount", PriceConvertUtils.priceToString(afterSaleInfoVO.getRefundPrice()));
        map.put("finalRefundAmount",PriceConvertUtils.priceToString(afterSaleInfoVO.getRefundPrice()));
        super.addMap(map);
    }

    @Override
    public void doAdd() {
        setAfterSaleInfo();
        super.doAdd();
    }
}
