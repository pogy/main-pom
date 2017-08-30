package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * Created by jmb on 2017/8/11.
 * Path com.shigu.main4.daifa.bo.PackageBO
 */
public class PackageBO implements Serializable {
    private Long id;//    包材ID
    private String money;//    包材费用
    private String name;//    名称
    private Integer num;//      件数

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
