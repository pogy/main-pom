package com.shigu.main4.daifa.enums;

/**
 * 代发交易状态
 */
public enum DaifaTradeStatus {
    NO_PAY(0),//未付款
    PAYED(1),//已付款，待分配
    PACKING(2),//拿货中
    SENDED(3),//已发货
    FINISHED(4),//交易完成
    CLOSED(10)//交易关闭
    ;

    DaifaTradeStatus(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
