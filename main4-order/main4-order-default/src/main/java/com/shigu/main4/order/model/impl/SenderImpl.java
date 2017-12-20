package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.LogisticsTemplate;
import com.opentae.data.mall.examples.LogisticsTemplateExample;
import com.opentae.data.mall.interfaces.ItemOrderSenderMapper;
import com.opentae.data.mall.interfaces.LogisticsTemplateMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.model.Sender;
import com.shigu.main4.order.vo.LogisticsTemplateVO;
import com.shigu.main4.order.vo.SenderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 发送者实现
 * Created by zhaohongbo on 17/7/19.
 */
@Service
@Scope("prototype")
public class SenderImpl implements Sender {

    @Autowired
    private LogisticsTemplateMapper logisticsTemplateMapper;

    @Autowired
    private ItemOrderSenderMapper itemOrderSenderMapper;

    private Long senderId;

    public SenderImpl(Long senderId) {
        this.senderId = senderId;
    }

    /**
     * 发货机构信息
     */
    @Override
    public SenderVO senderInfo() {
        return BeanMapper.map(itemOrderSenderMapper.selectByPrimaryKey(senderId), SenderVO.class);
    }

    @Override
    public void sendOrder(Long oid, String logistics) {

    }

    @Override
    public List<LogisticsTemplateVO> selTemplate() {
        LogisticsTemplateExample logisticsTemplateExample = new LogisticsTemplateExample();
        logisticsTemplateExample.createCriteria().andSenderIdEqualTo(senderId);
        return BeanMapper.mapList(logisticsTemplateMapper.selectByExample(logisticsTemplateExample),LogisticsTemplateVO.class) ;
    }

    @Override
    public LogisticsTemplateVO usedTemplate() {
        LogisticsTemplate logisticsTemplate = new LogisticsTemplate();
        logisticsTemplate.setEnabled(true);
        logisticsTemplate.setSenderId(senderId);
        LogisticsTemplate result = logisticsTemplateMapper.selectOne(logisticsTemplate);
        if (result == null) {
            logisticsTemplate.setSenderId(-1L);
            result = logisticsTemplateMapper.selectOne(logisticsTemplate);
        }
        return BeanMapper.map(result, LogisticsTemplateVO.class);
    }

    public Long getSenderId() {
        return senderId;
    }

}
