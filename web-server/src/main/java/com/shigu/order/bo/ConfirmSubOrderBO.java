package com.shigu.order.bo;

import java.io.Serializable;

/**
 * 确认的子订单
 * Created by zhaohongbo on 17/6/23.
 */
public class ConfirmSubOrderBO implements Serializable{

    private String id;

    private Integer num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
