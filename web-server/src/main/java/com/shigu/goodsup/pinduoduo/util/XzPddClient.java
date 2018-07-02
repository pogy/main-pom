package com.shigu.goodsup.pinduoduo.util;

import org.springframework.stereotype.Component;
import pdd.DefaultPddClient;
import pdd.PddClient;
import pdd.constant.PddConfig;

/**
 * Created by gtx on 2018/6/21.
 *
 * @author gtx
 * @since
 */
@Component
public class XzPddClient {
    
    public PddClient openClient(String accessToken){
        return new DefaultPddClient(PddConfig.API_URL,accessToken,PddConfig.APP_KEY,PddConfig.APP_SECRET);
    }

}
