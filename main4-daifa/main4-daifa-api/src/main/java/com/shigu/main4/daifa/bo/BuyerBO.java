package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * Created by jmb on 2017/8/12.
 * Path com.shigu.main4.daifa.bo.BuyerBO
 */
public class BuyerBO implements Serializable {
    private String aliWw;//    旺旺
    private String phone;//    手机号
    private String nickInMarket;//    市场内昵称
    private String imQq;
    private Long buyerId;

    public String getAliWw() {
        return aliWw;
    }

    public void setAliWw(String aliWw) {
        this.aliWw = aliWw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickInMarket() {
        return nickInMarket;
    }

    public void setNickInMarket(String nickInMarket) {
        this.nickInMarket = nickInMarket;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public Long getBuyerId() {
        return this.buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
}
