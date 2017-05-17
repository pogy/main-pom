package com.shigu.main4.monitor.service.impl;

import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.monitor.services.ItemBrowerService;
import com.shigu.main4.monitor.vo.ItemBrowerFlowVO;
import com.shigu.main4.tools.RedisIO;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private RedisIO redisIO;

    @Override
    public ItemBrowerFlowVO selUnrealBrower(Long itemId) {
        ItemBrowerFlowVO flowVO = redisIO.get("item_flow_" + itemId, ItemBrowerFlowVO.class);
        if (flowVO == null || flowVO.getVersion() != unrealVersion) {
            return makeUnrealBrower(itemId);
        }
        return flowVO;
    }

    @Override
    public ItemBrowerFlowVO makeUnrealBrower(Long itemId) {
        int multiple = 10;//倍数

        Long real = selItemBrower(itemId);

        ItemBrowerFlowVO vo = new ItemBrowerFlowVO();
        vo.setVersion(unrealVersion);
        vo.setNumber(real * multiple + real % multiple);
        vo.setMakeTime(new Date());
        redisIO.putTemp("item_flow_" + itemId, vo, 10000);
        return vo;
    }

    @Override
    public ItemBrowerFlowVO addUnrealBrower(Long itemId, Integer number) {
        ItemBrowerFlowVO unreal = selUnrealBrower(itemId);
        if (unreal == null) {
            unreal = makeUnrealBrower(itemId);
        }
        if (number == null) {
            return unreal;
        }
        unreal.setNumber(unreal.getNumber() + number);
        redisIO.putTemp("item_flow_" + itemId, unreal, 10000);
        return unreal;
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

        return response.getHits().getTotalHits();
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
