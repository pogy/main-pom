package com.shigu.main4.ucenter.services.test.wxc;

import com.opentae.data.mall.beans.ShiguGoodsCollect;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShiguStore;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Created by wxc on 2017/3/2.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class TestCase {

    private static final Logger logger = LoggerFactory.getLogger(TestCase.class);

    @Test
    public void testSameField() {
        Class class1 = ShiguShop.class;
        Class class2 = ShiguStore.class;

        for (Field field1 : class1.getDeclaredFields()) {
            for (Field field2 : class2.getDeclaredFields()) {
                if (field1.getName().equals(field2.getName())) {
                    logger.info(field1.getName() + "名称相同");
                    if (field1.getType() == field2.getType()) {
                        logger.info("类型相同");
                    }
                }
            }
        }
    }

}
