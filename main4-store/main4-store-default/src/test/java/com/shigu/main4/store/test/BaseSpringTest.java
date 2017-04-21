package com.shigu.main4.store.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wxc on 2017/4/5.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/main4/spring/store_test.xml")
public class BaseSpringTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseSpringTest.class);

    public void show(Object object) {
        logger.info("\n" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));
    }
}
