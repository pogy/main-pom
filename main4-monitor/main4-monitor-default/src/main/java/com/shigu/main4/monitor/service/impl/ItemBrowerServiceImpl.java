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
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.cardinality.Cardinality;
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

    private static final int unrealVersion=1;

    @Autowired
    private RedisIO redisIO;

    /**
     * 查询不真实流量， 不存在则创建
     * @param itemId 商品ID
     * @return 流量记录
     */
    @Override
    public ItemBrowerFlowVO selUnrealBrower(Long itemId) {
        ItemBrowerFlowVO flowVO = redisIO.get("item_flow_" + itemId, ItemBrowerFlowVO.class);
        if (flowVO == null || flowVO.getVersion() != unrealVersion) {
            return makeUnrealBrower(itemId);
        }
        return flowVO;
    }

    /**
     * 创建流量计录， 受倍数控制的初始流量值
     * @param itemId 商品ID
     * @return 流量记录
     */
    @Override
    public ItemBrowerFlowVO makeUnrealBrower(Long itemId) {
        int multiple = 10;//倍数

        Long real = selItemBrower(itemId);

        ItemBrowerFlowVO vo = new ItemBrowerFlowVO();
        vo.setVersion(unrealVersion);
        if(real==0L){
            vo.setNumber((long)(Math.random()*multiple));
        }else{
            vo.setNumber(real * multiple + real % multiple);
        }
        vo.setMakeTime(new Date());
        redisIO.putTemp("item_flow_" + itemId, vo, 300);
        return vo;
    }

    /**
     * 添加不真实流量， 不存在流量记录则创建
     * @param itemId 商品ID
     * @param number 添加数量
     * @return 流量记录
     */
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
        redisIO.putTemp("item_flow_" + itemId, unreal, 300);
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
        return ElasticConfiguration.searchClient.prepareSearch("shigupagerecode")
                .setTypes("item").setSearchType(SearchType.COUNT)
                .setQuery(QueryBuilders.termQuery("itemId", itemId))
                .execute().actionGet().getHits().getTotalHits();
    }

    @Override
    public Long selItemIP(Long itemId) {
        if (itemId == null) {
            return 0L;
        }
        SearchResponse response = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode")
                .setTypes("item")
                .setSearchType(SearchType.COUNT)
                .setQuery(QueryBuilders.termQuery("itemId", itemId))
                .addAggregation(AggregationBuilders.cardinality("countClient").field("clientMsg.clientIp"))
                .execute().actionGet();

        Cardinality countClient = response.getAggregations().get("countClient");
        return countClient.getValue();
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
