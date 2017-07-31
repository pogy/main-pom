package com.shigu.main4.storeservices.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ESGoods;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguDomainRetainExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguDomainRetainMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.exceptions.ShopDomainException;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopRegistService;
import com.shigu.main4.storeservices.ShopToEsService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.DmlReason;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.ShopInES;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.chainsaw.Main;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 店铺基本操作
 *
 * @author shigu_zjb
 * @date 2017/02/25 16:25
 *
 */
@Service("shopBaseService")
public class ShopBaseServiceImpl extends ShopServiceImpl implements ShopBaseService{

    private static final Logger logger = LoggerFactory.getLogger(ShopBaseServiceImpl.class);

    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;

    @Resource(name = "tae_mall_shiguDomainRetainMapper")
    private ShiguDomainRetainMapper shiguDomainRetainMapper;

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShopRegistService shopRegistService;

    @Resource(name = "tae_mall_shiguMarketMapper")
    private ShiguMarketMapper shiguMarketMapper;

//    @Resource(name = "userBaseService")
//    private UserBaseService userBaseService;

    @Autowired
    ShopToEsService shopToEsService;


    /**
     * 更新店铺二级域名
     * @param shopId
     * @param domain
     * @throws ShopDomainException
     */
    @Override
    public void updateDomain(Long shopId, String domain) throws ShopDomainException {
        // 数据无效验证
        if (shopId == null || StringUtils.isEmpty(domain)) {
            throw new ShopDomainException(ShopDomainException.ShopDomainExceptionErrorCode.DATA_IS_ERROR.getCode(),
                    ShopDomainException.ShopDomainExceptionErrorCode.DATA_IS_ERROR.getMessage());
        }
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        if(shiguShop == null){
            throw new ShopDomainException(ShopDomainException.ShopDomainExceptionErrorCode.DATA_IS_ERROR.getCode(),
                    ShopDomainException.ShopDomainExceptionErrorCode.DATA_IS_ERROR.getMessage());
        }
        // 二级域名长度验证 不能大于4
        if(domain.length() <= 4 && !StringUtils.equals(domain.toLowerCase(), shiguShop.getShopNum().toLowerCase())){
            throw new ShopDomainException(ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_NUM4_REPEAT.getCode(),
                    ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_NUM4_REPEAT.getMessage());
        }
        // 二级域名与其他域名重复校验
        Long shopdataId = shiguShopMapper.selectDoaminRepeatById(domain,shopId,null);
        if (shopdataId != null
                && shopdataId.intValue() != shopId.intValue()) {
            throw new ShopDomainException(ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_REPEAT.getCode(),
                    ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_REPEAT.getMessage());
        }
        // 二级域名与档口号重复校验
        shopdataId = shiguShopMapper.selectDoaminRepeatById(null,null,domain);
        if (shopdataId != null
                && shopdataId.intValue() != shopId.intValue()) {
            if(!StringUtils.equals(shiguShop.getShopNum(), domain)){
                throw new ShopDomainException(ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_SHOPNUM_REPEAT.getCode(),
                        ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_SHOPNUM_REPEAT.getMessage());
            }
        }
        // 二级域名与系统保留区域重复校验
        ShiguDomainRetainExample shiguDomainRetainExample = new ShiguDomainRetainExample();
        shiguDomainRetainExample.createCriteria().andDomainEqualTo(domain.toLowerCase());
        int result = shiguDomainRetainMapper.countByExample(shiguDomainRetainExample);
        if(result != 0){
            throw new ShopDomainException(ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_SYSTEM_REPEAT.getCode(),
                    ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_SYSTEM_REPEAT.getMessage());
        }
        // 验证通过更新域名
        ShiguShop shiguShopUpdate = new ShiguShop();
        shiguShopUpdate.setShopId(shopId);
        shiguShopUpdate.setDomain(domain);
        result = shiguShopMapper.updateByPrimaryKeySelective(shiguShopUpdate);
        shopToEsService.addToEs(shiguShop.getShopId());
        if(result == 0){
            throw new ShopDomainException(ShopDomainException.ShopDomainExceptionErrorCode.DATA_IS_ERROR.getCode(),
                    ShopDomainException.ShopDomainExceptionErrorCode.DATA_IS_ERROR.getMessage());
        }
        Cache domainByShopIdCache = cacheManager.getCache("domainByShopIdCache");
        domainByShopIdCache.evict(shopId);
        Cache shopDomainCache = cacheManager.getCache("shopDomainCache");
        shopDomainCache.evict(domain);
    }

    /**
     * 查询店铺二级域名
     * @param shopId
     * @return
     */
    @Override
    public String selDomain(Long shopId) {
        if(shopId == null){
            return null;
        }
        Cache cache = cacheManager.getCache("domainByShopIdCache");
        String domain=cache.get(shopId, String.class);
        if(domain!=null){
            return domain;
        }
        ShiguShopExample example = new ShiguShopExample();
        example.createCriteria().andShopIdEqualTo(shopId);
        List<ShiguShop> shiguShopList = shiguShopMapper.selectFieldsByExample(example , FieldUtil.codeFields("shop_id,domain"));
        if(shiguShopList.size() == 0){
            return null;
        }
        ShiguShop shiguShop = shiguShopList.get(0);
        if(shiguShop.getDomain()!=null){
            cache.put(shopId,shiguShop.getDomain());
        }
        return shiguShop.getDomain();
    }

    /**
     * 查店铺ID
     * @param domain
     * @return
     */
    @Override
        public Long selShopIdByDomain(String domain) {
        if(StringUtils.isEmpty(domain)){
            return null;
        }
        // 查询缓存
        Cache cache = cacheManager.getCache("shopDomainCache");
        Long shopId = cache.get(domain, Long.class);
        if(shopId != null){
            return shopId;
        }
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.createCriteria().andDomainEqualTo(domain).andShopStatusEqualTo(0);
        List<ShiguShop> shiguShopList = shiguShopMapper.selectFieldsByExample(shiguShopExample, FieldUtil.codeFields("shop_id"));
        if(shiguShopList.size() == 0){
            return null;
        }
        ShiguShop shiguShop = shiguShopList.get(0);
        // 加入缓存
        cache.put(domain, shiguShop.getShopId());
        return shiguShop.getShopId();
    }

    /**
     * 关店
     *
     * @param shopId
     * @param reason
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void closeShop(Long shopId, DmlReason reason) {
        if(shopId == null){
            return;
        }
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setShopId(shopId);
        shiguShop = shiguShopMapper.selectOne(shiguShop);
        if(shiguShop == null || shiguShop.getShopStatus() == 1){
            return;
        }
        shiguShop.setShopId(shopId);
        shiguShop.setShopStatus(1);
        if (reason != null) {
            shiguShop.setCloseReason(reason.toString());
        }
        shiguShopMapper.updateByPrimaryKeySelective(shiguShop);
        shopToEsService.addToEs(shiguShop.getShopId());

        shiguGoodsTinyMapper.updateGoodsTinyByClose(shiguShop.getWebSite(), 0, 1, shopId);

        // 更新es数据
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("goods");
        srb.setSize(5000);
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder queryBuilder = QueryBuilders.termQuery("storeId" ,shopId);
        boleanQueryBuilder.must(queryBuilder);
        QueryBuilder queryBuilderIsOff = QueryBuilders.termQuery("is_off" ,0);
        boleanQueryBuilder.must(queryBuilderIsOff);
        srb.setQuery(boleanQueryBuilder);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        if(hits == null || hits.length == 0){
            return;
        }
        // 批量更新
        Client client = ElasticConfiguration.client;
        BulkRequestBuilder bulkRequest = client.prepareBulk();

        for (SearchHit hit : hits) {
            if (hit == null) {
                continue;
            }
            String source = hit.getSourceAsString();
            if (StringUtils.isEmpty(source)) {
                continue;
            }
            ESGoods esGoods = JSON.parseObject(source,ESGoods.class);
            if (esGoods == null) {
                continue;
            }
            esGoods.setIs_off(1L);
            source = JSON.toJSONStringWithDateFormat(esGoods, "yyyy-MM-dd HH:mm:ss");
            bulkRequest.add(client.prepareIndex("goods"
                    , hit.getType()
                    , hit.getId()).setSource(source));
        }
        try {
            bulkRequest.execute().actionGet();
        } catch (Exception e) {
            logger.error("更新商品es数据关闭状态为1>>发生异常>>批量更新es数据>>error:" + e.toString());
            e.printStackTrace();
        }
    }

    /**
     * 开店
     *
     * @param shopId
     * @param reason
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void openShop(Long shopId, DmlReason reason) throws Main4Exception {
        if(shopId == null){
            return;
        }
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setShopId(shopId);
        shiguShop = shiguShopMapper.selectOne(shiguShop);
        if(shiguShop == null || shiguShop.getShopStatus() == 0){
            return;
        }

        ShiguShopExample shopExample = new ShiguShopExample();
        shopExample.createCriteria().andMarketIdEqualTo(shiguShop.getMarketId())
                .andShopNumEqualTo(shiguShop.getShopNum()).andShopStatusEqualTo(0).andShopIdNotEqualTo(shopId);
        int repeatShopNum = shiguShopMapper.countByExample(shopExample);
        if(repeatShopNum > 0){
            throw new Main4Exception("档口号已被使用，无法开店，请更换");
        }

        if (!shopRegistService.shopCanOpen(shiguShop.getUserId(),shiguShop.getTbNick(), shiguShop.getMarketId(), shiguShop.getShopNum()))
            throw new Main4Exception("该店铺不符合准入条件");

        shiguShop.setShopId(shopId);
        shiguShop.setShopStatus(0);
        if(reason != null){
            shiguShop.setCloseReason(reason.toString() + shiguShop.getCloseReason());
        }

        String domain = shiguShop.getDomain();
        shiguShop.setDomain("");
        shiguShopMapper.updateByPrimaryKeySelective(shiguShop);

        shopToEsService.addToEs(shiguShop.getShopId());
        shiguGoodsTinyMapper.updateGoodsTinyByClose(shiguShop.getWebSite(), 1, 0, shopId);

        // 修改二级域名
        try{
            updateDomain(shopId ,domain);
        }catch (Exception e){
            logger.error("开店修改二级域名>>error:" + e.toString());
            // 去除店铺缓存
            Cache domainByShopIdCache = cacheManager.getCache("domainByShopIdCache");
            domainByShopIdCache.evict(shopId);
            Cache shopDomainCache = cacheManager.getCache("shopDomainCache");
            shopDomainCache.evict(domain);
        }

        // 更新es数据
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("goods");
        srb.setSize(5000);
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder queryBuilder = QueryBuilders.termQuery("storeId" ,shopId);
        boleanQueryBuilder.must(queryBuilder);
        QueryBuilder queryBuilderIsOff = QueryBuilders.termQuery("is_off" ,1);
        boleanQueryBuilder.must(queryBuilderIsOff);
        srb.setQuery(boleanQueryBuilder);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        if(hits == null || hits.length == 0){
            return;
        }
        // 批量更新
        Client client = ElasticConfiguration.client;
        BulkRequestBuilder bulkRequest = client.prepareBulk();

        for (SearchHit hit : hits) {
            if (hit == null) {
                continue;
            }
            String source = hit.getSourceAsString();
            if (StringUtils.isEmpty(source)) {
                continue;
            }
            ESGoods esGoods = JSON.parseObject(source,ESGoods.class);
            if (esGoods == null) {
                continue;
            }
            esGoods.setIs_off(0L);
            source = JSON.toJSONStringWithDateFormat(esGoods, "yyyy-MM-dd HH:mm:ss");
            bulkRequest.add(client.prepareIndex("goods"
                    , hit.getType()
                    , hit.getId()).setSource(source));
        }
        try {
            bulkRequest.execute().actionGet();
        } catch (Exception e) {
            logger.error("更新商品es数据关闭状态为1>>发生异常>>批量更新es数据>>error:" + e.toString());
            e.printStackTrace();
        }
        // TODO:如果授权正常，此处需要全店同步

    }

    /**
     * 修改店铺基本信息
     *
     * @param shopId
     * @param shopBase
     */
    @Override
    public void modifyShopBase(Long shopId, ShopBase shopBase) {
        if(shopId == null || shopBase == null){
            return;
        }
        if(StringUtils.isEmpty(shopBase.getTbNick())||StringUtils.isEmpty(shopBase.getTaobaoUrl())){
            shopBase.setTbNick(null);
            shopBase.setTaobaoUrl(null);
        }
        ShiguShop shiguShop = BeanMapper.map(shopBase, ShiguShop.class);
        shiguShop.setDataPacketUrl(shopBase.getDataPackageUrl());
        shiguShop.setShopId(shopId);
        shiguShopMapper.updateByPrimaryKeySelective(shiguShop);
        shopToEsService.addToEs(shiguShop.getShopId());
        // 去除缓存
        cacheManager.getCache("shopBaseCache").evict(shopId);
    }

    /**
     * 提供给更新用的店铺基本信息
     * @param shopId
     * @return
     */
    @Override
    public ShopBase shopBaseForUpdate(Long shopId) {
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        if(shiguShop == null){
            return null;
        }
        ShopBase shopBase = BeanMapper.map(shiguShop, ShopBase.class);
        shopBase.setDataPackageUrl(shiguShop.getDataPacketUrl());
        return shopBase;
    }

    /**
     * 档口迁移
     *
     * @param shopId     档口ID,必填
     * @param toMarketId 目标市场ID,必填
     * @param toFloorId  目标楼层ID,必填
     * @param shopNum    目标档口号,可为空
     */
    @Override
    public void moveMarket(Long shopId, Long toMarketId, Long toFloorId, String shopNum) throws Main4Exception {
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setShopId(shopId);
        shiguShop = shiguShopMapper.selectOne(shiguShop);
        if(shiguShop == null){
            return;
        }

        ShiguMarket newShiguMarket = shiguMarketMapper.selectByPrimaryKey(shiguShop.getMarketId());
        ShiguMarket shiguMarket = shiguMarketMapper.selectByPrimaryKey(toMarketId);
        if(!StringUtils.equals(shiguMarket.getWebSite(),newShiguMarket.getWebSite())){
            logger.error("档口迁移，暂不支持跨站迁移");
            throw new Main4Exception("档口迁移，暂不支持跨站迁移");
        }

        shiguShop.setMarketId(toMarketId);
        shiguShop.setFloorId(toFloorId);
        shiguShop.setShopNum(shopNum);
        shiguShopMapper.updateByPrimaryKeySelective(shiguShop);
        shopToEsService.addToEs(shiguShop.getShopId());

        try{
            updateDomain(shopId, shiguShop.getDomain());
        }catch (ShopDomainException e){
            e.printStackTrace();
            logger.error("档口迁移，迁移二级域名发生错误>>error:" + e.getMsg());
            shiguShop.setDomain(null);
            shiguShopMapper.updateByPrimaryKey(shiguShop);
            shopToEsService.addToEs(shiguShop.getShopId());
        }


        shiguGoodsTinyMapper.updateFloorMarketByShopId(shopId, shiguShop.getWebSite(), toMarketId, toFloorId);

        // 更新es数据
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("goods");
        srb.setSize(5000);
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder queryBuilder = QueryBuilders.termQuery("storeId" ,shopId);
        boleanQueryBuilder.must(queryBuilder);
        srb.setQuery(boleanQueryBuilder);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        if(hits == null || hits.length == 0){
            return;
        }
        // 批量更新
        Client client = ElasticConfiguration.client;
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for (SearchHit hit : hits) {
            if (hit == null) {
                continue;
            }
            String source = hit.getSourceAsString();
            if (StringUtils.isEmpty(source)) {
                continue;
            }
            ESGoods esGoods = JSON.parseObject(source,ESGoods.class);
            if (esGoods == null) {
                continue;
            }
            esGoods.setMarketId(toFloorId);
            esGoods.setParentMarketId(toMarketId);
            source = JSON.toJSONStringWithDateFormat(esGoods, "yyyy-MM-dd HH:mm:ss");
            bulkRequest.add(client.prepareIndex("goods"
                    , hit.getType()
                    , hit.getId()).setSource(source));
        }
        try {
            bulkRequest.execute().actionGet();
        } catch (Exception e) {
            logger.error("更新商品es数据档口迁移>>发生异常>>批量更新es数据>>error:" + e.toString());
            e.printStackTrace();
        }
    }


    /**
     * 判断授权时间
     * @param refreshTime
     * @param expiredIn
     * @return
     */
    public int panssShopAuthState(Date refreshTime,Long expiredIn){
        if(refreshTime == null){
            return 0;
        }
        if(expiredIn == null){
            expiredIn = 0L;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(refreshTime);
        cal.add(Calendar.SECOND, expiredIn.intValue());
        Date d = cal.getTime();

        Date now = new Date();
        if(d.after(now)){
            return 1;
        }else{
            return 2;
        }
    }

    /**
     * 更新淘宝链接
     * @param shopId 店铺ID
     * @param tbNick 淘宝nick
     * @throws Main4Exception
     */
    @Override
    public void changeTbLink(Long userId,Long shopId, String tbNick, Long tbShopId) throws Main4Exception {
        if(shopId == null || StringUtils.isEmpty(tbNick)){
            throw new Main4Exception("更换淘宝链接失败");
        }
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        if(!StringUtils.isEmpty(shiguShop.getTbNick())&&StringUtils.equals(shiguShop.getTbNick(),tbNick)){
            // 无需更换
            return;
        }
//        // 淘宝昵称设为空，且
//        if(StringUtils.isEmpty(tbNick) && !StringUtils.isEmpty(shiguShop.getTbNick())){
//            if(userId == shiguShop.getUserId()){
//                shiguShop.setUserId(null);
//                shiguShop.setTbNick(null);
//                shiguShopMapper.updateByPrimaryKey(shiguShop);
//            }
//            return;
//        }

        // 更换淘宝链接
        String tbUrl = "http://shop${shopId}.taobao.com".replace("${shopId}", tbShopId.toString());
        shiguShop.setTaobaoUrl(tbUrl);

        // 判断用户下是否存在店铺
        if(userId != null){
            // 判断该userId下是否存在店铺
            ShiguShopExample shopExample = new ShiguShopExample();
            shopExample.createCriteria().andUserIdEqualTo(userId).andShopStatusEqualTo(0);
            int result = shiguShopMapper.countByExample(shopExample);
            if(result > 0){
                throw new Main4Exception("该淘宝昵称下已存在店铺，不能再绑定店铺");
            }

            shopExample = new ShiguShopExample();
            shopExample.createCriteria().andTbNickEqualTo(tbNick).andShopStatusEqualTo(0);
            result = shiguShopMapper.countByExample(shopExample);
            if(result > 0){
                throw new Main4Exception("该淘宝昵称下已绑定店铺，不能再绑定店铺");
            }
        }
        shiguShop.setTbNick(tbNick);
        shiguShop.setUserId(userId);
        shiguShopMapper.updateByPrimaryKey(shiguShop);

        shopToEsService.addToEs(shiguShop.getShopId());
    }

    /**
     * 授权同步信息
     * @param shopId 店铺ID
     * @return
     */
    @Override
    public int shopAuthState(Long shopId) {
        if(shopId == null){
            return 0;
        }
        ShiguShop shiguShop = shiguShopMapper.selectTbAuthSyn(shopId);
        if(shiguShop == null){
            return 0;
        }
        if(StringUtils.isEmpty(shiguShop.getTbNick())){
            return 0;
        }
        return panssShopAuthState(shiguShop.getFreshTime(),shiguShop.getExpiresIn());
    }

    /**
     * 店铺状态
     * @param shopId
     * @return
     */
    @Override
    public int getShopStatus(Long shopId) {
        ShiguShop shiguShop = shiguShopMapper.selectFieldsByPrimaryKey(shopId,FieldUtil.codeFields("shop_id,shop_status"));
        if(shiguShop == null){
            return 1;
        }
        return shiguShop.getShopStatus();
    }
}
