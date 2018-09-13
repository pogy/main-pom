package com.shigu.main4.pay.requests;

import java.io.Serializable;
import java.util.Date;

/**
 * 类名：XzbUserPayTradeRecordRequest
 * 类路径： com.shigu.main4.pay.requests.XzbUserPayTradeRecordRequest
 * 创建者： whx
 * 创建时间： 8/10/18 4:03 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbUserPayTradeRecordRequest implements Serializable {

    /**
     * 星座网用户id
     */
    private Long xzUserId;
    /**
     * 星座宝账户id
     */
    private Long accountId;

    private Integer page;
    private Integer pageSize;
    private Integer type;
    private String inout;
    private Integer debitType;
    private Date createTime;
    private Date endTime;
    private String outTradeNo;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getXzUserId() {
        return xzUserId;
    }

    public void setXzUserId(Long xzUserId) {
        this.xzUserId = xzUserId;
    }

    public Integer getPage() {
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInout() {
        return inout;
    }

    public void setInout(String inout) {
        this.inout = inout;
    }

    public Integer getDebitType() {
        return debitType;
    }

    public void setDebitType(Integer debitType) {
        this.debitType = debitType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
}
