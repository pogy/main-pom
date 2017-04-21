package com.shigu.main4.store.test.zjb;


import com.alibaba.fastjson.JSON;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.storeservices.ShopFitmentService;
import com.shigu.main4.vo.ShopFitmentForUpadte;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 店铺装修修改
 * @author shigu_zjb
 * @date 2017/02/25 15:45
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/store_test.xml")
public class ShopFitmentServiceTest {

    @Resource(name = "shopFitmentService")
    private ShopFitmentService shopFitmentService;

    /**
     * 店铺修改查询
     */
    @Test
    public void selFitmentForUpadte(){
        Long shopId = 32888L;
        ShopFitmentForUpadte shopFitmentForUpadte = shopFitmentService.selFitmentForUpadte(shopId);
        System.out.println("店铺修改查询：" + JSON.toJSONString(shopFitmentForUpadte));
        Assert.assertTrue(shopFitmentForUpadte!=null);

        shopId = 32999L;
        shopFitmentForUpadte = shopFitmentService.selFitmentForUpadte(shopId);
        System.out.println("店铺修改查询：" + JSON.toJSONString(shopFitmentForUpadte));
        Assert.assertTrue(shopFitmentForUpadte==null);
    }

    /**
     * 店铺装修更新
     */
    @Test
    public void updateFitment() throws ShopFitmentException {
        Long shopId = 32888L;
        Long fltId = 1L;
        ShopFitmentForUpadte shopFitmentForUpadte = new ShopFitmentForUpadte();
        shopFitmentForUpadte.setFitmentId(fltId);
        shopFitmentForUpadte.setShopName("我是小球球2");

        shopFitmentService.updateFitment(shopId ,shopFitmentForUpadte);

        shopId = 32999L;

        try{
            shopFitmentService.updateFitment(shopId ,shopFitmentForUpadte);
        }catch(Exception e){
            Assert.assertTrue(e instanceof ShopFitmentException);
            System.out.println("抛出异常，信息不对应");
        }
    }
}
