package com.shigu.phone.waps.vo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-19/16:38
 */
public class ParentCatVO implements Serializable {
    /**总分类id*/
    private String pid;
    /**总分类名称*/
    private String name;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
