package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.daifa.beans.DaifaAfterReceiveExpresStock;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_daifa_daifaAfterReceiveExpresStockMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaAfterReceiveExpresStockMapper extends Mapper<DaifaAfterReceiveExpresStock> {
    Integer selectExpressPackageCount(@Param("sendPhone")String sendPhone,
                                      @Param("postCode")String postCode,
                                      @Param("status")Integer status);

    List<DaifaAfterReceiveExpresStock> selectExpressPackage(@Param("sendPhone")String sendPhone,
                                                            @Param("postCode")String postCode,
                                                            @Param("status")Integer status,
                                                            @Param("start")Integer start,
                                                            @Param("end")Integer end);

}
