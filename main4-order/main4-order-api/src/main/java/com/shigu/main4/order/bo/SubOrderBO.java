package com.shigu.main4.order.bo;

import java.io.Serializable;

/**
 * 子订单入单信息
 */
public class SubOrderBO implements Serializable{
    private Long pid;//产品ID

    private Long skuId;//skuId

    private Integer number;//买入数量

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
