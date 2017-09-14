package com.shigu.buyer.services;

import com.searchtool.configs.ElasticConfiguration;
import com.shigu.buyer.bo.GoodsupSearchBO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Service;

/**
 * 类名：GoodsupRecordSimpleService
 * 类路径：com.shigu.buyer.services.GoodsupRecordSimpleService
 * 创建者：王浩翔
 * 创建时间：2017-09-13 15:22
 * 项目：main-pom
 * 描述：
 */
@Service("goodsupRecordSimpleService")
public class GoodsupRecordSimpleService {

    public ShiguPager<ItemUpRecordVO> goodsupRecordList(Long userId,String userNick,GoodsupSearchBO bo) {
        SearchRequestBuilder shigugoodsup = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(QueryBuilders.termQuery("fenUserId",userId)).must(QueryBuilders.termQuery("fenUserNick",userNick));
        //todo:前端确定字段后，根据前端搜索条件，进行搜索
        //{条件搜索代码段  boolQuery....   }
        //todo:分页，字段名要由前端确认
        shigugoodsup.setQuery(boolQuery).setFrom((bo.getNumber()-1)*bo.getSize()).setSize(bo.getSize());

        return null;
    }
}
