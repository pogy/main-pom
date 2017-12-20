package com.shigu.main4.spread.vo.active.draw;

import java.io.Serializable;

/**
 * 类名：DrawResult
 * 类路径：com.shigu.main4.spread.vo.active.draw.DrawResult
 * 创建者：王浩翔
 * 创建时间：2017-08-14 17:29
 * 项目：main-pom
 * 描述：中奖结果
 */
public class DrawResult implements Serializable {

    public DrawResult() {
    }

    public DrawResult(Integer hitResult, Integer rank, String prizeName) {
        this.hitResult = hitResult;
        this.rank = rank;
        this.prizeName = prizeName;
    }

    /**
     * 抽奖点数
     */
    private Integer hitResult;
    /**
     * 几等奖
     */
    private Integer rank;
    /**
     * 所中奖品
     */
    private String prizeName;

    public Integer getHitResult() {
        return hitResult;
    }

    public void setHitResult(Integer hitResult) {
        this.hitResult = hitResult;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

}
