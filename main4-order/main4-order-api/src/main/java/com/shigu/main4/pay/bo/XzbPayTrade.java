package com.shigu.main4.pay.bo;

import java.io.Serializable;

/**
 * 类名：XzbPayTrade
 * 类路径： com.shigu.main4.pay.bo.XzbPayTrade
 * 创建者： whx
 * 创建时间： 8/9/18 4:03 PM
 * 项目： main-pom
 * 描述： 星座宝
 */
public class XzbPayTrade implements Serializable {

    /**
     * 总费用
     */
    private Long totalFee;
    /**
     * 外部交易ID
     */
    private String outerId;
    /**
     * 可能存在的子订单号
     */
    private String subOuterId;

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getSubOuterId() {
        return subOuterId;
    }

    public void setSubOuterId(String subOuterId) {
        this.subOuterId = subOuterId;
    }
}
