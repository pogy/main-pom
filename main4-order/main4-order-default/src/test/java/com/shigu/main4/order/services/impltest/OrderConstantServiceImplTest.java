package com.shigu.main4.order.services.impltest;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.OrderConstant;
import com.opentae.data.mall.interfaces.OrderConstantMapper;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.CityVO;
import com.shigu.main4.order.vo.ProvinceVO;
import com.shigu.main4.order.vo.ServiceVO;
import com.shigu.main4.order.vo.TownVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;

/**
 * 订单常量服务测试
 * Created by bugzy on 2017/6/9 0009.
 */
public class OrderConstantServiceImplTest extends BaseTest {
    @Test
    public void selProvinces() throws Exception {
        List<ProvinceVO> vos = orderConstantService.selProvinces();
        assertFalse(vos.isEmpty());
        show(vos);
    }

    @Test
    public void selCitysByPid() throws Exception {
        List<ProvinceVO> provinces = orderConstantService.selProvinces();
        Long provinceId = provinces.get(0).getProvinceId();
        List<CityVO> cityVOS = orderConstantService.selCitysByPid(provinceId);
        assertFalse(cityVOS.isEmpty());
        show(cityVOS);
    }

    @Test
    public void selTownByCid() throws Exception {
        List<ProvinceVO> provinces = orderConstantService.selProvinces();
        Long provinceId = provinces.get(0).getProvinceId();
        List<CityVO> cityVOS = orderConstantService.selCitysByPid(provinceId);
        Long cityId = cityVOS.get(0).getCityId();
        List<TownVO> townVOS = orderConstantService.selTownByCid(cityId);
        assertFalse(townVOS.isEmpty());
        show(townVOS);
    }

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

}