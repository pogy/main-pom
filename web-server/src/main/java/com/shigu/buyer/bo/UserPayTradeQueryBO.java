package com.shigu.buyer.bo;

/**
 * 类名：UserPayTradeQueryBO
 * 类路径： com.shigu.buyer.bo.UserPayTradeQueryBO
 * 创建者： whx
 * 创建时间： 9/18/18 6:18 PM
 * 项目： main-pom
 * 描述：
 */
public class UserPayTradeQueryBO {

    private Integer type;

    // 查询开始时间
    private String beginTime;

    // 查询结束时间
    private String endTime;

    private String outTradeNo;

    private Integer page;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
