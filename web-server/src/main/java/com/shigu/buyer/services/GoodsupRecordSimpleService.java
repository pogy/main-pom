package com.shigu.buyer.services;

import com.alibaba.fastjson.JSON;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.shigu.buyer.bo.OnekeyRecordBO;
import com.shigu.buyer.vo.OnekeyRecoreVO;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.tb.finder.exceptions.TbItemSynException;
import com.shigu.tb.finder.services.TaobaoSynService;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    final String tbDownFlag = "bulk_tb_down_to_es";

    @Autowired
    RedisIO redisIO;

    @Autowired
    ShowForCdnService showForCdnService;

    @Autowired
    StoreRelationService storeRelationService;

    @Autowired
    ItemUpRecordService itemUpRecordService;

    @Autowired
    TaobaoSynService taobaoSynService;

    /**
     * 分销商下架淘宝商品
     */
    public void downTbGoods(Long userId, String tbUserNick, String ids) throws JsonErrException {
        if (userId == null || StringUtils.isBlank(tbUserNick)) {
            throw new JsonErrException("需要淘宝授权");
        }
        //必须是淘宝授权（淘宝登陆用户）才能进行淘宝下架，userId和tbNick一定非空
        List<Long> goodsIds = Arrays.stream(ids.split(",")).map(o -> Long.valueOf(o)).collect(Collectors.toList());
        List<SimpleElaBean> simpleElaBeans = selElaItemupRecords(userId, tbUserNick, goodsIds);
        for (SimpleElaBean simpleElaBean : simpleElaBeans) {
            ItemUpRecordVO goodsUpRecord = JSON.parseObject(simpleElaBean.getSource(), ItemUpRecordVO.class);
            try {
                goodsUpRecord.setTbSoldout(true);
                simpleElaBean.setSource(JSON.toJSONString(goodsUpRecord));
                downTbOneGoods(goodsUpRecord.getFenNumiid(), tbUserNick);
                redisIO.rpush(tbDownFlag, simpleElaBean);
            } catch (TbItemSynException e) {
                //如果淘宝已将下架了，也要更新记录
                if (e.getMessage().contains("ITEM_NOT_FOUND")) {
                    redisIO.rpush(tbDownFlag, simpleElaBean);
                }
                if (e.getMessage().contains("用户SessionKey不存在")) {
                    throw new JsonErrException("需要淘宝授权");
                }
            }
        }
    }

    /**
     * 手动淘宝下架
     * @param fenNumIid
     * @param tbNick
     * @throws TbItemSynException
     */
    @Transactional(rollbackFor = Exception.class)
    protected void downTbOneGoods(Long fenNumIid, String tbNick) throws TbItemSynException {
        taobaoSynService.downTbGoods(fenNumIid, tbNick);
    }

    /**
     * 获取用户对应商品的淘宝上传记录
     * userId和tbNick调用方法前必须经过验证
     *
     * @param userId
     * @param tbNick
     * @param goodsIds
     * @return
     */
    private List<SimpleElaBean> selElaItemupRecords(Long userId, String tbNick, List<Long> goodsIds) throws JsonErrException {
        if (goodsIds == null || goodsIds.size() == 0) {
            throw new JsonErrException("商品不能为空");
        }
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        query.must(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("fenUserId", userId)).should(QueryBuilders.termQuery("fenUserNick", tbNick)))
                .must(QueryBuilders.termQuery("flag", "web-tb")).must(QueryBuilders.termQuery("status", 0));
        BoolQueryBuilder goodsIdsQuery = QueryBuilders.boolQuery();
        for (Long goodsId : goodsIds) {
            goodsIdsQuery.should(QueryBuilders.termQuery("supperGoodsId", goodsId));
        }
        query.must(goodsIdsQuery);
        srb.addSort("daiTime", SortOrder.DESC);
        srb.setQuery(query);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        if (hits == null || hits.length == 0) {
            throw new JsonErrException("没有找到对应商品上传记录");
        }
        List<SimpleElaBean> vo = new ArrayList<>(hits.length);
        for (SearchHit hit : hits) {
            SimpleElaBean elaBean = new SimpleElaBean();
            elaBean.setIndex(hit.getIndex());
            elaBean.setPk(hit.getId());
            elaBean.setType(hit.getType());
            elaBean.setSource(hit.getSourceAsString());
            vo.add(elaBean);
        }
        return vo;
    }

    public ShiguPager<OnekeyRecoreVO> selOnekeyRecore(Long userId, String tbNick, OnekeyRecordBO bo) {
        if (userId == null) {
            return new ShiguPager<>();
        }
        if (bo == null) {
            bo = new OnekeyRecordBO();
        }
        ShiguPager<OnekeyRecoreVO> pager = new ShiguPager<>();
        SearchRequestBuilder searchRequestBuilder = ElasticConfiguration.searchClient.prepareSearch(esIndex);
        searchRequestBuilder.setQuery(buildQuery(userId, tbNick, bo));
        if (bo.getUploadGoodsState() != null && bo.getUploadGoodsState() == 3) {
            searchRequestBuilder.addSort(SortBuilders.scoreSort().order(SortOrder.DESC));
        }
        searchRequestBuilder.addSort(SortBuilders.fieldSort("daiTime").order(SortOrder.DESC));
        searchRequestBuilder.setFrom((bo.getPage() - 1) * bo.getRows());
        searchRequestBuilder.setSize(bo.getRows());
        SearchResponse searchResponse = null;
        try {
            searchResponse = searchRequestBuilder.execute().actionGet();
        } catch (Exception e) {
            return new ShiguPager<>();
        }
        Long totalHits = searchResponse.getHits().getTotalHits();
        List<OnekeyRecoreVO> recoreList = new ArrayList<>(bo.getRows());
        SearchHit[] hits = searchResponse.getHits().getHits();
        if (hits != null && hits.length > 0) {
            for (SearchHit hit : hits) {
                ItemUpRecordVO shiguGoodsUp = JSON.parseObject(hit.getSourceAsString(), ItemUpRecordVO.class);
                if (shiguGoodsUp == null) {
                    continue;
                }
                OnekeyRecoreVO onekeyRecoreVO = new OnekeyRecoreVO();
                onekeyRecoreVO.setGoodsId(shiguGoodsUp.getSupperGoodsId());
                onekeyRecoreVO.setImgsrc(shiguGoodsUp.getSupperImage());
                onekeyRecoreVO.setTitle(shiguGoodsUp.getSupperGoodsName());
                onekeyRecoreVO.setOnekeyId(hit.getId());
                onekeyRecoreVO.setUpTime(shiguGoodsUp.getDaiTime());
                onekeyRecoreVO.setPiprice(shiguGoodsUp.getSupperPrice());
                if (shiguGoodsUp.getShopSoldout() != null) {
                    onekeyRecoreVO.setShopSaleState(!shiguGoodsUp.getShopSoldout() ? 1 : 2);
                }
                if (shiguGoodsUp.getTbSoldout() != null) {
                    onekeyRecoreVO.setTaobaoSaleState(!shiguGoodsUp.getTbSoldout() ? 1 : 2);
                }
                if (shiguGoodsUp.getWebSite() == null) {
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
                    onekeyRecoreVO.setGoodsNo(cdnItem.getHuohao());
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
        if (bo.getFlag() != null) {
            otherQuery.must(QueryBuilders.termQuery("flag", bo.getFlag()));
        }
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
                    otherQuery.must(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(tbSoldout, true)).should(QueryBuilders.termQuery(shopSoldout, true).boost(10f)).should(QueryBuilders.termQuery(shopSoldout, false).boost(1f)));
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
        otherQuery.must(QueryBuilders.termQuery("status", 0));
        return otherQuery.must(userQuery);
    }

    public long shopDownNum(Long userId, String tbNick) {
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
