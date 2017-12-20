package com.shigu.main4.tools;

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

    public static <T> T getBeanByName(String beanName, Class<T> clazz) {
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 根据名称获取Bean
     * @param beanName  Bean 名称
     * @param clazz bean 类型
     */
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return applicationContext.getBean(beanName, clazz);
    }
}
