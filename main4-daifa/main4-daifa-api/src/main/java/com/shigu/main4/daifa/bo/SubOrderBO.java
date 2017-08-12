package com.shigu.main4.daifa.bo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jmb on 2017/8/11.
 * Path com.shigu.main4.daifa.bo.SubOrderBO
 */
public class SubOrderBO implements Serializable{
    private Long soid;//      子订单ID
    private List<SubOrderPBO> subOrderPBOS;//   按件拆分ID

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public List<SubOrderPBO> getSubOrderPBOS() {
        return subOrderPBOS;
    }

    public void setSubOrderPBOS(List<SubOrderPBO> subOrderPBOS) {
        this.subOrderPBOS = subOrderPBOS;
    }


}
