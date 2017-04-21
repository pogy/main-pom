package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguGoodsDataPackage;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguGoodsDataPackageMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguGoodsDataPackageMapper extends Mapper<ShiguGoodsDataPackage> {

    /** 数据包查询 */
    List<ShiguGoodsDataPackage> selGoodsPackageList(@Param("userId") Long userId, @Param("startIndex") int startIndex,
                                                        @Param("pageSize") int pageSize);
    /** 数据包查询参数 */
    int selGoodsPackageCount(@Param("userId") Long userId);

    /** 查询数据包 BY ids */
    List<ShiguGoodsDataPackage> selGoodsPackageListByIds(@Param("packageIds") List<Long> packageIds);
}
