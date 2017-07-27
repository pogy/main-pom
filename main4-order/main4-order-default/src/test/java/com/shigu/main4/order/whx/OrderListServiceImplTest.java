package com.shigu.main4.order.whx;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.zfenums.ShStatusEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

/**
 * Created by whx on 2017/7/26 0026.
 */
public class OrderListServiceImplTest extends BaseTest {

    @Autowired private OrderListService orderListService;



    @Test
    public void selectCountShManaOrderTest() throws ParseException {
        show(orderListService.selectCountShManaOrder(ShStatusEnum.CHANGE,1,20,9968L));
    }

    @Test
    public void selectCountMyOrderTest() throws ParseException {
        OrderBO bo = generateOrderBO(null, null, null, null, "测试goodsNo", null, null, 2, 20);
        show(orderListService.selectCountMyOrder(bo,9968L));
    }

    @Test
    public void myOrderTest() throws ParseException {
        OrderBO bo = generateOrderBO(null, null, "2017-07-25 00:00:00", "2017-07-26 23:59:59", null, null, null, 1, 20);
        show(orderListService.myOrder(bo,9968L));
        bo.setSt(null);
        bo.setEt(null);
        bo.setReceiver("测试");
        show(orderListService.myOrder(bo,9968L));
        bo.setReceiver(null);
        bo.setTelePhone("15151515151");
        show(orderListService.myOrder(bo,9968L));
        bo.setTelePhone(null);
        bo.setStatus("3");
        show(orderListService.myOrder(bo,9968L));
        bo.setGoodsNo("测试goodsNo");
        show(orderListService.myOrder(bo,9968L));
        bo.setPage(2);
        show(orderListService.myOrder(bo,9968L));
    }

    @Test
    public void selectMyorderTest() {
        show(orderListService.selectMyorder(3L));
    }

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

    @Test
    public void selectSubListTest() {
        show(orderListService.selectSubList(70L));
    }

    @Test
    public void selectExpressTest() {
        try {
            show(orderListService.selectExpress(2L));
        } catch (Main4Exception e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private OrderBO generateOrderBO(String status, Long orderId, String startTime, String endTime, String goodsNo, String receiver, String telePhone, Integer page, Integer pageSize) {
        OrderBO bo = new OrderBO();
        bo.setOrderId(orderId);
        bo.setSt(startTime);
        bo.setEt(endTime);
        bo.setGoodsNo(goodsNo);
        bo.setReceiver(receiver);
        bo.setTelePhone(telePhone);
        bo.setStatus(status);
        bo.setPage(page);
        bo.setPageSize(pageSize);
        return bo;
    }
}
