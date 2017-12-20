package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 包材消息
 * Created by bugzy on 2017/8/15 0015.
 */
public class PackageMessage implements Serializable {
    private Long id;
    private String money;
    private Long name;
    private Integer num;

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

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
