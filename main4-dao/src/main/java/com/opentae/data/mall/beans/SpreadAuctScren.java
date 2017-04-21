package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 广告竞拍场次
 * @author shigu_zjb
 * @date 2017/3/22 17:19
 *
 */
public class SpreadAuctScren {

    /** 竞拍ID */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long id;

    /** 广告屏幕ID */
    private Long spreadPmId;

    /** 开始时间 */
    private Date startTime;

    /** 结果时间 */
    private Date endTime;

    /** 下次场次时间 */
    private Date nextScrenTime;

    /** 投放开始时间 */
    private Date delverStartTime;

    /** 投放结束时间 */
    private Date delverEndTime;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date modifyTime;

    /** 数据有效性 */
    private Boolean enabled;

    /** 活动规则描述 */
    private String activeRuleDesc;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpreadPmId() {
        return spreadPmId;
    }

    public void setSpreadPmId(Long spreadPmId) {
        this.spreadPmId = spreadPmId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getNextScrenTime() {
        return nextScrenTime;
    }

    public void setNextScrenTime(Date nextScrenTime) {
        this.nextScrenTime = nextScrenTime;
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

    public Date getDelverStartTime() {
        return delverStartTime;
    }

    public void setDelverStartTime(Date delverStartTime) {
        this.delverStartTime = delverStartTime;
    }

    public Date getDelverEndTime() {
        return delverEndTime;
    }

    public void setDelverEndTime(Date delverEndTime) {
        this.delverEndTime = delverEndTime;
    }

    public String getActiveRuleDesc() {
        return activeRuleDesc;
    }

    public void setActiveRuleDesc(String activeRuleDesc) {
        this.activeRuleDesc = activeRuleDesc;
    }
}
