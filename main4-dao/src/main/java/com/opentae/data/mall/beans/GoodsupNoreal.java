package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 一键上传增量调整
 * Created by zhaohongbo on 17/4/9.
 */
public class GoodsupNoreal {

    @Id
    @GeneratedValue(generator="JDBC")
    private Long norealId;

    private Long itemId;

    private Integer addNum;

    private Integer realNum;

    private Integer activeNum;

    public Long getNorealId() {
        return norealId;
    }

    public void setNorealId(Long norealId) {
        this.norealId = norealId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getAddNum() {
        return addNum;
    }

    public void setAddNum(Integer addNum) {
        this.addNum = addNum;
    }

    public Integer getRealNum() {
        return realNum;
    }

    public void setRealNum(Integer realNum) {
        this.realNum = realNum;
    }

    public Integer getActiveNum() {
        return activeNum;
    }

    public void setActiveNum(Integer activeNum) {
        this.activeNum = activeNum;
    }
}
