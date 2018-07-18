package com.shigu.main4.order.bo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/7/17.
 * 透传消息
 * @author gtx
 * @since
 */
public class NewOrderTransparentMsg implements Serializable {

    private Long msgId;
    private String msgStr;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgStr() {
        return msgStr;
    }

    public void setMsgStr(String msgStr) {
        this.msgStr = msgStr;
    }
}
