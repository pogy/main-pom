package com.shigu.main4.order.whx;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.services.ItemOrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by whx on 2017/7/20 0020.
 */
public class ItemOrderServiceImplTest extends BaseTest {

    @Autowired
    private ItemOrderService itemOrderService;

    @Test
    public void suborderInfoTest() {
        show(itemOrderService.suborderInfo(10L));
    }

    @Test
    public void expressInfoTest() {
        itemOrderService.expressInfo(2L);
    }
}
