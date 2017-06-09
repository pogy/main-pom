package com.shigu.main4.order.services.impltest;

import com.opentae.data.mall.beans.ItemOrderSender;
import com.opentae.data.mall.interfaces.ItemOrderSenderMapper;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Created by bugzy on 2017/6/9 0009.
 */
public class ItemOrderServiceImplTest extends BaseTest {

    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private ItemOrderSenderMapper itemOrderSenderMapper;


    @Test
//    @Transactional
    public void createOrder() throws Exception {

        ItemOrderBO orbo = new ItemOrderBO();
        orbo.setWebSite("hz");
        orbo.setSenderId(1L);
        Long order = itemOrderService.createOrder(orbo);

        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, order);
        show(itemOrder.orderInfo());
        // 如果订单创建异常，调用订单信息会发生错误
    }

}