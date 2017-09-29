package com.shigu.base.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：BaseBO
 * @文件路径：com.shigu.base.bo.BaseBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/19 16:00
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class BaseBO implements Serializable{
    /**
     * 当前页
     */
    private String page;
    /**
     * 总数量
     */
    private Integer count;

    public String getPage () {
        return page;
    }

    public void setPage (String page) {
        this.page = page;
    }

    public Integer getCount () {
        return count;
    }

    public void setCount (Integer count) {
        this.count = count;
    }
}
