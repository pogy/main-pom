package com.shigu.activity.service;


import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ActiveDrawGoodsExample;
import com.opentae.data.mall.examples.ActiveDrawPemExample;
import com.opentae.data.mall.examples.ActiveDrawRecordExample;
import com.opentae.data.mall.examples.ActiveDrawShopExample;
import com.opentae.data.mall.interfaces.ActiveDrawGoodsMapper;
import com.opentae.data.mall.interfaces.ActiveDrawPemMapper;
import com.opentae.data.mall.interfaces.ActiveDrawRecordMapper;
import com.opentae.data.mall.interfaces.ActiveDrawShopMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.util.BeanMapper;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 活动抽奖SERVICE
 *
 * @author shigu_zjb
 * @date 2017/05/12 18:45
 *
 */
@Service
public class ActiveDrawService {

    @Autowired
    private ActiveDrawPemMapper activeDrawPemMapper;

    @Autowired
    private ActiveDrawGoodsMapper activeDrawGoodsMapper;

    @Autowired
    private ActiveDrawShopMapper activeDrawShopMapper;

    @Autowired
    private ActiveDrawRecordMapper activeDrawRecordMapper;

    /**
     * 查询当前期次
     * @return
     */
    public ActiveDrawPem selNowDrawPem(){
        ActiveDrawPemExample activeDrawPemExample = new ActiveDrawPemExample();
        activeDrawPemExample.createCriteria().andStartTimeLessThan(new Date());
        activeDrawPemExample.setOrderByClause("start_time ASC");
        activeDrawPemExample.setStartIndex(0);
        activeDrawPemExample.setEndIndex(1);
        List<ActiveDrawPem> activeDrawPemList = activeDrawPemMapper.selectByExample(activeDrawPemExample);
        if(activeDrawPemList == null){
            return null;
        }
        return activeDrawPemList.get(0);
    }

    /**
     * 查询当前期次商品数据
     * @param pemId
     */
    public List<ActiveDrawGoods> selGoodsList(Long pemId, String type, int size){
        ActiveDrawGoodsExample drawGoodsExample = new ActiveDrawGoodsExample();
        drawGoodsExample.createCriteria().andPemIdEqualTo(pemId).andTypeEqualTo(type).andEnabledEqualTo(false);
        List<ActiveDrawGoods> drawGoodsList = activeDrawGoodsMapper.selectByExample(drawGoodsExample);
        List goodsList = BeanMapper.getFieldList(drawGoodsList, "goodsId", List.class);
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("goods");
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder goodIdsQuery = QueryBuilders.termsQuery("goodsId", goodsList);
        QueryBuilder goodStatusQuery = QueryBuilders.termsQuery("is_off", 0);
        boleanQueryBuilder.must(goodIdsQuery);
        boleanQueryBuilder.must(goodStatusQuery);
        srb.setSize(size);
        srb.setFrom(0);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        if (hits != null && hits.length > 0) {
            for (SearchHit hit : hits) {
                ShiguGoodsTiny shiguGoodsTiny = JSON.parseObject(hit.getSourceAsString(), ShiguGoodsTiny.class);
                
            }
        }

        return drawGoodsList;
    }

    /**
     * 查询当前期次店铺
     * @param pemId
     * @return
     */
    public List<ActiveDrawShop> selShopList(Long pemId){
        ActiveDrawShopExample drawShopExample = new ActiveDrawShopExample();
        drawShopExample.createCriteria().andPemIdEqualTo(pemId);
        List<ActiveDrawShop> drawShopList = activeDrawShopMapper.selectByExample(pemId);
        return drawShopList;
    }

    /**
     * 查询中奖
     * @param pemId
     * @return
     */
    public List<ActiveDrawRecord> selDrawRecordList(Long pemId){
        ActiveDrawRecordExample drawRecordExample = new ActiveDrawRecordExample();
        drawRecordExample.createCriteria().andPemIdEqualTo(pemId);
        List<ActiveDrawRecord> drawRecordList = activeDrawRecordMapper.selectByExample(drawRecordExample);
        return drawRecordList;
    }

}
