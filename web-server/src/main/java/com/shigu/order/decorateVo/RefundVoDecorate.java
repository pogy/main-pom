package com.shigu.order.decorateVo;

import java.util.Map;

/**
 * Created by pc on 2017-07-25.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class RefundVoDecorate extends AbstractRefundVo{
    private AbstractRefundVo abstractRefundVo;


    public RefundVoDecorate(AbstractRefundVo vo){
        this.abstractRefundVo = vo;
    }

    @Override
    public Map<String, Object> getViewVo() {
        return super.getViewVo();
    }
}
