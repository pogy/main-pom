package com.opentae.data.daifa.interfaces;

import com.opentae.data.daifa.beans.DaifaPostCustomer;
import com.opentae.data.daifa.cust.beans.ZipCodeBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Lazy;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.core.mybatis.config.MyBatisRepository;
/**
 *==========================================================
 *TODO ->这里需要配置 主要是这个类的描述信息
 *@类编号：
 *@类名称：DaifaPostCustomerMapper.java
 *@文件路径：com.opentae.data.daifa.interfaces.DaifaPostCustomerMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:16
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_daifa_daifaPostCustomerMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaPostCustomerMapper extends Mapper<DaifaPostCustomer>{
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
