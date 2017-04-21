package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 淘宝来的类目
 * Created by zhaohongbo on 17/3/15.
 */
public class TbCat implements Serializable{
    /**
     * 类目ID
     */
    private Long cid;
    /**
     * 类目名
     */
    private String cname;
    /**
     * 是否父级类目,1是0不是
     */
    private Integer isParent;
    /**
     * 父级类目ID
     */
    private Long parentCid;
    /**
     * 父级类目名
     */
    private String parentCname;

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

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    public Long getParentCid() {
        return parentCid;
    }

    public void setParentCid(Long parentCid) {
        this.parentCid = parentCid;
    }

    public String getParentCname() {
        return parentCname;
    }

    public void setParentCname(String parentCname) {
        this.parentCname = parentCname;
    }
}
