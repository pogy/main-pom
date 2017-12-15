package com.shigu.main4.monitor.services;

import com.shigu.main4.monitor.bo.BugFeedbackBO;

/**
 * bug反馈监控服务
 * Created by zhaohongbo on 17/2/16.
 */
public interface BugFeedbackService {
    /**
     * 添加反馈记录
     * @param bo 反馈内容
     */
    void addRecord(BugFeedbackBO bo);
}
