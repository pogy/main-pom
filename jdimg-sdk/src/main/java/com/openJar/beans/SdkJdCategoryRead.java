package com.openJar.beans;

import com.openJar.responses.api.JdFeatureResponse;
import com.openJar.utils.OpenBean;

import java.util.Set;

public class SdkJdCategoryRead extends OpenBean{

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

    private Set<JdFeatureResponse> features;

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

    public Set<JdFeatureResponse> getFeatures() {
        return features;
    }

    public void setFeatures(Set<JdFeatureResponse> features) {
        this.features = features;
    }
}
