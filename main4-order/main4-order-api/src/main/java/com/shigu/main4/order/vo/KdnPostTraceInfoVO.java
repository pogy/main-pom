package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gtx on 2018/9/3 0003.
 *
 * @author gtx
 * @since
 */
public class KdnPostTraceInfoVO implements Serializable,Comparable<KdnPostTraceInfoVO> {

    /**
     * acceptStation	String	描述	R
     */
    private String acceptStation;
    /**
     * acceptTime		时间	R
     */
    private Date acceptTime;

    /**
     * remark	String	备注	O
     */
    private String remark;

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "KdnPostTraceInfoVO{" +
                "acceptStation='" + acceptStation + '\'' +
                ", acceptTime=" + acceptTime +
                ", remark='" + remark + '\'' +
                '}';
    }

    @Override
    public int compareTo(KdnPostTraceInfoVO o) {
        if (o == null) {
            return -1;
        }
        if (acceptTime.getTime() > o.getAcceptTime().getTime()) {
            return -1;
        }
        return 1;
    }
}
