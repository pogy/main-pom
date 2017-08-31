package com.shigu.daifa.bo;

/**
 * Created by pc on 2017-08-31.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class AfterSaleBO {
    /**
     * 主单号
     */
    private Long orderId;
    /**
     * 下单人id
     */
    private Long buyerId;
    /**
     * 收货人
     */
    private String receiver;
    /**
     *收货人手机号
     */
    private String telphone;

    /**
     * 当前页
     */
    private String page;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
