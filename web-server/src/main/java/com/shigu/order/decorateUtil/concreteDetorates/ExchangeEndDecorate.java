package com.shigu.order.decorateUtil.concreteDetorates;

import com.shigu.main4.order.servicevo.AfterSaleEntVO;
import com.shigu.order.decorateUtil.AbstractRefundVo;
import com.shigu.order.decorateUtil.RefundVoDecorate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-27.
 *修饰换货完成
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class ExchangeEndDecorate extends RefundVoDecorate{
    private AfterSaleEntVO afterSaleEntVO;
    public ExchangeEndDecorate(AbstractRefundVo vo,AfterSaleEntVO afterSaleEntVO){
        super(vo);
        this.afterSaleEntVO = afterSaleEntVO;
    }

    private void setExchangeEnd(){
        Map<String,Object> map = new HashMap<>();
        map.put("exchageFinishTime",afterSaleEntVO.getAfterSeleEntDate());
        super.addMap(map);

    }

    @Override
    public void doAdd() {
        setExchangeEnd();
        super.doAdd();
    }
}
