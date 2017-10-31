package com.shigu.daifa.bo;

import java.io.Serializable;

/**
 * Created by pc on 2017-08-14.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class AllOrderBO implements Serializable {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 手机号
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

    private String buyerNick;//昵称
    private Integer stockoutFlag;//1缺货
    /**
     * 当前页
     */
    private String page;
    /**
     * 总数量
     */
    private Integer count;

    private String postCode;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getBuyerNick () {
        return buyerNick;
    }

    public void setBuyerNick (String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public Integer getStockoutFlag () {
        return stockoutFlag;
    }

    public void setStockoutFlag (Integer stockoutFlag) {
        this.stockoutFlag = stockoutFlag;
    }
}
