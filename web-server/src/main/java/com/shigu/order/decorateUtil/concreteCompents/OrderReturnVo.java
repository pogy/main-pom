package com.shigu.order.decorateUtil.concreteCompents;

import com.shigu.order.decorateUtil.AbstractRefundVo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-25.
 *退货返回数据类
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class OrderReturnVo extends AbstractRefundVo {
    /**
     * 返回数据 map结构
     */
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
        vo.putAll(map);
    }

    @Override
    public void doAdd() {

    }


}
