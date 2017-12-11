package com.shigu.main4.order.vo;

import java.util.List;

/**
 * 禁止发货的几个地方
 */
public class CantSendVO {
    private Long companyId;//快递公司ID
    private List<Long> areaIds;//区ID
    private List<Long> provIds;//省ID
    private List<Long> cityIds;;//省

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public List<Long> getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(List<Long> areaIds) {
        this.areaIds = areaIds;
    }

    public List<Long> getProvIds() {
        return provIds;
    }

    public void setProvIds(List<Long> provIds) {
        this.provIds = provIds;
    }

    public List<Long> getCityIds() {
        return cityIds;
    }

    public void setCityIds(List<Long> cityIds) {
        this.cityIds = cityIds;
    }
}
