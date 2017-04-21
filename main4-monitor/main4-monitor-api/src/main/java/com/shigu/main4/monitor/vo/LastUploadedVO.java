package com.shigu.main4.monitor.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 最后一次上传的信息
 * Created by zhaohongbo on 17/3/19.
 */
public class LastUploadedVO implements Serializable{

    private Date lastTime;

    private Long numIid;

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }
}
