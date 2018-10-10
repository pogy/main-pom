package com.shigu.main4.monitor.enums;

/**
 * 类名：RankingPeriodEnum
 * 类路径：com.shigu.main4.monitor.enums.RankingPeriodEnum
 * 创建者：王浩翔
 * 创建时间：2017-10-12 17:24
 * 项目：main-pom
 * 描述：排行时间戳获取用枚举
 */
public enum AppDownLoadTypeEnum {
    ANDROID(1),
    IOS(2),//DAY_OF_WEEK,DATE,一周七天
    ;
    private final int type;

    AppDownLoadTypeEnum(int type) {
        this.type = type;
    }

    public static AppDownLoadTypeEnum paseType(int type){
        for (AppDownLoadTypeEnum item : AppDownLoadTypeEnum.values()){
            if (item.getType() == type) {
                return item;
            }
        }
        return null;
    }

    public int getType() {
        return type;
    }
}
