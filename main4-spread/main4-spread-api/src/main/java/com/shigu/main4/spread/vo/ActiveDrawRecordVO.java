package com.shigu.main4.spread.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 类名：ActiveDrawRecordVO
 * 类路径：com.shigu.main4.spread.vo.ActiveDrawRecordVO
 * 创建者：王浩翔
 * 创建时间：2017-11-21 12:30
 * 项目：main-pom
 * 描述：
 */
public class ActiveDrawRecordVO implements Serializable {
    /** 中奖/抽奖记录ID */
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 奖项 */
    private String ward;

    /** 期次 */
    private Long pemId;

    /** 是否领取 */
    private Boolean receivesYes;

    /** 中奖码 */
    private String drawCode;

    /** 中奖状态 */
    private Integer drawStatus;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date modifyTime;

    /** 查阅时间 */
    private Date refeTime;

    /** 数据有效性 */
    private Boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Long getPemId() {
        return pemId;
    }

    public void setPemId(Long pemId) {
        this.pemId = pemId;
    }

    public Boolean getReceivesYes() {
        return receivesYes;
    }

    public void setReceivesYes(Boolean receivesYes) {
        this.receivesYes = receivesYes;
    }

    public String getDrawCode() {
        return drawCode;
    }

    public void setDrawCode(String drawCode) {
        this.drawCode = drawCode;
    }

    public Integer getDrawStatus() {
        return drawStatus;
    }

    public void setDrawStatus(Integer drawStatus) {
        this.drawStatus = drawStatus;
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

    public Date getRefeTime() {
        return refeTime;
    }

    public void setRefeTime(Date refeTime) {
        this.refeTime = refeTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
