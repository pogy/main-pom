package com.shigu.main4.spread.vo;

import java.io.Serializable;

/**
 * 类名：PrizePoolVO
 * 类路径：com.shigu.main4.spread.vo.PrizePoolVO
 * 创建者：王浩翔
 * 创建时间：2017-11-21 9:43
 * 项目：main-pom
 * 描述：
 */
public class PrizePoolVO implements Serializable {
    //奖品奖池主键
    private Long prizeId;
    //活动期次id
    private Long pemId;
    //奖品级别 如一等奖1 二等奖2
    private Integer rank;
    //奖品级别字符串  一等奖，二等奖。。。
    private String rankStr;
    //奖品名称 XXX手机。。
    private String prizeName;
    //奖品图片链接地址
    private String prizeImgUrl;
    //总奖品数量
    private Integer totalNum;
    //可抽取奖品数量
    private Integer drawAbleNum;
    //已被抽中奖品数量
    private Integer drawedNum;

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public Long getPemId() {
        return pemId;
    }

    public void setPemId(Long pemId) {
        this.pemId = pemId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getRankStr() {
        return rankStr;
    }

    public void setRankStr(String rankStr) {
        this.rankStr = rankStr;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeImgUrl() {
        return prizeImgUrl;
    }

    public void setPrizeImgUrl(String prizeImgUrl) {
        this.prizeImgUrl = prizeImgUrl;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getDrawAbleNum() {
        return drawAbleNum;
    }

    public void setDrawAbleNum(Integer drawAbleNum) {
        this.drawAbleNum = drawAbleNum;
    }

    public Integer getDrawedNum() {
        return drawedNum;
    }

    public void setDrawedNum(Integer drawedNum) {
        this.drawedNum = drawedNum;
    }
}
