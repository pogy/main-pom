package com.shigu.mq.enums;

/**
 * lys
 * 消息接收类型enum
 */
public enum MessageTagEnum {
    ORDER_PUSH("order_push","订单写入"),
    ORDER_REFUND_NOITEM("order_refund_noitem","申请退款"),
    ORDER_REFUND_HASITEM("order_refund_hasitem","申请退货"),
    REFUND_COURIER_NUMBER("refund_courier_number","退货填写快递单"),
    REFUND_COURIER_NUMBER_MODIFY("refund_courier_number_modify","退货修改快递单"),
    REPRICE_AGREE("reprice_agree","同意/拒绝议价"),
    ;
    private String tag;
    private String detail;
    MessageTagEnum(String tag, String detail){
        this.tag=tag;
        this.detail=detail;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
