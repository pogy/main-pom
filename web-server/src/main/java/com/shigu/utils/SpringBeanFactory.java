package com.shigu.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * spring对象工厂
 * Created by zhaohongbo on 17/6/1.
 */
@Configuration
public class SpringBeanFactory implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanFactory.applicationContext=applicationContext;
    }

    /**
     * 获取某个Bean的对象
     */
    public static <T> T getBean(Class<T> clazz,Object... objs) {
        return applicationContext.getBean(clazz,objs);
    }
}
