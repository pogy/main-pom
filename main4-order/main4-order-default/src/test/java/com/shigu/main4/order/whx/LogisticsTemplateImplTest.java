package com.shigu.main4.order.whx;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.model.impl.LogisticsTemplateImpl;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by whx on 2017/7/19 0019.
 */
public class LogisticsTemplateImplTest extends BaseTest {
    private LogisticsTemplate logisticsTemplate;

    @Before
    public void init() {
        logisticsTemplate = SpringBeanFactory.getBean(LogisticsTemplateImpl.class, 1L);
    }

    @Test
    public void templateInfoTest() {
        show(logisticsTemplate.templateInfo());
    }
}
