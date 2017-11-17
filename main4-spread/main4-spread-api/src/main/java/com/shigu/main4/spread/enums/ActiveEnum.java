package com.shigu.main4.spread.enums;

/**
 * 类名：ActiveEnum
 * 类路径：com.shigu.main4.spread.enums.ActiveEnum
 * 创建者：王浩翔
 * 创建时间：2017-11-17 15:56
 * 项目：main-pom
 * 描述：
 */
public enum ActiveEnum {
    NOMAL_NO_AWARD("常规非奖励活动"),
    SYN_DRAW("即时抽奖活动"),
    ASYN_DRAW("非即时抽奖活动"),
    ;

    //活动类型描述
    public final String desc;

    ActiveEnum(String desc) {
        this.desc = desc;
    }
}
