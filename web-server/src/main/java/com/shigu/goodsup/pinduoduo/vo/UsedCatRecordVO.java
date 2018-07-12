package com.shigu.goodsup.pinduoduo.vo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/6/25.
 * 上传过的类目
 * @author gtx
 * @since
 */
public class UsedCatRecordVO implements Serializable {
    /**
     * 类目id
     */
    private String cid;
    /**
     * 类目文本 例:女装/女士精品 > 牛仔裤
     */
    private String text;
    /**
     * 用于提交的值 例:16,162205 即总类目id，子类目id
     */
    private String value;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
