package com.shigu.main4.spread.enums;

/**
 * 类名：PrizeOverduePlanEnum
 * 类路径：com.shigu.main4.spread.enums.PrizeOverduePlanEnum
 * 创建者：王浩翔
 * 创建时间：2017-11-17 15:58
 * 项目：main-pom
 * 描述：
 */
public enum  PrizeOverduePlanEnum {
    AFTER_DRAWED("从中奖时间开始计算领奖有效时间"),
    AFTER_END_OF_ACTIVE("从活动结束时间开始计算领奖有效时间"),
    FIXED_TIME("固定领奖有效时间"),
    ;
    public final String desc;

    PrizeOverduePlanEnum(String desc) {
        this.desc = desc;
    }
}
