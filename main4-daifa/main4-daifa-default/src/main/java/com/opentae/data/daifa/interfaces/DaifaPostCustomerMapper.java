package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.daifa.beans.DaifaPostCustomer;
import com.opentae.data.daifa.cust.beans.ZipCodeBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_daifa_daifaPostCustomerMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaPostCustomerMapper extends Mapper<DaifaPostCustomer> {
    /**
     * 读取市级邮编
     * @param cityName
     * @return
     */
    ZipCodeBean selectPostCodeByCity(@Param("cityName")String cityName);

    /**
     * 读取区级邮编
     * @param townName
     * @return
     */
    ZipCodeBean selectPostCodeByTown(@Param("townName")String townName,@Param("cityId")Long cityId);

}
