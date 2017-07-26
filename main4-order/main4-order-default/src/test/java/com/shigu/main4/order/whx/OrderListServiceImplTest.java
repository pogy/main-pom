package com.shigu.main4.order.whx;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.services.OrderListService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by whx on 2017/7/26 0026.
 */
public class OrderListServiceImplTest extends BaseTest {

    @Autowired private OrderListService orderListService;

    @Test
    public void selectOrderAddrInfoTest() {
        show(orderListService.selectOrderAddrInfo(null));
        show(orderListService.selectOrderAddrInfo(5L));
        show(orderListService.selectOrderAddrInfo(90L));
    }

    @Test
    public void selectTotalTest() {
        show(orderListService.selectTotal(71L));
    }
}
