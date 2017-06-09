package com.shigu.main4.order.services.impltest;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.OrderConstant;
import com.opentae.data.mall.interfaces.OrderConstantMapper;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.MetarialVO;
import com.shigu.main4.order.vo.OrderConstantVo;
import com.shigu.main4.order.vo.ServiceVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单常量服务测试
 * Created by bugzy on 2017/6/9 0009.
 */
public class OrderConstantServiceImplTest extends BaseTest {

    @Autowired
    private OrderConstantService orderConstantService;

    @Autowired
    private OrderConstantMapper orderConstantMapper;

    //@Test
    public void addConstant(){
        OrderConstant constant = new OrderConstant();

        // 初始化一个服务
        constant.setType(OrderConstantService.SERVICE_TYPE);
        constant.setName("一键代发");
        ServiceVO serviceVO = new ServiceVO();
        serviceVO.setId(1L);
        serviceVO.setName("代发服务");
        serviceVO.setPrice(100L);
        serviceVO.setDetail("货品一件代发服务由星帮提供服务。");
        constant.setContext(JSON.toJSONString(serviceVO));
//
        // 初始化一个包材
//        constant.setType(OrderConstantService.PACKAGE_TYPE);
//        constant.setName("加厚飞机盒");
//        MetarialVO metarialVO = new MetarialVO();
//        metarialVO.setId(2L);
//        metarialVO.setName("霸王飞机盒加厚");
//        metarialVO.setPrice(700L);
//        metarialVO.setSize("480X680X220MM");
//        constant.setContext(JSON.toJSONString(metarialVO));

        // 初始化一个物流
//        constant.setType(OrderConstantService.LOGISTICS_TYPE);
//        constant.setName("赵信物流");
//        LogisticsCompanyVO logisticsCompanyVO = new LogisticsCompanyVO();
//        logisticsCompanyVO.setId(1L);
//        logisticsCompanyVO.setName("赵信物流");
//        constant.setContext(JSON.toJSONString(logisticsCompanyVO));

        orderConstantMapper.insertSelective(constant);
    }

    @Test
    public void selServices() throws Exception {
        show(orderConstantService.selServices(-1L));
    }

    @Test
    public void selServiceById() throws Exception {
        show(orderConstantService.selServiceById(-1L, 1L));
    }

    @Test
    public void selMetarials() throws Exception {
        show(orderConstantService.selMetarials(-1L));
    }

    @Test
    public void selMetarialById() throws Exception {
        show(orderConstantService.selMetarialById(-1L, 2L));
    }

    @Test
    public void selLogistics() throws Exception {
        show(orderConstantService.selLogistics(-1L));
    }

    @Test
    public void selLogisticsById() throws Exception {
        show(orderConstantService.selLogisticsById(-1L, 1L));
    }

}