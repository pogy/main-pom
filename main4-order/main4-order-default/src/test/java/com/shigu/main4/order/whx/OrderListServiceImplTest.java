package com.shigu.main4.order.whx;

import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.zfenums.ShStatusEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        show(orderListService.selectSubList(70L));
    }

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
}
