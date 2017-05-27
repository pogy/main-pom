package com.shigu.main4.item.update.wxc;

import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.item.services.PriceCalculateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by bugzy on 2017/5/27 0027.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:main4/spring/item-update.xml")
public class ModPriceCalculateServiceImplTest {

    @Resource(name = "mod_mod")
    PriceCalculateService priceCalculateService;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Test
    public void run() throws InterruptedException {
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite("hz");
        tinyExample.setStartIndex(4000);
        tinyExample.setEndIndex(50);
        for (ShiguGoodsTiny tiny : shiguGoodsTinyMapper.selectByConditionList(tinyExample)) {
            System.out.println(tiny.getGoodsId() + ", " + tiny.getTitle() + ", " + tiny.getGoodsNo() + ", " + tiny.getOuterId());
            System.out.println("原价："+tiny.getPrice()+", 计算批发价:" + priceCalculateService.pickPipriceFromTitle(tiny.getStoreId(), tiny.getPrice(), tiny.getTitle(), tiny.getGoodsNo(), tiny.getOuterId()));
            System.out.println();
            Thread.sleep(1000);
        }
    }
}
