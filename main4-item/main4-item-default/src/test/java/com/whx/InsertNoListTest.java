package com.whx;

import com.google.common.collect.Lists;
import com.item.test.BaseSpringTest;
import com.opentae.data.mall.beans.GoodsCountForsearch;
import com.opentae.data.mall.examples.GoodsCountForsearchExample;
import com.opentae.data.mall.interfaces.GoodsCountForsearchMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * 路径:com.whx.InsertNoListTest
 * 工程:main-pom
 * 时间:18-1-23下午3:35
 * 创建人:wanghaoxiang
 * 描述：
 */
public class InsertNoListTest extends BaseSpringTest {

    @Autowired
    GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Test
    public void testInsertNoIdList() {
        ArrayList<GoodsCountForsearch> list = new ArrayList<>();
        for (long i = -10L; i < -3L ; i++) {
            GoodsCountForsearch val = new GoodsCountForsearch();
            val.setGoodsId(i);
            val.setWebSite("test");
            val.setClick(0L);
            val.setClickIp(0L);
            val.setUp(0L);
            val.setUpMan(0L);
            val.setTrade(0L);
            val.setStyleSearchScore(0L);
            list.add(val);
        }
        goodsCountForsearchMapper.insertListNoIdMore(list,"goods_id,web_site,click,click_ip,up,up_man,trade,style_search_score");
    }

    @Test
    public void testExam() {
        GoodsCountForsearchExample example = new GoodsCountForsearchExample();
        example.createCriteria().andGoodsIdIn(Lists.newArrayList(-10L,-9L,-8L,-7L,-6L));
        GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
        goodsCountForsearch.setStyleId(0L);
        goodsCountForsearchMapper.updateByExampleSelective(goodsCountForsearch,example);
    }
}
