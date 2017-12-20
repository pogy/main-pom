package com.shigu.main4.order.whx;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.Sender;
import com.shigu.main4.order.model.impl.SenderImpl;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by whx on 2017/7/19 0019.
 */
public class SenderImplTest extends BaseTest {

    private Sender sender;

    @Before
    public void init() {
        sender = SpringBeanFactory.getBean(SenderImpl.class,1L);
    }

    @Test
    public void selTemplateTest() {
        show(sender);
        show(sender.selTemplate());
    }

    @Test
    public void usedTemplateTest() {
        show(sender.usedTemplate());
    }
}
