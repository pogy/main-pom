package com.shigu.main4.monitor.service.impl;

import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.monitor.services.ItemBrowerService;
import com.shigu.main4.monitor.vo.ItemBrowerFlowVO;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 商品浏览记录服务
 *
 * @author shigu_zjb
 * @date 2017/03/8 14:52
 *
 */
@Service("itemBrowerService")
public class ItemBrowerServiceImpl implements ItemBrowerService{

    int unrealVersion=1;

    @Override
    public ItemBrowerFlowVO selUnrealBrower(Long itemId) {
        return null;
    }

    @Override
    public ItemBrowerFlowVO makeUnrealBrower(Long itemId) {
        return null;
    }

    @Override
    public ItemBrowerFlowVO addUnrealBrower(Long itemId, Integer number) {
        return null;
    }

    /**
     * 按商品ID统计商品浏览量
     * @param itemId
     * @return
     */
    @Override
    public Long selItemBrower(Long itemId) {
        if(itemId == null){
            return 0L;
        }
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
        srb.setTypes("item");
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();

        QueryBuilder itemQb = QueryBuilders.termQuery("itemId", itemId);
        boleanQueryBuilder.must(itemQb);

        srb.setQuery(boleanQueryBuilder);
        srb.setSearchType(SearchType.COUNT);
        SearchResponse response = srb.execute().actionGet();
        Long total = response.getHits().getTotalHits();

        return total;
    }

    /**
     * 批量聚合商品流量
     * @param itemIds
     * @return
     */
    public Map<Long,Long> selMoreItemBrower(List<Long> itemIds) {
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
        srb.setTypes("item");
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        for(Long itemId:itemIds){
            QueryBuilder itemQb = QueryBuilders.termQuery("itemId", itemId);
            boleanQueryBuilder.should(itemQb);
            boleanQueryBuilder.minimumNumberShouldMatch(1);
        }
        srb.setQuery(boleanQueryBuilder);
        srb.addAggregation(AggregationBuilders.terms("itembrow_count").field("itemId").size(itemIds.size())
                .subAggregation(AggregationBuilders.count("result").field("itemId")));
        SearchResponse response=srb.execute().actionGet();
        Terms aggs=response.getAggregations().get("itembrow_count");
        Map<Long,Long> map=new HashMap<>();
        if (aggs != null) {
            List<Terms.Bucket> bucks=aggs.getBuckets();
            for(Terms.Bucket bk:bucks){
//                System.out.println("key:"+bk.getKeyAsString());
//                System.out.println("value:"+bk.getDocCount());
                map.put(bk.getKeyAsNumber().longValue(),bk.getDocCount());
            }
        }
        return map;
    }
}
