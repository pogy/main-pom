package com.shigu.order.decorateUtil;

import java.util.Map;

/**
 * Created by pc on 2017-07-25.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description 说点啥呢
 * @since 3.0.0-SNAPSHOT
 */
public class RefundVoDecorate extends AbstractRefundVo{
    private AbstractRefundVo abstractRefundVo;


    public RefundVoDecorate(AbstractRefundVo vo){
        this.abstractRefundVo = vo;
    }

    @Override
    public Map<String, Object> getViewVo() {
        return abstractRefundVo.getViewVo();
    }

    @Override
    public void addMap(Map<String, Object> map) {
        abstractRefundVo.addMap(map);
    }

    @Override
    public void doAdd() {
        abstractRefundVo.doAdd();
    }
}
