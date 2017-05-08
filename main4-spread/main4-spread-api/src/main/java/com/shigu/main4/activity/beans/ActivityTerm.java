package com.shigu.main4.activity.beans;

import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.ActivityVO;

import java.util.Date;

/**
 * 活动期对象
 * Created by zhaohongbo on 17/5/4.
 */
public abstract class ActivityTerm extends ActivityTermVO{

    public abstract <T extends ActivityVO> Long throwActivity(T activity);

    /**
     * 修改期
     * @param type 活动类别
     * @param start 开始时间
     * @param end 结束时间
     */
    public abstract void modify(ActivityType type, Date start, Date end) throws ActivityException;
}
