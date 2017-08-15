package com.shigu.main4.spread.enums;

/**
 * 类名：ActivityDrawEnum
 * 类路径：com.shigu.main4.spread.enums.ActivityDrawEnum
 * 创建者：王浩翔
 * 创建时间：2017-08-14 14:42
 * 项目：main-pom
 * 描述：
 */
public enum ActivityDrawEnum {
    NEW_AUTUMN("秋装上新抽奖",20,15,2,"NEW_AUTUMN","hitDrawModelNewAutumn"),
    ;
    public final long pemId;
    /**
     * 活动期次
     */
    public final long term;
    /**
     * 活动类型
     */
    public final int type;
    /**
     * 活动名称
     */
    public final String name;

    /**
     * 对应抽奖bean名称
     */
    public final String drawModelName;
    /**
     * 活动名称中文
     */
    public final String activeName;

    ActivityDrawEnum(String activeName,long pemId,long term, int type, String name,String drawModelName) {
        this.pemId = pemId;
        this.term = term;
        this.type = type;
        this.name = name;
        this.drawModelName = drawModelName;
        this.activeName = activeName;
    }

}
