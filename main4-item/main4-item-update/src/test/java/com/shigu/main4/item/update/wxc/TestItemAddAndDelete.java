package com.shigu.main4.item.update.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.vo.SynItem;
import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wxc on 2017/3/3.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class TestItemAddAndDelete extends BaseSpringTest {

    private static final Logger logger = LoggerFactory.getLogger(TestItemAddAndDelete.class);

    @Autowired
    private ItemAddOrUpdateService itemAddOrUpdateService;

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Test
    public void testSystemAddItem() throws ItemModifyException {
        SynItem item = JSON.parseObject(TestItemHelper.json, SynItem.class);
        item.setOuterId("144444444");
        item.setGoodsNo("CS144444444");
        item.setItemWeight("222");
        item.setItemSize("11");
        item.setWirelessDesc(item.getGoodsDesc());
        item.setShopId(32888L);
        Long itemId = itemAddOrUpdateService.systemAddItem(item);

        logger.info("\n" + JSON.toJSONString(item, SerializerFeature.PrettyFormat));
        logger.info(itemId.toString());
    }

    @Test
    public void testSystemDeleteItem() throws ItemModifyException {

        itemAddOrUpdateService.systemDeleteItem(9454156L);
        assertTrue(shiguGoodsIdGeneratorMapper.selectByPrimaryKey(9454156L) == null);
    }

}
