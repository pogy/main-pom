package com.shigu.main4.order.model.impl;

import com.shigu.main4.order.model.Sender;
import com.shigu.main4.order.vo.LogisticsTemplateVO;

import java.util.List;

/**
 * 发送者实现
 * Created by zhaohongbo on 17/7/19.
 */
public class SenderImpl implements Sender {
    @Override
    public void sendOrder(Long oid, String logistics) {

    }

    @Override
    public List<LogisticsTemplateVO> selTemplate() {
        return null;
    }

    @Override
    public LogisticsTemplateVO usedTemplate() {
        return null;
    }
}
