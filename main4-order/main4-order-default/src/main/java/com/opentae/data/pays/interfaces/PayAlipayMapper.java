package com.opentae.data.pays.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.pays.beans.PayAlipay;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_pays_payAlipayMapper")
@Scope("singleton")
@Lazy(true)
public interface PayAlipayMapper extends Mapper<PayAlipay> {
}
