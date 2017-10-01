package com.shigu.admin.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：GgoodsUmCompleteVO
 * @文件路径：com.shigu.admin.vo.GgoodsUmCompleteVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/1 13:44
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class GgoodsUmCompleteVO implements Serializable{

    private String createDate;//创建时间
    private String daifaWorker;//拿货人
    private Long daifaWorkerId;//拿货人ID
    private Long sellerId;//代发机构ID

    public String getCreateDate () {
        return createDate;
    }

    public void setCreateDate (String createDate) {
        this.createDate = createDate;
    }

    public String getDaifaWorker () {
        return daifaWorker;
    }

    public void setDaifaWorker (String daifaWorker) {
        this.daifaWorker = daifaWorker;
    }

    public Long getDaifaWorkerId () {
        return daifaWorkerId;
    }

    public void setDaifaWorkerId (Long daifaWorkerId) {
        this.daifaWorkerId = daifaWorkerId;
    }

    public Long getSellerId () {
        return sellerId;
    }

    public void setSellerId (Long sellerId) {
        this.sellerId = sellerId;
    }
}
