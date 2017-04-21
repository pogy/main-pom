package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 店内发布使用过的类目
 *
 * @author shigu_zjb
 * @date 2017/03/15 14:44
 *
 */
public class ShiguStoreUsercat {

    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long useCatId;
    private String showName;
    private String allcids;
    private Long cid;
    private String cname;
    private Long storeId;
    private Date created;

    public ShiguStoreUsercat() {
    }

    public Long getUseCatId() {
        return this.useCatId;
    }

    public void setUseCatId(Long useCatId) {
        this.useCatId = useCatId;
    }

    public String getShowName() {
        return this.showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getAllcids() {
        return this.allcids;
    }

    public void setAllcids(String allcids) {
        this.allcids = allcids;
    }

    public Long getCid() {
        return this.cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
