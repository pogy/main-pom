package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.util.Date;

/**
 * Created By admin on 2018/1/17/15:24
 */
public class JdToken extends OpenBean {
    /**
     * 京东Id
     */
    private Long  id;
    /**
     * token创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
