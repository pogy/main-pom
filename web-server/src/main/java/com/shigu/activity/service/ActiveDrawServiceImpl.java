package com.shigu.activity.service;


import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.spread.service.ActiveDrawService;
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
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 活动抽奖SERVICE
 *
 * @author shigu_zjb
 * @date 2017/05/12 18:45
 *
 */
@Service("activeDrawService")
public class ActiveDrawServiceImpl implements ActiveDrawService{

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

    @Autowired
    private ActiveDrawPitMapper activeDrawPitMapper;

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
        ActiveDrawPitExample drawPitExample = new ActiveDrawPitExample();
        drawPitExample.createCriteria().andTypeEqualTo(ActiveDrawPit.TYPE_GOODS);
        drawPitExample.setOrderByClause("num asc");
        List<ActiveDrawPit> drawPitList = activeDrawPitMapper.selectByExample(drawPitExample);
        if(drawPitList.size() == 0 && StringUtils.equals(ActiveDrawGoods.TYPE_FAGOODS,type)){
            return Collections.emptyList();
        }
        ActiveDrawGoodsExample drawGoodsExample = new ActiveDrawGoodsExample();
        ActiveDrawGoodsExample.Criteria ctx = drawGoodsExample.createCriteria();
        ctx.andPemIdEqualTo(pemId).andTypeEqualTo(type);
        drawGoodsExample.setOrderByClause("sort asc");
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
            HashMap<Long, ESGoods> goodsTinyHashMap = new HashMap<Long, ESGoods>();
            for (SearchHit hit : hits) {
                ESGoods esGoods = JSON.parseObject(hit.getSourceAsString(), ESGoods.class);
                goodsTinyHashMap.put(esGoods.getGoodsId(),esGoods);
            }
            List<Long> shopIds = BeanMapper.getFieldList(new ArrayList<Object>(goodsTinyHashMap.values()), "storeId", Long.class);
            ShiguShopExample shopExample = new ShiguShopExample();
            shopExample.createCriteria().andShopIdIn(shopIds);
            List<ShiguShop> shiguShopList = shiguShopMapper.selectFieldsByExample(shopExample,FieldUtil.codeFields("shop_id,shop_num"));
            Map<Long, ShiguShop> shopMap = BeanMapper.list2Map(shiguShopList, "shopId", Long.class);
            List<Long> parentMarketIdList = BeanMapper.getFieldList(new ArrayList<Object>(goodsTinyHashMap.values()), "parentMarketId", Long.class);
            ShiguMarketExample marketExample = new ShiguMarketExample();
            marketExample.createCriteria().andMarketIdIn(parentMarketIdList);
            List<ShiguMarket> marketList = shiguMarketMapper.selectFieldsByExample(marketExample, FieldUtil.codeFields("market_id,market_name"));
            Map<Long, ShiguMarket> marketMap = BeanMapper.list2Map(marketList, "marketId", Long.class);
            for(ActiveDrawGoods drawGoods : drawGoodsList){
                ESGoods shiguGoodsTiny = goodsTinyHashMap.get(drawGoods.getGoodsId());
                if(shiguGoodsTiny == null){continue;}
                ActiveDrawGoodsVo activeDrawGoodsVo = new ActiveDrawGoodsVo();
                activeDrawGoodsVo.setGoodsId(shiguGoodsTiny.getGoodsId());
                activeDrawGoodsVo.setImgSrc(shiguGoodsTiny.getPicUrl());
                activeDrawGoodsVo.setMarketName(shiguGoodsTiny.getParentMarketName());
                activeDrawGoodsVo.setShopNum(shiguGoodsTiny.getStoreNum());
                activeDrawGoodsVo.setPemId(pemId);
                activeDrawGoodsVo.setIsOff(shiguGoodsTiny.getIs_off());

                DecimalFormat df2=(DecimalFormat) DecimalFormat.getInstance();
                df2.applyPattern("0.00");
                activeDrawGoodsVo.setPiPriceString(df2.format(shiguGoodsTiny.getPiPrice()/100));
                activeDrawGoodsVo.setTitle(shiguGoodsTiny.getTitle());
                activeDrawGoodsVo.setShopId(shiguGoodsTiny.getStoreId());
                if(StringUtils.isEmpty(shiguGoodsTiny.getParentMarketName())){
                    ShiguMarket shiguMarket = marketMap.get(shiguGoodsTiny.getParentMarketId());
                    if(shiguMarket != null){
                        activeDrawGoodsVo.setMarketName(shiguMarket.getMarketName());
                    }
                }
                if(StringUtils.isEmpty(activeDrawGoodsVo.getShopNum())){
                    ShiguShop shiguShop = shopMap.get(activeDrawGoodsVo.getShopId());
                    if(shiguShop != null){
                        activeDrawGoodsVo.setShopNum(shiguShop.getShopNum());
                    }
                }
                drawGoodsVoList.add(activeDrawGoodsVo);
                activeDrawGoodsVo.setId(drawGoods.getId());
                activeDrawGoodsVo.setPitId(drawGoods.getPitId());
            }

        }

        if(ActiveDrawGoods.TYPE_DAILYFIND.equals(type)){
            return drawGoodsVoList;
        }

        List<ActiveDrawGoodsVo> newDrawGoodsVoList = new ArrayList<ActiveDrawGoodsVo>();
        for (int i = 0; i < drawPitList.size(); i++) {
            ActiveDrawPit drawPit = drawPitList.get(i);
            Boolean panss = false;
            for (int j = 0; j < drawGoodsVoList.size(); j++) {
                ActiveDrawGoodsVo drawGoodsVo = drawGoodsVoList.get(j);
                if(drawGoodsVo.getPitId()!=null && drawPit.getId().intValue() == drawGoodsVo.getPitId().intValue()){
                    drawGoodsVo.setNum(drawPit.getNum());
                    newDrawGoodsVoList.add(drawGoodsVo);
                    panss = true;
                    break;
                }
            }
            if(!panss){
                ActiveDrawGoodsVo drawGoodsVo = new ActiveDrawGoodsVo();
                drawGoodsVo.setPitId(drawPit.getId());
                drawGoodsVo.setNum(drawPit.getNum());
                newDrawGoodsVoList.add(drawGoodsVo);
            }
        }

        return newDrawGoodsVoList;
    }

    /**
     * 获取当前正在进行的期次
     * @return
     */
    @Override
    public ActiveDrawPemVo selNowDrawPem() {
        return selNowDrawPem(null);
    }

    /**
     * 查询本期级以后的期次
     * @return
     */
    @Override
    public List<ActiveDrawPemVo> selDrawPemQueList() {
        ActiveDrawPemExample activeDrawPemExample = new ActiveDrawPemExample();
        activeDrawPemExample.createCriteria().andStartTimeGreaterThan(new Date());
        activeDrawPemExample.setOrderByClause("start_time ASC");
        activeDrawPemExample.setStartIndex(0);
        activeDrawPemExample.setEndIndex(1);
        List<ActiveDrawPem> activeDrawPemList = activeDrawPemMapper.selectByExample(activeDrawPemExample);
        List<ActiveDrawPemVo> drawPemVoList = BeanMapper.mapList(activeDrawPemList, ActiveDrawPemVo.class);
        drawPemVoList.add(0,selNowDrawPem());
        return drawPemVoList;
    }

    /**
     * 查询所有期次
     * @return
     */
    @Override
    public List<ActiveDrawPemVo> selDrawPemList() {
        ActiveDrawPemExample activeDrawPemExample = new ActiveDrawPemExample();
        activeDrawPemExample.setOrderByClause("start_time DESC");
        List<ActiveDrawPem> activeDrawPemList = activeDrawPemMapper.selectByExample(activeDrawPemExample);
        List<ActiveDrawPemVo> drawPemVoList = BeanMapper.mapList(activeDrawPemList, ActiveDrawPemVo.class);
        return drawPemVoList;
    }

    /**
     * 排序交换
     * @param type 1 上 2 下
     * @param drawGoodsId 主键ID
     */
    @Override
    public void changeGoodsSort(int type, Long drawGoodsId) {
        ActiveDrawGoods drawGoods = activeDrawGoodsMapper.selectByPrimaryKey(drawGoodsId);
        ActiveDrawGoodsExample drawGoodsExample = new ActiveDrawGoodsExample();
        ActiveDrawGoodsExample.Criteria ctx = drawGoodsExample.createCriteria();
        ctx.andPemIdEqualTo(drawGoods.getPemId());
        ctx.andTypeEqualTo(drawGoods.getType());
        drawGoodsExample.setStartIndex(0);
        drawGoodsExample.setEndIndex(1);
        if(type == 1){
            drawGoodsExample.setOrderByClause("pit_id desc");
            ctx.andPitIdLessThan(drawGoods.getPitId());
        }
        if(type == 2){
            drawGoodsExample.setOrderByClause("pit_id asc");
            ctx.andPitIdGreaterThan(drawGoods.getPitId());
        }
        List<ActiveDrawGoods> drawGoodsList = activeDrawGoodsMapper.selectByExample(drawGoodsExample);
        if(drawGoodsList.size() == 0){
            return;
        }
        ActiveDrawGoods activeDrawGoods = drawGoodsList.get(0);
        Long otherPitId = activeDrawGoods.getPitId();
        activeDrawGoods.setPitId(drawGoods.getPitId());
        drawGoods.setPitId(otherPitId);
        activeDrawGoodsMapper.updateByPrimaryKeySelective(activeDrawGoods);
        activeDrawGoodsMapper.updateByPrimaryKeySelective(drawGoods);
    }

    /**
     * 删除
     * @param drawGoodsId
     */
    @Override
    public void delDrawGoods(Long drawGoodsId) {
        if (drawGoodsId == null) {
            return;
        }
        ActiveDrawGoods activeDrawGoods = activeDrawGoodsMapper.selectByPrimaryKey(drawGoodsId);
        if(activeDrawGoods == null){
            return;
        }
        activeDrawGoods.setEnabled(true);
        activeDrawGoodsMapper.updateByPrimaryKeySelective(activeDrawGoods);
    }

    /**
     * 修改商品
     * @param id
     * @param goodsId
     */
    @Override
    public void changeDrawGoods(Long id, Long goodsId, Long pemId, String type) {
        if(id == null || goodsId == null || pemId == null){
            return;
        }
        ActiveDrawGoodsExample drawGoodsExample = new ActiveDrawGoodsExample();
        drawGoodsExample.createCriteria().andPemIdEqualTo(pemId).andTypeEqualTo(type).andPitIdEqualTo(id).andEnabledEqualTo(false);
        List<ActiveDrawGoods> drawGoodsList = activeDrawGoodsMapper.selectByExample(drawGoodsExample);
        if(drawGoodsList.size() == 0){
            ActiveDrawGoods drawGoods = new ActiveDrawGoods();
            drawGoods.setGoodsId(goodsId);
            drawGoods.setEnabled(false);
            drawGoods.setCreateTime(new Date());
            drawGoods.setModifyTime(new Date());
            drawGoods.setPemId(pemId);
            drawGoods.setType(type);
            drawGoods.setSort(id.intValue());
            drawGoods.setPitId(id);
            activeDrawGoodsMapper.insertSelective(drawGoods);
            return;
        }
        ActiveDrawGoods activeDrawGoods = drawGoodsList.get(0);
        if(goodsId != null && activeDrawGoods.getGoodsId() != null
                && goodsId.intValue() != activeDrawGoods.getGoodsId().intValue()){
            // 更换商品
            activeDrawGoods.setEnabled(true);
            activeDrawGoodsMapper.updateByPrimaryKeySelective(activeDrawGoods);

            // 新增商品
            activeDrawGoods.setId(null);
            activeDrawGoods.setEnabled(false);
            activeDrawGoods.setGoodsId(goodsId);
            activeDrawGoodsMapper.insertSelective(activeDrawGoods);
            return;
        }
        activeDrawGoods.setGoodsId(goodsId);
        activeDrawGoodsMapper.updateByPrimaryKeySelective(activeDrawGoods);
    }

    /**
     * 新增商品
     * @param activeDrawGoodsVo
     */
    @Override
    public void addDrawGoods(ActiveDrawGoodsVo activeDrawGoodsVo) {
        if(activeDrawGoodsVo == null || activeDrawGoodsVo.getGoodsId() == null
                || activeDrawGoodsVo.getPemId() == null || StringUtils.isEmpty(activeDrawGoodsVo.getType())){
            return;
        }
        ActiveDrawGoods activeDrawGoods = new ActiveDrawGoods();
        activeDrawGoods.setGoodsId(activeDrawGoodsVo.getGoodsId());
        activeDrawGoods.setEnabled(false);
        activeDrawGoods.setCreateTime(new Date());
        activeDrawGoods.setModifyTime(new Date());
        activeDrawGoods.setPemId(activeDrawGoodsVo.getPemId());
        activeDrawGoods.setType(activeDrawGoodsVo.getType());

        ActiveDrawGoodsExample drawGoodsExample = new ActiveDrawGoodsExample();
        drawGoodsExample.createCriteria().andPemIdEqualTo(activeDrawGoods.getPemId())
                .andTypeEqualTo(activeDrawGoods.getType());
        int count = activeDrawGoodsMapper.countByExample(drawGoodsExample);
        activeDrawGoods.setSort(count*10 + 10);
        activeDrawGoodsMapper.insertSelective(activeDrawGoods);
    }

    /**
     * 查询当前期次店铺
     * @param pemId
     * @return
     */
    public List<ActiveDrawShopVo> selShopList(Long pemId){
        ActiveDrawPitExample drawPitExample = new ActiveDrawPitExample();
        drawPitExample.createCriteria().andTypeEqualTo(ActiveDrawPit.TYPE_SHOP);
        drawPitExample.setOrderByClause("num asc");
        List<ActiveDrawPit> drawPitList = activeDrawPitMapper.selectByExample(drawPitExample);
        if(drawPitList.size() == 0){
            return Collections.emptyList();
        }

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
                    drawShopVo.setShopId(activeDrawShop.getShopId());
                    drawShopVo.setPemId(pemId);
                    drawShopVo.setMarketName(shiguShop.getMarketName());
                    drawShopVo.setImgSrc(activeDrawShop.getPicUrl());
                    drawShopVo.setShopNum(shiguShop.getShopNum());
                    drawShopVo.setuText(activeDrawShop.getuText());
                    drawShopVo.setdText(activeDrawShop.getdText());
                    drawShopVo.setPitId(activeDrawShop.getPitId());
                    drawShopVo.setShopId(activeDrawShop.getShopId());
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

        List<ActiveDrawShopVo> newDrawShopVoList = new ArrayList<ActiveDrawShopVo>();
        for (int i = 0; i < drawPitList.size(); i++) {
            ActiveDrawPit drawPit = drawPitList.get(i);
            Boolean panss = false;
            for (int j = 0; j < drawShopVoList.size(); j++) {
                ActiveDrawShopVo drawShopVo = drawShopVoList.get(j);
                if(drawShopVo.getPitId() != null && drawPit.getId().intValue() == drawShopVo.getPitId().intValue()){
                    drawShopVo.setNum(drawPit.getNum());
                    newDrawShopVoList.add(drawShopVo);
                    panss = true;
                    break;
                }
            }
            if(!panss){
                ActiveDrawShopVo newDrawShopVo = new ActiveDrawShopVo();
                newDrawShopVo.setPitId(drawPit.getId());
                newDrawShopVo.setNum(drawPit.getNum());
                newDrawShopVoList.add(newDrawShopVo);
            }
        }

        return newDrawShopVoList;
    }

    /**
     * 修改店铺
     * @param drawShopVo
     */
    @Override
    public void changeShop(ActiveDrawShopVo drawShopVo) {
        if(drawShopVo == null || drawShopVo.getPemId() == null || drawShopVo.getPitId() == null){
            return;
        }
        ActiveDrawShopExample drawShopExample = new ActiveDrawShopExample();
        drawShopExample.createCriteria().andPemIdEqualTo(drawShopVo.getPemId())
                .andPitIdEqualTo(drawShopVo.getPitId());
        List<ActiveDrawShop> drawShopList = activeDrawShopMapper.selectByExample(drawShopExample);
        if(drawShopList.size() == 0){
            ActiveDrawShop drawShop = new ActiveDrawShop();
            drawShop.setEnabled(false);
            drawShop.setdText(drawShopVo.getdText());
            drawShop.setuText(drawShopVo.getuText());
            drawShop.setCreateTime(new Date());
            drawShop.setModifyTime(new Date());
            drawShop.setPemId(drawShopVo.getPemId());
            drawShop.setPicUrl(drawShopVo.getImgSrc());
            drawShop.setSort(drawShopVo.getPitId().intValue());
            drawShop.setShopId(drawShopVo.getShopId());
            drawShop.setPitId(drawShopVo.getPitId());
            activeDrawShopMapper.insertSelective(drawShop);
            return;
        }
        ActiveDrawShop drawShop = drawShopList.get(0);
        if(drawShop == null){
            return;
        }
        drawShop.setShopId(drawShopVo.getShopId());
        drawShop.setPicUrl(drawShopVo.getImgSrc());
        drawShop.setuText(drawShopVo.getuText());
        drawShop.setdText(drawShopVo.getdText());
        activeDrawShopMapper.updateByPrimaryKeySelective(drawShop);
    }

    /**
     * 好店修改位置
     * @param type 1 上 2下
     * @param drawShopId
     */
    @Override
    public void changeShopSort(int type, Long drawShopId) {
        ActiveDrawShop drawShop = activeDrawShopMapper.selectByPrimaryKey(drawShopId);
        ActiveDrawShopExample drawShopExample = new ActiveDrawShopExample();
        ActiveDrawShopExample.Criteria ctx = drawShopExample.createCriteria();
        ctx.andPemIdEqualTo(drawShop.getPemId());
        drawShopExample.setStartIndex(0);
        drawShopExample.setEndIndex(1);
        if(type == 1){
            drawShopExample.setOrderByClause("pit_id desc");
            ctx.andPitIdLessThan(drawShop.getPitId());
        }
        if(type == 2){
            drawShopExample.setOrderByClause("pit_id asc");
            ctx.andPitIdGreaterThan(drawShop.getPitId());
        }
        List<ActiveDrawShop> drawShopList = activeDrawShopMapper.selectByExample(drawShopExample);
        if(drawShopList.size() == 0){
            return;
        }
        ActiveDrawShop activeDrawShop = drawShopList.get(0);
        Long otherPitId = activeDrawShop.getPitId();
        activeDrawShop.setPitId(drawShop.getPitId());
        drawShop.setPitId(otherPitId);
        activeDrawShopMapper.updateByPrimaryKeySelective(drawShop);
        activeDrawShopMapper.updateByPrimaryKeySelective(activeDrawShop);
    }

    /**
     * 新增好店
     * @param drawShopVo
     */
    @Override
    public void addDrawShop(ActiveDrawShopVo drawShopVo) {
        if(drawShopVo == null || drawShopVo.getPemId() == null || StringUtils.isEmpty(drawShopVo.getImgSrc())
                || StringUtils.isEmpty(drawShopVo.getuText()) || StringUtils.isEmpty(drawShopVo.getdText())){
            return;
        }
        ActiveDrawShop drawShop = new ActiveDrawShop();
        drawShop.setEnabled(false);
        drawShop.setdText(drawShopVo.getdText());
        drawShop.setuText(drawShopVo.getuText());
        drawShop.setCreateTime(new Date());
        drawShop.setModifyTime(new Date());
        drawShop.setPemId(drawShopVo.getPemId());
        drawShop.setPicUrl(drawShopVo.getImgSrc());

        ActiveDrawShopExample drawShopExample = new ActiveDrawShopExample();
        drawShopExample.createCriteria().andPemIdEqualTo(drawShopVo.getPemId()).andEnabledEqualTo(false);
        int count = activeDrawShopMapper.countByExample(drawShopExample);
        drawShop.setSort(count*10 + 10);
        activeDrawShopMapper.insertSelective(drawShop);
    }

    /**
     * 新增新的期次
     * @param
     */
    @Override
    public void addNewDrawPem(Date nextDrawPemTime) {
        if(nextDrawPemTime == null)nextDrawPemTime = new Date();
        ActiveDrawPem drawPem = new ActiveDrawPem();
        drawPem.setStartTime(nextDrawPemTime);
        drawPem.setCreateTime(new Date());
        activeDrawPemMapper.insertSelective(drawPem);
    }

    /**
     * 查询满足抽奖用户数据
     * @param pemId
     * @param ward
     * @return
     */
    @Override
    public ShiguPager<ActiveDrawRecordUserVo> selComDrawUserRecord(Long pemId, String ward, int pageNum, int pageSize) {
        ShiguPager<ActiveDrawRecordUserVo> drawRecordUserVoShiguPager = new ShiguPager<ActiveDrawRecordUserVo>();
        if(pemId == null || StringUtils.isEmpty(ward)){
            return drawRecordUserVoShiguPager;
        }
        int drawRecordCount = activeDrawRecordMapper.selDrawRecordCount(pemId, null,ward);
        int totalPages = drawRecordCount / pageSize + ((drawRecordCount % pageSize == 0) ? 0 : 1);
        if(pageNum > totalPages){
            return drawRecordUserVoShiguPager;
        }
        drawRecordUserVoShiguPager.setNumber(pageNum);
        drawRecordUserVoShiguPager.calPages(drawRecordCount,pageSize);
        List<ActiveDrawRecordUserVo> drawRecordUserVos = new ArrayList<ActiveDrawRecordUserVo>();
        String typeGoods = null;
        if(ward.indexOf("A") != -1){
            typeGoods = ActiveDrawGoods.TYPE_FAGOODS;
        }
        if(ward.indexOf("B") != -1){
            typeGoods = ActiveDrawGoods.TYPE_DAILYFIND;
        }
        int startRows = (pageNum-1)*pageSize;
        int endRows = pageNum*pageSize;
        List<ActiveDrawRecord> drawRecordList = activeDrawRecordMapper.selDrawRecordList(pemId, null, null, ward, startRows, endRows);
        // 查询发现好货活动的数据
        List<ActiveDrawRecordUserVo>  drawRecordUserVoList = poUserGoodsUp(pemId, typeGoods, drawRecordList);
        Map<Long, ActiveDrawRecordUserVo> recordUserVoMap = BeanMapper.list2Map(drawRecordUserVoList, "userId", Long.class);
        for (int i = 0; i < drawRecordList.size(); i++) {
            ActiveDrawRecordUserVo drawRecordUserVo = recordUserVoMap.get(drawRecordList.get(i).getUserId());
            drawRecordUserVos.add(drawRecordUserVo);
        }
        drawRecordUserVoShiguPager.setContent(drawRecordUserVos);
        return drawRecordUserVoShiguPager;
    }

    /**
     * 聚合用户数据
     * @param pemId
     * @param drawRecordList
     * @return
     */
    public List<ActiveDrawRecordUserVo> poUserGoodsUp(Long pemId, String type,List<ActiveDrawRecord> drawRecordList){
        List<ActiveDrawRecordUserVo> drawRecordUserVos = new ArrayList<ActiveDrawRecordUserVo>();
        // 查询发现好货活动的数据
        ActiveDrawGoodsExample drawGoodsExample = new ActiveDrawGoodsExample();
        ActiveDrawGoodsExample.Criteria ctx = drawGoodsExample.createCriteria();
        ctx.andPemIdEqualTo(pemId).andTypeEqualTo(type);
        List<ActiveDrawGoods> drawGoodsList = activeDrawGoodsMapper.selectByExample(drawGoodsExample);
        List userIdList = BeanMapper.getFieldList(drawRecordList, "userId", List.class);
        List goodsList = BeanMapper.getFieldList(drawGoodsList, "goodsId", List.class);
        // 发现好货
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        QueryBuilder userQuery = QueryBuilders.termsQuery("fenUserId", userIdList);
        QueryBuilder goodsIdQuery = QueryBuilders.termsQuery("supperGoodsId", goodsList);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(userQuery);
        boolQueryBuilder.must(goodsIdQuery);
        srb.setQuery(boolQueryBuilder);
        srb.addAggregation(AggregationBuilders.terms("fenUserIdAgg").field("fenUserId").size(1000));
        SearchResponse response = srb.execute().actionGet();
        LongTerms supperGoodsIdAgg = response.getAggregations().get("fenUserIdAgg");
        for (Terms.Bucket bucket : supperGoodsIdAgg.getBuckets()) {
            Long userId = (Long)bucket.getKeyAsNumber();
            Long count = bucket.getDocCount();
            for(ActiveDrawRecord drawRecord : drawRecordList){
                if(drawRecord.getUserId().intValue() == userId.intValue()){
                    ActiveDrawRecordUserVo drawRecordUserVo = new ActiveDrawRecordUserVo();
                    drawRecordUserVo.setId(drawRecord.getId());
                    drawRecordUserVo.setUserId(userId);
                    drawRecordUserVo.setUserNick(drawRecord.getUserNick());
                    drawRecordUserVo.setDrawStatus(drawRecord.getDrawStatus());
                    drawRecordUserVo.setUploadNum(count.intValue());
                    drawRecordUserVo.setPemId(pemId);
                    drawRecordUserVo.setWard(drawRecord.getWard());
                    drawRecordUserVo.setConcatPhone(drawRecord.getLoginPhone());
                    drawRecordUserVo.setCreateTime(drawRecord.getCreateTime());
                    drawRecordUserVo.setRefeTime(drawRecord.getRefeTime());
                    drawRecordUserVos.add(drawRecordUserVo);
                }
            }

        }
        return drawRecordUserVos;
    }

    /**
     * 期次中奖人数
     * @param pemId
     * @param ward
     * @return
     */
    @Override
    public int selWardDrawYes(Long pemId, String ward) {
        ActiveDrawRecordExample drawRecordExample = new ActiveDrawRecordExample();
        drawRecordExample.createCriteria().andPemIdEqualTo(pemId).andWardEqualTo(ward).andReceivesYesEqualTo(true);
        int count = activeDrawRecordMapper.countByExample(drawRecordExample);
        return count;
    }

    /**
     * 选择用户中奖
     * @param recordId
     */
    @Override
    public void chooseDrawWard(Long recordId) {
        ActiveDrawRecord drawRecord = activeDrawRecordMapper.selectByPrimaryKey(recordId);
        if(drawRecord == null){
            return;
        }
        drawRecord.setReceivesYes(false);
        drawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_YES);
        drawRecord.setDrawCode(StringUtil.str10To37Str());
        activeDrawRecordMapper.updateByPrimaryKeySelective(drawRecord);
    }

    /**
     * 查询中奖
     * @param pemId
     * @return
     */
    public List<ActiveDrawRecordUserVo> selDrawRecordList(Long pemId,Long userId, String type){
        List<ActiveDrawRecord> drawRecordList = activeDrawRecordMapper.selDrawRecordList(pemId, userId, type, null,null,null);
        if(userId != null){
            // 过滤过期

        }
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
        QueryBuilder startQuery = QueryBuilders.rangeQuery("daiTime");

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
        drawGoodsExample.createCriteria().andPemIdEqualTo(activeDrawPem.getId()).andTypeEqualTo(ActiveDrawGoods.TYPE_FAGOODS);
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
        if(total >= 8){
            activeDrawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_WAIT);
            activeDrawRecord.setId(null);
            activeDrawRecord.setWard("A3");
            addActiveDrawRecord(activeDrawRecord);
        }
        if(total >= 10){
            activeDrawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_WAIT);
            activeDrawRecord.setId(null);
            activeDrawRecord.setWard("A4");
            addActiveDrawRecord(activeDrawRecord);
        }

        // 查询每日发现
        ActiveDrawGoodsExample drawDaliyGoodsExample = new ActiveDrawGoodsExample();
        drawDaliyGoodsExample.createCriteria().andPemIdEqualTo(activeDrawPem.getId()).andTypeEqualTo(ActiveDrawGoods.TYPE_DAILYFIND);
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
     * 新增用户抽奖
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

    /**
     * 查询抽奖信息
     * @param drawCode
     * @return
     */
    public ActiveDrawRecordUserVo selUserDrawList(String drawCode) throws Main4Exception {
        ActiveDrawRecord activeDrawRecord = new ActiveDrawRecord();
        activeDrawRecord.setDrawCode(drawCode);
        activeDrawRecord = activeDrawRecordMapper.selectOne(activeDrawRecord);
        if(activeDrawRecord == null){
            throw new Main4Exception("提货码错误");
        }
        if(activeDrawRecord.getDrawStatus() != 3){
            throw new Main4Exception("未中奖");
        }
        if(activeDrawRecord.getReceivesYes()){
            throw new Main4Exception("已经领取，不能重复领取");
        }
        // 本期
        ActiveDrawPemVo drawPemVo = selNowDrawPem(null);
        if(drawPemVo == null){
            throw new Main4Exception("数据有误，活动从未开始");
        }

        ActiveDrawRecordUserVo drawRecordUserVo = BeanMapper.map(activeDrawRecord, ActiveDrawRecordUserVo.class);

        // 查询本期
        if(drawPemVo.getId().intValue() == activeDrawRecord.getPemId().intValue()){
            return drawRecordUserVo;
        }

        drawPemVo = selNowDrawPem(drawPemVo.getStartTime());
        // 查询上一期
        if(drawPemVo == null){
            throw new Main4Exception("数据有误");
        }

        if(drawPemVo.getId().intValue() == activeDrawRecord.getPemId().intValue()){
            return drawRecordUserVo;
        }

        int xcday = DateUtil.daysOfTwo(drawPemVo.getStartTime(), new Date());
        if(xcday > 7){
            throw new Main4Exception("已过期，无法领取");
        }

        return drawRecordUserVo;
    }

    /**
     * 领取用户奖品
     * @param tqcode
     * @param userId
     */
    public void receUserWard(String tqcode, Long userId) throws Main4Exception {
        if(StringUtils.isEmpty(tqcode) || userId == null){
            throw new Main4Exception("请求数据有误");
        }
        ActiveDrawRecord drawRecord = new ActiveDrawRecord();
        drawRecord.setDrawCode(tqcode);
        drawRecord.setUserId(userId);
        drawRecord = activeDrawRecordMapper.selectOne(drawRecord);
        if(drawRecord == null){
            throw new Main4Exception("请求数据有误");
        }
        if(drawRecord.getReceivesYes()){
            throw new Main4Exception("已经领取，无法重复领取！");
        }
        drawRecord.setReceivesYes(true);
        int result = activeDrawRecordMapper.updateByPrimaryKeySelective(drawRecord);
        if(result == 0){
            throw new Main4Exception("领取发生错误");
        }
    }

    /**
     * 查询本期店铺IDS
     * @return
     */
    @Override
    public List<Long> findDrawShopIds() {
        // 当前本期
        ActiveDrawPemVo activeDrawPemVo = selNowDrawPem(null);
        if(activeDrawPemVo == null){return null;}
        ActiveDrawShopExample shopExample = new ActiveDrawShopExample();
        shopExample.createCriteria().andPemIdEqualTo(activeDrawPemVo.getId());
        shopExample.setOrderByClause("sort asc");
        List<ActiveDrawShop> activeDrawShops = activeDrawShopMapper.selectFieldsByExample(shopExample,FieldUtil.codeFields("id,shop_id"));
        List shopIdsList = BeanMapper.getFieldList(activeDrawShops, "shopId", List.class);
        return shopIdsList;
    }

    /**
     * 修改查阅时间
     * @param recordId
     */
    @Override
    public void changeRefeTime(Long recordId) {
        if(recordId == null){
            return;
        }
        ActiveDrawRecord drawRecord = activeDrawRecordMapper.selectByPrimaryKey(recordId);
        if(drawRecord == null){
            return;
        }
        drawRecord.setRefeTime(new Date());
        activeDrawRecordMapper.updateByPrimaryKeySelective(drawRecord);
    }
}
