package com.shigu.photo.vo;

import java.io.Serializable;

public class PhotoCatVO implements Serializable {
    private Long cid;
    private String cname;

    public Long getCid() {
        return this.cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
