package com.shigu.main4.ucenter.services.impl;

import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.CollectSimpleGoodsInfo;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.ShopCollect;
import com.shigu.main4.ucenter.webvo.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wxc on 2017/2/25.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("userCollectService")
public class UserCollectServiceImpl implements UserCollectService {

    private static final Logger logger = LoggerFactory.getLogger(UserCollectServiceImpl.class);

    @Resource(name = "tae_mall_shiguGoodsCollectMapper")
    private ShiguGoodsCollectMapper shiguGoodsCollectMapper;

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Resource(name = "tae_mall_shiguGoodsSoldoutMapper")
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Autowired
    private ShiguStoreCollectMapper shiguStoreCollectMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;
    @Autowired
    TaobaoItemPropMapper taobaoItemPropMapper;

    /**
     * 查询本店收藏的宝贝
     *
     * @param userId   用户ID
     * @param webSite  分站标识
     * @param pageNo   当前页码
     * @param pageSize 每页条数
     * @return
     */
    @Override
    public ShiguPager<ItemCollectVO> selItemCollections(Long userId, String keyword, String webSite, int pageNo, int pageSize) {
        ShiguPager<ItemCollectVO> pager = new ShiguPager<>();
        if (pageNo < 1)
            pageNo = 1;
        if (pageSize < 1)
            pageSize = 10;
        if (StringUtils.isEmpty(webSite))
            webSite = "hz";
        pager.setNumber(pageNo);

        if (userId == null)
            return pager;

        int count = shiguGoodsCollectMapper.countTinyGoodsCollect(userId, keyword, webSite);
        pager.calPages(count, pageSize);
        if (count > 0) {
            List<TinyItemCollect> shiguGoodsCollects
                    = shiguGoodsCollectMapper.tinyGoodsCollect(
                    userId, keyword, webSite, (pageNo - 1) * pageSize, pageSize);
            pager.setContent(BeanMapper.mapList(shiguGoodsCollects, ItemCollectVO.class));
        }
        return pager;
    }

    @Override
    public ShiguPager<NewGoodsCollectVO> selItemCollectionsByType(Long userId, String keyword, String webSite, int pageNo, int pageSize, int type) {
        ShiguPager<NewGoodsCollectVO> pager = new ShiguPager<>();
        if (pageNo < 1)
            pageNo = 1;
        if (pageSize < 1)
            pageSize = 10;
        if (StringUtils.isEmpty(webSite))
            webSite = "hz";
        pager.setNumber(pageNo);

        if (userId == null)
            return pager;
        List<NewGoodsCollectVO> context = new ArrayList<>(pageSize);
        pager.setContent(context);
        ShiguGoodsCollectExample shiguGoodsCollectExample = new ShiguGoodsCollectExample();
        shiguGoodsCollectExample.createCriteria().andUserIdEqualTo(userId).andWebsiteEqualTo(webSite).andTypeEqualTo(type);
        if (StringUtils.isNotBlank(keyword)) {
            //新收藏，存收藏时title
            shiguGoodsCollectExample.createCriteria().andRemark1Like(keyword);
        }
        shiguGoodsCollectExample.setOrderByClause("goods_collect_id DESC");
        int count = shiguGoodsCollectMapper.countByExample(shiguGoodsCollectExample);
        pager.calPages(count, pageSize);
        if (count > 0) {
            shiguGoodsCollectExample.setStartIndex((pageNo - 1) * pageSize);
            shiguGoodsCollectExample.setEndIndex(pageSize);
            List<ShiguGoodsCollect> shiguGoodsCollects = shiguGoodsCollectMapper.selectByConditionList(shiguGoodsCollectExample);
            List<Long> goodsIds = new ArrayList<>(shiguGoodsCollects.size());
            List<Long> shopIds = new ArrayList<>(shiguGoodsCollects.size());
            for (ShiguGoodsCollect shiguGoodsCollect : shiguGoodsCollects) {
                goodsIds.add(shiguGoodsCollect.getGoodsId());
                shopIds.add(shiguGoodsCollect.getStoreId());
            }
            Map<Long, CollectSimpleGoodsInfo> goodsIdInfoMap = BeanMapper.list2Map(selSimpleCollectGoodsInfoList(goodsIds, webSite), "goodsId", Long.class);
            if (shopIds.size()>0) {
                Map<Long, ShopInfo> shopIdInfoMap = BeanMapper.list2Map(selShopInfoByShopIds(shopIds), "shopId", Long.class);
                for (ShiguGoodsCollect shiguGoodsCollect : shiguGoodsCollects) {
                    NewGoodsCollectVO newGoodsCollectVO = new NewGoodsCollectVO();
                    newGoodsCollectVO.setCollId(shiguGoodsCollect.getGoodsCollectId());
                    newGoodsCollectVO.setGoodsId(shiguGoodsCollect.getGoodsId());
                    try {
                        CollectSimpleGoodsInfo goodsInfo = goodsIdInfoMap.get(shiguGoodsCollect.getGoodsId());
                        newGoodsCollectVO.setGoodsNo(goodsInfo.getGoodsNo());
                        newGoodsCollectVO.setTitle(goodsInfo.getTitle());
                        newGoodsCollectVO.setImgSrc(goodsInfo.getPicUrl());
                        newGoodsCollectVO.setPiprice(goodsInfo.getPiPriceString());
                        newGoodsCollectVO.setOnSaleIs(goodsInfo.getOnSaleIs());
                    } catch (Exception e) {
                        newGoodsCollectVO.setGoodsNo("此商品已被删除");
                    }
                    ShopInfo shopInfo = shopIdInfoMap.get(shiguGoodsCollect.getStoreId());
                    newGoodsCollectVO.setShopId(shiguGoodsCollect.getStoreId());
                    newGoodsCollectVO.setMarketName(shopInfo.getMarketName());
                    newGoodsCollectVO.setShopNum(shopInfo.getShopNum());
                    newGoodsCollectVO.setImQq(shopInfo.getImQq());
                    newGoodsCollectVO.setImWw(shopInfo.getImWw());
                    context.add(newGoodsCollectVO);
                }
            }
        }
        return pager;
    }

    private List<CollectSimpleGoodsInfo> selSimpleCollectGoodsInfoList(List<Long> goodsIds, String webSite) {
        List<CollectSimpleGoodsInfo> simpleGoodsInfos = Lists.newArrayList();
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite(webSite);
        tinyExample.createCriteria().andGoodsIdIn(goodsIds);
        for (ShiguGoodsTiny tiny : shiguGoodsTinyMapper.selectByExample(tinyExample)) {
            CollectSimpleGoodsInfo goodsInfo = BeanMapper.map(tiny, CollectSimpleGoodsInfo.class);
            goodsInfo.setOnSaleIs(true);
            simpleGoodsInfos.add(goodsInfo);
        }
        if (goodsIds.size() > simpleGoodsInfos.size()) {
            ShiguGoodsSoldoutExample shiguGoodsSoldoutExample = new ShiguGoodsSoldoutExample();
            shiguGoodsSoldoutExample.setWebSite(webSite);
            shiguGoodsSoldoutExample.createCriteria().andGoodsIdIn(goodsIds);
            for (ShiguGoodsSoldout soldout : shiguGoodsSoldoutMapper.selectByExample(shiguGoodsSoldoutExample)) {
                CollectSimpleGoodsInfo goodsInfo = BeanMapper.map(soldout, CollectSimpleGoodsInfo.class);
                goodsInfo.setOnSaleIs(false);
                simpleGoodsInfos.add(goodsInfo);
            }
        }
        return simpleGoodsInfos;
    }

    /**
     * 查询本收藏该宝贝信息
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param webSite 分站标识
     * @return
     */
    public ItemCollectInfoVO selItemCollectionInfo(Long userId, Long goodsId, String webSite) {
        if (userId == null || goodsId == null) {
            if(logger.isErrorEnabled()){
                logger.error("查询店铺收藏的宝贝信息失败: [userId="+userId+" , goodsId="+goodsId+" , webSite="+webSite+"]");
            }
        }
        ShiguGoodsCollect shiguGoodsCollect = new ShiguGoodsCollect();
        shiguGoodsCollect.setUserId(userId);
        shiguGoodsCollect.setGoodsId(goodsId);
        if(!StringUtil.isNull(webSite)){
            shiguGoodsCollect.setWebsite(webSite);
        }
        shiguGoodsCollect =  shiguGoodsCollectMapper.selectOne(shiguGoodsCollect);
        if ( shiguGoodsCollect == null) {
            return null;
        }
        return BeanMapper.map(shiguGoodsCollect,ItemCollectInfoVO.class);
    }

    /**
     * 按条件查询收藏商品
     * @param userId
     * @param goodsId
     * @param useStatus
     * @param storeId
     * @param webSite
     * @return
     */
    public List<ItemCollectInfoVO> selItemCollection(Long userId, Long goodsId, Integer useStatus, Long storeId, String webSite) {
        ShiguGoodsCollectExample collectExample = new ShiguGoodsCollectExample();
        ShiguGoodsCollectExample.Criteria criteria = collectExample.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (goodsId != null) {
            criteria.andGoodsIdEqualTo(goodsId);
        }
        if (useStatus != null) {
            criteria.andUseStatusEqualTo(useStatus);
        }
        if (storeId != null) {
            criteria.andStoreIdEqualTo(storeId);
        }
        if (!StringUtil.isNull(webSite)) {
            criteria.andWebsiteEqualTo(webSite);
        }
        List<ShiguGoodsCollect> shiguGoodsCollects = shiguGoodsCollectMapper.selectByExample(collectExample);
        if (shiguGoodsCollects == null || shiguGoodsCollects.isEmpty())return null;
        return BeanMapper.mapList(shiguGoodsCollects,ItemCollectInfoVO.class);
    }

    /**
     * 按主键批量删除收藏记录
     *
     * @param userId     用户IDs
     * @param collectIds 主键
     */
    @Override
    public void delItemCollection(Long userId, List<Long> collectIds) {
        if (userId == null || collectIds == null || collectIds.isEmpty())
            return;
        ShiguGoodsCollectExample collectExample = new ShiguGoodsCollectExample();
        collectExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andGoodsCollectIdIn(collectIds);
        shiguGoodsCollectMapper.deleteByExample(collectExample);
    }

    /**
     * 添加商品收藏
     *
     * @param collect 收藏
     */
    @Override
    public void addItemCollection(ItemCollect collect) throws ItemCollectionException {
        if (collect == null || collect.getUserId() == null || collect.getItemId() == null || collect.getStoreId() == null) {
            throw new ItemCollectionException(ItemCollectionException.ItemCollecExcpEnum.IllegalArgumentException);
        }
        ShiguGoodsCollectExample collectExample = new ShiguGoodsCollectExample();
        collectExample.createCriteria().andGoodsIdEqualTo(collect.getItemId())
                .andUserIdEqualTo(collect.getUserId()).andTypeEqualTo(collect.getType());
        List<ShiguGoodsCollect> shiguGoodsCollects = shiguGoodsCollectMapper.selectByExample(collectExample);
        if (shiguGoodsCollects.isEmpty()) {
            ShiguGoodsCollect goodsCollect = BeanMapper.map(collect, ShiguGoodsCollect.class);
            goodsCollect.setGoodsId(collect.getItemId());
            goodsCollect.setRemark1(collect.getTitle());
            goodsCollect.setType(collect.getType());
            shiguGoodsCollectMapper.insertSelective(goodsCollect);
        } else
            throw new ItemCollectionException(ItemCollectionException.ItemCollecExcpEnum.CollectionAlreadyExist);
    }



    @Override
    public ShiguPager<ShopCollectVO> selShopCollections(Long userId, String webSite, int pageNo, int pageSize) {
        ShiguPager<ShopCollectVO> pager = new ShiguPager<>();
        if (pageNo < 1)
            pageNo = 1;
        if (pageSize < 1)
            pageSize = 10;
        pager.setNumber(pageNo);
        if (userId == null)
            return pager;
        ShiguStoreCollectExample collectExample = new ShiguStoreCollectExample();
        collectExample.setOrderByClause("store_collect_id DESC");
        collectExample.setStartIndex((pageNo - 1) * pageSize);
        collectExample.setEndIndex(pageSize);
        collectExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andWebSiteEqualTo(webSite);
        int count = shiguStoreCollectMapper.countByExample(collectExample);
        pager.calPages(count, pageSize);
        if (count > 0) {
            List<ShiguStoreCollect> shiguStoreCollects = shiguStoreCollectMapper.selectByConditionList(collectExample);
            List<ShopCollectVO> vos = new ArrayList<>(shiguStoreCollects.size());
            pager.setContent(vos);
            if (shiguStoreCollects.size() > 0) {
                Map<Long, ShopInfo> shopIdInfoMap = BeanMapper.list2Map(selShopInfoByShopIds(BeanMapper.getFieldList(shiguStoreCollects, "storeId", Long.class)), "shopId", Long.class);
                for (ShiguStoreCollect shiguStoreCollect : shiguStoreCollects) {
                    try {
                        ShopInfo shopInfo = shopIdInfoMap.get(shiguStoreCollect.getStoreId());
                        if (shopInfo == null) {
                            //过滤一些遗留的测试数据（没有对应的档口）
                            continue;
                        }
                        ShopCollectVO shopCollect = BeanMapper.map(shopInfo, ShopCollectVO.class);
                        shopCollect.setCollId(shiguStoreCollect.getStoreCollectId());
                        shopCollect.setWebSite(shiguStoreCollect.getWebSite());
                        vos.add(shopCollect);
                    } catch (Exception e) {
                        //System.out.println(e.getMessage());
                    }
                }
            }
        }
        return pager;
    }

    /**
     * 按主键删除店铺收藏
     *
     * @param userId     用户
     * @param collectIds 收藏ID
     */
    @Override
    public void delShopCollection(Long userId, List<Long> collectIds) {
        if (userId == null || collectIds == null || collectIds.isEmpty())
            return;
        ShiguStoreCollectExample collectExample = new ShiguStoreCollectExample();
        collectExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andStoreCollectIdIn(collectIds);
        shiguStoreCollectMapper.deleteByExample(collectExample);
    }

    /**
     * 按店铺id删除
     * @param userId
     * @param shopIds
     */
    public void delShopCollectionByShopIds(Long userId, List<Long> shopIds) {
        if (userId == null || shopIds == null || shopIds.isEmpty()){
            return;
        }
        ShiguStoreCollectExample example = new ShiguStoreCollectExample();
        example.createCriteria().andUserIdEqualTo(userId).andStoreIdIn(shopIds);
        shiguStoreCollectMapper.deleteByExample(example);
    }

    /**
     * 添加店铺收藏
     *
     * @param collect 店铺收藏
     */
    @Override
    public void addShopCollection(ShopCollect collect) throws ShopCollectionException {
        if (collect == null || collect.getUserId() == null || collect.getShopId() == null) {
            throw new ShopCollectionException(ShopCollectionException.ShopCollecExcpEnum.IllegalArgumentException);
        }
        ShiguStoreCollectExample collectExample = new ShiguStoreCollectExample();
        collectExample.createCriteria().andStoreIdEqualTo(collect.getShopId())
                .andUserIdEqualTo(collect.getUserId());
        List<ShiguStoreCollect> shiguStoreCollects = shiguStoreCollectMapper.selectByExample(collectExample);
        if (shiguStoreCollects.isEmpty()) {
            ShiguStoreCollect storeCollect = BeanMapper.map(collect, ShiguStoreCollect.class);
            storeCollect.setStoreId(collect.getShopId());
            storeCollect.setWebSite(collect.getWebsite());
            shiguStoreCollectMapper.insertSelective(storeCollect);
        } else
            throw new ShopCollectionException(ShopCollectionException.ShopCollecExcpEnum.CollectionAlreadyExist);
    }

    @Override
    public List<ShopInfo> selShopInfoByShopIds(List<Long> shopIds) {
        String defaultShopImgUrl = "";
        List<ShopInfo> shopInfoList = Lists.newArrayList();
        ShiguShopExample shopExample = new ShiguShopExample();
        shopExample.createCriteria().andShopIdIn(shopIds);
        List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shopExample);
        List<Long> marketIds = Lists.newArrayList();
        for (ShiguShop shiguShop : shiguShops) {
            marketIds.add(shiguShop.getMarketId());
        }
        if (marketIds.size() > 0) {
            ShiguMarketExample marketExample = new ShiguMarketExample();
            marketExample.createCriteria().andMarketIdIn(marketIds);
            Map<Long, ShiguMarket> marketIdInfoMap = BeanMapper.list2Map(shiguMarketMapper.selectByExample(marketExample), "marketId", Long.class);
            for (ShiguShop shiguShop : shiguShops) {
                ShopInfo shopInfo = new ShopInfo();
                shopInfo.setShopId(shiguShop.getShopId());
                shopInfo.setShopNum(shiguShop.getShopNum());
                shopInfo.setImWw(shiguShop.getImAliww());
                shopInfo.setImQq(shiguShop.getImQq());
                //todo 暂时没有店铺图片
                shopInfo.setShopImgSrc(defaultShopImgUrl);
                shopInfo.setMarketName(marketIdInfoMap.get(shiguShop.getMarketId()).getMarketName());
                shopInfoList.add(shopInfo);
            }
        }
        return shopInfoList;
    }

}
