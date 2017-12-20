package com.shigu.main4.spread.enums;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类名：AutumnNewConstant
 * 类路径：com.shigu.main4.spread.enums.AutumnNewConstant
 * 创建者：王浩翔
 * 创建时间：2017-08-24 13:50
 * 项目：main-pom
 * 描述：秋装抽奖活动用常量，统一维护秋装活动的flag标记，活动结束可废弃
 */
public class AutumnNewConstant {
    /**
     * 抽奖记录后缀标记
     */
    private static final String DRAW_RECORD_TAG = "_draw_qualification";
    /**
     * 活动商品撤换后缀标记
     */
    private static final String CLOSED_TAG = "_closed";
    /**
     * 秋装活动奖池后缀标记
     */
    private static final String PRIZE_POOL_TAG = "_prize_pool";
    /**
     * 当前期秋装活动
     */
    public static final ActivityDrawEnum CURRENT_ACTIVE = ActivityDrawEnum.NEW_AUTUMN_5;
    /**
     * 秋装活动标志，秋装活动使用对应活动AcitivityDrawEnum#name作为标志
     */
    public static final String ACTIVE_FLAG = CURRENT_ACTIVE.name;
    /**
     * 用户抽奖记录标志
     */
    public static final String DRAW_RECORD_FLAG = ACTIVE_FLAG + DRAW_RECORD_TAG;
    /**
     * 奖池记录标志
     */
    public static final String PRIZE_POOL_FLAG = ACTIVE_FLAG + PRIZE_POOL_TAG;
    /**
     * 已换下活动商品标志
     */
    public static final String CLOSED_FLAG = ACTIVE_FLAG + CLOSED_TAG;
    /**
     * 可参与抽奖的商品查询标志
     */
    public static final String[] UPLOAD_FLAG = {ACTIVE_FLAG};
    //往期flag
    public static final String[] PAST_ACTIVE_FLAG = {ActivityDrawEnum.NEW_AUTUMN.name,ActivityDrawEnum.NEW_AUTUMN_2.name};

    public static Date STARTTIME;
    public static Date DEADLINE;
    static {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            STARTTIME = sdf.parse(CURRENT_ACTIVE.startTime);
            DEADLINE = sdf.parse(CURRENT_ACTIVE.deadline);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
