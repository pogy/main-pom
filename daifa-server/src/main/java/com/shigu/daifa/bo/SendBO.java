package com.shigu.daifa.bo;

/**
 * Created by pc on 2017-09-05.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class SendBO {

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
    private String telephone;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 当前页
     */
    private int page;

    private String postCode;


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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     *收货人手机号
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     *收货人手机号
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
