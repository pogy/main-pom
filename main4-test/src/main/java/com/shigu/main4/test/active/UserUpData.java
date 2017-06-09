package com.shigu.main4.test.active;

import java.util.Collection;

/**
 *
 * Created by bugzy on 2017/6/6 0006.
 */
public class UserUpData {
   private Long userId;
   private String userNick;
   private String loginPhone;
   private String ward;
   private Collection<Goods> faGoods;
   private Collection<Goods> daily;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getLoginPhone() {
        return loginPhone;
    }

    public void setLoginPhone(String loginPhone) {
        this.loginPhone = loginPhone;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Collection<Goods> getDaily() {
        return daily;
    }

    public void setDaily(Collection<Goods> daily) {
        this.daily = daily;
    }

    public Collection<Goods> getFaGoods() {
        return faGoods;
    }

    public void setFaGoods(Collection<Goods> faGoods) {
        this.faGoods = faGoods;
    }

}
