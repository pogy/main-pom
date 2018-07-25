package com.shigu.main4.order.whx;

import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.services.OrderListService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

/**
 * Created by whx on 2017/7/26 0026.
 */
public class OrderListServiceImplTest extends BaseTest {

    @Autowired private OrderListService orderListService;

    @Test
    public void selectExpressTest() {
        try {
            show(orderListService.selectExpress(143L));
        } catch (Main4Exception e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ItemOrderMapper itemOrderMapper;


    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

}
