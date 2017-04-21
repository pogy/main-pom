package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.SafeHtml;

import java.io.Serializable;

/**
 * 充值的参数
 * Created by zhaohongbo on 17/3/1.
 */
public class RechangeBO implements Serializable{
    /**
     * 支付宝交易号
     */
    @SafeHtml(message = "paynum包含非法页面标签")
    private String paynum;
    /**
     * 支付宝账号
     */
    @SafeHtml(message = "alipay包含非法页面标签")
    private String alipay;

    public String getPaynum() {
        return paynum;
    }

    public void setPaynum(String paynum) {
        this.paynum = paynum;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }
}
