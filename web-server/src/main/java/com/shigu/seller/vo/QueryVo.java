package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: QueryVo
 * @Author: sy
 * @CreateDate: 2018/5/9 0009 14:50
 */
public class QueryVo implements Serializable{

    private Long cid;
    private Long id;
    private Long cPid;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getcPid() {
        return cPid;
    }

    public void setcPid(Long cPid) {
        this.cPid = cPid;
    }
}
