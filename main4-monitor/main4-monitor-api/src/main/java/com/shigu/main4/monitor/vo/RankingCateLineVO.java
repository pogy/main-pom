package com.shigu.main4.monitor.vo;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 类名：RankingCateLineVO
 * 类路径：com.shigu.main4.monitor.vo.RankingCateLineVO
 * 创建者：王浩翔
 * 创建时间：2017-09-27 16:41
 * 项目：main-pom
 * 描述：排行榜展示用类目单条数据
 */
public class RankingCateLineVO implements Serializable {

    //排名
    private Integer rank;
    //  统计条上的文本
    private String text;
    //  统计条上的数量
    private Long totalNum;
    //  统计条上升名次
    private Integer upPos;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getUpPos() {
        return upPos;
    }

    public void setUpPos(Integer upPos) {
        this.upPos = upPos;
    }

    public static class RankingCateComparator implements Comparator<RankingCateLineVO> {

        @Override
        public int compare(RankingCateLineVO o1, RankingCateLineVO o2) {
            return (int) (o2.getTotalNum() - o1.getTotalNum());
        }
    }
}
