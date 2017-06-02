package com.shigu.main4.order.bo;

/**
 * 物流信息参数
 * Created by zhaohongbo on 17/6/1.
 */
public class LogisticsBO {

    private Long companyId;
    private Long addressId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
