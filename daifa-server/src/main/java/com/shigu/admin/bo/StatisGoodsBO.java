package com.shigu.admin.bo;

import com.shigu.base.bo.BaseBO;

/**
 * @类编号
 * @类名称：StatisGoodsBO
 * @文件路径：com.shigu.admin.bo.StatisGoodsBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/7 14:00
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class StatisGoodsBO extends BaseBO {

    /**拿货状态@0开始拿货状态1已拿到2缺货*/
    private Integer takeGoodsStatus;

    /**
     * 开始时间
     */
    private String startTime;//createTime
    /**
     * 结束时间
     */
    private String endTime;//lastDoTime

    public Integer getTakeGoodsStatus () {
        return takeGoodsStatus;
    }

    public void setTakeGoodsStatus (Integer takeGoodsStatus) {
        this.takeGoodsStatus = takeGoodsStatus;
    }

    public String getStartTime () {
        return startTime;
    }

    public void setStartTime (String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime () {
        return endTime;
    }

    public void setEndTime (String endTime) {
        this.endTime = endTime;
    }
}
