package com.shigu.mq.receives;


import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

/**
 *
 */
public class ReceiveMessageListener implements MessageListener {

    private final static Logger log = LogManager.getLogger(ReceiveMessageListener.class);
    private DefaultProcessMessage defaultProcessMessage;
    @Autowired
    public void setDefaultProcessMessage(DefaultProcessMessage defaultProcessMessage) {
        this.defaultProcessMessage = defaultProcessMessage;
    }

    public Action consume(Message message, ConsumeContext context) {
            defaultProcessMessage.dispatchMessage(message.getTag(),message.getKey(),message.getBody());


//        System.out.println("Receive: " + message.getMsgID()+"@message.getTag ()="+message.getTag ());
//        try {
//            System.out.println(new String(message.getBody(),"utf-8"));
//            messageDealService.dealMessage (message.getTag (),message.getKey (),
//                    new String(message.getBody(),"utf-8"));
//            //do something..
//            return Action.CommitMessage;
//        }catch (TradeAddException e){
//            log.error("添加订单失败"+message.getKey()+":"+e.getCode()+"--"+e.getMessage());
//            return Action.ReconsumeLater;
//        }catch (DaifaAfterSaleException e){
//            log.error("快递回写失败"+message.getKey()+":"+e.getCode()+"--"+e.getMessage());
//            return Action.ReconsumeLater;
//        }catch (Exception e) {
//            //消费失败
//            log.error(e,e);
//            return Action.ReconsumeLater;
//        }
        return Action.CommitMessage;
    }

}
