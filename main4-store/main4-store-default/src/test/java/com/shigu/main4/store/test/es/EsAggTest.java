package com.shigu.main4.store.test.es;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.searchtool.configs.ElasticConfiguration;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wxc on 2017/2/20.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/store_test.xml" )
public class EsAggTest {

    @Test
    public void testAggCid() {
        SearchResponse response = ElasticConfiguration.searchClient
                .prepareSearch("goods")
                .setTypes("hz")
//                .setSearchType(SearchType.COUNT)
                .setQuery(QueryBuilders.termQuery("storeId", 15418))
                .addAggregation(AggregationBuilders.terms("cname_count").field("cid").size(1000)
                        .subAggregation(AggregationBuilders.count("result").field("goodsId")))
                .execute().actionGet();

        Aggregation cname_count = response.getAggregations().get("cname_count");
        for (Terms.Bucket bucket : ((LongTerms) cname_count).getBuckets()) {
            System.out.println(bucket.getKeyAsNumber() + ", " + bucket.getDocCount());
        }
    }
    @Test
    public void testUpCount() {
        SearchRequestBuilder prepareSearch = ElasticConfiguration.client.prepareSearch("shigugoodsup");
        List<Integer> goodsIds = new ArrayList<>();
        goodsIds.add(10020121);
        goodsIds.add(10020123);
        SearchResponse response = prepareSearch.setSearchType("count")
                .setQuery(QueryBuilders.termsQuery("supperGoodsId", goodsIds))
                .addAggregation(AggregationBuilders.terms("up_count").field("supperGoodsId"))
                .execute().actionGet();
        System.out.println(response);
    }

}
