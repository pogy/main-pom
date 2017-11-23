package com.shigu.seller.services;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.item.services.ShopsItemService;
import com.shigu.seller.bo.GoodsVideoLinkBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 类名：SellerGoodsSimpleModifiedService
 * 类路径：com.shigu.seller.services.SellerGoodsSimpleModifiedService
 * 创建者：王浩翔
 * 创建时间：2017-11-14 15:51
 * 项目：main-pom
 * 描述：出售中的商品简单修改中转
 */
@Service
public class SellerGoodsSimpleModifiedService {

    @Autowired
    ShopsItemService shopsItemService;

    public void setGoodsVideo(Long shopId, String webSite, GoodsVideoLinkBO bo) throws JsonErrException {
        shopsItemService.setGoodsVideo(shopId,webSite,bo.getGoodsId(),bo.getGoodsVideoUrl(), Objects.equals(true,bo.getLinkSameGoodsNo()));
    }
}
