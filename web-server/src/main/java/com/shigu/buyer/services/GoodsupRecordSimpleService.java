package com.shigu.buyer.services;

import com.alibaba.fastjson.JSON;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.buyer.bo.OnekeyRecordBO;
import com.shigu.buyer.vo.OnekeyRecoreVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.StoreRelation;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：GoodsupRecordSimpleService
 * 类路径：com.shigu.buyer.services.GoodsupRecordSimpleService
 * 创建者：王浩翔
 * 创建时间：2017-10-18 11:16
 * 项目：main-pom
 * 描述：商品上传信息简单处理
 */
@Service
public class GoodsupRecordSimpleService {

    //一键上传记录es索引
    final String esIndex = "shigugoodsup";

    @Autowired
    ShowForCdnService showForCdnService;

    @Autowired
    StoreRelationService storeRelationService;

    public ShiguPager<OnekeyRecoreVO> selOnekeyRecore(Long userId, String tbNick, OnekeyRecordBO bo) {
        if (userId == null) {
            return new ShiguPager<OnekeyRecoreVO>();
        }
        if (bo == null) {
            bo = new OnekeyRecordBO();
        }
        ShiguPager<OnekeyRecoreVO> pager = new ShiguPager<>();
        SearchRequestBuilder searchRequestBuilder = ElasticConfiguration.searchClient.prepareSearch(esIndex);
        searchRequestBuilder.setQuery(buildQuery(userId, tbNick, bo));
        if (bo.getUploadGoodsState() != null && bo.getUploadGoodsState()==3) {
            searchRequestBuilder.addSort(SortBuilders.scoreSort().order(SortOrder.DESC));
        }
        searchRequestBuilder.addSort(SortBuilders.fieldSort("daiTime").order(SortOrder.DESC));
        searchRequestBuilder.setFrom((bo.getPage() - 1)*bo.getRows());
        searchRequestBuilder.setSize(bo.getRows());
        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();
        Long totalHits = searchResponse.getHits().getTotalHits();
        List<OnekeyRecoreVO> recoreList = new ArrayList<>(bo.getRows());
        SearchHit[] hits = searchResponse.getHits().getHits();
        if (hits != null && hits.length > 0) {
            for (SearchHit hit : hits) {
                ItemUpRecordVO shiguGoodsUp = JSON.parseObject(hit.getSourceAsString(), ItemUpRecordVO.class);
                if(shiguGoodsUp == null){
                    continue;
                }
                OnekeyRecoreVO onekeyRecoreVO = new OnekeyRecoreVO();
                onekeyRecoreVO.setGoodsId(shiguGoodsUp.getSupperGoodsId());
                onekeyRecoreVO.setImgsrc(shiguGoodsUp.getSupperImage());
                onekeyRecoreVO.setTitle(shiguGoodsUp.getSupperGoodsName());
                onekeyRecoreVO.setOnekeyId(hit.getId());
                onekeyRecoreVO.setUpTime(shiguGoodsUp.getDaiTime());
                if (shiguGoodsUp.getShopSoldout() != null) {
                    onekeyRecoreVO.setShopSaleState(!shiguGoodsUp.getShopSoldout()?1:2);
                }
                if (shiguGoodsUp.getTbSoldout() != null) {
                    onekeyRecoreVO.setShopSaleState(!shiguGoodsUp.getShopSoldout()?1:2);
                }
                if(shiguGoodsUp.getWebSite()==null){
//                    continue;//跳过
                    shiguGoodsUp.setWebSite("hz");//暂时认为是杭州站 的
                }
                StoreRelation storeRelation = storeRelationService.selRelationById(shiguGoodsUp.getSupperStoreId());
                if (storeRelation != null) {
                    onekeyRecoreVO.setMarketName(storeRelation.getMarketName());
                    onekeyRecoreVO.setShopNum(storeRelation.getStoreNum());
                }
                CdnItem cdnItem = showForCdnService.selItemById(shiguGoodsUp.getSupperGoodsId(), shiguGoodsUp.getWebSite());
                if (cdnItem != null) {
                    onekeyRecoreVO.setPiprice(cdnItem.getPiPrice());
                }
                recoreList.add(onekeyRecoreVO);
            }
        }
        pager.setNumber(bo.getPage());
        pager.setContent(recoreList);
        pager.calPages(totalHits.intValue(), bo.getRows());
        return pager;
    }


    private QueryBuilder buildQuery(Long userId, String tbNick, OnekeyRecordBO bo) {
        String shopSoldout = "shopSoldout";
        String tbSoldout = "tbSoldout";
        BoolQueryBuilder userQuery = QueryBuilders.boolQuery();
        if (StringUtils.isNotBlank(tbNick)) {
            TermQueryBuilder fenUserId = QueryBuilders.termQuery("fenUserId", userId);
            TermQueryBuilder fenUserNick = QueryBuilders.termQuery("fenUserNick", tbNick);
            userQuery.should(fenUserId).should(fenUserNick).minimumNumberShouldMatch(1);
        } else {
            userQuery.must(QueryBuilders.termQuery("fenUserId", userId));
        }
        BoolQueryBuilder otherQuery = QueryBuilders.boolQuery();
        otherQuery.must(QueryBuilders.termQuery("flag", bo.getFlag()));
        if (bo.getShopState() != null) {
            boolean shopOnsale = bo.getShopState() == 1;
            otherQuery.must(QueryBuilders.termQuery(shopSoldout, !shopOnsale));
        }
        if (bo.getTbState() != null) {
            boolean tbOnsale = bo.getTbState() == 1;
            otherQuery.must(QueryBuilders.termQuery(tbSoldout, !tbOnsale));
        }
        if (bo.getUploadGoodsState() != null) {
            switch (bo.getUploadGoodsState()) {
                case 1:
                    otherQuery.must(QueryBuilders.termQuery(shopSoldout, false)).must(QueryBuilders.termQuery(tbSoldout, false));
                    break;
                case 2:
                    otherQuery.must(QueryBuilders.termQuery(shopSoldout, true)).must(QueryBuilders.termQuery(tbSoldout, false));
                    break;
                case 3:
                    otherQuery.must(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(tbSoldout, true)).should(QueryBuilders.termQuery(shopSoldout,true)));
                    break;
            }
        }
        if (StringUtils.isNotBlank(bo.getStartTime()) || StringUtils.isNotBlank(bo.getEndTime())) {
            RangeQueryBuilder timeQuery = QueryBuilders.rangeQuery("daiTime");
            if (StringUtils.isNotBlank(bo.getStartTime())) {
                timeQuery.from(bo.getStartTime() + " 00:00:00");
            }
            if (StringUtils.isNotBlank(bo.getEndTime())) {
                timeQuery.to(bo.getEndTime() + " 23:59:59");
            }
            otherQuery.must(timeQuery);
        }
        otherQuery.must(QueryBuilders.termQuery("status",0));
        return otherQuery.must(userQuery);
    }

    public long shopDownNum(Long userId,String tbNick){
        if (userId == null) {
            return 0;
        }
        OnekeyRecordBO bo = new OnekeyRecordBO();
        bo.setUploadGoodsState(2);
        QueryBuilder queryBuilder = buildQuery(userId, tbNick, bo);
        SearchResponse searchResponse = ElasticConfiguration.searchClient.prepareSearch(esIndex).setSearchType(SearchType.COUNT).setQuery(queryBuilder).setSize(0).execute().actionGet();
        return searchResponse.getHits().getTotalHits();
    }

}
