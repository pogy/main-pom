package com.shigu.buyer.services;

import com.shigu.main4.monitor.bo.ShiguFeedbackBO;
import com.shigu.main4.monitor.services.ShiguFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    @Autowired
    private ShiguFeedbackService shiguFeedbackService;

    /**
     * 添加用户反馈
     * @param userId
     * @param content
     */
    public void addFeedback(Long userId,String content){
        ShiguFeedbackBO bo = new ShiguFeedbackBO();
        bo.setUserId(userId);
        bo.setFcontents(content);
        shiguFeedbackService.addRecord(bo);
    }
}
