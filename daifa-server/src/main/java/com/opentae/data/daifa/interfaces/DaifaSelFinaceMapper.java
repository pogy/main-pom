package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.data.daifa.custom.beans.RefundedFee;
import com.opentae.data.daifa.custom.beans.StockGoods;
import com.opentae.data.daifa.custom.beans.TodayPostDetail;
import com.opentae.data.daifa.custom.beans.WorkerTakeNum;
import com.shigu.daifa.vo.NewRefundFeeVo;
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

    String selectTodayGoodsFee(@Param("day")String day,@Param("sellerId")Long sellerId);

    String selectTodayStockGoodsFee(@Param("day")String day,@Param("sellerId")Long sellerId);

    List<WorkerTakeNum> selectWorkerTakeNums(@Param("day")String day, @Param("endDay")String endDay, @Param("sellerId")Long sellerId);

    List<TodayPostDetail> selectTodayPostDetail(@Param("day")String day, @Param("sellerId")Long sellerId,@Param("start")Integer start, @Param("end")Integer end);

    Integer selectTodayPostDetailCount(@Param("day")String day, @Param("sellerId")Long sellerId);

    List<StockGoods> selectStockGoods(@Param("day")String day, @Param("sellerId")Long sellerId, @Param("start")Integer start, @Param("end")Integer end);

    Integer selectStockGoodsCount(@Param("day")String day, @Param("sellerId")Long sellerId);

    List<RefundedFee> selectTodayRefund(@Param("day")String day, @Param("sellerId")Long sellerId,@Param("start")Integer start, @Param("end")Integer end);

    Integer selectTodayRefundCount(@Param("day")String day, @Param("sellerId")Long sellerId);

    //当天发货商品金额
    String selTodayGoodsFee(@Param("time")String time, @Param("sellerId")Long sellerId);
    //当天发货服务费金额
    String selTodayServerFee(@Param("time")String time, @Param("sellerId")Long sellerId);
    //当天发货快递费金额
    String selExpressFee(@Param("time")String time, @Param("sellerId")Long sellerId);

    String selTodayRefundFee(@Param("time")String time);
}
