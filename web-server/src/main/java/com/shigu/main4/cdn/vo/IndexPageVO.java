package com.shigu.main4.cdn.vo;

import java.io.Serializable;

/**
 * 首页页面类型
 * Created by zhaohongbo on 17/4/10.
 */
public class IndexPageVO implements Serializable{
    /**
     * 页面类型，男装(M)，女装(W)
     */
    private String type;
    /**
     * 页面类型中文名 “男装”，“女装”
     */
    private String typeText;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }
}
