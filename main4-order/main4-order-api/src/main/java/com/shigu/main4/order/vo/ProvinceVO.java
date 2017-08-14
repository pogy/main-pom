package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 省份
 * Created by zhaohongbo on 17/6/20.
 */
public class ProvinceVO implements Serializable{
    /**
     * 省份
     */
    private String province;
    /**
     * 省份ID
     */
    private Long provinceId;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
}
