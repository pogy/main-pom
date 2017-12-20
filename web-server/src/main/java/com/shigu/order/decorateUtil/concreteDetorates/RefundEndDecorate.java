package com.shigu.order.decorateUtil.concreteDetorates;

import com.shigu.main4.order.servicevo.AfterSaleEntVO;
import com.shigu.order.decorateUtil.AbstractRefundVo;
import com.shigu.order.decorateUtil.RefundVoDecorate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-26.
 *售后完成修饰
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class RefundEndDecorate extends RefundVoDecorate {
    private AfterSaleEntVO afterSaleEntVO;
    public RefundEndDecorate(AbstractRefundVo vo, AfterSaleEntVO afterSaleEntVO){
        super(vo);
        this.afterSaleEntVO = afterSaleEntVO;
    }

    private void setRefundEndInfo(){
        Map<String,Object> map = new HashMap<>();
      //  map.put("refundAmount",afterSaleEntVO.getPrice());
        map.put("refundGoto",afterSaleEntVO.getPriceGoto());
        map.put("refundSuccessTime",afterSaleEntVO.getAfterSeleEntDate());
        super.addMap(map);

    }


    @Override
    public void doAdd() {
        setRefundEndInfo();
        super.doAdd();
    }
}
