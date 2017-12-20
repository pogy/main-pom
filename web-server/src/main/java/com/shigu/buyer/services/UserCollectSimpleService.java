package com.shigu.buyer.services;

import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ShiguShop;

import com.shigu.buyer.vo.NewStoreCollectVO;
import com.shigu.buyer.vo.SimpleGoodsInfoVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.webvo.ItemCollectVO;
import com.shigu.main4.ucenter.webvo.NewGoodsCollectVO;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.order.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public ShiguPager<NewGoodsCollectVO> selNewGoodsCollect(Long userId, String webSite, Integer page, Integer size) {
        return userCollectService.selItemCollectionsByType(userId, null, webSite, page, size, 2);
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

    public void delCollectGoods(Long userId,String collectIds){
        if (userId == null) {
            return;
        }
        String[] splitIds = collectIds.split(",");
        if (splitIds.length == 0) {
            return;
        }
        List<Long> collect = Arrays.stream(splitIds).map(o -> Long.valueOf(o)).collect(Collectors.toList());
        try {
            userCollectService.delItemCollection(userId,collect);
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
