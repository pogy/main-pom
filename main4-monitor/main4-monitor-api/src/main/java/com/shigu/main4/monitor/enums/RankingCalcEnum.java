package com.shigu.main4.monitor.enums;

/**
 * 类名：RankingCalcEnum
 * 类路径：com.shigu.main4.monitor.enums.RankingCalcEnum
 * 创建者：王浩翔
 * 创建时间：2017-10-02 10:24
 * 项目：main-pom
 * 描述：
 */
public enum  RankingCalcEnum {


    ;
    //策略对象名，用来获取计算对象
    public final String ruleBeanName;

    RankingCalcEnum(String ruleBeanName) {
        this.ruleBeanName = ruleBeanName;

    }
}
