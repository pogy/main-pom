package com.shigu.buyer.services;

import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ShiguShop;
import com.shigu.buyer.vo.NewGoodsCollectVO;
import com.shigu.buyer.vo.NewStoreCollectVO;
import com.shigu.buyer.vo.SimpleGoodsInfoVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.webvo.ItemCollectVO;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.order.services.CartService;
import com.shigu.zhb.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 类名：UserCollectSimpleService
 * 类路径：com.shigu.buyer.services.UserCollectSimpleService
 * 创建者：王浩翔
 * 创建时间：2017-10-13 14:23
 * 项目：main-pom
 * 描述：
 */
@Service
public class UserCollectSimpleService {

    @Autowired
    CartService cartService;

    @Autowired
    UserCollectService userCollectService;

    @Autowired
    ShopForCdnService shopForCdnService;

    public ShiguPager<NewGoodsCollectVO> selNewGoodsCollect(Long userId, String webSite,Integer page, Integer size) {
        ShiguPager<NewGoodsCollectVO> pager = new ShiguPager<>();
        ShiguPager<ItemCollectVO> itemCollectVOShiguPager = userCollectService.selItemCollectionsByType(userId, null, webSite, page, size, 2);
        List<NewGoodsCollectVO> collectVOList = Lists.newArrayList();
        itemCollectVOShiguPager.getContent().forEach(o->{
            NewGoodsCollectVO newGoodsCollectVO = BeanMapper.map(o, NewGoodsCollectVO.class);
            newGoodsCollectVO.setGoodsId(o.getId());
            newGoodsCollectVO.setCollId(o.getGoodsCollectId());
            //todo: onsale判别
            collectVOList.add(newGoodsCollectVO);
        });
        List<Long> shopIds = collectVOList.stream().map(NewGoodsCollectVO::getShopId).collect(Collectors.toList());
        if (shopIds.size() > 0) {
            Map<Long, ShiguShop> shopMap = cartService.selShopIn(shopIds);
            collectVOList.forEach(o->{
                ShiguShop shiguShop = shopMap.get(o.getShopId());
                o.setMarketName(shiguShop.getParentMarketName());
                o.setShopNum(shiguShop.getShopNum());
                o.setImWw(shiguShop.getImAliww());
                o.setImQq(shiguShop.getImQq());
            });
        }
        pager.setNumber(itemCollectVOShiguPager.getNumber());
        pager.calPages(itemCollectVOShiguPager.getTotalCount(),size);
        return pager;
    }

    public ShiguPager<NewStoreCollectVO> selShopCollections(Long userId,String webSite,Integer page, Integer size) {
        ShiguPager<NewStoreCollectVO> pager = new ShiguPager<>();
        ShiguPager<ShopCollectVO> shopCollectVOShiguPager = userCollectService.selShopCollections(userId, webSite, page, size);
        pager.setNumber(page);
        pager.calPages(shopCollectVOShiguPager.getTotalCount(),size);
        List<ShopCollectVO> shopCollectVOS = shopCollectVOShiguPager.getContent();
        List<NewStoreCollectVO> collectVOs = Lists.newArrayList();
        pager.setContent(collectVOs);
        for (ShopCollectVO shopCollectVO : shopCollectVOS) {
            NewStoreCollectVO map = BeanMapper.map(shopCollectVO, NewStoreCollectVO.class);
            map.setStarNum(shopForCdnService.selShopStarById(shopCollectVO.getShopId()));
            map.setGoodsList(shopForCdnService.shopGoodsNew(shopCollectVO.getShopId()).stream().map(o->{
                SimpleGoodsInfoVO goodsInfoVO = new SimpleGoodsInfoVO();
                goodsInfoVO.setGoodsId(o.getItemId());
                goodsInfoVO.setImgSrc(o.getImgUrl());
                return goodsInfoVO;
            }).collect(Collectors.toList()));
            collectVOs.add(map);
        }
        return pager;
    }
}
