package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguGysCategoryGoods;
import com.shigu.main4.vo.CatesVo;
import com.shigu.main4.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguGysCategoryGoodsMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguGysCategoryGoodsMapper extends Mapper<ShiguGysCategoryGoods> {
    /**
     * 获取类目信息
     * @param shopId
     * @param webSite
     * @return
     */
    List<CatesVo> getCateInfo(@Param("shopId") Long shopId,@Param("webSite") String webSite);

    /**
     * 获取商品列表
     * @param shopId
     * @param webSite
     * @param cateId
     * @return
     */
    List<GoodsVo> selectGoodsByDiyCate(@Param("shopId") Long shopId, @Param("webSite") String webSite, @Param("cateId") Long cateId, @Param("pageNo") Integer pageNo, @Param("pageSite") Integer pageSite);

    /**
     * 分页查询条数
     * @param shopId
     * @param webSite
     * @param cateId
     * @return
     */
    Integer selectGoodsCountByDiyCate(@Param("shopId") Long shopId,@Param("webSite") String webSite,@Param("cateId") Long cateId);

    /**
     * 根据商品id修改商品类目
     * @param goodsId
     * @param cateId
     * @return
     */
    Integer updateGoodsCateByGoodsId(@Param("goodsId")Long goodsId,@Param("cateId")Long cateId);

}
