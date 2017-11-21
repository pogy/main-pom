package com.shigu.main4.spread.service.impl;


import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.opentae.data.mall.beans.ActiveDrawPem;
import com.opentae.data.mall.beans.ActiveDrawPit;
import com.opentae.data.mall.beans.ActiveDrawRecord;
import com.opentae.data.mall.beans.ActiveDrawShop;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.examples.ActiveDrawGoodsExample;
import com.opentae.data.mall.examples.ActiveDrawPemExample;
import com.opentae.data.mall.examples.ActiveDrawPitExample;
import com.opentae.data.mall.examples.ActiveDrawRecordExample;
import com.opentae.data.mall.examples.ActiveDrawShopExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.ShiguTempExample;
import com.opentae.data.mall.interfaces.ActiveDrawGoodsMapper;
import com.opentae.data.mall.interfaces.ActiveDrawPemMapper;
import com.opentae.data.mall.interfaces.ActiveDrawPitMapper;
import com.opentae.data.mall.interfaces.ActiveDrawRecordMapper;
import com.opentae.data.mall.interfaces.ActiveDrawShopMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.spread.bo.ActiveDrawRecordBO;
import com.shigu.main4.spread.service.ActiveDrawService;
import com.shigu.main4.spread.service.ActiveShowService;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawGoodsVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawRecordUserVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawShopVo;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
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

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguTempMapper shiguTempMapper;

    @Autowired
    private ActiveShowService activeShowService;

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
    public List<ActiveDrawGoodsVo> selGoodsList(Long pemId, String type, int size, Boolean enabled,boolean back){

        // 取当前坑位
        ActiveDrawPitExample drawPitExample = new ActiveDrawPitExample();
        drawPitExample.createCriteria().andTypeEqualTo(ActiveDrawPit.TYPE_GOODS);
        drawPitExample.setOrderByClause("num asc");
        List<ActiveDrawPit> drawPitList = activeDrawPitMapper.selectByExample(drawPitExample);
        if(drawPitList.size() == 0 && StringUtils.equals(ActiveDrawGoods.TYPE_FAGOODS,type)){
            return Collections.emptyList();
        }

        // 当前期坑位数据
        ActiveDrawGoodsExample drawGoodsExample = new ActiveDrawGoodsExample();
        ActiveDrawGoodsExample.Criteria ctx = drawGoodsExample.createCriteria();
        ctx.andPemIdEqualTo(pemId).andTypeEqualTo(type);
        drawGoodsExample.setOrderByClause("sort asc");
        if(enabled != null){
            ctx.andEnabledEqualTo(enabled);
        }
        List<ActiveDrawGoods> drawGoodsList = activeDrawGoodsMapper.selectByExample(drawGoodsExample);

        List<ActiveDrawGoodsVo> drawGoodsVoList = new ArrayList<>();// 页面VO容器
        if (!drawGoodsList.isEmpty()) {
            List<Long> goodsList = BeanMapper.getFieldList(drawGoodsList, "goodsId", Long.class);
            ShiguGoodsTinyExample goodsTinyExample = new ShiguGoodsTinyExample();
            ShiguGoodsTinyExample.Criteria criteria = goodsTinyExample.createCriteria();
            criteria.andGoodsIdIn(goodsList);
            goodsTinyExample.setWebSite("hz");

            // 特殊要求：发现好货不用区分是否下架，该处为广告位
            if (!StringUtils.equals(ActiveDrawGoods.TYPE_FAGOODS, type)) {
                criteria.andIsClosedEqualTo(0L);
            }
            // 制作商品数据
            List<ShiguGoodsTiny> goodsTinyList = shiguGoodsTinyMapper.selectByExample(goodsTinyExample);
            Map<Long, ShiguGoodsTiny> goodsTinyMap = BeanMapper.list2Map(goodsTinyList, "goodsId", Long.class);

            // 制作店铺数据
            List<Long> shopIds = BeanMapper.getFieldList(goodsTinyList, "storeId", Long.class);
            Map<Long, ShiguShop> shopMap;
            if(shopIds.size()>0) {
                ShiguShopExample shopExample = new ShiguShopExample();
                shopExample.createCriteria().andShopIdIn(shopIds);
                shopMap =
                        BeanMapper.list2Map(
                                shiguShopMapper.selectFieldsByExample(
                                        shopExample, FieldUtil.codeFields("shop_id,shop_num")),
                                "shopId",
                                Long.class
                        );
            }else {
                shopMap=new HashMap<>();
            }
            // 制作市场数据
            List<Long> parentMarketIdList = BeanMapper.getFieldList(goodsTinyList, "parentMarketId", Long.class);
            Map<Long, ShiguMarket> marketMap;
            if(parentMarketIdList.size()>0) {
                ShiguMarketExample marketExample = new ShiguMarketExample();
                marketExample.createCriteria().andMarketIdIn(parentMarketIdList);
                marketMap =
                        BeanMapper.list2Map(
                                shiguMarketMapper.selectFieldsByExample(
                                        marketExample, FieldUtil.codeFields("market_id,market_name")),
                                "marketId",
                                Long.class
                        );
            }else {
                marketMap=new HashMap<>();
            }
            // 组装页面VO
            for(ActiveDrawGoods drawGoods : drawGoodsList){
                ShiguGoodsTiny shiguGoodsTiny = goodsTinyMap.get(drawGoods.getGoodsId());
                if(shiguGoodsTiny == null) {
                    continue;
                }

                ActiveDrawGoodsVo activeDrawGoodsVo = new ActiveDrawGoodsVo();
                activeDrawGoodsVo.setGoodsId(shiguGoodsTiny.getGoodsId());
                activeDrawGoodsVo.setImgSrc(shiguGoodsTiny.getPicUrl());
                activeDrawGoodsVo.setMarketName(shiguGoodsTiny.getParentMarketName());
                activeDrawGoodsVo.setShopNum(shiguGoodsTiny.getStoreNum());
                activeDrawGoodsVo.setPemId(pemId);
                activeDrawGoodsVo.setIsOff(shiguGoodsTiny.getIsClosed());

                activeDrawGoodsVo.setPiPriceString(String.format("%.2f",shiguGoodsTiny.getPiPrice() * .01));
                activeDrawGoodsVo.setTitle(shiguGoodsTiny.getTitle());
                activeDrawGoodsVo.setShopId(shiguGoodsTiny.getStoreId());
                ShiguMarket shiguMarket = marketMap.get(shiguGoodsTiny.getParentMarketId());
                if(shiguMarket != null){
                    activeDrawGoodsVo.setMarketName(shiguMarket.getMarketName());
                }
                ShiguShop shiguShop = shopMap.get(activeDrawGoodsVo.getShopId());
                if(shiguShop != null){
                    activeDrawGoodsVo.setShopNum(shiguShop.getShopNum());
                }
                activeDrawGoodsVo.setId(drawGoods.getId());
                activeDrawGoodsVo.setPitId(drawGoods.getPitId());
                drawGoodsVoList.add(activeDrawGoodsVo);
            }
        }

        // 每日发现不需要额外的期次 NUM信息
        if(ActiveDrawGoods.TYPE_DAILYFIND.equals(type)){
            return drawGoodsVoList;
        }

        List<ActiveDrawGoodsVo> newDrawGoodsVoList = new ArrayList<>();
        Map<Long, ActiveDrawGoodsVo> drawGoodsVoMap = BeanMapper.list2Map(drawGoodsVoList, "pitId", Long.class);
        for (ActiveDrawPit drawPit : drawPitList) {
            ActiveDrawGoodsVo activeDrawGoodsVo = drawGoodsVoMap.get(drawPit.getId());
            if (activeDrawGoodsVo != null) {
                activeDrawGoodsVo.setNum(drawPit.getNum());
                newDrawGoodsVoList.add(activeDrawGoodsVo);
            }else if(back){
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
        return BeanMapper.mapList(activeDrawPemList, ActiveDrawPemVo.class);
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
            //把本商品在本期的删除
            drawGoodsExample.clear();
            drawGoodsExample.createCriteria().andPemIdEqualTo(pemId).andGoodsIdEqualTo(goodsId).andTypeEqualTo(type).andEnabledEqualTo(true);
            activeDrawGoodsMapper.deleteByExample(drawGoodsExample);

            activeDrawGoodsMapper.insertSelective(drawGoods);
            return;
        }
        ActiveDrawGoods activeDrawGoods = drawGoodsList.get(0);
        if(activeDrawGoods.getGoodsId() != null
                && goodsId.intValue() != activeDrawGoods.getGoodsId().intValue()){
            // 更换商品
            activeDrawGoods.setEnabled(true);
            activeDrawGoods.setModifyTime(new Date());
            activeDrawGoodsMapper.updateByPrimaryKeySelective(activeDrawGoods);

            //把本商品在本期的删除
            drawGoodsExample.clear();
            drawGoodsExample.createCriteria().andGoodsIdEqualTo(goodsId).andPemIdEqualTo(pemId).andTypeEqualTo(type).andEnabledEqualTo(true);
            activeDrawGoodsMapper.deleteByExample(drawGoodsExample);

            // 新增商品
            activeDrawGoods.setId(null);
            activeDrawGoods.setCreateTime(new Date());
            activeDrawGoods.setModifyTime(new Date());
            activeDrawGoods.setEnabled(false);
            activeDrawGoods.setGoodsId(goodsId);
            activeDrawGoodsMapper.insertSelective(activeDrawGoods);
//            return;
        }
//        activeDrawGoods.setGoodsId(goodsId);
//        activeDrawGoodsMapper.updateByPrimaryKeySelective(activeDrawGoods);
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
     * @param back
     * @return
     */
    public List<ActiveDrawShopVo> selShopList(Long pemId, boolean back){
        ActiveDrawPitExample drawPitExample = new ActiveDrawPitExample();
        drawPitExample.createCriteria().andTypeEqualTo(ActiveDrawPit.TYPE_SHOP);
        drawPitExample.setOrderByClause("num asc");
        List<ActiveDrawPit> drawPitList = activeDrawPitMapper.selectByExample(drawPitExample);
        Map<Long, ActiveDrawShopVo> drawShopVoMap = Collections.emptyMap();
        if(!drawPitList.isEmpty()) {
            ActiveDrawShopExample drawShopExample = new ActiveDrawShopExample();
            drawShopExample.createCriteria().andPemIdEqualTo(pemId);
            List<ActiveDrawShop> drawShopList = activeDrawShopMapper.selectByExample(drawShopExample);

            List<ActiveDrawShopVo> drawShopVoList = new ArrayList<>();
            if (!drawShopList.isEmpty()) {
                List<Long> shopIdsList = BeanMapper.getFieldList(drawShopList, "shopId", Long.class);
                ShiguShopExample shopExample=new ShiguShopExample();
                shopExample.createCriteria().andShopIdIn(shopIdsList);
                List<ShiguShop> shops=shiguShopMapper.selectByExample(shopExample);
                if (shopIdsList.size() > 0) {
                    Map<Long, ActiveDrawShop> drawShopMap = BeanMapper.list2Map(drawShopList, "shopId", Long.class);
                    for (ShiguShop shiguShop : shops) {
                        ActiveDrawShop activeDrawShop = drawShopMap.get(shiguShop.getShopId());
                        if (activeDrawShop != null) {
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
                            if (StringUtils.isEmpty(drawShopVo.getMarketName())) {
                                ShiguMarket shiguMarket = shiguMarketMapper.selectFieldsByPrimaryKey(shiguShop.getMarketId(),
                                        FieldUtil.codeFields("market_id,market_name"));
                                if (shiguMarket != null) {
                                    drawShopVo.setMarketName(shiguMarket.getMarketName());
                                }
                            }
                            drawShopVoList.add(drawShopVo);
                        }
                    }
                    drawShopVoMap = BeanMapper.list2Map(drawShopVoList, "pitId", Long.class);
                }
            }
        }
        List<ActiveDrawShopVo> newDrawShopVoList = new ArrayList<>();
        for (ActiveDrawPit drawPit : drawPitList) {
            ActiveDrawShopVo activeDrawShopVo = drawShopVoMap.get(drawPit.getId());
            if (activeDrawShopVo != null) {
                activeDrawShopVo.setNum(drawPit.getNum());
                newDrawShopVoList.add(activeDrawShopVo);
            } else if (back) { // 如果是后台，坑位没数据也要显示在页面上
                ActiveDrawShopVo vo = new ActiveDrawShopVo();
                vo.setPemId(pemId);
                vo.setPitId(drawPit.getId());
                vo.setNum(drawPit.getNum());
                newDrawShopVoList.add(vo);
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
        drawPem.setTerm(activeDrawPemMapper.countByExample(new ActiveDrawPemExample())+1);
        activeDrawPemMapper.insertSelective(drawPem);
    }

    /**
     * 查询满足抽奖用户数据
     * @param pemId
     * @param ward
     * @return
     */
    @Override
    public ShiguPager<ActiveDrawRecordUserVo> selComDrawUserRecord(Long pemId, String ward,Long userId,String userNick, int pageNum, int pageSize) {
        ShiguPager<ActiveDrawRecordUserVo> drawRecordUserVoShiguPager = new ShiguPager<ActiveDrawRecordUserVo>();
        if(pemId == null || StringUtils.isEmpty(ward)){
            return drawRecordUserVoShiguPager;
        }
        int drawRecordCount = activeDrawRecordMapper.selDrawRecordCount(pemId, userId,ward,userNick);
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
        List<ActiveDrawRecord> drawRecordList = activeDrawRecordMapper.selDrawRecordList(pemId, userId, null, ward,userNick, startRows, pageSize);
        // 查询发现好货活动的数据
        List<ActiveDrawRecordUserVo>  drawRecordUserVoList = poUserGoodsUp(pemId, typeGoods, drawRecordList);
        Map<Long, ActiveDrawRecordUserVo> recordUserVoMap = BeanMapper.list2Map(drawRecordUserVoList, "userId", Long.class);
        for (int i = 0; i < drawRecordList.size(); i++) {
            ActiveDrawRecordUserVo drawRecordUserVo = recordUserVoMap.get(drawRecordList.get(i).getUserId());
            if(drawRecordUserVo == null){
                drawRecordUserVo = BeanMapper.map(drawRecordList.get(i), ActiveDrawRecordUserVo.class);
                drawRecordUserVo.setConcatPhone(drawRecordList.get(i).getLoginPhone());
            }
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
        ActiveDrawRecordExample activeDrawRecordExample = new ActiveDrawRecordExample();
        activeDrawRecordExample.createCriteria().andPemIdEqualTo(pemId).andUserIdEqualTo(userId);
        List<ActiveDrawRecord> drawRecordList = activeDrawRecordMapper.selectByExample(activeDrawRecordExample);
        //List<ActiveDrawRecord> drawRecordList = activeDrawRecordMapper.selDrawRecordList(pemId, userId, type, null,null,null,null);
        if(userId != null){
            // 过滤过期

        }
        List<ActiveDrawRecordUserVo> activeDrawRecordUserVos = BeanMapper.mapList(drawRecordList, ActiveDrawRecordUserVo.class);
        return activeDrawRecordUserVos;
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
        int total = supperGoodsIdAgg.getBuckets().size();
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
        return selDrawRecordList(activeDrawPem.getId(), userId, null);
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
            checkTime(drawPemVo.getStartTime());//本期也要验证一下，时间是否超限
            return drawRecordUserVo;
        }

        drawPemVo = selNowDrawPem(drawPemVo.getStartTime());
        // 查询上一期
        if(drawPemVo == null){
            throw new Main4Exception("数据有误");
        }
        checkTime(drawPemVo.getStartTime());
        if(drawPemVo.getId().intValue() == activeDrawRecord.getPemId().intValue()){
            return drawRecordUserVo;
        }
        return drawRecordUserVo;
    }

    /**
     * 验证时间是否超限
     */
    public void checkTime(Date time) throws Main4Exception {
        int xcday = DateUtil.daysOfTwo(time, new Date());
        if(xcday > 14){
            throw new Main4Exception("已过期，无法领取");
        }
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
        //处理此人本期,所有奖的阅
        ActiveDrawRecordExample example=new ActiveDrawRecordExample();
        example.createCriteria().andPemIdEqualTo(drawRecord.getPemId()).andUserIdEqualTo(drawRecord.getUserId());

        ActiveDrawRecord record=new ActiveDrawRecord();
        record.setRefeTime(new Date());
        activeDrawRecordMapper.updateByExampleSelective(record,example);
    }

    @Override
    public Map<Long,Long> newNumIids(String nick, List<Long> goodsId, Date fromTime, Date endTime) {
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        QueryBuilder userQuery = QueryBuilders.termQuery("fenUserNick", nick);
        QueryBuilder goodsIdQuery = QueryBuilders.termsQuery("supperGoodsId", goodsId);
        QueryBuilder timeQuery = QueryBuilders.rangeQuery("daiTime").gt(DateUtil.dateToString(fromTime,"yyyy-MM-dd HH:mm:ss"))
                .lt(DateUtil.dateToString(endTime,"yyyy-MM-dd HH:mm:ss"));

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(userQuery);
        boolQuery.must(goodsIdQuery);
        boolQuery.must(timeQuery);
        srb.setQuery(boolQuery);
        srb.setFrom(0).setSize(100);

        System.out.println(srb);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits=response.getHits().getHits();
        Map<Long,Long> numIidMaps=new HashMap<>();
        for(SearchHit hit:hits){
            Long fenNumIid = (Long) hit.getSource().get("fenNumiid");
            Integer supperGoodsId = (Integer) hit.getSource().get("supperGoodsId");
            if (fenNumIid != null) {
                numIidMaps.put(supperGoodsId.longValue(),fenNumIid);
            }
        }
        return numIidMaps;
    }

    @Override
    public void addActiveDrawRecord(ActiveDrawRecordBO activeDrawRecord) {
        if(activeDrawRecord == null || activeDrawRecord.getPemId() == null ||
                activeDrawRecord.getUserId() == null || StringUtils.isEmpty(activeDrawRecord.getWard())){
            return;
        }
        ActiveDrawRecord drawRecord = new ActiveDrawRecord();
        drawRecord.setPemId(activeDrawRecord.getPemId());
        drawRecord.setUserId(activeDrawRecord.getUserId());
        drawRecord.setEnabled(false);
        drawRecord.setReceivesYes(false);
        drawRecord.setCreateTime(new Date());
        drawRecord.setModifyTime(new Date());
        drawRecord.setWard(activeDrawRecord.getWard());
        int count = activeDrawRecordMapper.selectCount(drawRecord);
        if(count > 0){
            // 已经新增数据
            return;
        }
        activeDrawRecordMapper.insertSelective(drawRecord);
    }

    @Override
    public String shiguTempSigup(String flag, Long userId, Long shopId) {
        if (userId==null||shopId==null){
            return "您还没有店铺";
        }
        ShiguTempExample shiguTempExample =new ShiguTempExample();
        shiguTempExample.createCriteria().andKey1EqualTo(userId.toString()).andKey2EqualTo(shopId.toString()).andFlagEqualTo(flag);
        List<ShiguTemp> temps = shiguTempMapper.selectByExample(shiguTempExample);
        if (temps.size()>0){
            return "您已经报过名了";
        }
        ShiguTemp shiguTemp=new ShiguTemp();
        shiguTemp.setFlag(flag);
        shiguTemp.setKey1(userId.toString());
        shiguTemp.setKey2(shopId.toString());
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        shiguTemp.setKey3(dateFormat.format(new Date()));
        shiguTempMapper.insertSelective(shiguTemp);
        return "true";
    }


    @Override
    public void receUserWard(String tqcode) throws Main4Exception {
        ActiveDrawRecord activeDrawRecord = new ActiveDrawRecord();
        activeDrawRecord.setDrawCode(tqcode);
        activeDrawRecord = activeDrawRecordMapper.selectOne(activeDrawRecord);
        if (activeDrawRecord == null) {
            throw new Main4Exception("错误的领取码");
        }
        if (activeDrawRecord.getReceivesYes()) {
            throw new Main4Exception("已使用过的领取码");
        }
        ActiveDrawPem activeDrawPem = activeDrawPemMapper.selectByPrimaryKey(activeDrawRecord.getPemId());
        checkValidity(activeDrawPem.getEndTime());
        activeDrawRecord.setReceivesYes(true);
        int result = activeDrawRecordMapper.updateByPrimaryKeySelective(activeDrawRecord);
        if(result == 0){
            throw new Main4Exception("领取发生错误");
        }
    }

    /**
     * 检验领取码是否过期
     * @param date 活动截止日期
     * @throws Main4Exception
     */
    public void checkValidity(Date date) throws Main4Exception {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,-7);
        Date verifiedTime = instance.getTime();
        if (date.before(verifiedTime)) {
            throw new Main4Exception("领取码以过期");
        }
    }
}
