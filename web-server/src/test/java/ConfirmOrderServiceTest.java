import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.bo.ConfirmOrderBO;
import com.shigu.order.bo.ConfirmSubOrderBO;
import com.shigu.order.services.CartService;
import com.shigu.order.services.ConfirmOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/main4/spring/redisTest.xml")
public class ConfirmOrderServiceTest {


    @Test
    public void environmentTest() {

    }
    @Autowired
    ConfirmOrderService confirmOrderService;

    @Autowired
    CartService cartService;

    @Test
    public void confirmOrderServiceTest() {
        ConfirmBO confirmBO = new ConfirmBO();
        String code = null;
        Long oid = null;
//        confirmBO.setAddressId(24L);
//        confirmBO.setCourierId(1L);
//        confirmBO.setSenderId(1L);
        try {
            code = cartService.submitOrders(Lists.newArrayList(3L,4L,5L),9968L);
        } catch (JsonErrException e) {
            System.out.println("CartService#submitOrders异常");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("code:"+code);
        confirmBO.setCode(code);
        List<ConfirmOrderBO> confirmOrderBOList = Lists.newArrayList();
        ConfirmSubOrderBO confirmSubOrderBOshop1_1 = getConfirmSubOrderBO("3",4);
        ConfirmOrderBO confirmOrderBOShop1 = getConfirmOrderBO("1L","测试店铺1",Lists.<ConfirmSubOrderBO>newArrayList(confirmSubOrderBOshop1_1));
        ConfirmSubOrderBO confirmSubOrderBOShop2_1 = getConfirmSubOrderBO("4",5);
        ConfirmSubOrderBO confirmSubOrderBOShop2_2 = getConfirmSubOrderBO("5",3);
        ConfirmOrderBO confirmOrderBOShop2 = getConfirmOrderBO("2L","测试店铺2",Lists.<ConfirmSubOrderBO>newArrayList(confirmSubOrderBOShop2_1,confirmSubOrderBOShop2_2));

        confirmOrderBOList.add(confirmOrderBOShop1);
        confirmOrderBOList.add(confirmOrderBOShop2);
        confirmBO.setOrders(confirmOrderBOList);
        try {
            oid = confirmOrderService.confirmOrders(confirmBO,9968L);
        } catch (Main4Exception e) {
            System.out.println("ConfirmOrderService#submit异常");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(oid);
    }

    private ConfirmSubOrderBO getConfirmSubOrderBO(String id, Integer num) {
        ConfirmSubOrderBO bo = new ConfirmSubOrderBO();
        bo.setId(id);
        bo.setNum(num);
        return bo;
    }

    private ConfirmOrderBO getConfirmOrderBO(String orderId, String remark, List<ConfirmSubOrderBO> childOrders) {
        ConfirmOrderBO bo = new ConfirmOrderBO();
//        bo.setOrderId(orderId);
        bo.setRemark(remark);
        bo.setChildOrders(childOrders);
        return bo;
    }
}
