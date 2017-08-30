package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 服务信息
 * Created by bugzy on 2017/8/15 0015.
 */
public class ServiceMessage implements Serializable {
    private Long id;
    private String money;
    private String name;
    private Long soid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }
}
