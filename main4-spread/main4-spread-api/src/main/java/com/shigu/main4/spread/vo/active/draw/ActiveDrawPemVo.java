package com.shigu.main4.spread.vo.active.draw;


import java.io.Serializable;
import java.util.Date;

/**
 * 期次
 *
 */
public class ActiveDrawPemVo implements Serializable{

    private Long id;

    /**
     * 每期的额外信息。
     */
    private String info;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 截止时间
     */
    private Date endTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 期次展示
     */
    private Integer term;

    /**
     * 活动类别，1表示发现好货，2表示秋款上新
     */
    private Integer activeType;

    /**
     * 中奖信息标题
     */
    private String title;

    /**
     * 活动类型标记 代金券活动voucher
     */
    private String flag;

    public ActiveDrawPemVo() {
    }

    public ActiveDrawPemVo( Long id, String info, Integer term, Date startTime, Date createTime, String title ) {
        this.id = id;
        this.info = info;
        this.term = term;
        this.startTime = startTime;
        this.createTime = createTime;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getActiveType() {
        return activeType;
    }

    public void setActiveType(Integer activeType) {
        this.activeType = activeType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
