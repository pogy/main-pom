package com.shigu.seller.vo;

/**
 * 类名：HistoryCatVO
 * 类路径：com.shigu.seller.vo.HistoryCatVO
 * 创建者：王浩翔
 * 创建时间：2017-11-07 11:34
 * 项目：main-pom
 * 描述：历史上传类目
 */
public class HistoryCatVO {
    private Long cid;
    private String value;
    private String text;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
