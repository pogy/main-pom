package com.shigu.main4.activity.enums;

import com.shigu.main4.activity.vo.GoatActivityVO;
import com.shigu.main4.activity.vo.LedActivityVO;

import java.io.Serializable;

/**
 * 活动类别
 * Created by zhaohongbo on 17/5/4.
 */
public enum ActivityType implements Serializable{
    GOAT_SELL(GoatActivityVO.class),//广告售卖
    GOAT_LED(LedActivityVO.class);//led活动


    ActivityType(Class<?> activityVoClass) {
        this.activityVoClass = activityVoClass;
    }

    private Class<?> activityVoClass;

    public Class<?> getActivityVoClass() {
        return activityVoClass;
    }

    public void setActivityVoClass(Class<?> activityVoClass) {
        this.activityVoClass = activityVoClass;
    }
}
