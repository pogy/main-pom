package com.shigu.main4.order.vo;

/**
 * Created by jmb on 2017/7/20.
 */

import java.io.Serializable;

/**
 * 单条跟踪信息
 */
public class SingleMsgVO implements Serializable{
    //此条信息的时间
    String AcceptTime;

    //此条信息的描述
    String AcceptStation;

    String Remark;

    public String getAcceptStation() {
        return AcceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        AcceptStation = acceptStation;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getAcceptTime() {
        return AcceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        AcceptTime = acceptTime;
    }
}
