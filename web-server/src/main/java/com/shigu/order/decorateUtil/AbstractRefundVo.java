package com.shigu.order.decorateUtil;

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
    public abstract Map<String, Object> getViewVo();
    public abstract void addMap(Map<String,Object> map);
    public abstract void doAdd();


}
