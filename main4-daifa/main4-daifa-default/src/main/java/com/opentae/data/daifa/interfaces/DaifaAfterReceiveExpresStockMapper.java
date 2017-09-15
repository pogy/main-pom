package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.daifa.beans.DaifaAfterReceiveExpresStock;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_daifa_daifaAfterReceiveExpresStockMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaAfterReceiveExpresStockMapper extends Mapper<DaifaAfterReceiveExpresStock> {
}
