package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/5/31.
 * 实际数据
 * @author gtx
 * @description
 * @since
 */
public class DataListVO implements Serializable {
    /**
     * 折线图 X的数据
     */
    private String text;
    /**
     * 对应的值
     */
    private long value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
