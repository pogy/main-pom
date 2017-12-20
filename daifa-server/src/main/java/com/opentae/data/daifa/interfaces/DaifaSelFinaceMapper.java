package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.shigu.daifa.vo.WorkerTakeNumVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_daifa_daifaSelFinaceMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaSelFinaceMapper{
    /**
     * 当日拿货金额
     * @param day
     * @return
     */
    String selectTodayTakeFee(@Param("day")String day,@Param("sellerId")Long sellerId);

    String selectTodayNotTakeFee(@Param("day")String day,@Param("sellerId")Long sellerId);

    String selectTodayServerFee(@Param("day")String day,@Param("sellerId")Long sellerId);

    String selectTodayPostFee(@Param("day")String day,@Param("sellerId")Long sellerId);

    String selectTodayRefundFee(@Param("day")String day,@Param("sellerId")Long sellerId);

    List<WorkerTakeNumVO> selectWorkerTakeNums(@Param("day")String day, @Param("sellerId")Long sellerId);
}
