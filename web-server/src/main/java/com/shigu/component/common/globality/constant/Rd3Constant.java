package com.shigu.component.common.globality.constant;


import com.shigu.component.common.taobao.TaobaoConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * 第三方配置
 *
 */
@Component("rd3Constant")
public class Rd3Constant {

    @Value("${taobao.app.key}")
    public String app_key;

    @Value("${taobao.app.secret}")
    public String app_secret;

    @Value("${taobao.app.server.url}")
    public String app_server_url;



    @PostConstruct
    public void init() {
        if(!StringUtils.isEmpty(TaobaoConfig.appKey)){
            return;
        }
        TaobaoConfig.appKey = this.app_key;
        TaobaoConfig.appSecret = this.app_secret;
        TaobaoConfig.appServerUrl = this.app_server_url;
    }

}
