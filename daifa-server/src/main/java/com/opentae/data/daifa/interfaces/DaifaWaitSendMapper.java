package com.opentae.data.daifa.interfaces;

import com.opentae.data.daifa.beans.DaifaWaitSend;
import com.opentae.data.daifa.beans.DaifaWaitSendSimple;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Lazy;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.core.mybatis.config.MyBatisRepository;

import java.util.Date;
import java.util.List;

/**
 *==========================================================
 *TODO ->这里需要配置 主要是这个类的描述信息
 *@类编号：
 *@类名称：DaifaWaitSendMapper.java
 *@文件路径：com.opentae.data.daifa.interfaces.DaifaWaitSendMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:47
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_daifa_daifaWaitSendMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaWaitSendMapper extends Mapper<DaifaWaitSend>{

    List<DaifaWaitSendSimple> selectWaitSends(@Param("dwsIds")String dwsIds);

    List<DaifaWaitSendSimple> selectWaitSendsIds(@Param("dfSellerId")Long dfSellerId,
                                              @Param("lastTradeId")Long lastTradeId,
                                              @Param("phone")String phone,
                                              @Param("buyerId")Long buyerId,
                                              @Param("stId")Long stId,
                                              @Param("etId")Long etId,
                                              @Param("status")Integer status,
                                              @Param("start")Integer start,
                                              @Param("end")Integer end);

    Integer selectWaitSendsCount(@Param("dfSellerId")Long dfSellerId,
                                 @Param("lastTradeId")Long lastTradeId,
                                 @Param("phone")String phone,
                                 @Param("buyerId")Long buyerId,
                                 @Param("stId")Long stId,
                                 @Param("etId")Long etId,
                                 @Param("status")Integer status);

}
