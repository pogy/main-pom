package com.shigu.main4.order.model.impltest;

import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhaohongbo on 17/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test.xml")
public class ItemOrderTest {

    @Test
    public void test(){
        ItemOrder order=SpringBeanFactory.getBean(ItemOrder.class,111L);
        ItemOrderVO iv= order.orderInfo();
        System.out.println(iv.getOrderId());
    }
}
