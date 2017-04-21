package com.shigu.main4.monitor.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.monitor.enums.FlowType;
import com.shigu.main4.monitor.service.impl.ShopBrowerServiceImpl;
import com.shigu.main4.monitor.vo.DataLineVO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.histogram.InternalDateHistogram;
import org.elasticsearch.search.aggregations.bucket.histogram.InternalHistogram;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by wxc on 2017/3/14.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring/store_test.xml")
public class ShopBrowerServiceImplTest {

    @Autowired
    private ShopBrowerServiceImpl shopBrowerService;

    @Test
    public void selShopFlowByHour() throws Exception {
        Date start = DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.HOUR), -7);
        List<DataLineVO> vos = shopBrowerService.selShopFlowByHour(35747L, start, 4, FlowType.PV);
        System.out.println(JSON.toJSONString(vos, SerializerFeature.PrettyFormat));
    }

    @Test
    public void selShopFlowByDay() throws Exception {
        Date start = DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.HOUR), -7);
        List<DataLineVO> vos = shopBrowerService.selShopFlowByDay(35747L, start, 4, FlowType.IP);
        System.out.println(JSON.toJSONString(vos, SerializerFeature.PrettyFormat));
    }

    @Test
    public void testEsAggs() {
        Date Ot = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);

        SearchResponse response = ElasticConfiguration.searchClient
                .prepareSearch("shigupagerecode")
                .setTypes("item", "shop")
                .setSearchType(SearchType.COUNT)
                .setQuery(
                        QueryBuilders.boolQuery().must(QueryBuilders.termQuery("shop", 39528))
                        .filter(QueryBuilders.rangeQuery("inTime").gte(Ot.getTime()).lt(new Date().getTime()))
                )
                .execute().actionGet();
        System.out.println(JSON.toJSONString(response, SerializerFeature.PrettyFormat));
    }

    @Test
    public void testEs() {
        Calendar calendar = Calendar.getInstance();
        Date end = calendar.getTime();
        calendar.add(Calendar.MONTH, -2);
        InternalHistogram flowFromEs = shopBrowerService.getFlowFromEs(40304L, calendar.getTime(), end, FlowType.IP);
        List<DataLineVO> vos = new ArrayList<>();
        for (Object o : flowFromEs.getBuckets()) {
            InternalHistogram.Bucket bucket = (InternalHistogram.Bucket) o;
            DateTime dateTime = (DateTime) bucket.getKey();
            DataLineVO vo = new DataLineVO();
            vo.setDatestr(dateTime.getMonthOfYear() + "-" + dateTime.getDayOfMonth());
            vo.setHour(dateTime.getHourOfDay());
            vo.setType(FlowType.PV);
            vo.setFlow(((int) bucket.getDocCount()));
            vos.add(vo);
        }
        System.out.println(JSON.toJSONString(vos));
    }

    @Test
    public void testES222() {
        GetResponse response =
                ElasticConfiguration.searchClient.prepareGet().setIndex("shigupagerecode").setFetchSource(false).setId("49127340").execute().actionGet();
        System.out.println(response.isExists());
    }
}