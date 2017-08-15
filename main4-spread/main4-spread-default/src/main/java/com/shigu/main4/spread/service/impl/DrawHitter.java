package com.shigu.main4.spread.service.impl;

import com.shigu.main4.spread.service.HitDrawModel;
import com.shigu.main4.spread.vo.active.draw.DrawPrizePool;
import com.shigu.main4.spread.vo.active.draw.DrawResult;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 类名：DrawHitter
 * 类路径：com.shigu.main4.spread.service.impl.DrawHitter
 * 创建者：王浩翔
 * 创建时间：2017-08-14 16:21
 * 项目：main-pom
 * 描述：抽奖工具，通过奖池判断是否中奖，由各个活动抽奖实现类调用，抽奖资格由各活动实现类自行验证
 */
public class DrawHitter {


    /**
     * 需要传入活动抽奖随机数除数和中奖结果方式
     * @param maxDrawNum
     * @param strategy
     */
    public DrawHitter(Integer maxDrawNum,PrizeStrategy strategy) {
        this.maxDrawNum = maxDrawNum;
        this.prizeStrategy = strategy;
    }

    /**
     * 最大中奖率
     */
    private final int maxDrawNum;

    /**
     * 对应奖品当日被领完后处理方式
     */
    private final PrizeStrategy prizeStrategy;

    /**
     * 返回所中奖项信息，没中奖则返回信息rank=0,prizeName="NO-PRIZE"
     * @param prizePool
     * @return
     */
    public DrawResult tryHitDraw(List<DrawPrizePool> prizePool) {
        Collections.sort(prizePool,new  DrawPrizePool.Comparator());
        //抽奖点数
        int hitResult = new Random().nextInt(maxDrawNum)+1;
        int currentNum = 0;
        for (DrawPrizePool pool : prizePool) {
            currentNum+=pool.getHitProbability();
            //中奖
            if (hitResult<=currentNum) {
                //奖项有剩余，成功中奖
                if (pool.getCurrentPrizeNum()>0) {
                    return new DrawResult(hitResult,pool.getRank(),pool.getPrizeGood());
                }
                //本奖项没有剩余，奖项降级
                if (PrizeStrategy.PRIZE_DOWN.equals(prizeStrategy)) {
                    continue;
                }
                //奖项没有剩余，不中奖
                if (PrizeStrategy.PRIZE_CANCLE.equals(prizeStrategy)) {
                    return new DrawResult(hitResult,HitDrawModel.NO_PRIZE_RANK,HitDrawModel.NO_PRIZE);
                }
            }
        }
        return new DrawResult(hitResult,HitDrawModel.NO_PRIZE_RANK,HitDrawModel.NO_PRIZE);

    }

    public enum PrizeStrategy{
        PRIZE_CANCLE(1,"若今日本奖品被领完则不中奖"),
        PRIZE_DOWN(2,"若今日奖品被领完，则奖品降级"),
        ;
        public final int strategy;
        /**
         * 说明
         */
        public final String comment;
        PrizeStrategy(int strategy,String comment){
            this.strategy = strategy;
            this.comment = comment;
        }
    }
}
