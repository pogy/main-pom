package com.shigu.main4.spread.vo.active.draw;

/**
 * 类名：DrawVerifyVO
 * 类路径：com.shigu.main4.spread.vo.active.draw.DrawVerifyVO
 * 创建者：王浩翔
 * 创建时间：2017-08-14 15:36
 * 项目：main-pom
 * 描述：
 */
public class DrawVerifyVO {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 抽奖次数
     */
    private Integer opportunityFrequency;
    /**
     * 已用抽奖次数
     */
    private Integer usedFrequency;
    /**
     * 活动期次
     */
    private Long term;
    /**
     * 活动类型
     */
    private Integer type;
    /**
     * 已中最大奖项
     */
    private String hasWard;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getOpportunityFrequency() {
        return opportunityFrequency;
    }

    public void setOpportunityFrequency(Integer opportunityFrequency) {
        this.opportunityFrequency = opportunityFrequency;
    }

    public Integer getUsedFrequency() {
        return usedFrequency;
    }

    public void setUsedFrequency(Integer usedFrequency) {
        this.usedFrequency = usedFrequency;
    }

    public Long getTerm() {
        return term;
    }

    public void setTerm(Long term) {
        this.term = term;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHasWard() {
        return hasWard;
    }

    public void setHasWard(String hasWard) {
        this.hasWard = hasWard;
    }

}
