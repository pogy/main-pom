package com.shigu.main4.cdn.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.OrderCity;
import com.opentae.data.mall.beans.OrderProv;
import com.opentae.data.mall.beans.OrderTown;
import com.opentae.data.mall.examples.OrderCityExample;
import com.opentae.data.mall.examples.OrderProvExample;
import com.opentae.data.mall.examples.OrderTownExample;
import com.opentae.data.mall.interfaces.OrderCityMapper;
import com.opentae.data.mall.interfaces.OrderProvMapper;
import com.opentae.data.mall.interfaces.OrderTownMapper;
import com.shigu.main4.cdn.bo.ScStoreBO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.zf.utils.SimilarityMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cdh on 2017/9/27.
 * Path com.shigu.main4.cdn.services.CdnServiceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/test.xml")
public class CdnServiceTest {
//@Autowired
//CdnService cdnService;

//    @Test
//    public void addShopCollect() throws Exception {
//
//        ScStoreBO bo = new ScStoreBO();
//        bo.setStore_id(43455L);
//        cdnService.addShopCollect(1000085908L,bo);
//    }

    private static SimilarityMap<OrderProv> similarityProvMap;
    private static SimilarityMap<OrderCity> similarityCityMap;
    private static SimilarityMap<OrderTown> similarityTownMap;

    @Test
    public void v(){
        SimilarityMap<OrderProv> provmap = similarityProvMap();
        SimilarityMap<OrderCity> citymap = similarityCityMap();
        SimilarityMap<OrderTown> townmap = similarityTownMap();
        OrderProv prov=provmap.get("河北省",0L);
        OrderCity city=citymap.get("唐山市",prov.getProvId());
        OrderTown town=townmap.get("路北区 ",city.getCityId());
        System.out.println();


//        OrderProvMapper orderProvMapper= SpringBeanFactory.getBean(OrderProvMapper.class);
//        OrderProvExample example1 = new OrderProvExample();
//        List<OrderProv> provs = orderProvMapper.selectFieldsByExample(example1, FieldUtil.codeFields("prov_id,prov_name"));
//        OrderCityMapper orderCityMapper=SpringBeanFactory.getBean(OrderCityMapper.class);
//        OrderCityExample example2 = new OrderCityExample();
//        List<OrderCity> citys = orderCityMapper.selectFieldsByExample(example2, FieldUtil.codeFields("city_id,city_name,prov_id"));
//        OrderTownMapper orderTownMapper=SpringBeanFactory.getBean(OrderTownMapper.class);
//        OrderTownExample example3 = new OrderTownExample();
//        List<OrderTown> towns = orderTownMapper.selectFieldsByExample(example3, FieldUtil.codeFields("town_id,town_name,city_id"));
//        for (OrderProv p : provs) {
//            for(OrderCity c:citys){
//                if(c.getProvId().longValue()!=p.getProvId()){
//                    continue;
//                }
//                for(OrderTown t:towns){
//                    if(t.getCityId().longValue()!=c.getCityId()){
//                        continue;
//                    }
//                    String s=p.getProvName()+c.getCityName()+t.getTownName();
//                    if(p.getProvName().equals("西藏")){
//                        System.out.println();
//                    }
//                    String s1=similarityProvMap.get(p.getProvName(),null).getProvName()
//                            +similarityCityMap.get(c.getCityName(),p.getProvId()).getCityName()
//                            +similarityTownMap.get(t.getTownName().substring(0,t.getTownName().length()-1),c.getCityId()).getTownName();
//                    if(!s.equals(s1)){
//                        System.out.println(s);
//                        System.out.println(s1);
//                        System.out.println(s.equals(s1));
//                    }
//                }
//            }
//        }
//        for (OrderProv p : provs) {
//            boolean b=similarityProvMap.get(p.getProvName().substring(0,p.getProvName().length()-1),null).getProvName().equals(p.getProvName());
//            if(!b){
//                System.err.println(p.getProvName());
//            }
//            for (OrderCity c : citys) {
//                boolean b1=similarityCityMap.get(c.getCityName().substring(0,p.getProvName().length()-1),p.getProvId()).getCityName().equals(c.getCityName());
//                if(!b1){
//                    System.err.println(c.getCityName());
//                }
//                for (OrderTown t : towns) {
//                    boolean b2=similarityTownMap.get(t.getTownName().substring(0,p.getProvName().length()-1),c.getCityId()).getTownName().equals(t.getTownName());
//                    if(!b2){
//                        System.err.println(t.getTownName());
//                    }
//                }
//            }
//        }
    }



    private static SimilarityMap<OrderProv> similarityProvMap(){
        if(similarityProvMap==null){
            similarityProvMap=new SimilarityMap<OrderProv>();
            OrderProvMapper orderProvMapper= SpringBeanFactory.getBean(OrderProvMapper.class);
            OrderProvExample example1 = new OrderProvExample();
            List<OrderProv> provs = orderProvMapper.selectFieldsByExample(example1, FieldUtil.codeFields("prov_id,prov_name"));
            for (OrderProv p : provs) {
                similarityProvMap.put(p.getProvName(), p);
            }
        }
        return similarityProvMap;
    }
    private static SimilarityMap<OrderCity> similarityCityMap(){
        if(similarityCityMap==null){
            similarityCityMap=new SimilarityMap<OrderCity>();
            OrderCityMapper orderCityMapper=SpringBeanFactory.getBean(OrderCityMapper.class);
            OrderCityExample example2 = new OrderCityExample();
            List<OrderCity> citys = orderCityMapper.selectFieldsByExample(example2, FieldUtil.codeFields("city_id,city_name,prov_id"));
            for (OrderCity c : citys) {
                similarityCityMap.put(c.getCityName(), c);
            }
        }
        return similarityCityMap;
    }
    private static SimilarityMap<OrderTown> similarityTownMap(){
        if(similarityTownMap==null){
            similarityTownMap=new SimilarityMap<OrderTown>();
            OrderTownMapper orderTownMapper=SpringBeanFactory.getBean(OrderTownMapper.class);
            OrderTownExample example2 = new OrderTownExample();
            List<OrderTown> towns = orderTownMapper.selectFieldsByExample(example2, FieldUtil.codeFields("town_id,town_name,city_id"));
            for (OrderTown t : towns) {
                similarityTownMap.put(t.getTownName(), t);
            }
        }
        return similarityTownMap;
    }


}