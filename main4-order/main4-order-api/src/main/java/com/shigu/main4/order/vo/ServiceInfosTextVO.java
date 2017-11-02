package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-30/15:37
 * 服务费详情
 */
public class ServiceInfosTextVO implements Serializable {

    private static final long serialVersionUID = 8676768508468135928L;

    /**服务项目*/
    private String text;
    /**服务费用*/
    private String cost;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
