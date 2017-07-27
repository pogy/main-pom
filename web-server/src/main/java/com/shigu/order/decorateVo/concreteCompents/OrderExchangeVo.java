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
    private Map<String,Object> map;
    @Override
    public Map<String, Object> getViewVo() {
        if(map == null){
            map = new HashMap<>();
        }
        return map;
    }

    @Override
    public void addMap(Map<String, Object> map) {
        if(map == null){
            map = new HashMap<>();
        }
        map.putAll(map);
    }

    @Override
    public void doAdd() {

    }
}
