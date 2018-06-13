package com.shigu.sn.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:/third_part.properties")
public class SnKeyConfig {
    @Autowired
    Environment environment;
    @PostConstruct
    public void initJdKeyConfig(){
        snAppkey=environment.getProperty("sn.app.key");
        snSecret=environment.getProperty("sn.app.secret");
        snRedirectUri=environment.getProperty("sn.redirect_uri");
        snFuWuId=environment.getProperty("sn.fuwu_id");
    }

    public static String snAppkey;

    public static String snSecret;

    public static String snRedirectUri;

    public static String snFuWuId;

}
