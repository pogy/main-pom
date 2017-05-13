package com.shigu.main4.spread.vo.active.draw;


import java.io.Serializable;
import java.util.Date;

/**
 * 期次
 *
 */
public class ActiveDrawPemVo implements Serializable{

    private Long id;

    /** 开始时间 */
    private Date startTime;

    /** 创建时间 */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
