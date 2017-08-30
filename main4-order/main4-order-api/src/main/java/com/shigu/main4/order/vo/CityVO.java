package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 城市
 * Created by zhaohongbo on 17/6/20.
 */
public class CityVO implements Serializable{
    /**
     * 城市
     */
    private String city;
    /**
     * 城市ID
     */
    private Long cityId;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityVO vo = (CityVO) o;

        return cityId != null ? cityId.equals(vo.cityId) : vo.cityId == null;
    }

    @Override
    public int hashCode() {
        return cityId != null ? cityId.hashCode() : 0;
    }
}
