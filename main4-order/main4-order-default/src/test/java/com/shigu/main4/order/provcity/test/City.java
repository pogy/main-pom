package com.shigu.main4.order.provcity.test;

import java.util.List;

/**
 * 城市
 * Created by zhaohongbo on 17/6/21.
 */
public class City {
    private String cityId;

    private String text;

    private List<Country> countys;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Country> getCountys() {
        return countys;
    }

    public void setCountys(List<Country> countys) {
        this.countys = countys;
    }
}
