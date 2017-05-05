package com.shigu.main4.activity.beans;

import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.vo.ActivityEnlistVO;

/**
 * 报名记录
 * Created by zhaohongbo on 17/5/4.
 */
public abstract class ActivityEnlist extends ActivityEnlistVO {
    /**
     * 命中
     */
    public abstract void hit() throws ActivityException;

    /**
     * 取消命中
     */
    public abstract void unhit();
}
