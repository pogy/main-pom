package com.shigu.main4.daifa.mq;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import org.springframework.stereotype.Service;

/**
 * 退款处理服务
 */
@Service("refundListener")
public class RefundListener implements MessageListener {

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        return null;
    }
}
