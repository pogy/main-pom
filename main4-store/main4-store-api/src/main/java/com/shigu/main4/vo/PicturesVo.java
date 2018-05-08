package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.vo
 * @ClassName: PicturesVo
 * @Author: sy
 * @CreateDate: 2018/5/8 0008 11:23
 */
public class PicturesVo implements Serializable{
    private String picUrl;
    private Date createTime;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
