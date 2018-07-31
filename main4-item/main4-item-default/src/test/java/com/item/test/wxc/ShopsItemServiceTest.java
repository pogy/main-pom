package com.item.test.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.exceptions.ShopsItemException;
import com.shigu.main4.item.services.ShopsItemService;
import com.shigu.main4.item.vo.InstockItem;
import com.shigu.main4.item.vo.ItemCount;
import com.shigu.main4.item.vo.OnsaleItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by wxc on 2017/3/2.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:main4/spring/item_test.xml"})
public class ShopsItemServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(ShopsItemServiceTest.class);

    @Autowired
    private ShopsItemService shopsItemService;
    @Test
    public void selOnsaleItems() throws Exception {
        // 功能
        ShiguPager<OnsaleItem> pager = shopsItemService.selOnsaleItems(null, null, null, 29737L, 1, 10);
        logger.info("\n" + JSON.toJSONStringWithDateFormat(pager, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));

        // 测试店铺不存在异常
        try {
            pager = shopsItemService.selOnsaleItems(null, null, null, 66666666666L, 1, 10);
            fail();
        } catch (ShopsItemException e) {
            assertTrue(e.getCode().equals(ShopsItemException.ShopsItemExceptionEnum.SHOP_DOES_NOT_EXIST.getCode()));
        }
    }

    @Test
    public void selInstockItems() throws Exception {
        // 功能
        ShiguPager<InstockItem> pager = shopsItemService.selInstockItems(null, "电商", null, 32888L, 1, 10);
        // 因为下架表里的 is_excel_imp 全部是 null 所以ItemFrom来源信息丢失
        logger.info("\n" + JSON.toJSONStringWithDateFormat(pager, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));

        // 测试店铺不存在异常
        try {
            pager = shopsItemService.selInstockItems(null, null, null, 66666666666L, 1, 10);
            fail();
        } catch (ShopsItemException e) {
            assertTrue(e.getCode().equals(ShopsItemException.ShopsItemExceptionEnum.SHOP_DOES_NOT_EXIST.getCode()));
        }
    }

    @Test
    public void selItemCount() throws Exception {
        ItemCount itemCount = shopsItemService.selItemCount(32888L);
        logger.info("\n" + JSON.toJSONString(itemCount, SerializerFeature.PrettyFormat));

        // 测试店铺不存在异常
        try {
            itemCount = shopsItemService.selItemCount(66666666666L);
            fail();
        } catch (ShopsItemException e) {
            assertTrue(e.getCode().equals(ShopsItemException.ShopsItemExceptionEnum.SHOP_DOES_NOT_EXIST.getCode()));
        }
    }

}