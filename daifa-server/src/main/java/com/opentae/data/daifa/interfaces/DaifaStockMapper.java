package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.daifa.beans.DaifaStock;
import com.opentae.data.daifa.custom.beans.WorkerStock;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_daifa_daifaStockMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaStockMapper extends Mapper<DaifaStock> {
    List<WorkerStock> selectWorkerOutStock(@Param("workerId")Long workerId, @Param("inOutType")Integer inOutType);
    Integer selectTodayStockCount(@Param("sellerId")Long sellerId, @Param("inOutType")Integer inOutType,@Param("day")String day);
    Integer selectTheDayStockRecordIdsCount(@Param("sellerId")Long sellerId, @Param("inOutType")Integer inOutType,@Param("startDay")String startDay,@Param("endDay")String endDay);
    List<Long> selectTheDayStockRecordIds(@Param("sellerId")Long sellerId, @Param("inOutType")Integer inOutType,
                                          @Param("startDay")String startDay,@Param("endDay")String endDay,
                                          @Param("start")Integer start,@Param("end")Integer end);
}
