package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/5/29.
 * 展示累计数据
 * @author gtx
 * @description
 * @since
 */
public class EachAllDataVO implements Serializable {

    private static final long serialVersionUID = 7697577726697411176L;
    /**
     * 项目文本(今日访问、今日下载、累计下载、关注用户)
     */
    private String text;
    /**
     * 项目累计数量
     */
    private String num;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
