package com.shigu.main4.spread.vo.active.draw;

import java.util.Date;

/**
 * 类名：NewAutumnPrizePool
 * 类路径：com.shigu.main4.spread.vo.active.draw.NewAutumnPrizePool
 * 创建者：王浩翔
 * 创建时间：2017-08-15 9:43
 * 项目：main-pom
 * 描述：秋装新品发布会抽奖奖池
 */
public class NewAutumnPrizePool extends DrawPrizePool {
    /**
     * 秋装新品发布会抽奖奖池数据存在shigu_temp表中
     * key2：目前剩余可抽取奖品数量 currentPrizeNum
     * key3：已被抽中奖品数量 distributedNum
     * key4：奖池下次投放奖品奖品更新数量 throwNum
     * key5：奖池下次投放奖品时间 nextThrowInTime
     * key6：奖池投放奖品周期（小时） updatePeriod
     * key1：剩余各种不变的信息，以json格式存储：
     * 几等奖->rank:"rank"
     * 中奖率->hitProbability:"hitProbability"
     * 奖品->prizeGood:"prizeGood"
     * 奖品总数->fullNumber:"fullNumber":
     * 活动名称->activeName:"activeName"
     * 活动类型->activeType:"activeType"
     * 活动展示期次->term:"term"
     * 活动期次->pemId:"pemId"
     */

    public static final String PRIZE_POOL_FLAG = "new_autumn_0811_prize_pool";
    /**
     * 奖池奖项id，奖池信息存在shigu_temp中
     */
    private Long id;

    /**
     * 奖品下次投放时间
     */
    private Date nextThrowInTime;

    /**
     * 奖品下次投放数量
     */
    private Integer throwNum;

    /**
     * 奖池投放周期：小时
     */
    private Integer updatePeriod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNextThrowInTime() {
        return nextThrowInTime;
    }

    public void setNextThrowInTime(Date nextThrowInTime) {
        this.nextThrowInTime = nextThrowInTime;
    }

    public Integer getThrowNum() {
        return throwNum;
    }

    public void setThrowNum(Integer throwNum) {
        this.throwNum = throwNum;
    }

    public Integer getUpdatePeriod() {
        return updatePeriod;
    }

    public void setUpdatePeriod(Integer updatePeriod) {
        this.updatePeriod = updatePeriod;
    }
}
