package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 提现的参数
 * Created by zhaohongbo on 17/3/22.
 */
public class TixianBO implements Serializable{
    /**
     *
      */
    @NotEmpty(message = "支付宝号不能为空")
    @SafeHtml(message = "alipay含非法页面标签")
    private String alipay;
    /**
     * 实名
     */
    @NotEmpty(message = "需要实名才能提现")
    @SafeHtml(message = "payname含非法页面标签")
    private String payname;
    /**
     * 付的钱数
     */
    @NotNull(message = "金额不能为空")
    private Double paynum;

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname;
    }

    public Double getPaynum() {
        return paynum;
    }

    public void setPaynum(Double paynum) {
        this.paynum = paynum;
    }
}
