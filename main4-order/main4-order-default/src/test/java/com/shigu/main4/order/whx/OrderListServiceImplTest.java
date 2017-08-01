package com.shigu.main4.order.whx;

import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.zfenums.ShStatusEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by whx on 2017/7/26 0026.
 */
public class OrderListServiceImplTest extends BaseTest {

    @Autowired private OrderListService orderListService;



    @Test
    public void selectCountShManaOrderTest() throws ParseException {
        show(orderListService.selectCountShManaOrder(ShStatusEnum.REFUND,1,20,9968L));
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
        show(orderListService.selectSubList(2L));
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

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Test
    public void testOrderInfos() {
        show(itemOrderMapper.selOrderInfoDetailByOrderId(68L));
        System.out.println("-------------------------------------------------------------------------");
        show(itemOrderMapper.selOrderInfoDetailByOrderId(2L));
    }

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Test
    public void testSubOrderInfos() {
       itemOrderSubMapper.selSubOrderAndRefundInfos(2L).forEach(subOrderInfo -> {
           show(subOrderInfo);
           show(subOrderInfo.getItemOrderRefund());
           System.out.println("--------------------");
       });
    }

    @Test
    public void shPagerTest() {
        show(itemOrderMapper.selShOidsByUserId(9968L,null,0,6));
        show(itemOrderMapper.selShOidsByUserId(9968L,1,0,5));
        show(itemOrderMapper.selShOrderCount(9968L,1));
        show(itemOrderMapper.selShOrderCount(9968L,null));
    }

    @Test
    public void orderPagerTest() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        show(itemOrderMapper.selOidsByBo(9968L,null,3,sdf.parse("2017-07-23 00:00:00"),sdf.parse("2017-07-31 00:00:00"),"测试goods","测试","15151515151",0,10));
        show(itemOrderMapper.selOidsCountByBo(9968L,null,3,sdf.parse("2017-07-23 00:00:00"),sdf.parse("2017-07-31 00:00:00"),"测试goods","测试","15151515151"));
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
