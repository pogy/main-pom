package com.shigu.main4.order.enums;

/**
 * Created by zf on 2017/7/17.
 */
public enum  ExchangeWaitStatusEnum {
    DISPOSE_CHANGE(0),//申请换货
    AGREE_PROCESS(1),//同意申请
    EXPRESS_SUBMIT(2),//已提交快递
    ;
    public final int exchengWaitStatus;

    ExchangeWaitStatusEnum(int exchengWaitStatus) {
        this.exchengWaitStatus = exchengWaitStatus;
    }

    public static ExchangeWaitStatusEnum statusOf(int exchengWaitStatus) {
        for (ExchangeWaitStatusEnum exchangeWaitStatusEnum : values()) {
            if (exchangeWaitStatusEnum.exchengWaitStatus == exchengWaitStatus) {
                return exchangeWaitStatusEnum;
            }
        }
        throw new IllegalArgumentException(String.format("exchengWaitStatus %d 不合法", exchengWaitStatus));
    }
}
