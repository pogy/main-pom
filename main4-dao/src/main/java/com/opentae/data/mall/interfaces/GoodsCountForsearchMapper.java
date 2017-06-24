package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.GoodsCountForsearch;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_goodsCountForsearchMapper")
@Scope("singleton")
@Lazy(true)
public interface GoodsCountForsearchMapper extends Mapper<GoodsCountForsearch> {

    /**
     * 高效率的批量插入或批量更新 pv数和 ip 数
     *  批量更新依赖于表中goods_id 的唯一索引，当使用goods_id 插入遇到索引冲突改调更新操作
     * @param forsearchList 表数据集
     */
    int insertOrUpdate(List<GoodsCountForsearch> forsearchList);


    /**
     * 高效率的批量插入或批量更新 pv数和 ip 数
     *  批量更新依赖于表中goods_id 的唯一索引，当使用goods_id 插入遇到同值情况就更新click和click_ip
     * @param forsearchList 表数据集
     */
    int insertOrUpdateForAdd(List<GoodsCountForsearch> forsearchList);
}
