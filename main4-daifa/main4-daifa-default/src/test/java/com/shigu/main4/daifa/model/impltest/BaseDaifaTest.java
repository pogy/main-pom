package com.shigu.main4.daifa.model.impltest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jmb on 2017/8/10.
 * Path com.shigu.main4.spring-database.model.impltest.BaseDaifaTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class BaseDaifaTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseDaifaTest.class);

    public void show(Object object) {
        logger.info("\n" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));
    }
}
