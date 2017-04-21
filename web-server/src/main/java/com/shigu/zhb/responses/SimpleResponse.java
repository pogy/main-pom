package com.shigu.zhb.responses;

import java.io.Serializable;

/**
 * 简单返回结果
 * Created by zhaohongbo on 16/5/23.
 */
public class SimpleResponse implements Serializable {

    private static final long serialVersionUID = -2437984486540760101L;
    private String result;
    private String msg;

    public SimpleResponse() {
    }

    public SimpleResponse(String result) {
        this.result = result;
    }

    public SimpleResponse(String result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
