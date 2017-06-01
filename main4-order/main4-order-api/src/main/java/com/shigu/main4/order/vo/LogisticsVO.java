package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 物流信息
 * Created by zhaohongbo on 17/5/31.
 */
public class LogisticsVO implements Serializable{

    private Long id;

    private Long templateId;

    private Long addressId;

    private String courierNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber;
    }
}
