package com.item.test.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by wxc on 2017/2/21.
 *
 * 按商品ID查商品 测试
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:main4/spring/item_test.xml"})
public class ShowForCdnServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ShowForCdnServiceTest.class);

    @Resource
    private ShowForCdnService showForCdnService;

    /**
     * 测试商品获取
     */
    @Test
    public void testSelItemById() {

        // 存在的
        CdnItem item = showForCdnService.selItemById(20060755L);
        CdnItem itemCache = showForCdnService.selItemById(20060755L);

        logger.info("\n" + JSON.toJSONString(item, SerializerFeature.PrettyFormat));

        assertTrue(item == itemCache);

    }
    /**
     * 测试下架商品获取
     */
    @Test
    public void testSelInstockItemById() {

        // 下架的
        CdnItem item = showForCdnService.selItemInstockById(20101258L);
        CdnItem itemCache = showForCdnService.selItemInstockById(20101258L);

        logger.info("\n" + JSON.toJSONString(item, SerializerFeature.PrettyFormat));

        assertTrue(item == itemCache);

    }

    /**
     * 测试 商品权益获取
     */
    @Test
    public void testSelGoodsLicenses() {
        List<String> strings = showForCdnService.selItemLicenses(1498944L);

        logger.info("Licenses:\n" + JSON.toJSONString(strings, SerializerFeature.PrettyFormat));

        assertFalse(strings.isEmpty());
    }
}
