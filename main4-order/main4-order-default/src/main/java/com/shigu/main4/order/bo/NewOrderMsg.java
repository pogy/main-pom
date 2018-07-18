package com.shigu.main4.order.bo;

import com.opentae.data.mall.beans.ShiguPhonePushMark;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gtx on 2018/7/17.
 * 新订单详情
 * @author gtx
 * @since
 */
public class NewOrderMsg implements Serializable {
    private Long msgId;
    private String msgTitle;
    private String msgStr;
    private String strShopId;
    private Integer badge;
    private List<ShiguPhonePushMark> shiguPhonePushMarksList;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgStr() {
        return msgStr;
    }

    public void setMsgStr(String msgStr) {
        this.msgStr = msgStr;
    }

    public String getStrShopId() {
        return strShopId;
    }

    public void setStrShopId(String strShopId) {
        this.strShopId = strShopId;
    }

    public Integer getBadge() {
        return badge;
    }

    public void setBadge(Integer badge) {
        this.badge = badge;
    }

    public List<ShiguPhonePushMark> getShiguPhonePushMarksList() {
        return shiguPhonePushMarksList;
    }

    public void setShiguPhonePushMarksList(List<ShiguPhonePushMark> shiguPhonePushMarksList) {
        this.shiguPhonePushMarksList = shiguPhonePushMarksList;
    }
}
