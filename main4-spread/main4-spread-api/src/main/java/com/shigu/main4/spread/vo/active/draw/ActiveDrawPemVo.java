package com.shigu.main4.spread.vo.active.draw;


import java.io.Serializable;
import java.util.Date;

/**
 * 期次
 *
 */
public class ActiveDrawPemVo implements Serializable{

    private Long id;

    private String info;

    private Integer term;

    /** 开始时间 */
    private Date startTime;

    /** 创建时间 */
    private Date createTime;

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
