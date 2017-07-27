package com.shigu.main4.order.servicevo;


import java.io.Serializable;
import java.util.List;

/**
 * Created by zf on 2017/7/17.
 */
public class ReturnableExpressInfoVO implements Serializable{
    /**
     * 退换货快递
     */
    private String expressName;
    /**
     * 退换货快递单号
     */
    private String expressCode;

    /**
     * 获取 退换货快递
     */
    public String getExpressName() {
        return this.expressName;
    }

    /**
     * 设置 退换货快递
     */
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    /**
     * 获取 退换货快递单号
     */
    public String getExpressCode() {
        return this.expressCode;
    }

    /**
     * 设置 退换货快递单号
     */
    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
}
