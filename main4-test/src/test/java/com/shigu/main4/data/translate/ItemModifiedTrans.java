package com.shigu.main4.data.translate;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsModified;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsModifiedExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsModifiedMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.common.util.BeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by wxc on 2017/3/23.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class ItemModifiedTrans {

    private static final Logger logger = LoggerFactory.getLogger(ItemModifiedTrans.class);

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguGoodsModifiedMapper shiguGoodsModifiedMapper;

    private LinkedBlockingQueue<List<ShiguGoodsTiny>> queue = new LinkedBlockingQueue<>();

    @Test
    public void trans() throws Exception {

        for (int i = 0; i < 20; i++) {
            new Thread(new InsertModifyRunner()).start();
        }

        String[] sites = {
                "hz",
                "cs",
                "bb",
                "bj",
                "gz",
                "jf",
                "jx",
                "ss",
                "wa",
                "xh",
        };

        int pageSize = 500;
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.or().andIsModTitleEqualTo(1);
        tinyExample.or().andIsModGoodsnoEqualTo(1);
        tinyExample.or().andIsModPriceEqualTo(1);
        tinyExample.or().andIsUserSetPiPriceEqualTo(1);
        tinyExample.setEndIndex(pageSize);
        for (String site : sites) {
            tinyExample.setWebSite(site);

            int pageStep;
            tinyExample.setStartIndex(pageStep = 0);
            List<ShiguGoodsTiny> goodsTinies;
            while (!(goodsTinies = shiguGoodsTinyMapper.selectFieldsByConditionList(tinyExample, FieldUtil.codeFields("goods_id,is_mod_title,is_mod_price,is_mod_goodsno,is_user_set_pi_price"))).isEmpty()) {
                List<Long> goodsIds = BeanMapper.getFieldList(goodsTinies, "goodsId", Long.class);
                ShiguGoodsModifiedExample modifiedExample = new ShiguGoodsModifiedExample();
                modifiedExample.createCriteria().andItemIdIn(goodsIds);
                List<ShiguGoodsModified> modifieds = shiguGoodsModifiedMapper.selectFieldsByExample(modifiedExample, FieldUtil.codeFields("modify_id,item_id"));
                List<Long> itemIds = BeanMapper.getFieldList(modifieds, "itemId", Long.class);
                if (!itemIds.isEmpty()) {
                    goodsIds.removeAll(itemIds);
                    Iterator<ShiguGoodsTiny> iterator = goodsTinies.iterator();
                    while (iterator.hasNext()) {
                        if (goodsIds.contains(iterator.next().getGoodsId())) {
                            continue;
                        }
                        iterator.remove();
                    }
                }
                queue.put(goodsTinies);
                tinyExample.setStartIndex(pageStep += pageSize);
            }

        }

        while (true) {
            if (queue.isEmpty()) {

            } else
                logger.info("queue size:" + queue.size());
            Thread.sleep(5000);
        }
    }

    private class InsertModifyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    for (ShiguGoodsTiny goodsTiny : queue.take()) {
                        ShiguGoodsModified modified = new ShiguGoodsModified();
                        modified.setItemId(goodsTiny.getGoodsId());
                        if (isOne(goodsTiny.getIsModPrice())) {
                            modified.setHasSetPrice(1);
                        }
                        if (isOne(goodsTiny.getIsModTitle())) {
                            modified.setHasSetTitle(1);
                        }
                        if (isOne(goodsTiny.getIsModGoodsno())) {
                            modified.setHasSetGoodsno(1);
                        }
                        if (isOne(goodsTiny.getIsUserSetPiPrice())) {
                            modified.setHasSetPiprice(1);
                        }
                        try {
                            shiguGoodsModifiedMapper.insertSelective(modified);
                        } catch (Exception e) {
                            logger.error("insert error.", e);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isOne(Integer one) {
        return one != null && one == 1;
    }
}
