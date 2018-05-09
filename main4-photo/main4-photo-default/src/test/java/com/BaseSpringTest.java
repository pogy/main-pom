package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * PATH: com.BaseSpringTest
 * PROJECT: main-pom
 * TIME: 18-5-8 下午4:11
 * USER: wanghaoxiang
 * DESCRIPTION: 单元测试基类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-photo-test.xml")
public class BaseSpringTest {

    public static final Logger logger = LoggerFactory.getLogger(BaseSpringTest.class);

    public void show(Object object) {
        System.out.println("\n" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));
    }

    public void info(Object object) {
        logger.info("\n" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));
    }
}
