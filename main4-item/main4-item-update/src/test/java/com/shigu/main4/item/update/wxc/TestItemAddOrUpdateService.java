package com.shigu.main4.item.update.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.ESGoods;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.services.impl.EsGoodsService;
import com.shigu.main4.item.vo.SynItem;
import org.elasticsearch.action.get.GetResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wxc on 2017/2/26.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:main4/spring/item-update.xml")
public class TestItemAddOrUpdateService {

    public static final Logger logger = LoggerFactory.getLogger(TestItemAddOrUpdateService.class);
//
    private Pattern pattern = Pattern.compile("((http|https):)?(//)?(imgs.571xz.net|shigu.oss-cn-hangzhou.aliyuncs.com)(:\\d+)?(/[^#()?&=]+)+.(jpg|png|gif)");

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private EsGoodsService esGoodsService;

    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;

    @Test
    public void testString() {
        String reg = "(/[^#()?&=]+)+.(jpg|png|gif)";
        Pattern.compile(reg);
        Matcher matcher = pattern.matcher("asdfashttp://imgs.571xz.net:8888/shigu/agfsdfh3j523k3j4.jpg asd");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }


    @Test
    public void testElasticSearchById() {
        GetResponse response
                = ElasticConfiguration.searchClient.prepareGet().setIndex("goods").setType("hz").setId("1085536").execute().actionGet();
        if (response.isExists()) {
            Map<String, Object> source = response.getSource();
            System.out.println(source);
            Object is_off = source.get("is_off");
            if (is_off != null)
                source.put("is_off", 1);
            System.out.println(JSON.toJSONString(source, SerializerFeature.PrettyFormat));
        }
    }

    @Test
    public void testTinyQuery() {
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setStoreId(41575L);
        tiny.setWebSite("hz");
        List<ShiguGoodsTiny> select = shiguGoodsTinyMapper.select(tiny);

        ElasticRepository repository = new ElasticRepository();
        for (ShiguGoodsTiny goodsTiny : select) {
            SimpleElaBean seb = new SimpleElaBean("goods", goodsTiny.getWebSite(), goodsTiny.getGoodsId().toString());
            seb.setSource(JSON.toJSONStringWithDateFormat(esGoodsService.createEsGoods(goodsTiny), "yyyy-MM-dd HH:mm:ss"));
//            logger.info("\n" + JSON.toJSONString(seb, SerializerFeature.PrettyFormat));
            repository.updateByKey(seb);
        }
    }

    @Test
    public void testUpdateSymItem() throws ItemModifyException {
        SynItem synItem=new SynItem();
        synItem.setShopId(41844L);
        synItem.setGoodsId(20122187L);
        synItem.setPriceString("11.50");
        synItem.setNumIid(546469224305L);
        synItem.setWebSite("hz");
        itemAddOrUpdateService.systemUpdateItem(synItem);
    }


}
