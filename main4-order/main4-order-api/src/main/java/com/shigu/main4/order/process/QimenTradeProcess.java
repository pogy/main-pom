package com.shigu.main4.order.process;

public interface QimenTradeProcess {
    void toTransfer(Long oid);
    void toCheack(Long oid);
    void toNotify(Long oid);
    void toOut(Long oid);
}
