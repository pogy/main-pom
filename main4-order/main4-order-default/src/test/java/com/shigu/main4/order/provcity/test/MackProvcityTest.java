package com.shigu.main4.order.provcity.test;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.interfaces.OrderCityMapper;
import com.opentae.data.mall.interfaces.OrderProvMapper;
import com.opentae.data.mall.interfaces.OrderTownMapper;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.CityVO;
import com.shigu.main4.order.vo.ProvinceVO;
import com.shigu.main4.order.vo.TownVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 省市联动数据摘取
 * Created by zhaohongbo on 17/6/21.
 */
public class MackProvcityTest extends BaseTest {

    @Autowired
    private OrderConstantService orderConstantService;

    @Autowired
    private OrderProvMapper orderProvMapper;

    @Autowired
    private OrderCityMapper orderCityMapper;

    @Autowired
    private OrderTownMapper orderTownMapper;

    @Test
    public void testAuto(){
        ItemOrder itemOrder=SpringBeanFactory.getBean(ItemOrder.class,1L);
        System.out.println(itemOrder);
    }
    /**
     * 读出数据
     */
    @Test
    public void test(){
        List<ProvinceVO> ps=orderConstantService.selProvinces();
        List<Prov> pvs=new ArrayList<>();
        for(ProvinceVO p:ps){
            Prov pr=new Prov();
            pr.setProvinceId(p.getProvinceId().toString());
            pr.setText(p.getProvince());
            pr.setCitys(new ArrayList<City>());
            pvs.add(pr);
            List<CityVO> cityVOs=orderConstantService.selCitysByPid(p.getProvinceId());
            if(cityVOs!=null){
                for(CityVO cv:cityVOs){
                    City c=new City();
                    c.setText(cv.getCity());
                    c.setCityId(cv.getCityId().toString());
                    c.setCountys(new ArrayList<Country>());
                    pr.getCitys().add(c);
                    List<TownVO> townVOs=orderConstantService.selTownByCid(cv.getCityId());
                    if(townVOs!=null){
                        for(TownVO tv:townVOs){
                            Country country=new Country();
                            country.setText(tv.getTown());
                            country.setCountyId(tv.getTownId().toString());
                            c.getCountys().add(country);
                        }
                    }
                }
            }
        }
        System.out.println(JSON.toJSONString(pvs));
    }

    @Test
    public void ttt(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("step");
        stringBuilder.append(":");
        System.out.println(stringBuilder.toString());
    }

}
