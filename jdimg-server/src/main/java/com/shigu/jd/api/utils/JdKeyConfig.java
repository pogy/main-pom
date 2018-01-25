package com.shigu.jd.api.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:/third_part.properties")
public class JdKeyConfig {
    @Autowired
    Environment environment;
    @PostConstruct
    public void initJdKeyConfig(){
        jdAppkey=environment.getProperty("jd.app.key");
        jdSecret=environment.getProperty("jd.app.secret");
        jdState=environment.getProperty("jd.app.state");
        jdRedirectUri=environment.getProperty("jd.app.redirect_uri");
        itemId=environment.getProperty("jd.app.itemId");
    }

    public static String jdAppkey;

    public static String jdSecret;

    public static String jdState;

    public static String jdRedirectUri;

    public static String itemId;

}
