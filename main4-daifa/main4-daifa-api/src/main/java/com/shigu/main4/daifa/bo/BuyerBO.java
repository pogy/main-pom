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
