package com.openJar.responses.api;

import com.openJar.responses.Response;
import java.io.Serializable;

/**
 * Created By admin on 2017/12/15/15:40
 */
public class JdCategoryResponse extends Response {

    /**
     * 类目ID
     */
    private Integer id;
    /**
     * 父类目ID
     */
    private Integer fid;
    /**
     * 类目名称
     */
    private String name;
    /**
     *
     */
    private Integer indexId;
    /**
     * 类目状态
     */
    private String status;
    /**
     * 类目级别 0：一级类目 1：二级类目 2：三级类目
     */
    private Integer lev;
    /**
     * 是否是父级类目
     */
    private Boolean parent;

    public JdCategoryResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLev() {
        return lev;
    }

    public void setLev(Integer lev) {
        this.lev = lev;
    }

    public Boolean getParent() {
        return parent;
    }

    public void setParent(Boolean parent) {
        this.parent = parent;
    }
}
