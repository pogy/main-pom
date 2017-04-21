package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguShopApply;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguShopApplyMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguShopApplyMapper extends Mapper<ShiguShopApply> {

    /** 店铺入驻列表 */
    List<ShiguShopApply> selectShopApplyListByBo(@Param("applyId") Long applyId, @Param("shopNum") String shopNum,
                                                 @Param("applyStatus") Integer applyStatus, @Param("canExamine") Integer canExamine,
                                                 @Param("website") String website,@Param("startRow") int startRow, @Param("pageSize") int pageSize);
    /** 店铺入驻COUNT */
    int selectShopApplyCountByBo(@Param("applyId") Long applyId, @Param("shopNum") String shopNum,
                                 @Param("applyStatus") Integer applyStatus, @Param("canExamine") Integer canExamine,
                                 @Param("website") String website);

}
