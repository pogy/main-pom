package com.shigu.main4.jd.vo;


import java.io.Serializable;
import java.util.Set;

/**
 * Created By admin on 2017/12/15/15:40
 */
public class JdCategoryReadVO implements Serializable {

    private static final long serialVersionUID = -2590897270448542021L;
    /**
     * 类目ID
     */
    private Long id;
    /**
     * 父类目ID
     */
    private Long fid;
    /**
     * 类目级别 0：一级类目 1：二级类目 2：三级类目
     */
    private Integer lev;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer order;

    private Set<JdFeature> features;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Integer getLev() {
        return lev;
    }

    public void setLev(Integer lev) {
        this.lev = lev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Set<JdFeature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<JdFeature> features) {
        this.features = features;
    }
}
