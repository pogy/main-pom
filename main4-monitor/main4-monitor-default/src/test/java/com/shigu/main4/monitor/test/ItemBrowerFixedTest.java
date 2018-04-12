package com.shigu.main4.monitor.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.GoodsCountForsearch;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.GoodsCountForsearchExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.GoodsCountForsearchMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.Jobs;
import com.shigu.main4.monitor.services.ItemBrowerFixService;
import com.shigu.main4.tools.RedisIO;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.cardinality.InternalCardinality;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * 商品浏览量固化操作
 *
 *  @see com.shigu.main4.monitor.test.ItemBrowerFixedTest.AddSearchRecord
 *          该类实现 Jobs 接口 提供高优先级线程池，工作内容是聚合es访问量数据存储到数据库
 *          默认初始化线程数3，具体大小视ES 承载能力而定（Es 能力是此任务瓶颈）
 *  @author <a href="mailto:xiaochenyoo@sina.com">bugzy</a>
 * Created by zhaohongbo on 17/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring/store_test.xml" )
public class ItemBrowerFixedTest {

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Autowired
    private ItemBrowerFixService itemBrowerFixService;

    @Autowired
    private RedisIO redisIO;

    @Test
    public void testInPage() {
        Jedis jedis = redisIO.getJedis();
        try {
            jedis.del("item_flow_test");
        }finally {
            redisIO.returnJedis(jedis);
        }
        StringBuilder redisKeySb = new StringBuilder();
        redisKeySb.append("20770888").append("_").append(DateUtil.dateToString(new Date(), DateUtil.patternF)).append(RandomStringUtils.randomAlphanumeric(10));
        String redisKey = redisKeySb.toString();
        redisIO.hset("item_flow_test", redisKey, "192.168.1.1");
        redisKeySb = new StringBuilder();
        redisKeySb.append("20770888").append("_").append(DateUtil.dateToString(new Date(), DateUtil.patternF)).append(RandomStringUtils.randomAlphanumeric(10));
        redisKey = redisKeySb.toString();
        redisIO.hset("item_flow_test", redisKey, "192.168.1.2");
        redisKeySb = new StringBuilder();
        redisKeySb.append("20770888").append("_").append(DateUtil.dateToString(new Date(), DateUtil.patternF)).append(RandomStringUtils.randomAlphanumeric(10));
        redisKey = redisKeySb.toString();
        redisIO.hset("item_flow_test", redisKey, "192.168.1.1");
        redisKeySb = new StringBuilder();
        redisKeySb.append("20770889").append("_").append(DateUtil.dateToString(new Date(), DateUtil.patternF)).append(RandomStringUtils.randomAlphanumeric(10));
        redisKey = redisKeySb.toString();
        redisIO.hset("item_flow_test", redisKey, "192.168.1.1");
        redisKeySb = new StringBuilder();
        redisKeySb.append("20770887").append("_").append(DateUtil.dateToString(new Date(), DateUtil.patternF)).append(RandomStringUtils.randomAlphanumeric(10));
        redisKey = redisKeySb.toString();
        redisIO.hset("item_flow_test", redisKey, "192.168.1.3");
    }

    @Test
    public void testFixNow() {
        itemBrowerFixService.fixNow("item_flow_test");
    }


    /**
     * 同步es商品统计，上款、浏览量等数据存储到数据库
     */
    @Test
    public void doTranslateUpAndClickCount() {

        String[] sites = {
                "hz",
//                "cs",
//                "ss",
//                "bj",
//                "gz",
//                "wa",
//                "jx",
//                "bb",
//                "jf",
//                "xh",
        };

        int bucketSize = 1000;//一批商品大小，任务以批次传输给线程

        // 默认3个工作线程，工作内容是两次ES聚合一次数据库批量插入/更新，线程等待时间较久，可以适量增大线程数
        AddSearchRecord jobs = new AddSearchRecord(2);

        for (String site : sites) {

            ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
            tinyExample.setWebSite(site);
            tinyExample.setOrderByClause("created DESC");
            int start;
            tinyExample.setStartIndex(start = 0);
            tinyExample.setEndIndex(bucketSize);
            // today is 2017/06/22
            tinyExample.createCriteria().andIsClosedEqualTo(0L)
//                    .andCreatedLessThanOrEqualTo(DateUtil.stringToDate("2017-06-22 00:00:00"))
//            .andGoodsIdIn(Arrays.asList(20597888L, 20579000L, 20565125L, 20469608L, 20440630L, 20445645L, 20350398L, 20301772L, 20297240L, 20289270L, 20289301L, 20346502L, 20191246L, 20183296L, 20155018L, 10020161L, 10020139L, 10020171L))
            ;

            List<ShiguGoodsTiny> shiguGoodsTinies;
            while (!(shiguGoodsTinies = shiguGoodsTinyMapper.selectFieldsByConditionList(tinyExample, FieldUtil.codeFields("goods_id"))).isEmpty()) {
                tinyExample.setStartIndex(start += bucketSize);
                shiguGoodsTinies.get(0).setWebSite(site);//放置分站参数
                jobs.addJob(shiguGoodsTinies);
            }

        }

        jobs.join();
    }

    private class AddSearchRecord extends Jobs<List<ShiguGoodsTiny>> {

        public AddSearchRecord(int totalThread) {
            super(totalThread);
        }

        @Override
        public void doWork(List<ShiguGoodsTiny> ids) throws Exception {
            String webSite = ids.get(0).getWebSite();
            List<Long> goodsIds = BeanMapper.getFieldList(ids, "goodsId", Long.class);

            SearchResponse searchResponse = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode")
                    .setTypes("item").setSearchType(SearchType.COUNT)
                    .setQuery(QueryBuilders.termsQuery("itemId", goodsIds))
                    .addAggregation(AggregationBuilders.terms("goods_pv").field("itemId").size(goodsIds.size())
                                    .subAggregation(AggregationBuilders.cardinality("goods_ip").field("clientMsg.clientIp")))
                    .execute().actionGet();
            List<Terms.Bucket> goods_pv = ((LongTerms) searchResponse.getAggregations().get("goods_pv")).getBuckets();
            if (goods_pv.isEmpty()) {
                return;
            }
            List<GoodsCountForsearch> forsearches = new ArrayList<>(goods_pv.size());
            for (Terms.Bucket bucket : goods_pv) {
                GoodsCountForsearch forsearch = new GoodsCountForsearch();
                forsearches.add(forsearch);
                forsearch.setGoodsId(bucket.getKeyAsNumber().longValue());
                forsearch.setClick(bucket.getDocCount());
                forsearch.setClickIp(((InternalCardinality) bucket.getAggregations().get("goods_ip")).getValue());
                forsearch.setUp(0L);
                forsearch.setUpMan(0L);
                forsearch.setWebSite(webSite);
            }
            Map<Long, GoodsCountForsearch> forsearchMap = BeanMapper.list2Map(forsearches, "goodsId", Long.class);

            searchResponse = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup")
                    .setSearchType(SearchType.COUNT)
                    .setQuery(QueryBuilders.termsQuery("supperGoodsId", goodsIds))
                    .addAggregation(AggregationBuilders.terms("up_count").field("supperGoodsId").size(goodsIds.size())
                            .subAggregation(AggregationBuilders.cardinality("up_man_count").field("fenUserId")))
                    .execute().actionGet();
            List<Terms.Bucket> up_count = ((LongTerms) searchResponse.getAggregations().get("up_count")).getBuckets();
            for (Terms.Bucket bucket : up_count) {
                GoodsCountForsearch forsearch = forsearchMap.get(bucket.getKeyAsNumber().longValue());
                if (forsearch == null) {
                    forsearch = new GoodsCountForsearch();
                    forsearch.setClick(0L);
                    forsearch.setClickIp(0L);
                    forsearch.setWebSite(webSite);
                    forsearches.add(forsearch);
                    forsearch.setGoodsId(bucket.getKeyAsNumber().longValue());
                }
                forsearch.setUp(bucket.getDocCount());
                forsearch.setUpMan(((InternalCardinality) bucket.getAggregations().get("up_man_count")).getValue());
            }

            goodsCountForsearchMapper.insertOrUpdate(forsearches);
        }
    }

    @Test
    public void testV(){
        SearchResponse searchResponse = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup")
//                .setSearchType(SearchType.COUNT)
                .setQuery(QueryBuilders.termsQuery("supperGoodsId", Arrays.asList(20361517L)))
                .addAggregation(AggregationBuilders.terms("up_count").field("supperGoodsId").size(1000))
//                        .subAggregation(AggregationBuilders.cardinality("up_man_count").field("fenUserId")))
                .execute().actionGet();
        System.out.println(searchResponse);
    }

    @Test
    public void testEsAggsPV(){

        AddSearchRecord jobs = new AddSearchRecord(3);

        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setWebSite("hz");
        tiny.setGoodsId(20361517L);
        jobs.addJob(Arrays.asList(tiny));
        jobs.join();
    }

    @Test
    @Transactional
    public void testInsertOrUpdate(){
        List<GoodsCountForsearch> list = new ArrayList<>();
        GoodsCountForsearch forsearch1 = new GoodsCountForsearch();
        forsearch1.setGoodsId(20597888L);
        forsearch1.setWebSite("hz");
        forsearch1.setClick(2144L);
        forsearch1.setClickIp(1471L);
        forsearch1.setUp(0L);
        forsearch1.setUpMan(1L);
        GoodsCountForsearch forsearch2 = new GoodsCountForsearch();
        forsearch2.setUp(0L);
        forsearch2.setUpMan(2L);
        forsearch2.setGoodsId(20579000L);
        forsearch2.setWebSite("hz");
        forsearch2.setClick(2162L);
        forsearch2.setClickIp(1341L);
        list.add(forsearch1);
        list.add(forsearch2);
        System.out.println(goodsCountForsearchMapper.insertOrUpdate(list));

        GoodsCountForsearchExample forsearchExample = new GoodsCountForsearchExample();
        forsearchExample.createCriteria().andGoodsIdIn(Arrays.asList(20597888L, 20579000L));
        System.out.println(JSON.toJSONString(goodsCountForsearchMapper.selectByExample(forsearchExample), SerializerFeature.PrettyFormat));
    }
}
