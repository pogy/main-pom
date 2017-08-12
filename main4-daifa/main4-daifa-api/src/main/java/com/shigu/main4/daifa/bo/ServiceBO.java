package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * Created by jmb on 2017/8/11.
 * Path com.shigu.main4.daifa.bo.ServiceBO
 */
public class ServiceBO implements Serializable {
    private Long id;//    服务ID
    private String money;//   服务费
    private String name;//   服务名称
    private Long soid;//    子订单ID

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
