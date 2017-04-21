package data.fix;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsSoldoutMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.common.util.BeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by wxc on 2017/3/28.
 *
 * 清除重复商品数据，将上架表中查到去下架表删除
 *  goodsId
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class TinyAndSoldoutDuplicateHotfix {

    private static final Logger logger = getLogger(TinyAndSoldoutDuplicateHotfix.class);

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Test
    public void hotfix() throws Exception {

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
        int size = 1000;

        for (String site : sites) {
            ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
            tinyExample.setWebSite(site);
            tinyExample.setEndIndex(size);
            int index;
            tinyExample.setStartIndex(index = 0);
            List<ShiguGoodsTiny> tinies;
            while (!(tinies = shiguGoodsTinyMapper.selectFieldsByConditionList(tinyExample, FieldUtil.codeFields("goods_id, num_iid, store_id"))).isEmpty()) {
                logger.info(site + ": " + index);
                List<Long> goodsIds = BeanMapper.getFieldList(tinies, "goodsId", Long.class);
                ShiguGoodsSoldoutExample soldoutExample = new ShiguGoodsSoldoutExample();
                soldoutExample.setWebSite(site);
                soldoutExample.createCriteria().andGoodsIdIn(goodsIds);
                shiguGoodsSoldoutMapper.deleteByExample(soldoutExample);
                tinyExample.setStartIndex(index += size);
            }
        }
    }
}
