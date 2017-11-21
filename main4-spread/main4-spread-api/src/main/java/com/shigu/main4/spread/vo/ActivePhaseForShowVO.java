package com.shigu.main4.spread.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 类名：ActivePhaseForShowVO
 * 类路径：com.shigu.main4.spread.vo.ActivePhaseForShowVO
 * 创建者：王浩翔
 * 创建时间：2017-11-20 17:46
 * 项目：main-pom
 * 描述：前端显示我的奖品需要期次信息
 */
public class ActivePhaseForShowVO implements Serializable {
    //活动期次id
    private Long pemId;
    //活动周期时间
    private String phaseTime;
    //活动起始时间
    private Date startTime;
    //活动截止时间
    private Date endTime;
    //活动规则列表
    private List<String> ruleList;
    //中奖信息列表
    private List<UserPrizeForShowVO> awardList;

    public Long getPemId() {
        return pemId;
    }

    public void setPemId(Long pemId) {
        this.pemId = pemId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPhaseTime() {
        return phaseTime;
    }

    public void setPhaseTime(String phaseTime) {
        this.phaseTime = phaseTime;
    }

    public List<String> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<String> ruleList) {
        this.ruleList = ruleList;
    }

    public List<UserPrizeForShowVO> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<UserPrizeForShowVO> awardList) {
        this.awardList = awardList;
    }
}
