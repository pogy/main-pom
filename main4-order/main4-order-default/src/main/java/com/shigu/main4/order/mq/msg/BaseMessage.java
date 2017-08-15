package com.shigu.main4.order.mq.msg;

import com.alibaba.fastjson.JSON;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 消息基础
 * Created by bugzy on 2017/8/14 0014.
 */
public class BaseMessage<D> implements Serializable {
    private boolean status;
    @Transient
    private transient String key;
    private String msg;
    private D data;

    public BaseMessage() {
    }

    private BaseMessage(boolean status, String key, String msg, D data) {
        this.status = status;
        this.key = key;
        this.msg = msg;
        this.data = data;
    }

    public static <D> BaseMessage<D> success(String key, String msg, D data) {
        return new BaseMessage<>(true, key, msg, data);
    }

    public static <D> BaseMessage<D> error(String key, String msg) {
        return new BaseMessage<>(false, key, msg, null);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
