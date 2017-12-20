package com.shigu.mq.receives;

import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.mq.enums.MessageTagEnum;
import com.shigu.mq.services.OrderConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

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
    public void dispatchMessage(String tag, String key, byte[] s) throws UnsupportedEncodingException {
        MessageTagEnum messageTagEnum = MessageTagEnum.valueOf(tag.toUpperCase());
        String body=new String(s,"utf-8");
        switch (messageTagEnum){
            case ORDER_PUSH:{
                orderConsumerService.orderConvertTrade(body);
                break;
            }
            case ORDER_REFUND_NOITEM:{
                orderConsumerService.refund(body);
                break;
            }
            case ORDER_REFUND_HASITEM:{
                orderConsumerService.returnOrChange(body);
                break;
            }
            case REFUND_COURIER_NUMBER: case REFUND_COURIER_NUMBER_MODIFY:{
                orderConsumerService.setPost(body);
                break;
            }
            case REPRICE_AGREE:{
                orderConsumerService.reproce(body);
                break;
            }
            default:{
                break;
            }
        }
    }

}
