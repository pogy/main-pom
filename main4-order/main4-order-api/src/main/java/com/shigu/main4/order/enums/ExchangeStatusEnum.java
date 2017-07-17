package com.shigu.main4.order.enums;

/**
 * Created by zf on 2017/7/17.
 */
public enum ExchangeStatusEnum {
    DISPOSE_CHANGE(0),//申请换货
    WAIT_PROCESS(1),//等待申请处理
    CHANGE_ENT(2),//换货完成
    ;
    public final int exchengStatus;

    ExchangeStatusEnum(int exchengStatus) {
        this.exchengStatus = exchengStatus;
    }

    public static ExchangeStatusEnum statusOf(int exchengStatus) {
        for (ExchangeStatusEnum exchangeStatusEnum : values()) {
            if (exchangeStatusEnum.exchengStatus == exchengStatus) {
                return exchangeStatusEnum;
            }
        }
        throw new IllegalArgumentException(String.format("exchengStatus %d 不合法", exchengStatus));
    }
}
