package com.shigu.main4.order.zfenums;

/**
 * 类名：SubOrderSoidpsEnum
 * 类路径：com.shigu.main4.order.zfenums.SubOrderSoidpsEnum
 * 创建者：王浩翔
 * 创建时间：2017-09-11 16:43
 * 项目：main-pom
 * 描述：子单拆单
 */
public enum  SubOrderSoidpsEnum {

    DEFAULT_STATUS(0),  //默认状态
    OUT_OF_STOCK(1),    //缺货
    ARRIVAL(2),         //到货
    ;
    public final int status;
    SubOrderSoidpsEnum(int status) {
        this.status = status;
    }

    public static SubOrderSoidpsEnum statusOf(int status) {
        for (SubOrderSoidpsEnum subOrderSoidpsEnum : values()) {
            if (subOrderSoidpsEnum.status == status) {
                return subOrderSoidpsEnum;
            }
        }
        throw new IllegalArgumentException(status + "不存在");
    }

    public int getStatus() {
        return status;
    }
}
