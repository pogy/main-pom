package com.opentae.data.pays.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.pays.beans.PayXzbRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_pays_payXzbRecordMapper")
@Scope("singleton")
@Lazy(true)
public interface PayXzbRecordMapper extends Mapper<PayXzbRecord> {
}
