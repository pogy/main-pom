package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * Created by zhaohongbo on 17/3/15.
 */
public class EverUsedCatForAdd  implements Serializable {

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
}
