package com.shigu.admin.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：OrderSendErrorDealBO
 * @文件路径：com.shigu.admin.bo.OrderSendErrorDealBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/12 11:16
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderSendErrorDealBO implements Serializable{

    private String dfTradeId;//订单ID

    private String phone;//手机号

    private Integer sendType;//发送类型@0普通1重新修改交易编号再进行发货
    /**
     * 当前页
     */
    private String page;
    /**
     * 总数量
     */
    private Integer count;

    private Integer flo;

    public String getDfTradeId () {
        return dfTradeId;
    }

    public Integer getFlo () {
        return flo;
    }

    public void setFlo (Integer flo) {
        this.flo = flo;
    }

    public void setDfTradeId (String dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
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

    public Integer getSendType () {
        return sendType;
    }

    public void setSendType (Integer sendType) {
        this.sendType = sendType;
    }
}
