package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemForList;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguGoodsTinyCreatedQz;
import com.opentae.data.mall.beans.ShiguGoodsToday;
import com.opentae.data.mall.multibeans.GoodsStyleInfoBean;
import com.opentae.data.mall.multibeans.ShopStyleGoodsAggrBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguGoodsTinyMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguGoodsTinyMapper extends Mapper<ShiguGoodsTiny> {


    List<ItemForList> selItemsForList(@Param("website") String website, @Param("goodsIds") List<Long> goodsIds);

    /**
     * 下架的商品
     *
     * @param website
     * @param goodsIds
     * @return
     */
    List<ItemForList> selSoldItemsForList(@Param("website") String website, @Param("goodsIds") List<Long> goodsIds);

    /**
     * 看了又看
     *
     * @param website
     * @param storeId
     * @return
     */
    List<ItemForList> selForSee(@Param("website") String website, @Param("storeId") Long storeId);

    /**
     * 统计店铺内各风格商品数
     *
     * @param shopId
     * @param parentStyleIds
     * @return
     */
    List<ShopStyleGoodsAggrBean> countShopStyleGoods(@Param("website") String webSite, @Param("shopId") Long shopId, @Param("parentStyleIds") List<Long> parentStyleIds);

    /**
     * 查询店内风格商品
     *
     * @param webSite
     * @param shopId
     * @param parentStyleId
     * @param startIndex
     * @param endIndex
     * @return
     */
    List<GoodsStyleInfoBean> selShopStyleGoods(@Param("website") String webSite, @Param("shopId") Long shopId, @Param("parentStyleId") Long parentStyleId, @Param("ignoredGoodsIds") List<Long> ignoredGoodsIds, @Param("startIndex") Integer startIndex, @Param("endIndex") Integer endIndex);

    int saveCreated(ShiguGoodsTinyCreatedQz shiguGoodsTinyCreatedQz);

    int updateCreated(ShiguGoodsTiny shiguGoodsTiny);

    int update(ShiguGoodsTinyCreatedQz shiguGoodsTinyCreatedQz);
}
