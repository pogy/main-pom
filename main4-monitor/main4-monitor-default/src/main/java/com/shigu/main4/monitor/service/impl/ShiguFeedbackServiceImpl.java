package com.shigu.main4.monitor.service.impl;

import com.opentae.data.mall.beans.ShiguFeedback;
import com.opentae.data.mall.examples.ShiguFeedbackExample;
import com.opentae.data.mall.interfaces.ShiguFeedbackMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.monitor.bo.ShiguFeedbackBO;
import com.shigu.main4.monitor.services.ShiguFeedbackService;
import com.shigu.main4.monitor.vo.ShiguFeedbackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * bug反馈监控服务
 * Created by zhaohongbo on 17/2/16.
 */
@Service("shiguFeedbackService")
public class ShiguFeedbackServiceImpl implements ShiguFeedbackService {

    @Resource(name = "tae_mall_shiguFeedbackMapper")
    private ShiguFeedbackMapper shiguFeedbackMapper;

    @Override
    public void addRecord(ShiguFeedbackBO bo) {
        ShiguFeedback shiguFeedback = new ShiguFeedback();
        shiguFeedback.setFcontents(bo.getFcontents());
        shiguFeedback.setUserId(bo.getUserId());
        shiguFeedback.setStatus(0);
        shiguFeedbackMapper.insert(shiguFeedback);
    }

    @Override
    public List<ShiguFeedbackVO> selRecord(Long userId, Integer type) {
        if (userId == null) {
            return new ArrayList<>();
        }
        ShiguFeedbackExample shiguFeedbackExample = new ShiguFeedbackExample();
        shiguFeedbackExample.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(type);
        List<ShiguFeedback> shiguFeedbacks = shiguFeedbackMapper.selectByExample(shiguFeedbackExample);
        if (shiguFeedbacks == null || shiguFeedbacks.isEmpty()) {
            return null;
        }
        return BeanMapper.mapList(shiguFeedbacks,ShiguFeedbackVO.class);
    }

    @Override
    public void updateRecord(Long feedbackId, Integer type) {
        ShiguFeedback shiguFeedback = new ShiguFeedback();
        shiguFeedback.setFeedbackId(feedbackId);
        shiguFeedback.setStatus(type);
        shiguFeedbackMapper.updateByPrimaryKeySelective(shiguFeedback);
    }
}
