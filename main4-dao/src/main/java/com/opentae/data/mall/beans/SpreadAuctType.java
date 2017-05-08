package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 广告类别
 *
 * @author shigu_zjb
 * @date 2017/04/14 11:47
 *
 */
@Deprecated
public class SpreadAuctType implements Serializable {
    /** 主键ID */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long id;

    /** 广告名称 */
    private String name;

    /** 广告数量 */
    private Long spreadNum;

    /** 单价 */
    private Long price;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date modifyTime;

    /** 数据有效性 */
    private Boolean disEnabled;

    /** 投放开始时间 */
    @Transient
    private Date delverStartTime;

    /** 投放结束时间 */
    @Transient
    private Date detDelverEndTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSpreadNum() {
        return spreadNum;
    }

    public void setSpreadNum(Long spreadNum) {
        this.spreadNum = spreadNum;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getDisEnabled() {
        return disEnabled;
    }

    public void setDisEnabled(Boolean disEnabled) {
        this.disEnabled = disEnabled;
    }

    public Date getDelverStartTime() {
        return delverStartTime;
    }

    public void setDelverStartTime(Date delverStartTime) {
        this.delverStartTime = delverStartTime;
    }

    public Date getDetDelverEndTime() {
        return detDelverEndTime;
    }

    public void setDetDelverEndTime(Date detDelverEndTime) {
        this.detDelverEndTime = detDelverEndTime;
    }
}
