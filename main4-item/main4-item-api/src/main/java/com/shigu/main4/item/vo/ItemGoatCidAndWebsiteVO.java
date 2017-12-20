package com.shigu.main4.item.vo;/**
 * Created by pc on 2017-09-21.
 *
 * @author pc
 * @description
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */

import java.io.Serializable;

/**
 *Created By pc on 2017-09-21/14:27
 *
 */
public class ItemGoatCidAndWebsiteVO implements Serializable{
    /**
     * 类目ID
     */
    private Long cid;

    /**
     * 站点
     */
    private String website;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
