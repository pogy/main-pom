package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.GoodsCountForsearch;
import com.opentae.data.mall.beans.GoodsFile;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */
@MyBatisRepository("tae_mall_goodsFileMapper")
@Scope("singleton")
@Lazy(true)
public interface GoodsFileMapper extends Mapper<GoodsFile> {
}
