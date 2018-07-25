package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguRebateGoods;
import com.shigu.spread.vo.InviteGoodsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguRebateGoodsMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguRebateGoodsMapper extends Mapper<ShiguRebateGoods> {

    List<InviteGoodsVO> selRebateGoodsByType(@Param("typeId") Long typeId, @Param("fromSize") Integer fromSize, @Param("pageSize") Integer pageSize);
    int countRebateGoodsByType(@Param("typeId") Long typeId);
}
