package com.shigu.main4.order.enums;

/**
 * Created by zf on 2017/7/17.
 */
public enum ExchangeStatusEnum {
    DISPOSE_CHANGE(0),//申请换货,       对应页面"等待处理换货申请-申请提交"
    AGREE_PROCESS(1),//同意申请,        对应页面"等待处理换货申请-同意换货申请"
    EXPRESS_SUBMIT(2),//已提交快递,     对应页面"等待处理换货申请-换货快递已提交"
    RECEIVED(3),//到货,                  对应页面"等待处理换货申请-换货快递已提交"
    WAIT_AFTER_SALE(4),//等待售后处理   对应页面"等待处理换货申请-换货快递已提交"
    CHANGE_ENT(5),//换货完成             对应页面"换货已完成"
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
