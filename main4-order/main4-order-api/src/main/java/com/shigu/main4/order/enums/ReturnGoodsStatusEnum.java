package com.shigu.main4.order.enums;

/**
 * Created by zf on 2017/7/17.
 */
public enum ReturnGoodsStatusEnum {
    DISPOSE_RETRUN_GOODS(0),//买家申请退款 对应页面"等待处理退货申请"
    AGREE_PROCESS(1),//同意申请,            对应页面"买家退货-平台同意申请"
    EXPRESS_SUBMIT(2),//已提交快递,         对应页面"买家退货-退货物理信息提交"
    RECEIVED(3),//到货,                      对应页面"买家退货-货物收到"
    WAIT_AFTER_SALE(4),//等待售后处理       对应页面"买家退货-货物收到"
    RETURN_ENT(5),//退货完成                 对应页面"退货退款完成"
    ;
    public final int returnGoodsStatus;

    ReturnGoodsStatusEnum(int returnGoodsStatus) {
        this.returnGoodsStatus = returnGoodsStatus;
    }

    public static ReturnGoodsStatusEnum statusOf(int returnGoodsStatus) {
        for (ReturnGoodsStatusEnum returnGoodsStatusEnum : values()) {
            if (returnGoodsStatusEnum.returnGoodsStatus == returnGoodsStatus) {
                return returnGoodsStatusEnum;
            }
        }
        throw new IllegalArgumentException(String.format("returnGoodsStatus %d 不合法", returnGoodsStatus));
    }
}
