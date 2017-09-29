package com.shigu.main4.monitor.vo;

import java.io.Serializable;

/**
 * 类名：RankingCateLineVO
 * 类路径：com.shigu.main4.monitor.vo.RankingCateLineVO
 * 创建者：王浩翔
 * 创建时间：2017-09-27 16:41
 * 项目：main-pom
 * 描述：排行榜展示用类目单条数据
 */
public class RankingCateLineVO implements Serializable {

    //  统计条上的文本
    private String text;
    //  统计条上的数量
    private Long totalNum;
    //  统计条上升名次
    private Integer upPos;

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
}
