package com.shigu.order.decorateVo.concreteCompents;

import com.shigu.order.decorateVo.AbstractRefundVo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-25.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class OrderRefundVo extends AbstractRefundVo {
    protected Map<String,Object> vo;

    @Override
    public Map<String, Object> getViewVo() {
        if(vo == null){
            vo = new HashMap<>();
        }
        return vo;
    }

    @Override
    public void addMap(Map<String, Object> map) {
        if(vo == null){
            vo = new HashMap<>();
        }
        System.out.println(11);
        vo.putAll(map);
    }

    @Override
    public void doAdd() {
    }


}
