package com.shigu.jd.mapper.beans;

import java.io.Serializable;
import java.util.Set;

/**
 * Created By admin on 2017/12/14/16:18
 */
public class JdCategoryAttrGroupJosVO implements Serializable {

    private static final long serialVersionUID = 8190845150192673657L;

    private Long groupId;
    private String groupName;
    private Integer attrGroupIndexId;
    private Set<JdFeatureCateAttrGroupJosVO> attrGroupfeatures;

    public JdCategoryAttrGroupJosVO() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getAttrGroupIndexId() {
        return attrGroupIndexId;
    }

    public void setAttrGroupIndexId(Integer attrGroupIndexId) {
        this.attrGroupIndexId = attrGroupIndexId;
    }

    public Set<JdFeatureCateAttrGroupJosVO> getAttrGroupfeatures() {
        return attrGroupfeatures;
    }

    public void setAttrGroupfeatures(Set<JdFeatureCateAttrGroupJosVO> attrGroupfeatures) {
        this.attrGroupfeatures = attrGroupfeatures;
    }
}