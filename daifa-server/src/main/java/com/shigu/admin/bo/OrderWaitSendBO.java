package com.shigu.admin.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：OrderWaitSendBO
 * @文件路径：com.shigu.admin.bo.OrderWaitSendBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/16 12:37
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderWaitSendBO implements Serializable {
    private Long dfTradeId;//主订单号
    private String receiverName;//收货人
    private Integer orderDisplay;//待发货订单是否显示0不显示1显示
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

    public String getReceiverName () {
        return receiverName;
    }

    public void setReceiverName (String receiverName) {
        this.receiverName = receiverName;
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

    public Integer getOrderDisplay () {
        return orderDisplay;
    }

    public void setOrderDisplay (Integer orderDisplay) {
        this.orderDisplay = orderDisplay;
    }
}
