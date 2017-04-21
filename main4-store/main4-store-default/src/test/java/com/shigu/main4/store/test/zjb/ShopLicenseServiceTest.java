package com.shigu.main4.store.test.zjb;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.common.vo.ShiguTags;
import com.shigu.main4.storeservices.ShopLicenseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/store_test.xml")
public class ShopLicenseServiceTest {

    @Autowired
    private ShopLicenseService shopLicenseService;

    @Test
    public void selTagLicenseByShopId(){
        Long shopId = 35992L;
        List<ShiguTags> shiguTagsList = shopLicenseService.selTagLicenseByShopId(shopId);
        System.out.println("标签：" + JSON.toJSONString(shiguTagsList));
    }

    @Test
    public void updateShopTagLickense(){
        Long shopId = 35992L;
        List<ShiguTags> shiguTagsList = new ArrayList<ShiguTags>();
        shiguTagsList.add(ShiguTags.CAN_CHANGE);
        shiguTagsList.add(ShiguTags.CAN_RETREAT);
        shopLicenseService.updateShopTagLicense(shopId, shiguTagsList);
        return;
    }
}
