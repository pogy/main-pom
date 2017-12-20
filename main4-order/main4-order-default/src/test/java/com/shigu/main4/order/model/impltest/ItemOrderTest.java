package com.shigu.main4.order.model.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.LogisticsVO;
import com.shigu.main4.order.vo.PayedVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        show(order().selLogisticses());
    }

    @Test
    public void orderInfo() throws Exception {
        show(order().orderInfo());
    }

    @Test
    public void subOrdersInfo() throws Exception {
        show(order().subOrdersInfo());
    }

    @Test
    public void addLogistics() throws Exception {
        List<Long> soids = new ArrayList<>();

        show(order().orderInfo());
        LogisticsVO vo = new LogisticsVO();
        vo.setAddress("环北西北");
        vo.setCityId(1L);
        vo.setCompanyId(2L);
        vo.setMoney(400L);
        vo.setProvId(1L);
        vo.setTelephone("15151515151");
        vo.setTownId(2L);
        vo.setZipCode("UUID");
        vo.setCourierNumber("1231");
        order().addLogistics(soids, vo,true);
        show(order().orderInfo());
        selLogisticses();
    }

    @Test
    public void modifyLogistics() throws Exception {
        LogisticsVO vo = new LogisticsVO();
        vo.setMoney(400L);
        show(order().orderInfo());
        order().modifyLogistics(1L, vo);
        show(order().orderInfo());
    }

    @Test
//    @Transactional
    public void addPackage() throws Exception {

        order().addPackage(1L, 5,true);
        show(order().orderInfo());
    }

    @Test
    public void refundPackage() throws Exception {
    }

    @Test
    public void addService() throws Exception {
//        order().addService(1L);
//        show(order().orderInfo());
    }

    @Test
    public void refundService() throws Exception {
        order().refundService(1L, 20L);
    }

    @Test
    public void sended() throws Exception {
        order().sended("1273456167254178");
    }

    @Test
    public void sendPart() throws Exception {
    }

    @Test
    public void selSender() throws Exception {
        show(order().selSender());
    }

    @Test
    public void payApply() throws Exception {
    }

    @Test
    public void addSubOrder() throws Exception {
//        List<SubOrderVO> subs = new ArrayList<>();
//
//        SubOrderVO vo1 = new SubOrderVO();
//        vo1.setGoodsId(20724865L);
//        vo1.setColor("深灰色");
//        vo1.setSize("M 28-29");
//        vo1.setNum(1);
//        subs.add(vo1);
//        order().addSubOrder(subs);
//
//        show(order().orderInfo());
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
    @Test
    public void payedInfo(){
        ItemOrder order = SpringBeanFactory.getBean(ItemOrder.class, 1L);
        List<PayedVO> payedVOS = order.payedInfo();
        for (PayedVO vo:payedVOS){
            System.out.println(vo);
        }
    }

}
