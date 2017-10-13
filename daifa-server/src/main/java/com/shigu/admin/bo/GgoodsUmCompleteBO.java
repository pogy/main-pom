package com.shigu.admin.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：GgoodsUmCompleteBO
 * @文件路径：com.shigu.admin.bo.GgoodsUmCompleteBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/1 14:04
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class GgoodsUmCompleteBO implements Serializable{

    private String createDate;//创建时间
    //private String daifaWorker;//拿货人
    //private Long daifaWorkerId;//拿货人ID
    private Long sellerId;//代发机构ID
    /**
     * 当前页
     */
    private String page;
    /**
     * 总数量
     */
    private Integer count;

    public String getCreateDate () {
        return createDate;
    }

    public void setCreateDate (String createDate) {
        this.createDate = createDate;
    }

    public Long getSellerId () {
        return sellerId;
    }

    public void setSellerId (Long sellerId) {
        this.sellerId = sellerId;
    }

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
