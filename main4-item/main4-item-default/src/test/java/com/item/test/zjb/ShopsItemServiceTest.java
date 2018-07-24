package com.item.test.zjb;

import com.shigu.main4.item.services.ShopsItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 店铺商品
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:main4/spring/item_test.xml"})
public class ShopsItemServiceTest {

    @Autowired
    private ShopsItemService shopsItemService;

    @Test
    public void downuploadItem(){
        Long goodsId = 20396142L;
        String uploadUrl = shopsItemService.itemImgzipUrl(goodsId);
        System.out.println("OSS下载路径：" + uploadUrl);
    }

}
