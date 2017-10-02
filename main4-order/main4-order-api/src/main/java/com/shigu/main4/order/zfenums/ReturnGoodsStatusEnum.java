package com.shigu.main4.order.zfenums;

/**
 * Created by zf on 2017/7/17.
 */
public enum ReturnGoodsStatusEnum {
    DISPOSE_RETRUN_GOODS(0),//买家申请退(换)货             售前退款类型下为"申请退款"
    AGREE_PROCESS(1),//同意申请,                            售前退款类型下为"同意申请"
    REFUSE_PROCESS(2),//拒绝申请                            售前退款类型下为"拒绝申请"
    EXPRESS_SUBMIT(3),//已提交快递,                         售前退款类型下无次状态
    REFUND_MONEY_CHANGED(4),//退款金额已修改               售前退款类型下无次状态
    REFUSE_MONEY_CHANGED(5),//不同意金额修改               售前退款类型下无次状态
    RETURN_ENT(6),//退(换)货完成                             售前退款类型下为"退款完成"
    REFUND_FAIL(7),//售后失败
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
