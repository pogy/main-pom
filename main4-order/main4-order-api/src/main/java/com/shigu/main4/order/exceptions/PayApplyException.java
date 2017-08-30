package com.shigu.main4.order.exceptions;

/**
 * 支付请求异常
 * Created by bugzy on 2017/6/14 0014.
 */
public class PayApplyException extends PayerException {

    public PayApplyException() {
    }

    public PayApplyException(String message) {
        super(message);
    }

    public static PayApplyException wxApplyException(Throwable t) {
        return new PayApplyException("微信支付请求异常： " + t.getMessage());
    }

    public static PayApplyException xzApplyException(Throwable t) {
        return new PayApplyException("星座支付请求异常： " + t.getMessage());
    }

    public static PayApplyException aliApplyException(Throwable t) {
        return new PayApplyException("支付宝支付请求异常： " + t.getMessage());
    }
}
