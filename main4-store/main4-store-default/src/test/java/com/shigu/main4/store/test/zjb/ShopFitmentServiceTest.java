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

}
