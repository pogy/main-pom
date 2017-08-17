package com.shigu.mq.receives;

import com.shigu.mq.enums.MessageTagEnum;
import com.shigu.mq.services.OrderConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pc on 2017-08-17.
 * 处理接受到的消息
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Component
public class DefaultProcessMessage {

    private OrderConsumerService orderConsumerService;
    @Autowired
    public void setOrderConsumerService(OrderConsumerService orderConsumerService) {
        this.orderConsumerService = orderConsumerService;
    }

    /**
     * 分发消息到相应的service
     *  @param tag
     * @param key
     * @param s
     */
    public void dispatchMessage(String tag, String key, byte[] s) {
        MessageTagEnum messageTagEnum = MessageTagEnum.valueOf(tag.toUpperCase());

        switch (messageTagEnum){
            case ORDER_PUSH:{

                orderConsumerService.orderConvertTrade(s);
                break;
            }
            default:{
                break;
            }
        }
    }

}
