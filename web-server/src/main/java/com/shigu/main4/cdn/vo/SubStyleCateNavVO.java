package com.shigu.main4.cdn.vo;

import java.io.Serializable;

/**
 * 路径:com.shigu.main4.cdn.vo.SubStyleCateNavVO
 * 工程:main-pom
 * 时间:18-1-26下午6:44
 * 创建人:wanghaoxiang
 * 描述：子类目导航 风格频道
 */
public class SubStyleCateNavVO implements Serializable {

    //子类目名称
    private String text;
    //子类目列表，格式：类目名|id或keyword，多个用空格隔开
    private String items;

    public SubStyleCateNavVO(String text, String items) {
        this.text = text;
        this.items = items;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
