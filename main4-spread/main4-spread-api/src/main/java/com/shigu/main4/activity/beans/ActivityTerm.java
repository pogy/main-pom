package com.shigu.main4.activity.beans;

import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.ActivityVO;

/**
 * 活动期对象
 * Created by zhaohongbo on 17/5/4.
 */
public abstract class ActivityTerm extends ActivityTermVO{

    public abstract Long throwActivity(ActivityVO activity);
}
