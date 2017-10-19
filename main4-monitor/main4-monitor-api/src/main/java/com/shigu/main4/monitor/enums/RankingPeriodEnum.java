package com.shigu.main4.monitor.enums;

/**
 * 类名：RankingPeriodEnum
 * 类路径：com.shigu.main4.monitor.enums.RankingPeriodEnum
 * 创建者：王浩翔
 * 创建时间：2017-10-12 17:24
 * 项目：main-pom
 * 描述：排行时间戳获取用枚举
 */
public enum  RankingPeriodEnum {

    RANKING_BY_WEEK(7,5,-7),//DAY_OF_WEEK,DATE,一周七天
    RANKING_BY_MONTH(5,2,-1),//DAY_OF_MONTH,MONTH,一个月
    ;
    public final int startDay;
    public final int stepPeriod;
    public final int stepLength;

    RankingPeriodEnum(int startDay, int stepPeriod, int stepLength) {
        this.startDay = startDay;
        this.stepPeriod = stepPeriod;
        this.stepLength = stepLength;
    }
}
