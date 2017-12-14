package com.shigu.main4.monitor.service.impl;

import com.opentae.data.mall.beans.BugFeedback;
import com.opentae.data.mall.interfaces.BugFeedbackMapper;
import com.shigu.main4.monitor.bo.BugFeedbackBO;
import com.shigu.main4.monitor.services.BugFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * bug反馈监控服务
 * Created by zhaohongbo on 17/2/16.
 */
@Service("bugFeedbackService")
public class BugFeedbackServiceImpl  implements BugFeedbackService{

    @Autowired
    private BugFeedbackMapper bugFeedbackMapper;

    @Override
    public void addRecord(BugFeedbackBO bo) {
        BugFeedback bugFeedback = new BugFeedback();
        bugFeedback.setBrand(bo.getBrand());
        bugFeedback.setMobileModel(bo.getMobileModel());
        bugFeedback.setOsVersion(bo.getOsVersion());
        bugFeedback.setOpenVersion(bo.getOpenVersion());
        bugFeedback.setUserId(bo.getUserId());
        bugFeedback.setBugs(bo.getBugs());
        bugFeedbackMapper.insert(bugFeedback);
    }
}
