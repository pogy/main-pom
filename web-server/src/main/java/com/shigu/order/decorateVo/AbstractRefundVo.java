package com.shigu.order.decorateVo;

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
public abstract class AbstractRefundVo {
    protected Map<String,Object> vo;
    public  Map<String, Object> getViewVo(){
        if(vo == null){
            vo = new HashMap<>();
        }
        return vo;
    }



}
