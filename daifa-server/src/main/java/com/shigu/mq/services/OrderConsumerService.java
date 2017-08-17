package com.shigu.mq.services;

import com.alibaba.fastjson.JSON;
import com.shigu.mq.beans.ResponseBasic;
import org.springframework.stereotype.Service;

/**
 * Created by pc on 2017-08-17.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class OrderConsumerService {
    public void orderConvertTrade(byte[] body) {
        ResponseBasic res= JSON.parseObject(body,ResponseBasic.class);
        if(res.isStatus()){
            synchronized (this) {

                }

        }

    }
}
