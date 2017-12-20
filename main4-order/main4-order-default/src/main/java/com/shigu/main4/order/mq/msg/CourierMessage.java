package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 退货快递单信息
 * Created by bugzy on 2017/8/14 0014.
 */
public class CourierMessage implements Serializable {

    private Long refundId;
    private String company;
    private String courierNumber;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber;
    }
}
