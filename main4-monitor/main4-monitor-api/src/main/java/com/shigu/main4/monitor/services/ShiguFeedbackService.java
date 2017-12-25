package com.shigu.main4.monitor.services;

import com.shigu.main4.monitor.bo.ShiguFeedbackBO;
import com.shigu.main4.monitor.vo.ShiguFeedbackVO;

import java.util.List;


/**
 * bug反馈监控服务
 * Created by zhaohongbo on 17/2/16.
 */
public interface ShiguFeedbackService {
    /**
     * 添加用户反馈记录
     * @param bo 反馈内容
     */
    void addRecord(ShiguFeedbackBO bo);

    /**
     * 查询用户反馈记录
     * @param userId
     * @param type  反馈处理状态0待处理，1已处理...
     */
    List<ShiguFeedbackVO> selRecord(Long userId, Integer type);

    /**
     * @Warn 管理端专用
     * 修改用户反馈记录
     * @param feedbackId
     * @param type  反馈处理状态0待处理，1已处理...
     */
    void updateRecord(Long feedbackId, Integer type);
}
