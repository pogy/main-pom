package com.shigu.main4.order.model.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.SubOrderVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * ItemOrder Test
 * Created by zhaohongbo on 17/6/1.
 */
public class ItemOrderTest extends BaseTest {

    @Autowired
    private ItemOrderService itemOrderService;

    private ItemOrder order() {
        return SpringBeanFactory.getBean(ItemOrder.class, 2L);
    }

    @Test
    public void selLogisticses() throws Exception {

    }

    @Test
    public void orderInfo() throws Exception {
    }

    @Test
    public void subOrdersInfo() throws Exception {
        show(order().subOrdersInfo());
    }

    @Test
    public void addLogistics() throws Exception {
    }

    @Test
    public void modifyLogistics() throws Exception {
    }

    @Test
//    @Transactional
    public void addPackage() throws Exception {

        order().addPackage(1L, 5);
        show(order().orderInfo());
    }

    @Test
    public void refundPackage() throws Exception {
    }

    @Test
    public void addService() throws Exception {
        order().addService(1L);
        show(order().orderInfo());
    }

    @Test
    public void refundService() throws Exception {
    }

    @Test
    public void sended() throws Exception {
    }

    @Test
    public void sendPart() throws Exception {
    }

    @Test
    public void selSender() throws Exception {
    }

    @Test
    public void payApply() throws Exception {
    }

    @Test
    public void addSubOrder() throws Exception {
        List<SubOrderVO> subs = new ArrayList<>();

        SubOrderVO vo1 = new SubOrderVO();
        vo1.setGoodsId(20724865L);
        vo1.setColor("深灰色");
        vo1.setSize("M 28-29");
        vo1.setNum(1);
        subs.add(vo1);
        order().addSubOrder(subs);

        show(order().orderInfo());
    }

    @Test
    public void repayApply() throws Exception {
    }

    @Test
    public void pay() throws Exception {
    }

    @Test
    public void refunds() throws Exception {
    }

    @Test
    public void addMark() throws Exception {
    }

    @Test
    public void payed() throws Exception {
    }

    @Test
    public void finished() throws Exception {
    }

    @Test
    public void closed() throws Exception {
    }

    @Test
    public void test(){
        ItemOrder order=SpringBeanFactory.getBean(ItemOrder.class,111L);
        ItemOrderVO iv= order.orderInfo();
        System.out.println(iv.getOrderId());
    }
}
