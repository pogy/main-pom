package com.shigu.order.vo;

/**
 * Created by whx on 2017/7/17 0017.
 */
public class PayModePageVO {

    /**
     * 站点.如'hz'
     */
    private String webSite;
    /**
     * 订单编号
     */
    private Long orderId;
    /**
     * 应付金额
     */
    private String amountPay;
    /**
     * 当前星座宝余额
     */
    private String currentAmount;
    /**
     * 如果存在该字段，则为未设置支付密码
     */
    private String notSetPassword;
    /**
     * 验签
     */
    private String tempCode;
    /**
     * 本地支付宝链接
     */
    private String alipayUrl;

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAmountPay() {
        return amountPay;
    }

    public void setAmountPay(String amountPay) {
        this.amountPay = amountPay;
    }

    public String getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(String currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getNotSetPassword() {
        return notSetPassword;
    }

    public void setNotSetPassword(String notSetPassword) {
        this.notSetPassword = notSetPassword;
    }

    public String getTempCode() {
        return tempCode;
    }

    public void setTempCode(String tempCode) {
        this.tempCode = tempCode;
    }

    public String getAlipayUrl() {
        return alipayUrl;
    }

    public void setAlipayUrl(String alipayUrl) {
        this.alipayUrl = alipayUrl;
    }
}
