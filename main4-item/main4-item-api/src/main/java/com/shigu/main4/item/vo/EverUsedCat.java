package com.shigu.main4.item.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 曾经使用过的类目
 * Created by zhaohongbo on 17/3/15.
 */
public class EverUsedCat implements Serializable{
    /**
     * 主键
     */
    private Long useCatId;
    /**
     * 类目路径
     */
    private String showName;
    /**
     * 类目ID串
     */
    private String allcids;
    /**
     * 类目ID
     */
    private Long cid;
    /**
     * 类目名
     */
    private String cname;
    /**
     * 店铺ID
     */
    private Long storeId;
    /**
     * 创建时间
     */
    private Date created;

    public Long getUseCatId() {
        return useCatId;
    }

    public void setUseCatId(Long useCatId) {
        this.useCatId = useCatId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getAllcids() {
        return allcids;
    }

    public void setAllcids(String allcids) {
        this.allcids = allcids;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
