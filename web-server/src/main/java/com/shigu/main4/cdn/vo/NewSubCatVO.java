package com.shigu.main4.cdn.vo;

import java.io.Serializable;

/**
 * 路径:com.shigu.main4.cdn.vo.NewSubCatVO
 * 工程:main-pom
 * 时间:18-1-26上午11:47
 * 创建人:wanghaoxiang
 * 描述：现在前端修改的类目数据字段封装
 */
public class NewSubCatVO implements Serializable {


    private Long cid;

    private String cname;

    private Long pid;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
