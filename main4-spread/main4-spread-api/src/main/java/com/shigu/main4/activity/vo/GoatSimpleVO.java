package com.shigu.main4.activity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告活动
 * -Long goatId
 -Date pubFromTime  //公布时间
 -Date pubToTime   //公布结束时间
 * Created by zhaohongbo on 17/5/10.
 */
public class GoatSimpleVO implements Serializable{

    private Long goatId;

    private String time;

    private String price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoatSimpleVO that = (GoatSimpleVO) o;

        return goatId.equals(that.goatId);

    }

    @Override
    public int hashCode() {
        return goatId.hashCode();
    }

    public Long getGoatId() {
        return goatId;
    }

    public void setGoatId(Long goatId) {
        this.goatId = goatId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
