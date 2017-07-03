package com.shigu.main4.activity.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 活动异常
 * Created by bugzy on 2017/6/30 0030.
 */
public class ActivityException extends Main4Exception {
    public ActivityException() {
    }

    public ActivityException(String message) {
        super(message);
    }
}
