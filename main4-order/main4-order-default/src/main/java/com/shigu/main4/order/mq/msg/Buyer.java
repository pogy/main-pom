package com.shigu.main4.order.mq.msg;

/**
 * 买家信息
 * Created by bugzy on 2017/8/14 0014.
 */
public class Buyer {
    private String aliWw;
    private String phone;
    private String nickInMarket;

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
