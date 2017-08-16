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
    NEW_AUTUMN("秋装上新抽奖",20,15,2,"NEW_AUTUMN","hitDrawModelNewAutumn","2017-08-16 23:55:00","2017-08-26 23:59:59"),
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
    /**
     * 起始时间
     */
    public final String startTime;
    /**
     * 截止时间 格式：yyyy-MM-dd HH:mm:ss
     */
    public final String deadline;

    ActivityDrawEnum(String activeName,long pemId,long term, int type, String name,String drawModelName,String startTime, String deadline) {
        this.pemId = pemId;
        this.term = term;
        this.type = type;
        this.name = name;
        this.drawModelName = drawModelName;
        this.activeName = activeName;
        this.startTime = startTime;
        this.deadline = deadline;
    }

}
