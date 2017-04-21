package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 评论打分
 *
 */
public class DiscusScore {

    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long dsId;
    private Long storeId;
    private String webSite;
    private Long userId;
    private Integer scoreNum;
    private Date createdTime;

    public DiscusScore() {
    }

    public Long getDsId() {
        return this.dsId;
    }

    public void setDsId(Long dsId) {
        this.dsId = dsId;
    }

    public Long getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getWebSite() {
        return this.webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getScoreNum() {
        return this.scoreNum;
    }

    public void setScoreNum(Integer scoreNum) {
        this.scoreNum = scoreNum;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
