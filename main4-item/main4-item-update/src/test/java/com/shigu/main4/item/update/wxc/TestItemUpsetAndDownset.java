package com.shigu.main4.item.update.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.vo.SynItem;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

/**
 * Created by wxc on 2017/3/3.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class TestItemUpsetAndDownset extends BaseSpringTest {

    private static final Logger logger = LoggerFactory.getLogger(TestItemUpsetAndDownset.class);

    @Autowired
    private ItemAddOrUpdateService itemAddOrUpdateService;

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguTinyMapper;

    @Test
    public void testSystemItemUp() throws ItemModifyException {
        itemAddOrUpdateService.systemUpItem(20213346L);

    }
    @Test
    public void testSystemItemDown() throws ItemModifyException {
        itemAddOrUpdateService.systemDownItem(20213346L);
    }

    @Test
    public void testShopDown() throws ItemModifyException {
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite("hz");
        tinyExample.createCriteria().andStoreIdEqualTo(39318L);
        for (ShiguGoodsTiny tiny : shiguTinyMapper.selectByExample(tinyExample)) {
            itemAddOrUpdateService.systemDownItem(tiny.getGoodsId());
        }
    }

}
