package com.opentae.data.mall.beans;

/**
 * 报名情况聚合
 * Created by zhaohongbo on 17/5/14.
 */
public class EnlistEgg {

    private Long shopId;

    private String name;

    private String telephone;

    private Integer times;

    private Long money;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
