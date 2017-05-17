package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 活动抽奖期次
 *
 * @author shigu_zjb
 * @date 2017/05/12 18:00
 *
 */
public class ActiveDrawPem {

    /** 期次ID */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
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
