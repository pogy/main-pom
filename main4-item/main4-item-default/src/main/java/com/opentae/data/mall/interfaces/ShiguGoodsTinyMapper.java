package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.shigu.main4.item.beans.GoodsInfoVO;
import com.shigu.main4.item.bo.StoreGoodsListSearchBO;
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

    //获取出售中的商品基本信息
    List<GoodsInfoVO> selOnsaleGoodsInfo(@Param("shopId") Long shopId, @Param("webSite") String webSite, @Param("bo") StoreGoodsListSearchBO bo, @Param("start") int start, @Param("size") int size);
    //统计出售中的商品
    int countOnsaleGoods(@Param("shopId") Long shopId, @Param("webSite") String webSite, @Param("bo") StoreGoodsListSearchBO bo);

    //获取档口中无大图商品数量
    int selNoBigPic(@Param("shopId") Long shopId,@Param("webSite") String webSite);
    //获取档口中未设置最低零售价商品数量
    int selNoLowPrice(@Param("shopId") Long shopId,@Param("webSite") String webSite);
    //获取未设置面料成分商品数量
    int selNoConstituent(@Param("shopId") Long shopId,@Param("webSite") String webSite);

}
