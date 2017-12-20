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
    NEW_AUTUMN("秋装上新抽奖",20,15,2,"new_autumn_0811","hitDrawModelNewAutumn","2017-08-15 23:55:00","2017-08-26 23:59:59"),
    NEW_AUTUMN_2("秋装活动第二期抽奖",21,16,2,"NEW_AUTUMN_2","hitDrawModelNewAutumn","2017-08-27 00:00:00","2017-09-03 23:59:59"),
    NEW_AUTUMN_3("秋装活动第三期抽奖",22,17,2,"NEW_AUTUMN_3","hitDrawModelNewAutumn","2017-09-04 00:00:01","2017-09-11 23:59:59"),
    NEW_AUTUMN_4("秋装活动第四期抽奖",23,18,2,"NEW_AUTUMN_4","hitDrawModelNewAutumn","2017-09-11 11:00:00","2017-09-18 11:00:00"),
    NEW_AUTUMN_5("秋装活动第五期抽奖",24,19,2,"NEW_AUTUMN_5","hitDrawModelNewAutumn","2017-09-18 11:00:00","2017-09-25 11:00:00"),
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
