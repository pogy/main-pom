package com.shigu.order.decorateVo;

import com.shigu.main4.order.servicevo.AfterSaleInfoVO;

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
public class RefundSimpleInfoDecorate extends RefundVoDecorate{
    private AfterSaleInfoVO afterSaleInfoVO;
    public RefundSimpleInfoDecorate(AbstractRefundVo vo, AfterSaleInfoVO afterSaleInfoVO){
        super(vo);
        this.afterSaleInfoVO = afterSaleInfoVO;
    }


    RefundSimpleInfoDecorate(AbstractRefundVo vo) {
        super(vo);
    }

    private void setAfterSaleInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("refundId",afterSaleInfoVO.getRefundId());
        map.put("refundAmount",afterSaleInfoVO.getRefundPrice());
        super.addMap(map);
    }

    @Override
    public void doAdd() {
        setAfterSaleInfo();
        super.doAdd();
    }
}
