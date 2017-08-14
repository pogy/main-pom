package com.shigu.main4.order.provcity.test;

import java.util.List;

/**
 * Created by zhaohongbo on 17/6/21.
 */
public class Prov {
    private String provinceId;

    private String text;

    private List<City> citys;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }
}
