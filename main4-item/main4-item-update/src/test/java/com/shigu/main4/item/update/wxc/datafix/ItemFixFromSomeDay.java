package com.shigu.main4.item.update.wxc.datafix;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ESGoods;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.searchtool.domain.SimpleElaBean;
import com.shigu.main4.item.services.impl.EsGoodsService;
import com.shigu.main4.item.tools.GoodsAddToRedis;
import com.shigu.main4.item.update.wxc.BaseSpringTest;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wxc on 2017/4/17.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class ItemFixFromSomeDay extends BaseSpringTest {
    @Autowired
    private GoodsAddToRedis goodsAddToRedis;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private EsGoodsService esGoodsService;

    /**
     * 时间2017/04/16 00*00*00 到现在新增商品导入redis
     */
    @Test
    public void fix() {
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite("hz");
        tinyExample.createCriteria().andCreatedGreaterThanOrEqualTo(DateUtils.truncate(DateUtils.addDays(new Date(), -1), Calendar.DAY_OF_MONTH));
        List<ShiguGoodsTiny> tinies = shiguGoodsTinyMapper.selectByExample(tinyExample);
        for (ShiguGoodsTiny tiny : tinies) {
            ESGoods esGoods = esGoodsService.createEsGoods(tiny);
            SimpleElaBean seb = new SimpleElaBean("goods", "hz", esGoods.getGoodsId().toString());
            seb.setSource(JSON.toJSONStringWithDateFormat(esGoods, "yyyy-MM-dd HH:mm:ss"));
            goodsAddToRedis.addToRedis(seb);
        }
    }
}
