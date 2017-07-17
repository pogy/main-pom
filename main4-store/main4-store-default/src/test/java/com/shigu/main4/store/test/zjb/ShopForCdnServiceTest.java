package com.shigu.main4.store.test.zjb;

import com.alibaba.fastjson.JSON;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.main4.vo.ShopFitment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/store_test.xml")
public class ShopForCdnServiceTest {

    @Autowired
    private ShopForCdnService shopForCdnService;

    @Test
    public void selItemNumberById() {
        Long shopId = 32888L;
        Long resultCount = shopForCdnService.selItemNumberById(shopId,"hz");
        System.out.println("商品总数：" + resultCount);
    }

    @Test
    public void searchItemOnsale() throws ParseException {
        String keyword = "淘宝客家T691P35–此款是爆款 建议主推 质量好 备货足不断货";
        Long shopId = 32888L;
        String orderBy = "price_up";
        int pageNo = 1;
        int pageSize = 10;
        Double priceFrom = 50.00;
        Double priceTo = 100.00;
        Long cid = 50023727L;
        String scid = "1";
        Date dateFrom = ShopForCdnServiceTest.stringToDate("2017-01-01 13:35:00");
        Date dateTo = new Date();
        ShiguPager<ItemShowBlock> shiguPager = shopForCdnService.searchItemOnsale(keyword, shopId,"hz", orderBy, pageNo, pageSize);
        System.out.println(JSON.toJSONString(shiguPager));

        /*shiguPager = shopForCdnService.searchItemOnsale(keyword, shopId, priceFrom, priceTo, orderBy, pageNo, pageSize);
        System.out.println(JSON.toJSONString(shiguPager));

        shiguPager = shopForCdnService.searchItemInstock(dateFrom, dateTo, shopId, pageNo, pageSize);
        System.out.println(JSON.toJSONString(shiguPager));

        shiguPager = shopForCdnService.searchItemOnsale(null, shopId, cid, scid, orderBy, pageNo, pageSize);
        System.out.println(JSON.toJSONString(shiguPager));*/
    }


    public static Date stringToDate(String str) {
        if (str == null) {
            return null;
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(str);
        } catch (ParseException ex) {
            return null;
        }
    }


    @Test
    public void updateScid() {
        /*SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("goods");
        srb.setQuery(QueryBuilders.termQuery("goodsId" ,9816500L));
        System.out.println(srb.toString());
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        if (hits != null && hits.length > 0) {
            for (SearchHit hit : hits) {
                String jsonsource = hit.getSourceAsString();
                System.out.println(jsonsource);
            }
        }*/
        String jsonstr = "{\"goodsId\":9816500,\"is_other\":0,\"inStoreSortOrder\":999,\"v_clicks\":0,\"storeNum\":\"测试不要乱点啊-8000\",\"remark1\":\"0\",\"type\":\"fixed\",\"remark3\":\"0\",\"remark2\":\"0\",\"city\":\"杭州\",\"title\":\"大睡袋\",\"piPrice\":1200,\"is_off\":1,\"webSite\":\"hz\",\"created\":\"2016-12-30 13:18:20\",\"listTime\":\"2016-12-30 13:18:20\",\"is_hezuo\":0,\"isExcelImp\":2,\"parent_cname\":\"户外/登山/野营/旅行用品\",\"soldOutTime\":\"2017-01-10 23:59:59\",\"v_bounceRate\":5,\"marketId\":603,\"services\":\"无质量问题不退换\",\"prov\":\"浙江\",\"picUrl\":\"http://sgimage.571xz.com/new_image_site/SGimg/8f2f0734b40c8faa0d2e700a00aa5377.jpg\",\"sortOrder\":999,\"parentMarketName\":\"星座女装\",\"goodsNo\":\"12\",\"cid\":50013908,\"modified\":\"2016-12-30 13:18:20\",\"cidAll\":\"\",\"delistTime\":\"2017-01-06 13:18:20\",\"num\":12,\"price\":1200,\"market\":\"2F\",\"nick\":\"lyszhen3\",\"goods_level\":0,\"loadDate\":\"2016-12-30 13:18:20\",\"parent_cid\":50013886,\"parentMarketId\":601,\"relation_level_id\":0,\"storeId\":32888,\"v_tradingVolume\":0,\"last_update_xs\":\"2017-01-03 18:03:43\",\"cname\":\"睡袋\",\"cidAll\":\",111,222,333,\"}";
        SimpleElaBean bean = new SimpleElaBean();
        bean.setIndex("goods");
        bean.setType("hz");
        bean.setPk("9816500");
        bean.setSource(jsonstr);
        try {
            ElasticRepository elasticRepository = new ElasticRepository();
            elasticRepository.insert(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询店铺推荐数据
     */
    @Test
    public void selRecomments(){
        Long shopId = 32888L;
        List<ItemShowBlock> itemShowBlockList = shopForCdnService.selRecomments(shopId);
        System.out.println("店铺推荐数据：" + JSON.toJSONString(itemShowBlockList));
    }

}
