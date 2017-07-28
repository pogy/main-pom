package com.shigu.order.decorateVo.concreteCompents;

import com.shigu.order.decorateVo.AbstractRefundVo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-27.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class OrderExchangeVo extends AbstractRefundVo{
    private Map<String,Object> vo;
    @Override
    public Map<String, Object> getViewVo() {
        if(this.vo == null){
            this.vo = new HashMap<>();
        }
        return this.vo;
    }

    @Override
    public void addMap(Map<String, Object> map) {
        if(this.vo == null){
            this.vo = new HashMap<>();
        }
        this.vo.putAll(map);
    }

    @Override
    public void doAdd() {

    }
}
