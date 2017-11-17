package com.shigu.main4.ucenter.services.test.sjb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @类编号
 * @类名称：BaseTest
 * @文件路径：com.shigu.main4.ucenter.services.test.sjb.BaseTest
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/3 20:54
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/main4/spring/spring.xml")
public class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected void show(Object o) {
        logger.info("\n" + JSON.toJSONStringWithDateFormat(o, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));
    }
}
