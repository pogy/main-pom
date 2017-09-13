package com.shigu.buyer.services;

import com.searchtool.configs.ElasticConfiguration;
import com.shigu.buyer.bo.GoodsupSearchBO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

/**
 * 类名：GoodsupRecordSimpleService
 * 类路径：com.shigu.buyer.services.GoodsupRecordSimpleService
 * 创建者：王浩翔
 * 创建时间：2017-09-13 15:22
 * 项目：main-pom
 * 描述：
 */
public class GoodsupRecordSimpleService {

    public ShiguPager<ItemUpRecordVO> goodsupRecordList(Long userId,String userNick,GoodsupSearchBO bo) {
        SearchRequestBuilder shigugoodsup = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        return null;
    }
}
