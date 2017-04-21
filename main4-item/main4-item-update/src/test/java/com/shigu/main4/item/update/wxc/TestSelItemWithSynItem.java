package com.shigu.main4.item.update.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.vo.SynItem;
import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * Created by wxc on 2017/3/3.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class TestSelItemWithSynItem extends BaseSpringTest {

    public static final Logger logger = LoggerFactory.getLogger(TestSelItemWithSynItem.class);

    @Autowired
    private ItemAddOrUpdateService itemAddOrUpdateService;

    @Test
    public void testSelItemWithSynItem() throws IllegalAccessException {
        SynItem item = itemAddOrUpdateService.selItemWithSynItem(528633679906L, 32888L);

        logger.info("\n" + JSON.toJSONString(item, SerializerFeature.PrettyFormat));

        assertTrue(item != null);

        for (Field field : item.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object o = field.get(item);
            // 此商品所有值都可转化为SynItem对象内容
            if (o == null) {
                fail(field.getName() + " is null.");
            }
        }
    }
}
