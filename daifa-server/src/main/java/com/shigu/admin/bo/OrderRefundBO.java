package com.shigu.admin.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：OrderRefundBO
 * @文件路径：com.shigu.admin.bo.OrderRefundBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/12 17:57
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderRefundBO implements Serializable{

    private Long dfTradeId;//主订单号
    private Long suborderId;//子订单号
    /**
     * 当前页
     */
    private String page;
    /**
     * 总数量
     */
    private Integer count;

    public Long getDfTradeId () {
        return dfTradeId;
    }

    public void setDfTradeId (Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public Long getSuborderId () {
        return suborderId;
    }

    public void setSuborderId (Long suborderId) {
        this.suborderId = suborderId;
    }

    public String getPage () {
        return page;
    }

    public void setPage (String page) {
        this.page = page;
    }

    public Integer getCount () {
        return count;
    }

    public void setCount (Integer count) {
        this.count = count;
    }
}
