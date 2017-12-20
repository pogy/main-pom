package com.shigu.main4.order.whx;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by whx on 2017/7/20 0020.
 */
public class ItemOrderServiceImplTest extends BaseTest {

    @Autowired
    private ItemOrderService itemOrderService;


    @Test
    public void expressInfoTest() throws Main4Exception {
        show(itemOrderService.expressInfo(143L));
    }
}
