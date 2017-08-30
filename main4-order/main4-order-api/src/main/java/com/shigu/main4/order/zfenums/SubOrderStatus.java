package com.shigu.main4.order.zfenums;

/**
 * 子订单状态  '0初始状态，1已退，2已发',
 * Created by bugzy on 2017/6/16 0016.
 */
public enum SubOrderStatus {

    ORIGINAL(0),
    RETURNED(1),
    SEND(2),
    ;
    public final int status;

    SubOrderStatus(int status) {
        this.status = status;
    }

    public static SubOrderStatus statusOf(int status) {
        for (SubOrderStatus subOrderStatus : values()) {
            if (subOrderStatus.status == status) {
                return subOrderStatus;
            }
        }
        throw new IllegalArgumentException(status + "不存在");
    }
}
