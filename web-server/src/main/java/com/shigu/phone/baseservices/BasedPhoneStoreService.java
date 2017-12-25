package com.shigu.phone.baseservices;


import com.openJar.beans.app.AppShopBlock;
import com.openJar.exceptions.OpenException;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.beans.ShiguStoreCollect;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.ShiguStoreCollectExample;
import com.opentae.data.mall.interfaces.ShiguStoreCollectMapper;
import com.opentae.data.mall.multibeans.AppShopBlockBean;
import com.shigu.main4.cdn.bo.ScStoreBO;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.phone.basevo.ShopSearchVO;
import com.shigu.phone.basevo.StoreCollectVO;
import com.shigu.search.bo.StorenumBO;
import com.shigu.search.services.StoreSelFromEsService;
import com.shigu.search.vo.StoreInSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 类名：PhoneStoreService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneStoreService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 15:38
 * 项目：main-pom
 * 描述：
 */

@Service
public class BasedPhoneStoreService {

    @Autowired
    private UserCollectService userCollectService;

    @Autowired
    private CdnService cdnService;

    @Autowired
    private StoreSelFromEsService storeSelFromEsService;

    @Autowired
    private ShopForCdnService shopForCdnService;

    @Autowired
    private MultipleMapper tae_mall_multipleMapper;

    @Autowired
    private ShiguStoreCollectMapper shiguStoreCollectMapper;

    /**
     * 移动端店铺搜索
     *
     * @return
     */
    public ShopSearchVO shopSearch(String keyword, String webSite,Integer index,Integer size) {
        StorenumBO bo = new StorenumBO();
        bo.setKeyword(keyword);
        bo.setWebSite(webSite);
        bo.setPage(index);
        bo.setRows(size);
        ShiguPager<StoreInSearch> result = storeSelFromEsService.searchStore(bo);
        ShopSearchVO shopSearchVO = new ShopSearchVO();
        shopSearchVO.setTotal(result.getTotalCount());
        shopSearchVO.setHasNext(result.getNumber() < result.getTotalPages());
        shopSearchVO.setShops(result.getContent().parallelStream().map(o -> {
            AppShopBlock vo = new AppShopBlock();
            vo.setShopId(Long.valueOf(o.getId()));
            vo.setMarket(o.getFullMarketText());
            vo.setHighLightMarket(o.getHighMarketName());
            vo.setShopNum(o.getName());
            vo.setHighLightShopNum(o.getHighName());
            vo.setStarNum(o.getXy());
            vo.setTelephone(o.getTel());
            vo.setImAliww(o.getAliww());
            vo.setImQq(o.getImqq());
            vo.setMainCase(o.getMainCate());
            vo.setItemNum(o.getGoodsCount());
            vo.setShopHeadUrl(ImgUtils.headUrl(o.getAliww()));
            return vo;
        }).collect(Collectors.toList()));
        return shopSearchVO;
    }

    /**
     * 店铺收藏夹
     *
     * @return
     */
    public StoreCollectVO storeCollect(Long userId, String webSite,Integer index,Integer size) {
        StoreCollectVO storeCollectVO = new StoreCollectVO();
        ShiguPager<ShopCollectVO> shopCollectVOShiguPager = userCollectService.selShopCollections(userId, webSite, index, size);
        if (shopCollectVOShiguPager.getTotalCount() == 0) {
            storeCollectVO.setHasNext(false);
            storeCollectVO.setTotal(0);
            storeCollectVO.setShops(Collections.emptyList());
            return storeCollectVO;//收藏夹无商品
        }
        List<ShopCollectVO> shopCollectVOS = shopCollectVOShiguPager.getContent();
        List<Long> shopIds = shopCollectVOS.stream().map(ShopCollectVO::getShopId).collect(Collectors.toList());
        Map<Long, ShopCollectVO> collectGroup = BeanMapper.list2Map(shopCollectVOS, "shopId", Long.class);

        if (shopIds == null || shopIds.isEmpty()) {
            storeCollectVO.setHasNext(false);
            storeCollectVO.setTotal(0);
            storeCollectVO.setShops(Collections.emptyList());
            return storeCollectVO;//不可能走到这吧
        }
        ArrayList<AppShopBlockBean> appShopBlockBeans = new ArrayList<>(size);
        ShiguMarketExample marketExample = new ShiguMarketExample();
        ShiguShopExample shopExample = new ShiguShopExample();
        MultipleExample example = MultipleExampleBuilder.from(shopExample)
                .join(marketExample).on(shopExample.createCriteria().andShopIdIn(shopIds).equalTo(ShiguGoodsTinyExample.marketId, ShiguMarketExample.marketId))
                .build();
        example.setGroupByClause("shigu_shop.shop_id");
        appShopBlockBeans.addAll(tae_mall_multipleMapper.selectFieldsByMultipleExample(example, com.opentae.data.mall.multibeans.AppShopBlockBean.class));
        storeCollectVO.setShops(appShopBlockBeans.parallelStream().map(o -> {
            AppShopBlock shop = BeanMapper.map(o, AppShopBlock.class);
            //从ShopCdn拿档口商品数量
            shop.setItemNum(shopForCdnService.selItemNumberById(o.getShopId(), o.getWebSite()).intValue());
            //从缓存拿星星数
            shop.setStarNum(shopForCdnService.selShopStarById(o.getShopId()).toString());
            shop.setShopHeadUrl(ImgUtils.headUrl(o.getImAliww()));
            Long collectId = collectGroup.get(o.getShopId()).getCollId();
            shop.setMarketCollectId(String.valueOf(collectId));
            return shop;
        }).collect(Collectors.toList()));
        storeCollectVO.setTotal(shopCollectVOShiguPager.getTotalCount());
        storeCollectVO.setHasNext(shopCollectVOShiguPager.getNumber() < shopCollectVOShiguPager.getTotalPages());
        return storeCollectVO;
    }

    /**
     * 收藏OR取消收藏店铺
     *
     * @return
     */
    public void doStoreCollect( Long shopId,boolean yesOrNo,Long userId) throws OpenException {
        if (yesOrNo) {
            try {
                addShopCollection(userId,shopId);
            } catch (ShopCollectionException e) {
               OpenException openException  = new OpenException();
               openException.setErrMsg("收藏失败");
               throw openException;
            }
        } else {
            ShiguStoreCollectExample collectExample = new ShiguStoreCollectExample();
            collectExample.createCriteria()
                    .andUserIdEqualTo(userId)
                    .andStoreIdEqualTo(shopId);
            List<ShiguStoreCollect> shiguStoreCollects = shiguStoreCollectMapper.selectByExample(collectExample);
            if (shiguStoreCollects.size()>0){
                userCollectService.delShopCollection(userId, Arrays.asList(shiguStoreCollects.get(0).getStoreCollectId()));
            }
        }
    }

    /**
     * 删除店铺收藏
     *
     * @return
     */
    public void delShopCollection(Long userId,List<Long> collectIds) {
        userCollectService.delShopCollection(userId,collectIds);
    }

    /**
     * 添加店铺收藏
     *
     * @throws ShopCollectionException
     */
    public void addShopCollection(Long userId,Long shopId) throws ShopCollectionException {
        ScStoreBO bo = new ScStoreBO();
        bo.setStore_id(shopId);
        cdnService.addShopCollect(userId, bo);
    }

    public Long hasCollected(Long storeId, Long userId) throws OpenException {
        ShiguStoreCollect shiguStoreCollect = new ShiguStoreCollect();
        shiguStoreCollect.setStoreId(storeId);
        shiguStoreCollect.setUserId(userId);
        shiguStoreCollect = shiguStoreCollectMapper.selectOne(shiguStoreCollect);
        if (shiguStoreCollect == null) {
           return null;
        }
        return shiguStoreCollect.getStoreCollectId();
    }

    public ShiguStoreCollect collectStore( Long userId,Long shopId) throws OpenException {
        try {
            addShopCollection(userId,shopId);
        } catch (ShopCollectionException e) {
           OpenException openException = new OpenException();
           openException.setErrMsg(e.getMessage());
           throw openException;
        }

        ShiguStoreCollect shiguStoreCollect = new ShiguStoreCollect();
        shiguStoreCollect.setStoreId(shopId);
        shiguStoreCollect.setUserId(userId);
        return shiguStoreCollectMapper.selectOne(shiguStoreCollect);
    }
}
