package com.shigu.main4.monitor.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by zhaohongbo on 17/5/17.
 */
@Component
public class FactoryTest implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    /**
     * 获取某个Bean的对象
     */
    public <T> T getBean(Class<T> clazz) {
        try {
            return applicationContext.getBean(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
