package com.shigu.main4.order.bo;

import java.io.Serializable;

/**
 * 子订单参数
 * Created by zhaohongbo on 17/6/1.
 */
public class SubItemOrderBO implements Serializable{
    /**
     * 产品ID
     */
    private Long pid;
    /**
     * skuId
     */
    private Long skuId;
    /**
     * 产品数量
     */
    private Integer num;
    /**
     * 备注
     */
    private String mark;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
