package com.shigu.activity.service;


import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ActiveDrawGoodsExample;
import com.opentae.data.mall.examples.ActiveDrawPemExample;
import com.opentae.data.mall.examples.ActiveDrawShopExample;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawGoodsVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawRecordUserVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawShopVo;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.tools.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
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

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    /**
     * 查询当前期次
     * @return
     */
    public ActiveDrawPemVo selNowDrawPem(Date startTime){
        if(startTime == null)startTime = new Date();
        ActiveDrawPemExample activeDrawPemExample = new ActiveDrawPemExample();
        activeDrawPemExample.createCriteria().andStartTimeLessThan(startTime);
        activeDrawPemExample.setOrderByClause("start_time DESC");
        activeDrawPemExample.setStartIndex(0);
        activeDrawPemExample.setEndIndex(1);
        List<ActiveDrawPem> activeDrawPemList = activeDrawPemMapper.selectByExample(activeDrawPemExample);
        if(activeDrawPemList == null || activeDrawPemList.size() == 0){
            return null;
        }
        ActiveDrawPemVo activeDrawPemVo = BeanMapper.map(activeDrawPemList.get(0), ActiveDrawPemVo.class);
        return activeDrawPemVo;
    }

    /**
     * 查询当前期次商品数据
     * @param pemId
     */
    public List<ActiveDrawGoodsVo> selGoodsList(Long pemId, String type, int size, Boolean enabled){
        ActiveDrawGoodsExample drawGoodsExample = new ActiveDrawGoodsExample();
        ActiveDrawGoodsExample.Criteria ctx = drawGoodsExample.createCriteria();
        ctx.andPemIdEqualTo(pemId).andTypeEqualTo(type);
        if(enabled != null){
            ctx.andEnabledEqualTo(enabled);
        }
        List<ActiveDrawGoods> drawGoodsList = activeDrawGoodsMapper.selectByExample(drawGoodsExample);
        List goodsList = BeanMapper.getFieldList(drawGoodsList, "goodsId", List.class);
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("goods");
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder goodIdsQuery = QueryBuilders.termsQuery("goodsId", goodsList);

        // 特殊要求：发现好货不用区分是否下架，该处为广告位
        if (!StringUtils.equals(ActiveDrawGoods.TYPE_FAGOODS, type)) {
            QueryBuilder goodStatusQuery = QueryBuilders.termQuery("is_off", 0);
            boleanQueryBuilder.must(goodStatusQuery);
        }

        boleanQueryBuilder.must(goodIdsQuery);
        srb.setSize(size);
        srb.setFrom(0);
        srb.setQuery(boleanQueryBuilder);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        List<ActiveDrawGoodsVo> drawGoodsVoList = new ArrayList<ActiveDrawGoodsVo>();
        if (hits != null && hits.length > 0) {
            for (SearchHit hit : hits) {
                ShiguGoodsTiny shiguGoodsTiny = JSON.parseObject(hit.getSourceAsString(), ShiguGoodsTiny.class);
                ActiveDrawGoodsVo activeDrawGoodsVo = new ActiveDrawGoodsVo();
                activeDrawGoodsVo.setGoodsId(shiguGoodsTiny.getGoodsId());
                activeDrawGoodsVo.setImgSrc(shiguGoodsTiny.getPicUrl());
                activeDrawGoodsVo.setMarketName(shiguGoodsTiny.getParentMarketName());
                activeDrawGoodsVo.setShopNum(shiguGoodsTiny.getStoreNum());
                activeDrawGoodsVo.setPemId(pemId);
                DecimalFormat df2=(DecimalFormat) DecimalFormat.getInstance();
                df2.applyPattern("0.00");
                activeDrawGoodsVo.setPiPriceString(df2.format(shiguGoodsTiny.getPiPrice()/100));
                activeDrawGoodsVo.setTitle(shiguGoodsTiny.getTitle());
                activeDrawGoodsVo.setShopId(shiguGoodsTiny.getStoreId());
                if(StringUtils.isEmpty(shiguGoodsTiny.getParentMarketName())){
                    ShiguMarket shiguMarket = shiguMarketMapper.selectFieldsByPrimaryKey(shiguGoodsTiny.getParentMarketId(),
                            FieldUtil.codeFields("market_id,market_name"));
                    if(shiguMarket != null){
                        activeDrawGoodsVo.setMarketName(shiguMarket.getMarketName());
                    }
                }
                if(StringUtils.isEmpty(activeDrawGoodsVo.getShopNum())){
                    ShiguShop shiguShop = shiguShopMapper.selectFieldsByPrimaryKey(activeDrawGoodsVo.getShopId(),
                            FieldUtil.codeFields("shop_id,shop_num"));
                    if(shiguShop != null){
                        activeDrawGoodsVo.setShopNum(shiguShop.getShopNum());
                    }
                }
                drawGoodsVoList.add(activeDrawGoodsVo);
            }
        }
        return drawGoodsVoList;
    }

    /**
     * 查询当前期次店铺
     * @param pemId
     * @return
     */
    public List<ActiveDrawShopVo> selShopList(Long pemId){
        ActiveDrawShopExample drawShopExample = new ActiveDrawShopExample();
        drawShopExample.createCriteria().andPemIdEqualTo(pemId);
        List<ActiveDrawShop> drawShopList = activeDrawShopMapper.selectByExample(drawShopExample);
        List shopIdsList = BeanMapper.getFieldList(drawShopList,"shopId", List.class);
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shop");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder shopQuery = QueryBuilders.termsQuery("shop_id",shopIdsList);
        boolQueryBuilder.must(shopQuery);
        srb.setQuery(boolQueryBuilder);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        if(hits == null){
            return Collections.EMPTY_LIST;
        }
        List<ActiveDrawShopVo> drawShopVoList = new ArrayList<ActiveDrawShopVo>();
        for(SearchHit hit : hits){
            ShiguShop shiguShop = JSON.parseObject(hit.getSourceAsString(),ShiguShop.class);
            for(int i = 0;i<drawShopList.size();i++){
                ActiveDrawShop activeDrawShop = drawShopList.get(i);
                if(activeDrawShop.getShopId().intValue() == shiguShop.getShopId().intValue()){
                    ActiveDrawShopVo drawShopVo = new ActiveDrawShopVo();
                    drawShopVo.setId(activeDrawShop.getId());
                    drawShopVo.setPemId(pemId);
                    drawShopVo.setMarketName(shiguShop.getMarketName());
                    drawShopVo.setImgSrc(activeDrawShop.getPicUrl());
                    drawShopVo.setShopNum(shiguShop.getShopNum());
                    drawShopVo.setuText(activeDrawShop.getuText());
                    drawShopVo.setdText(activeDrawShop.getdText());
                    if(StringUtils.isEmpty(drawShopVo.getMarketName())){
                        ShiguMarket shiguMarket = shiguMarketMapper.selectFieldsByPrimaryKey(shiguShop.getMarketId(),
                                FieldUtil.codeFields("market_id,market_name"));
                        if(shiguMarket != null){
                            drawShopVo.setMarketName(shiguMarket.getMarketName());
                        }
                    }
                    drawShopVoList.add(drawShopVo);
                    break;
                }
            }
        }
        return drawShopVoList;
    }

    /**
     * 查询中奖
     * @param pemId
     * @return
     */
    public List<ActiveDrawRecordUserVo> selDrawRecordList(Long pemId,Long userId, String type){
        List<ActiveDrawRecord> drawRecordList = activeDrawRecordMapper.selDrawRecordList(pemId, userId, type);
        List<ActiveDrawRecordUserVo> recordUserVos = BeanMapper.mapList(drawRecordList, ActiveDrawRecordUserVo.class);
        return recordUserVos;
    }

    /**
     * 查询上传
     * @param goodslist
     * @param userId
     * @return
     */
    public Long selGoodsupTotal(List goodslist, Long userId, Date startTime){
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        QueryBuilder userQuery = QueryBuilders.termQuery("fenUserId", userId);
        QueryBuilder goodsIdQuery = QueryBuilders.termsQuery("supperGoodsId", goodslist);
        QueryBuilder startQuery = QueryBuilders.rangeQuery("daiTime");//.gte(DateUtil.dateToString(startTime,DateUtil.patternD)).format("yyyy-MM-dd HH:mm:ss");

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(userQuery);
        boolQuery.must(goodsIdQuery);
        boolQuery.must(startQuery);
        srb.setQuery(boolQuery);

        srb.addAggregation(AggregationBuilders.terms("supperGoodsIdAgg").field("supperGoodsId").size(1000));
        SearchResponse response = srb.execute().actionGet();
        LongTerms supperGoodsIdAgg = response.getAggregations().get("supperGoodsIdAgg");
        int total = supperGoodsIdAgg.getBuckets().size();;
        return Long.valueOf(total);
    }

    /**
     * 查询当前正在进行的
     * @param userId
     * @return
     */
    public List<ActiveDrawRecordUserVo> selDrawNowUserRecord(Long userId){
        ActiveDrawPemVo activeDrawPem = selNowDrawPem(null);
        if(activeDrawPem == null){
            // 当前没有正在进行的活动
            return Collections.EMPTY_LIST;
        }
        // 查询发现好货活动的数据
        ActiveDrawGoodsExample drawGoodsExample = new ActiveDrawGoodsExample();
        drawGoodsExample.createCriteria().andPemIdEqualTo(activeDrawPem.getId()).andTypeEqualTo(ActiveDrawGoods.TYPE_FAGOODS)
                .andEnabledEqualTo(false);
        List<ActiveDrawGoods> drawGoodsList = activeDrawGoodsMapper.selectByExample(drawGoodsExample);
        List goodsList = BeanMapper.getFieldList(drawGoodsList, "goodsId", List.class);
        Long total = selGoodsupTotal(goodsList, userId, activeDrawPem.getStartTime());

        ActiveDrawRecord activeDrawRecord = new ActiveDrawRecord();
        activeDrawRecord.setUserId(userId);
        activeDrawRecord.setPemId(activeDrawPem.getId());
        activeDrawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_WAIT);
        activeDrawRecord.setEnabled(false);
        activeDrawRecord.setReceivesYes(false);
        activeDrawRecord.setCreateTime(new Date());
        activeDrawRecord.setModifyTime(new Date());
        if(total >= 3){
            activeDrawRecord.setWard("A1");
            String drawCode = StringUtil.str10To37Str();
            activeDrawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_YES);
            activeDrawRecord.setDrawCode(drawCode);
            addActiveDrawRecord(activeDrawRecord);
        }
        activeDrawRecord.setDrawCode(null);
        if(total >= 5){
            activeDrawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_WAIT);
            activeDrawRecord.setId(null);
            activeDrawRecord.setWard("A2");
            addActiveDrawRecord(activeDrawRecord);
        }
        if(total >= 10){
            activeDrawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_WAIT);
            activeDrawRecord.setId(null);
            activeDrawRecord.setWard("A3");
            addActiveDrawRecord(activeDrawRecord);
        }

        // 查询每日发现
        ActiveDrawGoodsExample drawDaliyGoodsExample = new ActiveDrawGoodsExample();
        drawDaliyGoodsExample.createCriteria().andPemIdEqualTo(activeDrawPem.getId()).andTypeEqualTo(ActiveDrawGoods.TYPE_DAILYFIND)
                .andEnabledEqualTo(false);
        List<ActiveDrawGoods> drawDaliyGoodsList = activeDrawGoodsMapper.selectByExample(drawDaliyGoodsExample);
        List daliyGoodsList = BeanMapper.getFieldList(drawDaliyGoodsList, "goodsId", List.class);
        total = selGoodsupTotal(daliyGoodsList, userId, activeDrawPem.getStartTime());
        if(total >= 3){
            activeDrawRecord.setWard("B1");
            activeDrawRecord.setId(null);
            String drawCode = StringUtil.str10To37Str();
            activeDrawRecord.setDrawCode(drawCode);
            activeDrawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_YES);
            addActiveDrawRecord(activeDrawRecord);
        }
        activeDrawRecord.setDrawCode(null);
        if(total >= 5){
            activeDrawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_WAIT);
            activeDrawRecord.setId(null);
            activeDrawRecord.setWard("B2");
            addActiveDrawRecord(activeDrawRecord);
        }

        List<ActiveDrawRecordUserVo> selDrawRecordList = selDrawRecordList(activeDrawPem.getId(), userId, null);

        return selDrawRecordList;
    }

    /**
     *  新增用户抽奖
     * @param activeDrawRecord
     */
    public void addActiveDrawRecord(ActiveDrawRecord activeDrawRecord){
        if(activeDrawRecord == null || activeDrawRecord.getPemId() == null ||
             activeDrawRecord.getUserId() == null || StringUtils.isEmpty(activeDrawRecord.getWard())){
            return;
        }
        ActiveDrawRecord drawRecord = new ActiveDrawRecord();
        drawRecord.setPemId(activeDrawRecord.getPemId());
        drawRecord.setUserId(activeDrawRecord.getUserId());
        drawRecord.setWard(activeDrawRecord.getWard());
        int count = activeDrawRecordMapper.selectCount(drawRecord);
        if(count > 0){
            // 已经新增数据
            return;
        }
        activeDrawRecordMapper.insertSelective(activeDrawRecord);
    }

}
