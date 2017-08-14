package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 退货过程
 * Created by zhaohongbo on 17/7/26.
 */
public class RefundProcessVO implements Serializable{

    private Date createTime;

    private String msg;

    private Boolean imBuyer;

    private Integer fromStatus;

    private Integer toStatus;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getImBuyer() {
        return imBuyer;
    }

    public void setImBuyer(Boolean imBuyer) {
        this.imBuyer = imBuyer;
    }

    public Integer getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(Integer fromStatus) {
        this.fromStatus = fromStatus;
    }

    public Integer getToStatus() {
        return toStatus;
    }

    public void setToStatus(Integer toStatus) {
        this.toStatus = toStatus;
    }
}
