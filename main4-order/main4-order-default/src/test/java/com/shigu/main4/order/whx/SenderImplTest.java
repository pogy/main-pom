package com.shigu.main4.order.whx;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.Sender;
import com.shigu.main4.order.model.impl.SenderImpl;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;

/**
 * Created by whx on 2017/7/19 0019.
 */
public class SenderImplTest extends BaseTest {

    @Test
    public void selTemplateTest() {
        Sender sender = SpringBeanFactory.getBean(SenderImpl.class,1L);
        show(sender);
        show(sender.selTemplate());
    }
}
