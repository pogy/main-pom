package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.daifa.beans.DaifaSeller;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_daifa_daifaSellerMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaSellerMapper extends Mapper<DaifaSeller> {
}
