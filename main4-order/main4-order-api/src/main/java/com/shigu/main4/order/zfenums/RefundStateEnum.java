package com.shigu.main4.order.zfenums;

/**
 * Created by zf on 2017/7/17.
 */
public enum RefundStateEnum {
    APPLY_REFUND(0, true, "发起申请退款"),//申请退款
    DISPOSE_REFUND(1, false, "商家已受理"),//商家受理退请求
    ENT_REFUND(2, null, "售后处理完成"),//退款完成
    SELLER_REFUND(3, false, "商家拒绝受理"),//商家拒绝受理,msg
    NOT_REFUND(4, false, "退款失败"),//退款失败,msg
    BUYER_SEND(5, true, "买家已发件"),//买家已发件
    SELLER_CACHED(6, false, "买家已收货"),//卖家已收件
    SELLER_REPRICE(7, false, "商家修改退款金额"),//卖家议价,msg
    BUYER_NOREPRICE(9, true, "买家拒绝接受议价金额"),//买家拒绝附议
    ;
    public final int refundStatus;
    public final Boolean imBuyer;
    public final String log;
    RefundStateEnum(int refundStatus, Boolean imBuyer, String log){
        this.refundStatus=refundStatus;
        this.log = log;
        this.imBuyer = imBuyer;
    }
    public static RefundStateEnum statusOf(int refundStatus) {
        for (RefundStateEnum refundStateEnum : values()) {
            if (refundStateEnum.refundStatus == refundStatus) {
                return refundStateEnum;
            }
        }
        throw new IllegalArgumentException(String.format("refundStatus %d 不合法", refundStatus));
    }
}
