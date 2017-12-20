package com.shigu.main4.order.bo;

import java.io.Serializable;

/**
 * 物流信息参数
 * Created by zhaohongbo on 17/6/1.
 */
public class LogisticsBO implements Serializable{

    private String companyId;
    private String addressId;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
