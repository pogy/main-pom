package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 买家信息
 * Created by bugzy on 2017/8/14 0014.
 */
public class Buyer implements Serializable {
    private String aliWw;
    private String phone;
    private String nickInMarket;

    private String imQq;

    private Long buyerId;

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

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
}
