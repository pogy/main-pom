package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 活动抽奖商品
 *
 * @auhtor shigu_zjb
 * @date 2017/05/12 18:21
 *
 */
public class ActiveDrawGoods {

    public final static String TYPE_FAGOODS = "FAGOODS";// 发现好货
    public final static String TYPE_DAILYFIND = "DAILYFIND";// 每日发现

    /** 主键ID */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long id;

    /** 商品ID */
    private Long goodsId;

    /** 期次 */
    private Long pemId;

    /** 类别发现好货/每日发现 */
    private String type;

    private Integer sort;

    /** 坑位ID */
    private Long pitId;

    private Date createTime;

    private Date modifyTime;

    private Boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getPemId() {
        return pemId;
    }

    public void setPemId(Long pemId) {
        this.pemId = pemId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getPitId() {
        return pitId;
    }

    public void setPitId(Long pitId) {
        this.pitId = pitId;
    }
}
